package com.quickbite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NavigationServlet
 */
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String page = request.getParameter("page");

		if ("addOrder".equals(page)) {
            request.getRequestDispatcher("/WEB-INF/createOrder.jsp").forward(request, response);
        } else
		if ("addItem".equals(page)) {
            request.getRequestDispatcher("/WEB-INF/createItem.jsp").forward(request, response);
        }if ("logout".equals(page)) {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        if ("removeItem".equals(page)) {
            request.getRequestDispatcher("/WEB-INF/removeItem.jsp").forward(request, response);
        }
		else {
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
