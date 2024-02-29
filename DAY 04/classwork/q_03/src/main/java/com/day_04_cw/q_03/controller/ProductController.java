package com.day_04_cw.q_03.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_04_cw.q_03.model.Product;
import com.day_04_cw.q_03.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductController {

    @Autowired
    public ProductService productService;

    @PostMapping("/api/product")
    public ResponseEntity<String> postMethodName(@RequestBody Product entity) {
        if (productService.saveProduct(entity) == false) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/product")
    public ResponseEntity<List<Product>> getMethodName() {
        List<Product> pro = productService.getAllProducts();
        if (pro.isEmpty()) {
            return new ResponseEntity<>(pro, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pro, HttpStatus.OK);
    }

    @GetMapping("/api/product/{productId}")
    public ResponseEntity<Product> getProductId(@PathVariable int productId) {
        Optional<Product> pro = productService.getProductById(productId);
        if (pro.isPresent()) {
            return new ResponseEntity<>(pro.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
