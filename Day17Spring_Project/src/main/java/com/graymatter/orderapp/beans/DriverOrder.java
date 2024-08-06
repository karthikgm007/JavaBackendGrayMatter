package com.graymatter.orderapp.beans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.graymatter.config.OrderConfig;

public class DriverOrder {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		ApplicationContext context = new ClassPathXmlApplicationContext();
//		Customer c1 = context.getBean(Customer.class);
		 
//		//Using Beans
//		ApplicationContext context = new AnnotationConfigApplicationContext(OrderConfig.class);
//	    Customer customer = (Customer) context.getBean("customer");
//	    System.out.println(customer);
		
		
//		//Using @Component
//		 ApplicationContext context = new AnnotationConfigApplicationContext(OrderConfig.class);
//	        
//		 
//	        // Create and initialize items and order
//		 Item item1 = (Item) context.getBean("item");
//	        item1.setItemId("I001");
//	        item1.setItemName("Laptop");
//	        item1.setCostPerUnit(1200.00);
//	        
//			 Item item2 = (Item) context.getBean("item");
//	        item2.setItemId("I002");
//	        item2.setItemName("Mouse");
//	        item2.setCostPerUnit(25.00);
//
//	        Order order = (Order) context.getBean(Order.class);
//	        order.setOrderId("O12345");
//	        order.setOrderDate("2024-08-06");
//	        order.setItemList(Arrays.asList(item1, item2));
//
//	        Customer customer = (Customer) context.getBean(Customer.class);
//	        customer.setName("John Doe");
//	        customer.setId("C001");
//	        customer.setMobile("1234567890");
//	        customer.setEmail("johndoe@example.com");
//	        customer.setOrder(order);
//
//	        System.out.println(customer);
	  
	  ApplicationContext context = new AnnotationConfigApplicationContext(OrderConfig.class);
      Connection con=null;
      DatabaseConnection dataSource = (DatabaseConnection) context.getBean(DatabaseConnection.class);
      try {
			con= dataSource.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      System.out.println("connection created");
      RegionsUtility dbUtils=(RegionsUtility) context.getBean("regionsUtility");
      dbUtils.setCon(con);
      List<Regions> rlist= dbUtils.getAll();
      for(Regions r:rlist)
      	System.out.println(r.getRegion_id()+"  "+r.getRegion_name());
	
      //Add operation
      Regions reg = dbUtils.addRegion(new Regions(22, "India"));
      System.out.println(reg);
      
      //Get Region by ID
      Regions reg1 = dbUtils.getRegionById(22);
      System.out.println(reg1);
      
      //Update region
      Regions reg2 = new Regions(22, "Africa");
      Regions reg3 = dbUtils.updateRegion(reg2);
      System.out.println(reg3);
      
      //Delete Region
      dbUtils.deleteRegion(22);
      
      List<Regions> rlist1= dbUtils.getAll();
      for(Regions r:rlist1)
      	System.out.println(r.getRegion_id()+"  "+r.getRegion_name());
      
	}
}
