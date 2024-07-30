package com.graymatter;

import java.util.ArrayList;
import java.util.List;

public class PerosnImplementation implements PersonInterface{

	List<Person> people;
	
	@Override
	public List<Person> getAllPersonsInfo() {
		return people;
	}

	@Override
	public Person getPersonById(int id) {

		this.people.stream().filter(i - > i.get).)
	}

	@Override
	public void addPerson(Person p) {
		if(people == null) {
			people = new ArrayList<Person>()
		}
		people.add(p);
		System.out.println("Person Added");
	}

	@Override
	public Person updatePerson(Person p, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePerson(int id) {
		// TODO Auto-generated method stub
		
	}
  
	
		 

    
    }
}
