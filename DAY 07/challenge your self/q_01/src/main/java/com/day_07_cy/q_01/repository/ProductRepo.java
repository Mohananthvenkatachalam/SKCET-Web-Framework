package com.day_07_cy.q_01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day_07_cy.q_01.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByPriceCategory(String priceCategory);

    List<Product> findByProductCategory(String productCategory);;
}
