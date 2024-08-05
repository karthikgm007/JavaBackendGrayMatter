package com.quickbite;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quickbite.utilities.DatabaseConnection;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at SignUpServlet: ").append(request.getContextPath());
		   String name = request.getParameter("name");
	        String mobile = request.getParameter("mobile");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        
	        try {
	            Connection conn = DatabaseConnection.getConnection();
	            String sql = "INSERT INTO Customer (Name, Mobile, Email, Password) VALUES (?, ?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            PrintWriter out = response.getWriter();
	            stmt.setString(1, name);
	            stmt.setString(2, mobile);
	            stmt.setString(3, email);
	            stmt.setString(4, hashPassword(password));
				out.print("<html> <body bgcolor = cyan > <h1>User Account created</h1> </body> </html>");

	            stmt.executeUpdate();
	            
//	            response.sendRedirect("login.jsp");
	            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

	            
	            conn.close();
	        } catch (Exception e) {
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
