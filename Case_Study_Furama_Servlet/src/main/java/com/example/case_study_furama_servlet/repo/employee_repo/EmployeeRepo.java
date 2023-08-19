package com.example.case_study_furama_servlet.repo.employee_repo;

import com.example.case_study_furama_servlet.model.Employee;

import java.util.List;

public interface EmployeeRepo {
    void add(Employee employee);
    void update(Employee employee);
    Employee findById(int id);
    void delete(Employee employee);
    List<Employee> findAll();
    List<Employee> searchByName(String name);
}
