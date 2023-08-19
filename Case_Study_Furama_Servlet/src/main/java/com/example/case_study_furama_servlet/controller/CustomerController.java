package com.example.case_study_furama_servlet.controller;

import com.example.case_study_furama_servlet.model.Customer;
import com.example.case_study_furama_servlet.model.CustomerType;
import com.example.case_study_furama_servlet.service.customer_service.CustomerService;
import com.example.case_study_furama_servlet.service.customer_service.CustomerServiceImpl;
import com.example.case_study_furama_servlet.service.customer_service.CustomerTypeService;
import com.example.case_study_furama_servlet.service.customer_service.CustomerTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "customer", urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "list_customer":
                viewListCustomer(req,resp);
                break;
            case "create_customer":
                viewCreateCustomer(req,resp);
                break;
            case "view_customer":
                viewDetailCustomer(req,resp);
                break;
            case "update_customer":
                viewUpdateCustomer(req,resp);
                break;
            case "delete_customer":
                doDeleteCustomer(req,resp);
                break;
            default:
                viewListCustomer(req,resp);
                break;
        }
    }

    private void doDeleteCustomer(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void viewUpdateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerService.findById(id);
        List<CustomerType> customerTypes = customerTypeService.findAll();
        req.setAttribute("customer",customer);
        req.setAttribute("customerTypes",customerTypes);
        req.getRequestDispatcher("/view/Customer/UpdateCustomer.jsp").forward(req,resp);
    }

    private void viewDetailCustomer(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void viewCreateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        req.setAttribute("customerTypes",customerTypes);
        req.getRequestDispatcher("/view/Customer/CreateCustomer.jsp").forward(req,resp);
    }

    private void viewListCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerService.findAll();
        req.setAttribute("customers",customers);
        req.getRequestDispatcher("/view/Customer/CustomerList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create_customer":
                doCreateCustomer(req,resp);
                break;
            case  "update_customer":
                doUpdate(req,resp);
                break;
        }
    }

    private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idType = Integer.parseInt(req.getParameter("typeID"));
        CustomerType customerType = customerTypeService.findById(idType);
        String name = req.getParameter("name");
        LocalDate date = LocalDate.parse(req.getParameter("birthday"));
        String genderAsString = req.getParameter("gender");
        boolean gender = "male".equals(genderAsString) ? true : false;
        String idCard = req.getParameter("idCard");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = new Customer(id,customerType,name,date,gender,idCard,phone,email,address);
        customerService.update(customer);
        viewListCustomer(req,resp);
    }

    private void doCreateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int idCustomerType = Integer.parseInt(req.getParameter("customerTypeID"));
        CustomerType customerType = customerTypeService.findById(idCustomerType);
        String name = req.getParameter("name");
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        String genderAsString = req.getParameter("gender");
        boolean gender = "male".equals(genderAsString) ? true : false;
        String idCard = req.getParameter("idcard");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Customer customer = new Customer(id,customerType,name,date,gender,idCard,phone,email,address);
        customerService.add(customer);
        viewListCustomer(req,resp);
    }
}
