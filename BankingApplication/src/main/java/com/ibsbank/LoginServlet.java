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
import javax.servlet.http.HttpSession;

import com.ibsbank.utilities.DatabaseConnection;


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
		response.getWriter().append("Served at: LoginServlet").append(request.getContextPath());
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String hashedPassword = hashPassword(request.getParameter("password"));
		
		HttpSession session = request.getSession();
        session.setAttribute("email", email);
        
		Connection con=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PrintWriter out = response.getWriter();
		String query = "SELECT * FROM user WHERE email = ? AND password = ?";
		
		try {
			con = DatabaseConnection.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2,hashedPassword);
			rs = stmt.executeQuery();
			 if (rs.next()) {
				 request.getRequestDispatcher("ProcessUserServlet").forward(request, response);
			    }
			 else {
				out.print("<html> <body bgcolor = cyan > <h1>User does not exist. Create Account</h1> </body> </html>");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Hashing Password before storing in database
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
