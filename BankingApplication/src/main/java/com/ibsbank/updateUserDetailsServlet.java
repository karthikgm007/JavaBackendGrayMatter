package com.ibsbank;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibsbank.utilities.DatabaseConnection;

/**
 * Servlet implementation class updateUserDetailsServlet
 */
public class updateUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUserDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		PrintWriter out = response.getWriter();
		String query = "INSERT INTO User (first_name, last_name, email, password, phone_number, address) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
			
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String hashedPassword = hashPassword(password);
        String phoneNumber = request.getParameter("phone_number");
        String address = request.getParameter("address");

        if (firstName == null || lastName == null || email == null || password == null ||
            firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect("signup.jsp?error=Please fill in all required fields");
            return;
        }
		try {
			con = DatabaseConnection.getConnection();
			
			statement = con.prepareStatement(query);
			statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, hashedPassword);
            statement.setString(5, phoneNumber);
            statement.setString(6, address);
            
			out.print("<html> <body bgcolor = cyan > <h1>User Account created</h1> </body> </html>");
            statement.executeUpdate();
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 private String hashPassword(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            byte[] messageDigest = md.digest(password.getBytes());
	            BigInteger number = new BigInteger(1, messageDigest);
	            String hashedPassword = number.toString(16);
	            
	            // Pad with leading zeros if necessary
	            while (hashedPassword.length() < 64) {
	                hashedPassword = "0" + hashedPassword;
	            }
	            
	            return hashedPassword;
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
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
