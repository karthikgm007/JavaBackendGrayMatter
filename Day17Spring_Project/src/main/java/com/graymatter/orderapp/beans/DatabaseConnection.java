package com.graymatter.orderapp.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DatabaseConnection {

//	@Value("com.mysql.cj.jdbc.Driver")
	private String driver;
//	@Value("jdbc:mysql://localhost:3306/graymatterdb")
	private String url;
//	@Value("root")
	private String uname;
//	@Value("password")
	private String pwd;
	
	Connection con=null;
	
	
	@PostConstruct
	public void setup() {
		driver = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/graymatterdb";
		uname = "root";
		pwd = "password";
		System.out.println("Setup done");
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uname, pwd);
		return con;
	}
	@PreDestroy
	public void destroy() throws SQLException {
		con.close();
		System.out.println("connection closed");
	}
}
