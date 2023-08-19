package com.example.case_study_furama_servlet.service.employee_service;

import com.example.case_study_furama_servlet.model.Employee;
import com.example.case_study_furama_servlet.repo.employee_repo.EmployeeRepo;
import com.example.case_study_furama_servlet.repo.employee_repo.EmployeeRepoImpl;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepo employeeRepo = new EmployeeRepoImpl();

    @Override
    public void add(Employee employee) {
        employeeRepo.add(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepo.update(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepo.findById(id);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepo.delete(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepo.searchByName(name);
    }
}
