package com.example.case_study_furama_servlet.service.employee_service;

import com.example.case_study_furama_servlet.model.Position;
import com.example.case_study_furama_servlet.repo.employee_repo.PositionRepo;
import com.example.case_study_furama_servlet.repo.employee_repo.PositionRepoImpl;

import java.util.List;

public class PositionServiceImpl implements PositionService{
    private PositionRepo positionRepo = new PositionRepoImpl();
    @Override
    public Position findById(int id) {
        return positionRepo.findById(id);
    }

    @Override
    public List<Position> findAll() {
        return positionRepo.findAll();
    }
}
