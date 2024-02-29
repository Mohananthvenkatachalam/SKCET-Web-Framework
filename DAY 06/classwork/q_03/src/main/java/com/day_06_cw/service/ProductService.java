package com.day_06_cw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.day_06_cw.model.Product;
import com.day_06_cw.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    public ProductRepo childrenRepo;

    public Product postChild(Product children) {
        return childrenRepo.save(children);
    }

    public List<Product> getByPaginate(int offset, int pageSize) {
        Page<Product> childrenPage = childrenRepo.findAll(PageRequest.of(offset, pageSize));
        return childrenPage.getContent();
    }

    public List<Product> getByPaginateSort(int offset, int pageSize, String field) {
        Page<Product> pg = childrenRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
        return pg.getContent();
    }

    public Optional<Product> getBiProdId(int id) {
        return childrenRepo.findById(id);
    }
}
