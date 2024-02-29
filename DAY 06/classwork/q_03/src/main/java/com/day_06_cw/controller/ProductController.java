package com.day_06_cw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_06_cw.model.Product;
import com.day_06_cw.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductController {
    @Autowired
    public ProductService childrenService;

    @PostMapping("/api/product")
    public ResponseEntity<Product> postMethodName(@RequestBody Product entity) {
        Product p = childrenService.postChild(entity);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/product/{productId}")
    public ResponseEntity<Product> getMethodName(@PathVariable("productId") int productId) {
        Optional<Product> p = childrenService.getBiProdId(productId);

        if (p.isPresent()) {
            return new ResponseEntity<>(p.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(p.get(), HttpStatus.OK);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/api/product/{offset}/{pagesize}")
    public ResponseEntity<List<Product>> getMethodName(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pageSize) {
        List<Product> ch = childrenService.getByPaginate(offset, pageSize);
        if (ch.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ch, HttpStatus.OK);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/api/product/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Product>> getMethod(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pageSize, @PathVariable("field") String field) {
        List<Product> ch = childrenService.getByPaginateSort(offset, pageSize, field);
        if (ch.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ch, HttpStatus.OK);
    }

}
