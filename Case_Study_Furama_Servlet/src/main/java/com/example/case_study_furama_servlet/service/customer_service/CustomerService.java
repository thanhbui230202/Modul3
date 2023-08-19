package com.example.case_study_furama_servlet.service.customer_service;

import com.example.case_study_furama_servlet.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(int id);
    List<Customer> findAll();
    void add(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);

}
