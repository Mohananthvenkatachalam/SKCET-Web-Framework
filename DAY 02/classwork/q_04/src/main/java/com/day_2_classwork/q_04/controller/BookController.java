package com.day_2_classwork.q_04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.day_2_classwork.q_04.model.Book;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BookController {

    @Autowired
    public Book book;

    @GetMapping("/book")
    public Book getMethodName() {
        return book;
    }

}
