package com.example.case_study_furama_servlet.service.employee_service;

import com.example.case_study_furama_servlet.model.Division;
import com.example.case_study_furama_servlet.model.EducationDegree;

import java.util.List;

public interface EducationDegreeService {
    EducationDegree findById(int id);
    List<EducationDegree> findAll();
}
