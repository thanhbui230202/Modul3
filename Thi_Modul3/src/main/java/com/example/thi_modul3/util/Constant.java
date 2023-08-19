package com.example.thi_modul3.util;

public class Constant {
    public static final String FIND_BENH_AN_BY_ID = "Select * from benh_an where mabenhan = ?";
    public static final String FIND_ALL_BENH_AN = "select * from benh_an ";

    public static final String FIND_BENH_NHAN_BY_ID = "Select * from benh_nhan where mabenhnhan = ?";
    public static final String FIND_ALL_BENH_NHAN = "select * from benh_nhan ";
    public static final String DELETE_BENH_NHAN = "delete from  benh_nhan where mabenhnhan = ?";
    public static final String UPDATE_BENH_NHAN = "update employee set mabenhnhan = ? , mabenhan = ? , name = ? , datebegin = ? , dateend = ? ,  lydo = ?";

}
