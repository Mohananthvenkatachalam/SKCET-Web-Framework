package com.day_04_cw.q_03.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_04_cw.q_03.model.Product;
import com.day_04_cw.q_03.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    public ProductRepo productRepo;

    public boolean saveProduct(Product p) {
        try {
            productRepo.save(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }
}
