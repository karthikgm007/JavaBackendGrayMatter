package com.graymatter;

import java.util.List;

public interface PersonInterface {
    
    List<Person> getAllPersonsInfo();
    Person getPersonById(int id);
    void addPerson(Person p);
    Person updatePerson(Person p, int id);
    void deletePerson(int id);
}

