package com.graymatter.orderapp.beans;

import java.util.List;

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
//@Component
public class Order {
//	@Value("${Order.orderId}")
	 private String orderId;
//	@Value("${Order.orderId}")
	 private String orderDate;
	
	 private List<Item> itemList;
	 
	 @Autowired
	 Order(List<Item> itemList){
		 this.itemList = itemList;
	 }
}
