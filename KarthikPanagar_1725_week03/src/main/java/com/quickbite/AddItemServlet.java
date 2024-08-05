package com.quickbite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quickbite.utilities.DatabaseConnection;

/**
 * Servlet implementation class AddItemServlet
 */
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at AddItemServlet: ").append(request.getContextPath());
		  String name = request.getParameter("name");
	        String costStr = request.getParameter("cost");
	        double cost = Double.parseDouble(costStr);

	        try {
	            Connection conn = DatabaseConnection.getConnection();
	            String sql = "INSERT INTO Item (Name, Cost) VALUES (?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, name);
	            stmt.setDouble(2, cost);
	            stmt.executeUpdate();
	            
	            conn.close();
	            request.getRequestDispatcher("/WEB-INF/itemConfirmation.jsp").forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
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
