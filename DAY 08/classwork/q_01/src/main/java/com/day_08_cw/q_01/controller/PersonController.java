package com.day_08_cw.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_08_cw.q_01.model.Person;
import com.day_08_cw.q_01.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PersonController {

    @Autowired
    public PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Person> postMethodName(@RequestBody Person entity) {
        Person p = personService.postAPerson(entity);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("/person/startsWithName/{value}")
    public ResponseEntity<List<Person>> getMethod(@PathVariable("value") String value) {
        List<Person> p = personService.getByStart(value);

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/person/endsWithName/{value}")
    public ResponseEntity<List<Person>> geMethod(@PathVariable("value") String value) {
        List<Person> p = personService.getByEnd(value);

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
