package com.example.case_study_furama_servlet.repo.customer_repo;

import com.example.case_study_furama_servlet.model.Customer;
import com.example.case_study_furama_servlet.model.CustomerType;

import java.util.List;

public interface CustomerTypeRepo {
    CustomerType findById(int id);
    List<CustomerType> findAll();
}
