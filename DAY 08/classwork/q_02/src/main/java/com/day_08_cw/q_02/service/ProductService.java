package com.day_08_cw.q_02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_08_cw.q_02.model.Product;
import com.day_08_cw.q_02.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    public ProductRepo personRepo;

    public Product postAPerson(Product person) {
        return personRepo.save(person);
    }

    public List<Product> getAllPerson() {
        return personRepo.findBySort();
    }

    public List<Product> getByStart(String value) {
        return personRepo.findByNameStartsWith(value);
    }

    public List<Product> getByEnd(String value) {
        return personRepo.findByNameEndsWith(value);
    }
}
