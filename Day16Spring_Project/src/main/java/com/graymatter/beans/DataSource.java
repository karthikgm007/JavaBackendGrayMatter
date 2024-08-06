package com.graymatter.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

	private String driverName;
	private String url;
	private String userName;
	private String pwd;
	public DataSource(String driverName, String url, String userName, String pwd) {
		super();
		this.driverName = driverName;
		this.url = url;
		this.userName = userName;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "DataSource [driverName=" + driverName + ", url=" + url + ", userName=" + userName + ", pwd=" + pwd
				+ "]";
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public DataSource() {
		super();
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(url, userName, pwd);
		return con;
	}

}
