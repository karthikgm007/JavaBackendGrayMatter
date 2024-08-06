package com.graymatter.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
public class Book {
	@Value("${Book.bookName}")
	private String bookName;
	@Value("${Book.isbnNum}")
	private String isbnNum;
	@Value("${Book.price}")
	private double price;
	@Autowired
	private Author author;

}
