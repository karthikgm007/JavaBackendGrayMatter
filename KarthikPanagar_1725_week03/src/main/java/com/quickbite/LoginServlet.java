package com.quickbite;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quickbite.utilities.DatabaseConnection;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
        String hashedPassword = hashPassword(request.getParameter("password")); 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM Customer WHERE Email=? AND Password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, hashedPassword);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("userName", rs.getString("Name"));
                session.setAttribute("email", rs.getString("Email"));
                session.setAttribute("customerId", rs.getInt("Id"));
	            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            } else {
	            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	 private String hashPassword(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            byte[] messageDigest = md.digest(password.getBytes());
	            BigInteger number = new BigInteger(1, messageDigest);
	            String hashedPassword = number.toString(16);
	            
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
