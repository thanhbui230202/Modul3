package com.example.case_study_furama_servlet.service.customer_service;

import com.example.case_study_furama_servlet.model.Customer;
import com.example.case_study_furama_servlet.model.CustomerType;
import com.example.case_study_furama_servlet.model.Division;

import java.util.List;

public interface CustomerTypeService {
     CustomerType findById(int id);
     List<CustomerType> findAll();
}
