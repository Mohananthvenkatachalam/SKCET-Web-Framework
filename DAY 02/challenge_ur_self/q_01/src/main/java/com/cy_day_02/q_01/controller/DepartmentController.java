package com.cy_day_02.q_01.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cy_day_02.q_01.model.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class DepartmentController {

    @Autowired
    public Department department;

    @PostMapping("/department")
    public Department postMethodName(@RequestBody Department entity) {
        return entity;
    }
}
