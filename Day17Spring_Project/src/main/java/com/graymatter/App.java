package com.graymatter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.graymatter.beans.Book;
import com.graymatter.beans.Employee;
import com.graymatter.config.BookConfig;

public class App 
{
    public static void main( String[] args )
    {

//    ApplicationContext context = new ClassPathXmlApplicationContext("emp-bean.xml");
//    Employee emp1 = context.getBean(Employee.class);   //OR emp
//    
//    System.out.println(emp1);
    	ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
    	Book book = (Book) context.getBean("book");
    	System.out.println(book);
    }
}
