package com.example.case_study_furama_servlet.service.employee_service;

import com.example.case_study_furama_servlet.model.Employee;

import java.util.List;

public interface EmployeeService {
    void add(Employee employee);
    void update(Employee employee);
    Employee findById(int id);
    void delete(Employee employee);
    List<Employee> findAll();
    List<Employee> searchByName(String name);
}
