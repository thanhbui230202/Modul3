package com.example.case_study_furama_servlet.util;

public class ConstantEmployee {
    public static final String FIND_ALL_DIVISION = "Select * from division";
    public static final String FIND_DIVISION_BY_ID = "Select * from division "
            + "where division_id = ?";
    public static final String FIND_ALL_EDUCATION = "Select * from education_degree";
    public static final String FIND_EDUCATION_BY_ID = "Select * from education_degree "
            + "where education_degree_id = ?";

    public static final String FIND_ALL_POSITION = "Select * from position";
    public static final String FIND_POSITION_BY_ID = "Select * from position "
            + "where position_id = ?";

    public static final String FIND_ALL_EMPLOYEE = "Select * from employee ";
    public static final String FIND_EMPLOYEE_BY_ID = "Select * from employee " +
            "where employee_id = ?";
    public static final String CREATE_EMPLOYEE = "insert into employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id) " +
            "values(?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_EMPLOYEE = "update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?, " +
            "employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, " +
            "position_id = ?, education_degree_id = ?, division_id =? where employee_id = ?";
    public static final String DELETE_EMPLOYEE_BY_ID = "delete from  employee where employee_id = ? ";
    public static final String FIND_EMPLOYEE_BY_NAME = "select * from employee where employee_name like ?";

    public static final String FIND_EMPLOYEE_BY_NAME_OR_ID = "select * from employee where employee_name like ? or employee_id = ?";

}
