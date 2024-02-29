package com.springapp.q_03.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springapp.q_03.model.Student;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getMethodName() {
        Student st = new Student(1L, "John Doe", "This is a student discription");
        return st;
    }

}
