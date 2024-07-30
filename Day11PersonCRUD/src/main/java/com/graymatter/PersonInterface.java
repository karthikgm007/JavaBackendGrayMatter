package com.graymatter;

import java.sql.SQLException;
import java.util.List;

public interface PersonInterface {

	    List<Person> getAllPersonsInfo() throws SQLException;
	    
	    Person getPersonById(int id) throws SQLException;
	    
	    void addPerson(Person p) throws SQLException; 
	    
	    void updatePerson(Person p) throws SQLException;
	    
	    void deletePerson(int id) throws SQLException;	
}
