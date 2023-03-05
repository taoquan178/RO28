package com.tn;

import com.tn.entity.Person;
import com.tn.repository.PersonRepository;

import java.util.List;

public class Applocation {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();

        List<Person> personList = personRepository.getlistPerson();
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
