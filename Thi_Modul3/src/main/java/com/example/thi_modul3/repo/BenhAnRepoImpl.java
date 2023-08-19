package com.example.thi_modul3.repo;

import com.example.thi_modul3.model.BenhAn;
import com.example.thi_modul3.util.Constant;
import com.example.thi_modul3.util.DataConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepoImpl implements BenhAnRpo{
    @Override
    public List<BenhAn> findAll() {
        List<BenhAn> benhAns = new ArrayList<>();
        try(
                Connection connection = DataConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(Constant.FIND_ALL_BENH_AN);
            BenhAn benhAn;
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                benhAn = new BenhAn(id,name);
                benhAns.add(benhAn);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAns;
    }
    @Override
    public BenhAn findByID(String id) {
        BenhAn benhAn =null;
        try(
                Connection connection = DataConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constant.FIND_BENH_AN_BY_ID);
        ) {
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString(2);
                benhAn = new BenhAn(id,name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAn ;
    }
}
