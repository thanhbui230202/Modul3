package com.example.case_study_furama_servlet.util;

public class ConstantCustomer {
    public static final String FIND_CUSTOMER_TYPE_BY_ID = "Select * from customer_type where customer_type_id = ?";
    public static final String FIND_ALL_CUSTOMER_TYPE = "Select * from customer_type ";
    public static final String FIND_CUSTOMER_BY_ID = "Select * from customer where customer_id = ?";
    public static final String FIND_ALL_CUSTOMER = "Select * from customer ";

    public static final String CREATE_CUSTOMER = "insert into customer values(?,?,?,?,?,?,?,?,?) ";

    public static final String DELETE_CUSTOMER_BY_ID = "delete from customer where customer_id = ?";

    public static final String UPDATE_CUSTOMER = "update customer set customer_id = ?, customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ? where customer_id = ?";
}
