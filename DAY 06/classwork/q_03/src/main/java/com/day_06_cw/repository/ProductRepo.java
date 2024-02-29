package com.day_06_cw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day_06_cw.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
