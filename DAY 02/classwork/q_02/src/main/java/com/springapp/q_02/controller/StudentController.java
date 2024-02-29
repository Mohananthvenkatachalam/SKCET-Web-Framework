package com.springapp.q_02.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springapp.q_02.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {

    @Autowired
    public Student st;

    @PostMapping("/students")
    public Student postMethodName(@RequestBody Student entity) {
        st.setName(entity.getName());
        st.setAge(entity.getAge());
        return entity;
    }
}
