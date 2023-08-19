package com.example.thi_modul3.repo;

import com.example.thi_modul3.model.BenhAn;
import com.example.thi_modul3.model.BenhNhan;
import com.example.thi_modul3.util.Constant;
import com.example.thi_modul3.util.DataConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepoImpl implements BenhNhanRepo{

    private BenhAnRepoImpl benhAnRepo = new BenhAnRepoImpl();
    @Override
    public void delete(BenhNhan benhNhan) {
        try(
                Connection connection = DataConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constant.DELETE_BENH_NHAN);
        ){
            statement.setString(1,benhNhan.getMaBenhNhan());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(BenhNhan benhNhan) {
        try (
                Connection connection = DataConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constant.UPDATE_BENH_NHAN);
        ){
            statement.setString(6,benhNhan.getMaBenhNhan());
            statement.setString(1,benhNhan.getMaBenhAn().getTenBenhAn());
            statement.setString(2,benhNhan.getTenBenhNhan());
            statement.setDate(3,Date.valueOf(benhNhan.getDateBegin()));
            statement.setDate(4,Date.valueOf(benhNhan.getDateEnd()));
            statement.setString(5,benhNhan.getLyDo());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BenhNhan> finAll() {
        List<BenhNhan> benhNhans = new ArrayList<>();
        try(
                Connection connection = DataConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(Constant.FIND_ALL_BENH_NHAN);
            BenhNhan benhNhan;
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String id1 = resultSet.getString(2);
                BenhAn benhAn = benhAnRepo.findByID(id1);
                String name = resultSet.getString(3);
                LocalDate datebegin = resultSet.getDate(4).toLocalDate();
                LocalDate dateend = resultSet.getDate(5).toLocalDate();
                String lydo = resultSet.getString(6);
                benhNhan = new BenhNhan(id,benhAn,name,datebegin,dateend,lydo);
                benhNhans.add(benhNhan);
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
//        return productList;
        return benhNhans;
        }



    @Override
    public BenhNhan finByID(String id) {
        BenhNhan benhNhan =null;
        try(
                Connection connection = DataConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constant.FIND_BENH_NHAN_BY_ID);
        ) {
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id1 = resultSet.getString(2);
                BenhAn benhAn = benhAnRepo.findByID(id1);
                String name = resultSet.getString(3);
                LocalDate datebegin = resultSet.getDate(4).toLocalDate();
                LocalDate dateend = resultSet.getDate(5).toLocalDate();
                String lydo = resultSet.getString(6);
                benhNhan = new BenhNhan(id,benhAn,name,datebegin,dateend,lydo);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return benhNhan;
    }
}
