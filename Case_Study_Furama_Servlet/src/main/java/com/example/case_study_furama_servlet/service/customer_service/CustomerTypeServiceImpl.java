package com.example.case_study_furama_servlet.service.customer_service;

import com.example.case_study_furama_servlet.model.Customer;
import com.example.case_study_furama_servlet.model.CustomerType;
import com.example.case_study_furama_servlet.repo.customer_repo.CustomerTypeRepo;
import com.example.case_study_furama_servlet.repo.customer_repo.CustomerTypeRepoImpl;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService{
    private CustomerTypeRepo customerTypeRepo = new CustomerTypeRepoImpl();

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepo.findById(id);
    }

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepo.findAll();
    }
}
