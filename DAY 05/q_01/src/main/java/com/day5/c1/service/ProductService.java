package com.day5.c1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day5.c1.model.Product;
import com.day5.c1.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(int productId, Product product) {
        product.setProductId(productId);
        return productRepo.save(product);
    }

    public boolean deleteProduct(int productId) {
        if (productRepo.existsById(productId)) {
            productRepo.deleteById(productId);
            return true;
        }
        return false;
    }
}
