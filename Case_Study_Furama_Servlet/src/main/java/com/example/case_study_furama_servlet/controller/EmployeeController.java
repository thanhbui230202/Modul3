package com.example.case_study_furama_servlet.controller;

import com.example.case_study_furama_servlet.model.Division;
import com.example.case_study_furama_servlet.model.EducationDegree;
import com.example.case_study_furama_servlet.model.Employee;
import com.example.case_study_furama_servlet.model.Position;
import com.example.case_study_furama_servlet.service.employee_service.*;
import com.example.case_study_furama_servlet.validate.EmployeeValidate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "employee",urlPatterns = "/employee")
public class EmployeeController extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private PositionService positionService = new PositionServiceImpl();
    private EducationDegreeService educationDegreeService = new EducationDegreeServiceImpl();
    private DivisionService divisionService = new DivisionServiceImpl();
    private EmployeeValidate validate = new EmployeeValidate();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "list_employee":
                viewListEmployee(req,resp);
                break;
            case "create_employee":
                viewCreateEmployee(req,resp);
                break;
            case "view_employee":
                viewDetailEmployee(req,resp);
                break;
            case "update_employee":
                viewUpdateEmployee(req,resp);
                break;
            case "delete_employee":
                doDeleteEmployee(req,resp);
                break;
            case "search_employee":
                doSearchByName(req,resp);
                break;
            default:
                viewListEmployee(req,resp);
                break;
        }
    }

    private void doSearchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search_name = req.getParameter("kw_name");
        String search_name_trim = search_name.trim();
        List<Employee> employees = null;
        if (search_name_trim.equals("")){
            employees = employeeService.findAll();
        }else {
            employees = employeeService.searchByName(search_name);
        }
        req.setAttribute("employees",employees);
        req.getRequestDispatcher("/view/Employee/EmployeeList.jsp").forward(req,resp);
    }

    private void viewListEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeService.findAll();
        req.setAttribute("employees",employees);
        req.getRequestDispatcher("/view/Employee/EmployeeList.jsp").forward(req,resp);
    }


    private void viewCreateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Position>positions = positionService.findAll();
        List<EducationDegree> educationDegrees = educationDegreeService.findAll();
        List<Division> divisions = divisionService.findAll();
        req.setAttribute("positions",positions);
        req.setAttribute("educations",educationDegrees);
        req.setAttribute("divisions",divisions);
        req.getRequestDispatcher("view/Employee/CreateEmployee.jsp").forward(req,resp);
    }
    // gửi employee qua trang viewdetail
    private void viewDetailEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = employeeService.findById(id);
        req.setAttribute("employee",employee);
        List<Position>positions = positionService.findAll();
        List<EducationDegree> educationDegrees = educationDegreeService.findAll();
        List<Division> divisions = divisionService.findAll();
        req.setAttribute("positions",positions);
        req.setAttribute("educations",educationDegrees);
        req.setAttribute("divisions",divisions);
        req.getRequestDispatcher("/view/Employee/ViewListEmployee.jsp").forward(req,resp);
    }

    private void viewUpdateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee  employee = employeeService.findById(id);
        List<Position>positions = positionService.findAll();
        List<EducationDegree> educationDegrees = educationDegreeService.findAll();
        List<Division> divisions = divisionService.findAll();
        req.setAttribute("employee", employee);
        req.setAttribute("positions",positions);
        req.setAttribute("educations",educationDegrees);
        req.setAttribute("divisions",divisions);
        req.getRequestDispatcher("view/Employee/UpdateEmployee.jsp").forward(req,resp);
    }

    private void doDeleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        employeeService.findById(id);
        employeeService.delete(employeeService.findById(id));
        viewListEmployee(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            resp.sendRedirect("/employee?action=list");
        }
        switch (action){
            case "create_employee":
                doCreateEmployee(req,resp);
                break;
            case "update_employee":
                doUpdateEmployee(req,resp);
                break;
            default:
        }
    }

    private void doUpdateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        String idCard = req.getParameter("idCard");
        Double salary = Double.parseDouble(req.getParameter("salary"));
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        int positionID = Integer.parseInt(req.getParameter("positionId"));
        Position position = positionService.findById(positionID);

        int euducationID = Integer.parseInt(req.getParameter("educationId"));
        EducationDegree educationDegree = educationDegreeService.findById(euducationID);

        int divisionID = Integer.parseInt(req.getParameter("divisionId"));
        Division division = divisionService.findById(divisionID);
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = new Employee(id,name,date,idCard,salary,phone,email,address,position,educationDegree,division);
        employeeService.update(employee);
        viewListEmployee(req,resp);
    }

    private void doCreateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isValidate = true;
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        String idCard = req.getParameter("idcard");
        String errIdCard = null;
        if (!validate.isCmnd(idCard)){
            isValidate = false;
            errIdCard = "Identity card is error";
        }
        String idCard_format ="";
        if (errIdCard  != null){
            req.setAttribute("errorIdCard",errIdCard);
        }else {
            idCard_format = idCard;
        }
        Double salary = Double.parseDouble(req.getParameter("salary"));
        String phone = req.getParameter("phone");
        String errorPhone = null;
        if (!validate.isPhone(phone)) {
            isValidate = false;
            errorPhone = "Phone number is error";
        }
        String phone_format = "";
        if (errorPhone != null) {
            req.setAttribute("errorPhone", errorPhone);
        } else {
            phone_format = phone;
        }
        String address = req.getParameter("address");

        String email = req.getParameter("email");
        int positionID = Integer.parseInt(req.getParameter("positionId"));
        Position position = positionService.findById(positionID);

        int euducationID = Integer.parseInt(req.getParameter("educationId"));
        EducationDegree educationDegree = educationDegreeService.findById(euducationID);

        int divisionID = Integer.parseInt(req.getParameter("divisionId"));
        Division division = divisionService.findById(divisionID);

//        String username = req.getParameter("userName");
        if (isValidate) {
            Employee employee = new Employee(id, name, date, idCard_format, salary, phone_format, email, address, position, educationDegree, division);
            employeeService.add(employee);
            viewListEmployee(req, resp);
        } else {
            viewCreateEmployee(req,resp);
        }
    }
}
