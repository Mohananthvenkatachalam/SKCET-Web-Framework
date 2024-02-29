package com.day_08_cw.q_03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_08_cw.q_03.model.Student;
import com.day_08_cw.q_03.service.StudentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class StudentController {
    @Autowired
    public StudentService personService;

    @PostMapping("/student")
    public ResponseEntity<Student> postMethodName(@RequestBody Student entity) {
        Student p = personService.postAPerson(entity);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/student/marksGreaterThan/{mark}")
    public ResponseEntity<List<Student>> getMethod(@PathVariable("mark") int mark) {
        List<Student> p = personService.getByStart(mark);

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/student/marksLessThan/{mark}")
    public ResponseEntity<List<Student>> geMethod(@PathVariable("mark") int mark) {
        List<Student> p = personService.getByEnd(mark);

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
