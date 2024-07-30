package com.graymatter;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppPerson implements PersonInterface{
	
	@Override
	public List<Person> getAllPersonsInfo() throws SQLException {
		// TODO Auto-generated method stub
	    List<Person> persons = new ArrayList<>();
	    //create connection
		Connection con = DatabaseConnection.getConnection();
		//create statement
		String query= "select * from persons";
		PreparedStatement stmt = con.prepareStatement(query);
		//Executing statement storing result from query
	    ResultSet rs = stmt.executeQuery();
	    
	    while (rs.next()) {
	    	Person person = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("mobile") , rs.getString("email"));             
	        persons.add(person);
	        }
	    return persons;
	}

	@Override
	public Person getPersonById(int id) throws SQLException {

		Person person = null;
		Connection con = DatabaseConnection.getConnection();
        String query = "SELECT * FROM persons WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
	    ResultSet rs = stmt.executeQuery();
	    if (rs.next()) {
            person = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("mobile") , rs.getString("email"));
        }
		return person;
	}

	@Override
	public void addPerson(Person p) throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO persons (id, name, age, mobile, email) VALUES (?, ?, ?, ?, ?)";
      
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
            
        stmt.setInt(1, p.getId());
        stmt.setString(2, p.getName());
        stmt.setInt(3, p.getAge());
        stmt.setString(4, p.getEmail());
        stmt.setString(5, p.getMobile());
        stmt.executeUpdate();
	}

	@Override
	public void updatePerson(Person p) throws SQLException {
		String query2 = "INSERT INTO persons (id, name, age, mobile, email) VALUES (?, ?, ?, ?, ?)";
      
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query2);
        
        //verify if person exists
        String query1 = "SELECT * FROM persons WHERE id = ?";
        PreparedStatement stmt1 = conn.prepareStatement(query1);
        
        stmt1.setInt(1, p.getId());
	    ResultSet rs = stmt1.executeQuery();
	    
	    if(rs.next()) {
	    	stmt.setInt(1, p.getId());
	        stmt.setString(2, p.getName());
	        stmt.setInt(3, p.getAge());
	        stmt.setString(4, p.getEmail());
	        stmt.setString(5, p.getMobile());
	        stmt.executeUpdate();
	        System.out.println("Person record updated");
	    }
	    else {
	    	System.out.println("Person with given id does not exist. Create new record");
	    }
	}

	@Override
	public void deletePerson(int id) throws SQLException {

		String query = "DELETE FROM persons WHERE id = ?";
	    Connection conn = DatabaseConnection.getConnection();
	    PreparedStatement stmt = conn.prepareStatement(query);
	    
	    //verify if person exists
	    String query1 = "SELECT * FROM persons WHERE id = ?";
        PreparedStatement stmt1 = conn.prepareStatement(query1);
        
        stmt1.setInt(1, id);
	    ResultSet rs = stmt1.executeQuery();
	    
	    if(rs.next()) {
	    	 stmt.setInt(1, id);
	         stmt.executeUpdate();
	         System.out.println("Person Deleted");
	    }
	    else {
	    	System.out.println("Person does not exist with this id.");
	    } 
	}

	
}
