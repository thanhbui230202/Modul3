package com.example.case_study_furama_servlet.repo.customer_repo;

import com.example.case_study_furama_servlet.model.Customer;


import java.util.List;

public interface CustomerRepo {
    void add(Customer customer);
    void update(Customer customer);
    Customer findById(int id);
    void delete(Customer customer);
    List<Customer> findAll();
}
