package com.example.case_study_furama_servlet.repo.employee_repo;

import com.example.case_study_furama_servlet.model.Division;

import java.util.List;

public interface DivisionRepo {
    Division findById(int id);
    List<Division> findAll();
}
