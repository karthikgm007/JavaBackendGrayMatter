package com.graymatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//load
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
		
		//connection
		String url ="jdbc:mysql://localhost:3306/graymatterdb";
		String username = "root";
		String password = "password";
		
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("connection established");
		
//		Statement st = con.createStatement();
//		String query = "select first_name, employee_id from employees";
//		
//		//store in a buffer
//		ResultSet rs = st.executeQuery(query);
//		
//		while(rs.next()) {
//			System.out.println(rs.getString(1) + " " + rs.getInt(2));
//		}
		
		String query = "insert into regions values(?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, 7);
		ps.setString(2, "India");
		int row = ps.executeUpdate();
		System.out.println("row inserted" + row);
		
		
		Statement st = con.createStatement();
		String query1 = "select * from regions ";
		
		//store in a buffer
		ResultSet rs = st.executeQuery(query1);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
//		
//		ResultSetMetaData rsmd = rs.getMetaData();
//		System.out.println(rsmd.toString());
//		
		
		rs.close();
		st.close();
		con.close();
		
	}

}
