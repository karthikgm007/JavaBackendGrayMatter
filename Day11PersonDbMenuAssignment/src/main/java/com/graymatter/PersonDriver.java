package com.graymatter;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PersonDriver {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		AppPerson app = new AppPerson();
		Scanner sc = new Scanner(System.in);
		boolean flag=true;
		
		do {
			System.out.println("1.Get All Persons Information \n2.Get Person By Id \n3.Add Person \n4.Update Person Informattion \n5. deletePerson \n6 Quit application");
			int i = sc.nextInt();
			switch(i) {
			case 1:
				List<Person> persons = app.getAllPersonsInfo();
				persons.forEach(p-> System.out.println(p));
				break;
			case 2:
				System.out.println("Enter id of the person to find");
				int i1 = sc.nextInt();
				Person p = app.getPersonById(i1);
				System.out.println("Found Person with given id" + p);
			    break;
			case 3:
				System.out.print("Enter ID: ");
		        int id = sc.nextInt();
		        sc.nextLine();

		        System.out.print("Enter Name: ");
		        String name = sc.nextLine();

		        System.out.print("Enter Age: ");
		        int age = sc.nextInt();
		        sc.nextLine();

		        System.out.print("Enter Mobile: ");
		        String mobile = sc.nextLine();

		        System.out.print("Enter Email: ");
		        String email = sc.nextLine();
		        Person person = new Person(id, name, age, mobile, email);
		        
		        app.addPerson(person);
		        System.out.println("Person added");
		        break;
			case 4:	
				System.out.println("Enter Details to be updated: ");
				System.out.print("Enter ID: ");
		        int id1 = sc.nextInt();
		        sc.nextLine();

		        System.out.print("Enter Name: ");
		        String name1 = sc.nextLine();

		        System.out.print("Enter Age: ");
		        int age1 = sc.nextInt();
		        sc.nextLine();

		        System.out.print("Enter Mobile: ");
		        String mobile1 = sc.nextLine();

		        System.out.print("Enter Email: ");
		        String email1 = sc.nextLine();
		        Person person1 = new Person(id1, name1, age1, mobile1, email1);
		        
		        app.updatePerson(person1);
		        break;
		        
			case 5: 
				System.out.println("Enter Person id to be deleted: ");
				System.out.print("Enter ID: ");
		        int id2 = sc.nextInt();
		        sc.nextLine();
		        app.deletePerson(id2);
		        break;
			case 6:
				flag = false;
				sc.close();
	            break;
			default:
				System.out.println("Invalid Choice");
			}	
		}while(flag);

	}

}
