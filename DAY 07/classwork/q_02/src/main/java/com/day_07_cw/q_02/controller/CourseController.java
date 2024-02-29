package com.day_07_cw.q_02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_07_cw.q_02.model.Course;
import com.day_07_cw.q_02.service.CourseService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CourseController {
    @Autowired
    public CourseService personService;

    @PostMapping("/api/course")
    public ResponseEntity<Course> postMethodName(@RequestBody Course entity) {
        Course p = personService.postAPerson(entity);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("/api/course")
    public ResponseEntity<List<Course>> getMethodName() {
        List<Course> p = personService.getAllPerson();

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/api/person/{courseName}")
    public ResponseEntity<List<Course>> getMethod(@PathVariable("courseName") String courseName) {
        List<Course> p = personService.getByAgePerson(courseName);

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
