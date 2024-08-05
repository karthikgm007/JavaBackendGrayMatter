package com.ibsbank;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibsbank.utilities.DatabaseConnection;

/**
 * Servlet implementation class CreateAccountServlet
 */
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at CreateAccountServlet: ").append(request.getContextPath());
		 	PrintWriter out = response.getWriter();
			String accountPin = request.getParameter("account_pin");
	        String balance = request.getParameter("balance");
	        String ifsc = request.getParameter("ifsc");
	        String branch = request.getParameter("branch");
	        String aadhaar = request.getParameter("aadhaar");
	        String pan = request.getParameter("pan");

	        HttpSession session = request.getSession();
	        String email = (String) session.getAttribute("email");
	        
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Integer userId = -1;

            String query = "SELECT user_id FROM User WHERE email = ?";
            try {
            	conn = DatabaseConnection.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, email);
		            rs = pstmt.executeQuery();

		          
					if (rs.next()) {
		                userId  = rs.getInt("user_id");
		            }
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
           
	        
	        try {
	            conn = DatabaseConnection.getConnection();

	            String sql = "INSERT INTO Account ( user_id, account_pin, balance, ifsc, branch, aadhar, pan) VALUES ( ?, ?, ?, ?, ?, ?, ?); ";

	            // Prepare statement
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, userId);
	            pstmt.setInt(2, Integer.parseInt(accountPin));
	            pstmt.setBigDecimal(3, new BigDecimal(balance));
	            pstmt.setString(4, ifsc);
	            pstmt.setString(5, branch);
	            pstmt.setString(6, aadhaar);
	            pstmt.setString(7, pan);

	            pstmt.executeUpdate();

				request.getRequestDispatcher("/WEB-INF/existingUserDashboard.jsp").forward(request, response);


	        } catch (SQLException e) {
	            // Handle errors for JDBC
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
