package com.day_08_cw.q_02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_08_cw.q_02.model.Product;
import com.day_08_cw.q_02.service.ProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProductController {

    @Autowired
    public ProductService personService;

    @PostMapping("/product")
    public ResponseEntity<Product> postMethodName(@RequestBody Product entity) {
        Product p = personService.postAPerson(entity);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("/product/distinct/startWith/{name}")
    public ResponseEntity<List<Product>> getMethod(@PathVariable("name") String name) {
        List<Product> p = personService.getByStart(name);

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/product/distinct/endwith/{name}")
    public ResponseEntity<List<Product>> geMethod(@PathVariable("name") String name) {
        List<Product> p = personService.getByEnd(name);

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/product/sortBy/price")
    public ResponseEntity<List<Product>> geMethhod() {
        List<Product> p = personService.getAllPerson();

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
