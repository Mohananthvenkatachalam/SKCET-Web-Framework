package com.day_07_cy.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_07_cy.q_01.model.Product;
import com.day_07_cy.q_01.service.ProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ProductController {
    @Autowired
    public ProductService personService;

    @PostMapping("/api/product")
    public ResponseEntity<Product> postMethodName(@RequestBody Product entity) {
        Product p = personService.postAPerson(entity);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("/api/product")
    public ResponseEntity<List<Product>> getMethodName() {
        List<Product> p = personService.getAllPerson();

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/api/product/category/{productCategory}")
    public ResponseEntity<List<Product>> getMethod(@RequestParam("productCategory") String productCategory) {
        List<Product> p = personService.getByAgePerson(productCategory);

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/api/product/pricecategory/{priceCategory}")
    public ResponseEntity<List<Product>> getsMethod(@RequestParam("priceCategory") String priceCategory) {
        List<Product> p = personService.getByAgePersonCat(priceCategory);

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
