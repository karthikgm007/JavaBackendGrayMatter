package com.graymatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */



    
public class UserServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Hello From User Servlet ");
		
		Connection con=null;
		
		DataSourceClass dc = new DataSourceClass();
		
		try {
			con = dc.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(" Hello Connection Established ");
		
		String name = request.getParameter("name");
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        
        
     // Perform server-side validation (optional)
        if (name == null || name.isEmpty() ||
            id == null || id.isEmpty() ||
            email == null || email.isEmpty() ||
            mobile == null || mobile.isEmpty() ||
            password == null || password.isEmpty()) {
            response.getWriter().println("All fields are required.");
            return;
        }
        
        //Query
		String query = "insert into regions values (?,?,?,?,?)";
		
		 // Create a PreparedStatement
        PreparedStatement ps=null;
		try {
			ps = con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Set the values for the query parameters
        try {
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, name);
	        ps.setString(3, email);
	        ps.setString(4, mobile);
	        ps.setString(5, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        out.print("Row inserted");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
