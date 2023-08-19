package com.example.case_study_furama_servlet.validate;

import com.example.case_study_furama_servlet.service.employee_service.EmployeeService;
import com.example.case_study_furama_servlet.service.employee_service.EmployeeServiceImpl;

public class EmployeeValidate {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    //phone number
    private static final String PHONE_FORMAT="^[0]9[01][0-9]{6}$";
    public  boolean isPhone(String Phone)
    {
        return Phone.matches(PHONE_FORMAT);
    }
    //cmnd
    private static final String CMND_FORMAT="^\\d{9}$|^\\d{12}$";
    public boolean isCmnd(String cmnd){return cmnd.matches(CMND_FORMAT);}
    //email
    private static final String EMAIL_FORMAT="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public boolean isEmail(String email){return email.matches(EMAIL_FORMAT);}
    //nameEmployeeViDu
    private static final String NAME_FORMAT="^KH-\\d{4}$";
    public boolean isName(String name){return name.matches(EMAIL_FORMAT);}
}

