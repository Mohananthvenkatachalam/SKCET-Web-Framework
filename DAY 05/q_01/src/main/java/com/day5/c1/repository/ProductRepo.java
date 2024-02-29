package com.day5.c1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day5.c1.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
