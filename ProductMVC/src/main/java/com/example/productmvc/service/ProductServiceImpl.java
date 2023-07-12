package com.example.productmvc.service;

import com.example.productmvc.model.Product;
import com.example.productmvc.repo.ProductRepo;
import com.example.productmvc.repo.ProductRepoImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo = new ProductRepoImpl();

    @Override
    public void add(Product product) {
        productRepo.add(product);
    }

    @Override
    public void delete(Product product) {
        productRepo.delete(product);
    }

    @Override
    public Product findByName(String name) {
        for (Product p : productRepo.findAll()) {
            if (p.getName().equals(name)) {
                return p;
            }

        }
        return null;
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void update(Product product) {
        productRepo.update(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

}
