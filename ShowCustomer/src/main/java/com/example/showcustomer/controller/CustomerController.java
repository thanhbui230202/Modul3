package com.example.showcustomer.controller;

import com.example.showcustomer.entity.Customer;
import com.example.showcustomer.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
    private CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerService.getList();
        req.setAttribute("customerList",customers);
        req.getRequestDispatcher("/customer/list_customer.jsp").forward(req,resp);
    }
}
