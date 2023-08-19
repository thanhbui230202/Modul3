package com.example.thi_modul3.service;

import com.example.thi_modul3.model.BenhAn;
import com.example.thi_modul3.repo.BenhAnRepoImpl;

import java.util.List;

public class BenhAnServiceImpl implements BenhAnService{
    private BenhAnRepoImpl benhAn = new BenhAnRepoImpl();
    @Override
    public List<BenhAn> findAll() {
        return benhAn.findAll();
    }

    @Override
    public BenhAn findByID(String id) {
        return benhAn.findByID(id);
    }
}
