package com.example.productmvc.util;

public class Constrain {
    public static final String FIND_ALL_PRODUCT = "select * from product";
    public static final String FIND_PRODUCT_BY_ID = "select * from product where id = ?";
    public static final String CREATE_PRODUCT = "insert into product values(?,?,?,?,?,?,?)";
    public static final String UPDATE_PRODUCT = "update product set name = ?, quantity = ?," +
            "price = ?, date_realease = ?, description= ?,category =? where id = ?";
    public static final String DELETE_PRODUCT_BY_ID = "delete from product where id = ?";
}
