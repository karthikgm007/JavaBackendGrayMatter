package com.graymatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDriverTest {

    private AppPerson appPerson;
    private PersonDriver personDriver;
   

    @Test
    void testGetAllPersonsInfo() throws SQLException {
        List<Person> persons = appPerson.getAllPersonsInfo();
        assertNotNull(persons);
        //assertEquals(2, persons.size());
    }

    @Test
    void testGetPersonById() throws SQLException {
        Person person = appPerson.getPersonById(1);
        appPerson.addPerson(new Person(1, "John Doe", 30, "1234567890", "john@example.com"));
        assertNotNull(person);
        assertEquals("John Doe", person.getName());
        appPerson.deletePerson(1);
    }

    @Test
    void testAddPerson() throws SQLException {
        Person newPerson = new Person(3, "Alice", 22, "1112223333", "alice@example.com");
        appPerson.addPerson(newPerson);

        Person retrievedPerson = appPerson.getPersonById(3);
        assertNotNull(retrievedPerson);
        assertEquals("Alice", retrievedPerson.getName());
        appPerson.deletePerson(3);
    }

    @Test
    void testUpdatePerson() throws SQLException {
        Person updatedPerson = new Person(1, "John Smith", 31, "1234567890", "johnsmith@example.com");
        appPerson.updatePerson(updatedPerson);

        Person retrievedPerson = appPerson.getPersonById(1);
        assertNotNull(retrievedPerson);
        assertEquals("John Smith", retrievedPerson.getName());
        appPerson.deletePerson(1);
    }

    @Test
    void testDeletePerson() throws SQLException {
        int personId = 1;
        appPerson.deletePerson(personId);

        Person retrievedPerson = appPerson.getPersonById(personId);
        assertNull(retrievedPerson); // Assuming getPersonById returns null if not found
    }
    
    
//    @BeforeEach
//    void setUp() throws SQLException {
//        // Initialize AppPerson with a connection to a test database
//        // Here, you would need to implement your own logic to connect to a test database
//        // For example, you could use an H2 in-memory database
//
//        // appPerson = new AppPerson("jdbc:h2:mem:testdb"); // Example for H2
//        appPerson = new AppPerson(); // Modify with actual test database setup
//
//        // Populate the test database with initial data if necessary
//        appPerson.addPerson(new Person(1, "John Doe", 30, "1234567890", "john@example.com"));
//        appPerson.addPerson(new Person(2, "Jane Doe", 25, "0987654321", "jane@example.com"));
//
//        personDriver = new PersonDriver(appPerson); // Assuming PersonDriver has such a constructor
//    }
//
//    @AfterEach
//    void tearDown() throws SQLException {
//        // Clean up the test database
//        // For H2, it might be as simple as closing the connection
//        // appPerson.close(); // Implement this method in AppPerson if needed
//
//        // Here, you would need to implement your logic to clean up the database
//    }
}
