package com.ibsbank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibsbank.utilities.DatabaseConnection;

/**
 * Servlet implementation class ProcessUserServlet
 */
public class ProcessUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served Process UserServlet at: ").append(request.getContextPath());

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection con = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        String userIdStrQuery = "SELECT * FROM user WHERE email = ? AND password = ?;";

        try {
            con = DatabaseConnection.getConnection(); 

            stmt = con.prepareStatement(userIdStrQuery);
            stmt.setString(1, email);
            stmt.setString(2, password); 

            rs = stmt.executeQuery();
            int userId = -1;
            if (rs.next()) {
                userId = rs.getInt("user_id");
            }

            String accountNumberQuery = "SELECT account_number FROM account WHERE user_id = ?;";
            stmt2 = con.prepareStatement(accountNumberQuery);
            stmt2.setInt(1, userId); 
            rs2 = stmt2.executeQuery();
            
            if (rs2.next()) {
                request.getRequestDispatcher("/WEB-INF/existingUserDashboard.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/newUserOnboard.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (rs2 != null) rs2.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt2 != null) stmt2.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
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
