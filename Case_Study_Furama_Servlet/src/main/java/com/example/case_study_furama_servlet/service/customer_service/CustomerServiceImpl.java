package com.example.case_study_furama_servlet.service.customer_service;

import com.example.case_study_furama_servlet.model.Customer;
import com.example.case_study_furama_servlet.repo.customer_repo.CustomerRepo;
import com.example.case_study_furama_servlet.repo.customer_repo.CustomerRepoImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private CustomerRepo customerRepo = new CustomerRepoImpl();
    @Override
    public Customer findById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public void add(Customer customer) {
        customerRepo.add(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepo.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepo.delete(customer);
    }

}
