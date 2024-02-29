package com.mohan.q_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohan.q_01.config.AppConfig;

@RestController
public class ApiController {

    @Autowired
    public AppConfig appConfig;

    @GetMapping("/appconfig")
    public AppConfig RetString() {
        // String str = appConfig.getAppName() + " " + appConfig.getAppVersion();
        return appConfig;
    }
}
