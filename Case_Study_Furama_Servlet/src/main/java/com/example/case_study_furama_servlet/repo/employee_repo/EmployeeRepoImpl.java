package com.example.case_study_furama_servlet.repo.employee_repo;

import com.example.case_study_furama_servlet.model.Division;
import com.example.case_study_furama_servlet.model.EducationDegree;
import com.example.case_study_furama_servlet.model.Employee;
import com.example.case_study_furama_servlet.model.Position;
import com.example.case_study_furama_servlet.util.ConstantEmployee;
import com.example.case_study_furama_servlet.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepoImpl implements EmployeeRepo{
    private DivisionRepo divisionRepo = new DivisionRepoImpl();
    private PositionRepo positionRepo = new PositionRepoImpl();
    private EducationDegreeRepo educationDegreeRepo = new EducationDegreeRepoImpl();
    @Override
    public void add(Employee employee) {
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(ConstantEmployee.CREATE_EMPLOYEE);
        ){
            statement.setInt(1, employee.getEmployee_id());
            statement.setString(2, employee.getEmployee_name());
            statement.setDate(3, Date.valueOf(employee.getEmployee_birthday()));
            statement.setString(4, employee.getEmployee_id_card());
            statement.setDouble(5, employee.getEmployee_salary());
            statement.setString(6, employee.getEmployee_phone());
            statement.setString(7, employee.getEmployee_email());
            statement.setString(8, employee.getEmployee_address());
            statement.setInt(9,employee.getPosition().getPosition_id());
            statement.setInt(10,employee.getEducationDegree().getEducation_id());
            statement.setInt(11,employee.getDivision().getDivision_id());
//            statement.setString(12,employee.getUsername().getUsername());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Employee employee) {
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(ConstantEmployee.UPDATE_EMPLOYEE);
        ){
            statement.setInt(11, employee.getEmployee_id());
            statement.setString(1, employee.getEmployee_name());
            statement.setDate(2, Date.valueOf(employee.getEmployee_birthday()));
            statement.setString(3, employee.getEmployee_id_card());
            statement.setDouble(4, employee.getEmployee_salary());
            statement.setString(5, employee.getEmployee_phone());
            statement.setString(6, employee.getEmployee_email());
            statement.setString(7, employee.getEmployee_address());
            statement.setInt(8,employee.getPosition().getPosition_id());
            statement.setInt(9,employee.getEducationDegree().getEducation_id());
            statement.setInt(10,employee.getDivision().getDivision_id());
//            statement.setString(12,employee.getUsername().getUsername());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee =null;
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(ConstantEmployee.FIND_EMPLOYEE_BY_ID);
        ) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("employee_name");
                LocalDate date = resultSet.getDate("employee_birthday").toLocalDate();
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int position = resultSet.getInt("position_id");
                int education = resultSet.getInt("education_degree_id");
                int division = resultSet.getInt("division_id");
                Position position1 = positionRepo.findById(position);
                EducationDegree educationDegree = educationDegreeRepo.findById(education);
                Division division1 = divisionRepo.findById(division);
                employee = new Employee(id,name,date,idCard,salary,phone,email,address,position1,educationDegree,division1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
//        return productList;
        return employee;
    }

    @Override
    public void delete(Employee employee) {
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(ConstantEmployee.DELETE_EMPLOYEE_BY_ID);
                ){
            statement.setInt(1,employee.getEmployee_id());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try(
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(ConstantEmployee.FIND_ALL_EMPLOYEE);
            Employee employee;
            while (resultSet.next()){
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                LocalDate date = resultSet.getDate("employee_birthday").toLocalDate();
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int position = resultSet.getInt("position_id");
                int education = resultSet.getInt("education_degree_id");
                int division = resultSet.getInt("division_id");
                Position position1 = positionRepo.findById(position);
                EducationDegree educationDegree = educationDegreeRepo.findById(education);
                Division division1 = divisionRepo.findById(division);
                employee = new Employee(id,name,date,idCard,salary,phone,email,address,position1,educationDegree,division1);
                employees.add(employee);
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
//        return productList;
        return employees;
    }

    @Override
    public List<Employee> searchByName(String name) {
        List<Employee> employees;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(ConstantEmployee.FIND_EMPLOYEE_BY_NAME);
        ) {
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            employees = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                LocalDate date = resultSet.getDate(3).toLocalDate();
                String idCard = resultSet.getString(4);
                Double salary = resultSet.getDouble(5);
                String phone = resultSet.getString(6);
                String email = resultSet.getString(7);
                String address = resultSet.getString(8);
                int position = resultSet.getInt(9);
                int education = resultSet.getInt(10);
                int division = resultSet.getInt(11);
                Position position1 = positionRepo.findById(position);
                EducationDegree educationDegree = educationDegreeRepo.findById(education);
                Division division1 = divisionRepo.findById(division);
                employees.add(new Employee(id, name1, date, idCard, salary, phone, email, address, position1, educationDegree, division1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}

