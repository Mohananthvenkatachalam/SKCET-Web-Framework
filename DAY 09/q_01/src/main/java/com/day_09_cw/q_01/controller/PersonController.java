package com.day_09_cw.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_09_cw.q_01.model.Person;
import com.day_09_cw.q_01.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PersonController {

    @Autowired
    public PersonService personService;

    @PostMapping("/api/person")
    public ResponseEntity<Person> postMethodName(@RequestBody Person entity) {
        Person p = personService.savePerson(entity);

        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/api/person/byage/{age}")
    public ResponseEntity<List<Person>> getMethodName(@PathVariable("age") int age) {
        List<Person> p = personService.getByAgePerson(age);
        if (p.isEmpty()) {
            return new ResponseEntity(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(p, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
