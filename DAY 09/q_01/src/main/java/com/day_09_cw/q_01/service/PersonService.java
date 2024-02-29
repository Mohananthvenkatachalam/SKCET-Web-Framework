package com.day_09_cw.q_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_09_cw.q_01.model.Person;
import com.day_09_cw.q_01.repository.PersonRepo;

@Service
public class PersonService {

    @Autowired
    public PersonRepo personRepo;

    public Person savePerson(Person person) {
        return personRepo.save(person);
    }

    public List<Person> getByAgePerson(int age) {
        return personRepo.findListByAge(age);
    }
}
