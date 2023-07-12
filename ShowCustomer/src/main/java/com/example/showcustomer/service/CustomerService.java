package com.example.showcustomer.service;

import com.example.showcustomer.entity.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {
    private static List<Customer> customerList;
    static {
        customerList = new ArrayList<>();
        customerList.add( new Customer("Mai Van Hoan","20/08/2023","Ha Noi","/img/anh_1.jpg"));
    }
    public List<Customer> getList(){
        return customerList;
    }
}
