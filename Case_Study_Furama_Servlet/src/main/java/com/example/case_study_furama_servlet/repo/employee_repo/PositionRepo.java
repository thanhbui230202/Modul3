package com.example.case_study_furama_servlet.repo.employee_repo;

import com.example.case_study_furama_servlet.model.Position;

import java.util.List;

public interface PositionRepo {
    Position findById(int id);
    List<Position> findAll();
}
