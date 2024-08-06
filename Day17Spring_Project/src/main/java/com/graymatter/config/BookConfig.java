package com.graymatter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.graymatter.beans.Author;
import com.graymatter.beans.Book;

//Configuration file for the application instead of xml
@Configuration
@ComponentScan("com.graymatter.beans")	//or universal one to scan 
@PropertySource("classpath:data.properties")
public class BookConfig {

	//define bean
	//supply values to bean properties
	
//	@Bean(name="book")	//if "book" given and methodName not book
//	public Book myBook() {
//		return new Book("Java", "Java2133", 100, getAuthor());
//	}
//	
//	@Bean(name="author")
//	public Author getAuthor() {
//		return new Author("Karthik", "12");
//		
//	}
	
}
