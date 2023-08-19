package com.example.case_study_furama_servlet.service.employee_service;

import com.example.case_study_furama_servlet.model.Division;
import com.example.case_study_furama_servlet.repo.employee_repo.DivisionRepo;
import com.example.case_study_furama_servlet.repo.employee_repo.DivisionRepoImpl;

import java.util.List;

public class DivisionServiceImpl implements DivisionService{
    private DivisionRepo divisionRepo = new DivisionRepoImpl();
    @Override
    public Division findById(int id) {
        return divisionRepo.findById(id);
    }

    @Override
    public List<Division> findAll() {
        return divisionRepo.findAll();
    }
}
