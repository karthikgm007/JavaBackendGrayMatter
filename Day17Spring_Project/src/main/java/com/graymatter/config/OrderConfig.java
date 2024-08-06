package com.graymatter.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.graymatter.orderapp.beans.Customer;
import com.graymatter.orderapp.beans.DatabaseConnection;
import com.graymatter.orderapp.beans.Item;
import com.graymatter.orderapp.beans.Order;

@Configuration
@ComponentScan("com.graymatter.orderapp.beans")
//@PropertySource("classpath:data.properties")
public class OrderConfig {

//	@Bean
//	public List<Item> item(){
//		List<Item> itemList = new ArrayList<Item>();
//		Item i1 = new Item("item1", "123", item());
//		Item i2 = new Item("item1", "123", item());
//		Item i3 = new Item("item1", "123", item());
//		itemList = {i1, i2, i3};
//		return itemList;
//		
//	}
//	
//	@Bean
//	public Order order() {
//		return new Order(123, LocalDate.now(), item());
//	}
	
	 	@Bean
	    public Item item1() {
	        Item item = new Item();
	        item.setItemId("I001");
	        item.setItemName("Laptop");
	        item.setCostPerUnit(1200.00);
	        return item;
	    }

	    @Bean
	    public Item item2() {
	        Item item = new Item();
	        item.setItemId("I002");
	        item.setItemName("Mouse");
	        item.setCostPerUnit(25.00);
	        return item;
	    }

	    @Bean
	    public Order order() {
	        Order order = new Order();
	        order.setOrderId("O12345");
	        order.setOrderDate("2024-08-06");
	        order.setItemList(Arrays.asList(item1(), item2()));
	        return order;
	    }

	    @Bean	
	    public Customer customer() {
	        Customer customer = new Customer();
	        customer.setName("John Doe");
	        customer.setId("C001");
	        customer.setMobile("1234567890");
	        customer.setEmail("johndoe@example.com");
	        customer.setOrder(order());
	        return customer;
	    }

	    @Bean
	    public DatabaseConnection databaseConnection() {
	    	return new DatabaseConnection();
	    }
	    

}