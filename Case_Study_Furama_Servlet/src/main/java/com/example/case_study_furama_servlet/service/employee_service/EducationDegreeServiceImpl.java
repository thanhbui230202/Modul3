package com.example.case_study_furama_servlet.service.employee_service;

import com.example.case_study_furama_servlet.model.EducationDegree;
import com.example.case_study_furama_servlet.repo.employee_repo.EducationDegreeRepo;
import com.example.case_study_furama_servlet.repo.employee_repo.EducationDegreeRepoImpl;

import java.util.List;

public class EducationDegreeServiceImpl implements EducationDegreeService{
    private EducationDegreeRepo educationDegreeRepo = new EducationDegreeRepoImpl();
    @Override
    public EducationDegree findById(int id) {
        return educationDegreeRepo.findById(id);
    }

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepo.findAll();
    }
}
