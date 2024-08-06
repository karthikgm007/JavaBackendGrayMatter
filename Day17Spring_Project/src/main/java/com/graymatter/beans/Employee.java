package com.graymatter.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
public class Employee {

    // Injected using @Value from properties
    @Value("${Employee.empName}")
    private String empName;

    @Value("${Employee.empId}")
    private int empId;

    @Value("${Employee.empSal}")
    private double empSal;

    // Injected using constructor injection
    private Department department;

    @Autowired
    public Employee(Department department) {
        this.department = department;
    }

   
    @Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", empSal=" + empSal + ", department=" + department
				+ "]";
	}}
