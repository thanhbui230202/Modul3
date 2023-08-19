package com.example.case_study_furama_servlet.repo.customer_repo;

import com.example.case_study_furama_servlet.model.Customer;
import com.example.case_study_furama_servlet.model.CustomerType;
import com.example.case_study_furama_servlet.model.Division;
import com.example.case_study_furama_servlet.util.ConstantCustomer;
import com.example.case_study_furama_servlet.util.ConstantEmployee;
import com.example.case_study_furama_servlet.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepoImpl implements CustomerTypeRepo{
    @Override
    public CustomerType findById(int id) {
        CustomerType customerType = null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(ConstantCustomer.FIND_CUSTOMER_TYPE_BY_ID);
        ){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("customer_type_name");
                customerType = new CustomerType(id, name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return customerType;
    }

    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerTypes = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery(ConstantCustomer.FIND_ALL_CUSTOMER_TYPE);
            CustomerType customerType;
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                customerType = new CustomerType(id, name);
                customerTypes.add(customerType);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return customerTypes;
    }
}
