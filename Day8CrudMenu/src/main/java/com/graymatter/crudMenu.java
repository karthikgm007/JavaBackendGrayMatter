package com.graymatter;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 
public class crudMenu {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/graymatterdb";
	String username="root";
	String password="password";
	
	Connection con=DriverManager.getConnection(url,username,password);
	boolean flag=true;
	
	do {
		System.out.println("1. Create record\n2. Update record\n3. Read\n4. Delete record\n5. Exit");
		Scanner sc=new Scanner(System.in);
		int i = sc.nextInt();
		switch(i) {
		case 1:
			String iQuery="Insert into regions values(?,?)";
			PreparedStatement ps = con.prepareStatement(iQuery);
			System.out.print("Enter Region Id:");
			int id = sc.nextInt();
			System.out.println("Enter Region Name:");
			String name = sc.next();
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.executeUpdate();
			System.out.println("Successfully created thr record");
			break;
		case 2:
			String query="update regions set region_name = ? where region_id=?";
		     PreparedStatement ps1 = con.prepareStatement(query);
		     System.out.print("Enter Region Id To be Updated:");
			 int uid=sc.nextInt();
			 System.out.println("Enter Region Name To be Added:");
			 String uname=sc.next();
		     ps1.setString(1, uname);
		     ps1.setInt(2, uid);
		     ps1.executeUpdate();
		     System.out.println("Successfully Updated");
		     break;
		case 4:
			query ="delete from regions where region_id=?";
	        	ps1=con.prepareStatement(query);
	        	ps1.setInt(1,7);
	        	ps1.executeUpdate();
 
               System.out.println("row deleted successfully");
               break;
		case 3:	
			 Statement st1 = con.createStatement();
			 String query3= "Select * from regions";
		     ResultSet rs1= st1.executeQuery(query3);
		     System.out.println("Region Id   Region_Name");
			 while(rs1.next()) {
			 System.out.println(rs1.getInt(1)+"           "+rs1.getString(2));
			 }
            break;
		case 5:
			flag = false;
			break;
		default:
			System.out.println("Invalid Choice");
		}	
	}while(flag);

}
}