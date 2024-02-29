package com.day_07_cy.q_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_07_cy.q_01.model.Product;
import com.day_07_cy.q_01.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    public ProductRepo personRepo;

    public Product postAPerson(Product person) {
        return personRepo.save(person);
    }

    public List<Product> getAllPerson() {
        return personRepo.findAll();
    }

    public List<Product> getByAgePerson(String cat) {
        return personRepo.findByProductCategory(cat);
    }

    public List<Product> getByAgePersonCat(String cat) {
        return personRepo.findByPriceCategory(cat);
    }
}
