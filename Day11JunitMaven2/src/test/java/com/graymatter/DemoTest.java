package com.graymatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoTest {
	
	@Test	
	public void testPrintname() {
		Assertions.assertEquals("abc", DemoClass.printName());

	}
	
	@BeforeEach
	public void printBeforeEach() {
		System.out.println("Before every test");
	}
	
	
	
	
	
}
