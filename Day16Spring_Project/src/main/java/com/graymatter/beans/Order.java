package com.graymatter.beans;

import java.util.List;

public class Order {

	private int orderId;
	private List<String> itemList;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Order(int orderId, List<String> itemList) {
		super();
		this.orderId = orderId;
		this.itemList = itemList;
	}
	public List<String> getItemList() {
		return itemList;
	}
	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}
	public Order() {
		super();
	}
	
}
