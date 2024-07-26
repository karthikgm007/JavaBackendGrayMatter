package com.graymatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    DataSourceClass ds = new DataSourceClass();

	    try {
	        con = ds.getConnection();

	        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
	        ps = con.prepareStatement(query);
	        ps.setString(1, username);
	        ps.setString(2, password);
	        rs = ps.executeQuery();

	        RequestDispatcher dispatcher;
	        if (rs.next()) {
	            // User exists and credentials match
	            dispatcher = request.getRequestDispatcher("Welcome.jsp");
	        } else {
	            // User does not exist or credentials do not match
	            dispatcher = request.getRequestDispatcher("ErrorServlet");
	        }
	        dispatcher.forward(request, response);

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
			
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
