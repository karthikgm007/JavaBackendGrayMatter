package com.graymatter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;

import lombok.EqualsAndHashCode.Include;

public class TestJunitMethods {

	JunitMethods c = new JunitMethods();
	
	@Test
	public void testAdd() {
		assertEquals(9, c.add(3,6));
	}
	
	@Test
	public void testSub() {
		assertEquals(9, c.subtract(15,6));
	}
	@Test
	public void testMul() {
		assertEquals(9, c.mul(3,3));
	}
	@Test
	public void testDiv() {
		assertEquals(4, c.divide(8,2));
	}
	
	@Test
	@Category(MarkerInterface.class)

	public void testFindKey() {
		int[] arr = {1,2,3,4,5};
		int key = 3;
		assertEquals(2, c.findKey(arr, key));
	}
	@Test
	@Category(MarkerInterface.class)
	public void testArrayEquals() {
		int[] exparr = {1,2,3,4,5,6};
		int[] actarr = {1,2,3,4,5,6};
		assertArrayEquals(exparr, c.arrayEquals(actarr)); 
	}
	
	@Test
	@Category(MarkerInterface.class)
	public void testCheckString() {
		assertNull(c.checkString());
	}
	
	@Test
	public void testCreateStudent() {
		Student expS =  new Student("abc", 1, 12);
		assertEquals(expS, c.createStudent());
	}
	
	
	static Connection con = null;
	@BeforeClass
	public static void configureConnection() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		DbConnection dbc = new DbConnection();
//		Connection con = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/graymatterdb","root","password");
		//con = new DbConnection("jdbc:mysql://localhost:3306/graymatterdb","root","password");
	}
	@Test
	public void testConnection() {
		assertNotNull(con);
	}
	
	
//	@Before
//	public void printLogBeforeEveryTest() {
//		System.out.println("Before Test");
//	}
//	@After
//	public void printLogAfterEveryTest() {
//		System.out.println("after Test");
//	}
//	
//	@BeforeClass 
//	public static void beforeClassMethod() {
//		System.out.println("Before Class");
//	}
//	@AfterClass 
//	public static void afterClassMethod() {
//		System.out.println("After Class");
//	}
	
}

