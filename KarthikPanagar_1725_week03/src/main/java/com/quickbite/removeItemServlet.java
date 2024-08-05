package com.quickbite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quickbite.utilities.DatabaseConnection;

/**
 * Servlet implementation class removeItemServlet
 */
public class removeItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 String itemIdStr = request.getParameter("itemId");
	        if (itemIdStr == null || itemIdStr.trim().isEmpty()) {
	            response.sendRedirect("deleteItem.jsp?error=Item ID is required");
	            return;
	        }

	        int itemId;
	        try {
	            itemId = Integer.parseInt(itemIdStr);
	        } catch (NumberFormatException e) {
	            response.sendRedirect("deleteItem.jsp?error=Invalid Item ID");
	            return;
	        }

	        Connection conn = null;
	        PreparedStatement stmt = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DatabaseConnection.getConnection();

	            String sql = "DELETE FROM Item WHERE Id = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, itemId);

	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
		            request.getRequestDispatcher("/WEB-INF/itemDeletionConfirmation.jsp").forward(request, response);
	            } else {
		            request.getRequestDispatcher("/WEB-INF/itemDeletionConfirmation.jsp").forward(request, response);

	            }

	        } catch (ClassNotFoundException | SQLException e) {
	            ((Throwable) e).printStackTrace();
	            response.sendRedirect("deleteItem.jsp?error=Database error occurred");
	        } finally {
	            try {
	                if (stmt != null) stmt.close();
	                if (conn != null) conn.close();
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
