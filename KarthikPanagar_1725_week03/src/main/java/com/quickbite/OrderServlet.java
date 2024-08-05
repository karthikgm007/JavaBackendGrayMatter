package com.quickbite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quickbite.utilities.DatabaseConnection;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at Order Servlet: ").append(request.getContextPath());
		  int customerId = (int) request.getSession().getAttribute("customerId");
	        String[] itemIds = request.getParameterValues("itemId");
	        String[] quantities = request.getParameterValues("quantity");

	        try (Connection conn = DatabaseConnection.getConnection()) {
	        	
	            conn.setAutoCommit(false);
	            String orderQuery = "INSERT INTO `Order` (Date, CustomerId, TotalCost) VALUES (NOW(), ?, 0)";
	            PreparedStatement orderStmt = conn.prepareStatement(orderQuery, PreparedStatement.RETURN_GENERATED_KEYS);
	           
	            orderStmt.setInt(1, customerId);
	            orderStmt.executeUpdate();

	            ResultSet generatedKeys = orderStmt.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                int orderId = generatedKeys.getInt(1);
	                String orderItemQuery = "INSERT INTO OrderItem (OrderId, ItemId, Quantity) VALUES (?, ?, ?)";
	                PreparedStatement orderItemStmt = conn.prepareStatement(orderItemQuery);

	                for (int i = 0; i < itemIds.length; i++) {
	                    orderItemStmt.setInt(1, orderId);
	                    orderItemStmt.setInt(2, Integer.parseInt(itemIds[i]));
	                    orderItemStmt.setInt(3, Integer.parseInt(quantities[i]));
	                    orderItemStmt.addBatch();
	                }

	                orderItemStmt.executeBatch();
	                conn.commit();
	            }
	            
	            request.getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(request, response);
	        } catch (SQLException e) {
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
