package com.day_02_hm.q_01.controller;

import org.springframework.web.bind.annotation.RestController;

import com.day_02_hm.q_01.config.AppConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ApiController {

    @Autowired
    public AppConfig appconfig;

    @GetMapping("/info")
    public String getMethodName() {
        String str = "Student Name : " + appconfig.getStudentName() + ", Department : "
                + appconfig.getStudentDepartment();
        return str;
    }

}
