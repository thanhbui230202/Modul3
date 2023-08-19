package com.example.case_study_furama_servlet.model;

import java.time.LocalDate;

public class Employee {
    private int employee_id;
    private String employee_name;
    private LocalDate employee_birthday;
    private String employee_id_card;
    private Double employee_salary;
    private String employee_phone;
    private String employee_email;
    private String employee_address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private User username;

    public Employee() {
    }

    public Employee(int employee_id, String employee_name, LocalDate employee_birthday, String employee_id_card, Double employee_salary, String employee_phone, String employee_email, String employee_address, Position position_id, EducationDegree education_id, Division division_id, User username) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
        this.position = position_id;
        this.educationDegree = education_id;
        this.division = division_id;
        this.username = username;
    }

    public Employee(int id, String name, LocalDate date, String idCard, Double salary,
                    String phone, String email, String address, Position position,
                    EducationDegree educationDegree, Division division) {
        this.employee_id = id;
        this.employee_name = name;
        this.employee_birthday = date;
        this.employee_id_card = idCard;
        this.employee_salary = salary;
        this.employee_phone = phone;
        this.employee_email = email;
        this.employee_address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public LocalDate getEmployee_birthday() {
        return employee_birthday;
    }

    public void setEmployee_birthday(LocalDate employee_birthday) {
        this.employee_birthday = employee_birthday;
    }

    public String getEmployee_id_card() {
        return employee_id_card;
    }

    public void setEmployee_id_card(String employee_id_card) {
        this.employee_id_card = employee_id_card;
    }

    public Double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
}
