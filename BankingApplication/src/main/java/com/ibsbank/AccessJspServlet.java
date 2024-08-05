package com.ibsbank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccessJspServlet
 */
public class AccessJspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessJspServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		  String action = request.getParameter("action");

	        if ("createAccount".equals(action)) {
	            request.getRequestDispatcher("/WEB-INF/createAccount.jsp").forward(request, response);
	        } else if ("page2".equals(action)) {
	            request.getRequestDispatcher("/WEB-INF/page2.jsp").forward(request, response);
	        } else if ("redirectExample".equals(action)) {
	            response.sendRedirect("redirectDestination.jsp");
	        } else {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND, "The requested page was not found.");
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
