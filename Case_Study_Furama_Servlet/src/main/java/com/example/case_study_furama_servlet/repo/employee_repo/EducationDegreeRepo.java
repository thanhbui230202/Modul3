package com.example.case_study_furama_servlet.repo.employee_repo;

import com.example.case_study_furama_servlet.model.EducationDegree;

import java.util.List;

public interface EducationDegreeRepo {
    EducationDegree findById(int id);
    List<EducationDegree> findAll();
}
