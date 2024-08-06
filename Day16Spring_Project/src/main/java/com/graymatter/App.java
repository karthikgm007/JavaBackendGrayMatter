package com.graymatter;

import java.sql.Connection;
import java.sql.SQLException;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;

import com.graymatter.beans.Customer;
import com.graymatter.beans.DataSource;
import com.graymatter.beans.HelloBean;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {

//    	HelloBean hb = new HelloBean();
//    	hb.sayHello();
    	
 //   	ApplicationContext context = new ClassPathXmlApplicationContext("hello-bean.xml");
//    	HelloBean hb = (HelloBean) context.getBean("hello");	//down casting
//    	hb.sayHello();
//    	
//    	HelloBean hb1 = new HelloBean();
//    	hb1.sayHello();
//    	
//        Customer c = new Customer("Karthik", 12, "212123321");
//        System.out.println(c);
        
   //     ApplicationContext context1=  new ClassPathXmlApplicationContext("customer-bean.xml");
        
        //Customer c1 = (Customer) context1.getBean("cust");
        //System.out.println(c1);
        
//        Customer c2 = (Customer) context1.getBean("cust");
//        System.out.println(c2);
       
//        Order ord = (Order) context1.getBean("ord");
  
    	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("db-bean.xml"));
    	DataSource ds =  (DataSource) factory.getBean("dbCon");
    	
    	Connection con = ds.getConnection();
    	System.out.println("connection Established");
    }
}
