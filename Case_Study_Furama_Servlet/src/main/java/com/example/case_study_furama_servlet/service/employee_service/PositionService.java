package com.example.case_study_furama_servlet.service.employee_service;

import com.example.case_study_furama_servlet.model.Division;
import com.example.case_study_furama_servlet.model.Position;

import java.util.List;

public interface PositionService {
    Position findById(int id);
    List<Position> findAll();
}
