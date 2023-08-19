package com.example.case_study_furama_servlet.service.employee_service;

import com.example.case_study_furama_servlet.model.Division;

import java.util.List;

public interface DivisionService {
    Division findById(int id);
    List<Division> findAll();
}
