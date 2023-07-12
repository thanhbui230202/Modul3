package com.example.productmvc.service;

import com.example.productmvc.model.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);
    void delete(Product product);
    Product findByName(String name);
    Product findById(int id);
    void  update(Product product);

    List<Product> findAll();
}
