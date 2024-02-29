package com.day_08_cw.q_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_08_cw.q_01.model.Person;
import com.day_08_cw.q_01.repository.PersonRepo;

@Service
public class PersonService {

    @Autowired
    public PersonRepo personRepo;

    public Person postAPerson(Person person) {
        return personRepo.save(person);
    }

    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }

    public List<Person> getByStart(String value) {
        return personRepo.findByNameStartsWith(value);
    }

    public List<Person> getByEnd(String value) {
        return personRepo.findByNameEndsWith(value);
    }
}
