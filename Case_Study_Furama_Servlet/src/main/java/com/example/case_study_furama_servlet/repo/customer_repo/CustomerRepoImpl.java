package com.example.case_study_furama_servlet.repo.customer_repo;

import com.example.case_study_furama_servlet.model.*;
import com.example.case_study_furama_servlet.util.ConstantCustomer;
import com.example.case_study_furama_servlet.util.ConstantEmployee;
import com.example.case_study_furama_servlet.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepoImpl implements CustomerRepo{
    CustomerTypeRepo customerTypeRepo = new CustomerTypeRepoImpl();
    @Override
    public void add(Customer customer) {
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(ConstantCustomer.CREATE_CUSTOMER);
        ){
            statement.setInt(1,customer.getCustomer_id());
            statement.setInt(2,customer.getCustomer_type().getCustomer_type_id());
            statement.setString(3,customer.getCustomer_name());
            statement.setDate(4,Date.valueOf(customer.getCustomer_birthday()));
            statement.setBoolean(5,customer.isCustomer_gender());
            statement.setString(6,customer.getCustomer_id_card());
            statement.setString(7,customer.getCustomer_phone());
            statement.setString(8,customer.getCustomer_email());
            statement.setString(9,customer.getCustomer_address());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Customer customer) {
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(ConstantCustomer.UPDATE_CUSTOMER);
        ){
            statement.setInt(9,customer.getCustomer_id());
            statement.setInt(1,customer.getCustomer_type().getCustomer_type_id());
            statement.setString(2,customer.getCustomer_name());
            statement.setDate(3,Date.valueOf(customer.getCustomer_birthday()));
            statement.setBoolean(4,customer.isCustomer_gender());
            statement.setString(5,customer.getCustomer_id_card());
            statement.setString(6,customer.getCustomer_phone());
            statement.setString(7,customer.getCustomer_email());
            statement.setString(8,customer.getCustomer_address());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer findById(int id) {
        Customer customer =null;
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(ConstantCustomer.FIND_CUSTOMER_BY_ID);
        ) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int customerTypeID = resultSet.getInt("customer_type_id");
                CustomerType customerType = customerTypeRepo.findById(customerTypeID);
                String name = resultSet.getString("customer_name");
                LocalDate date = resultSet.getDate("customer_birthday").toLocalDate();
                Boolean gender = resultSet.getBoolean("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customer = new Customer(id,customerType,name,date,gender,idCard,phone,email,address);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try(
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(ConstantCustomer.FIND_ALL_CUSTOMER);
            Customer customer;
            while (resultSet.next()){
                int id = resultSet.getInt("customer_id");
                int customerTypeID = resultSet.getInt("customer_type_id");
                CustomerType customerType = customerTypeRepo.findById(customerTypeID);
                String name = resultSet.getString("customer_name");
                LocalDate date = resultSet.getDate("customer_birthday").toLocalDate();
                Boolean gender = resultSet.getBoolean("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customer = new Customer(id,customerType,name,date,gender,idCard,phone,email,address);
                customers.add(customer);
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}
