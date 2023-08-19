package com.example.case_study_furama_servlet.repo.employee_repo;

import com.example.case_study_furama_servlet.model.Division;
import com.example.case_study_furama_servlet.util.ConstantEmployee;
import com.example.case_study_furama_servlet.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepoImpl implements DivisionRepo{
    @Override
    public Division findById(int id) {
        Division division = null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(ConstantEmployee.FIND_DIVISION_BY_ID);
        ){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("division_name");
                division = new Division(id, name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return division;
    }


    @Override
    public List<Division> findAll() {
        List<Division> divisions = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery(ConstantEmployee.FIND_ALL_DIVISION);
            Division division;
            while (resultSet.next()) {
                int id = resultSet.getInt("division_id");
                String name = resultSet.getString("division_name");
                division = new Division(id, name);
                divisions.add(division);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return divisions;
    }
}

