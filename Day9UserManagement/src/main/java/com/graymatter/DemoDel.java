package com.grayMatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
* Servlet implementation class LoginServlet
*/
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    DataSourceClass ds = new DataSourceClass();

 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/graymatterdb","root","password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement st=null;
//		DataSourceClass dc=new DataSourceClass();
//		try {
//			con=dc.getConnection();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
       String query="select * from user ";
       try {
    	   System.out.println(con.toString());
			st=con.createStatement();
			rs = st.executeQuery(query);
			RequestDispatcher dispatcher;
			System.out.println(rs);
			System.out.println(username);
			System.out.println(password);
			while(rs.next())
			{
				System.out.println(rs.getString(2)+" "+rs.getString(3));
				if(rs.getString(2).equals(name) && rs.getString(3).equals(pwd))
				{
					request.setAttribute("usernname", name);
					dispatcher=request.getRequestDispatcher("WelcomeServlet");
					dispatcher.forward(request, response);
				}
			}
			dispatcher=request.getRequestDispatcher("ErrorServlet");
			dispatcher.forward(request, response);
 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
has context menu