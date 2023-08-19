package com.example.case_study_furama_servlet.repo.employee_repo;

import com.example.case_study_furama_servlet.model.EducationDegree;
import com.example.case_study_furama_servlet.util.ConstantEmployee;
import com.example.case_study_furama_servlet.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepoImpl implements EducationDegreeRepo{
    @Override
    public EducationDegree findById(int id) {
        EducationDegree educationDegree = null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(ConstantEmployee.FIND_EDUCATION_BY_ID);
        ){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("education_degree_name");
                educationDegree = new EducationDegree(id, name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return educationDegree;
    }

    @Override
    public List<EducationDegree> findAll() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(ConstantEmployee.FIND_ALL_EDUCATION);
            EducationDegree educationDegree;
            while (resultSet.next()) {
                int id = resultSet.getInt("education_degree_id");
                String name = resultSet.getString("education_degree_name");
                educationDegree = new EducationDegree(id, name);
                educationDegrees.add(educationDegree);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return educationDegrees;
    }
}
