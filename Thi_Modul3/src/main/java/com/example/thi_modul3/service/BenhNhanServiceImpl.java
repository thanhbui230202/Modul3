package com.example.thi_modul3.service;

import com.example.thi_modul3.model.BenhNhan;
import com.example.thi_modul3.repo.BenhNhanRepoImpl;

import java.util.List;

public class BenhNhanServiceImpl implements BenhNhanService{
    private BenhNhanRepoImpl benhNhan = new BenhNhanRepoImpl();


    @Override
    public void delete(BenhNhan benhNhan1) {
        benhNhan.delete(benhNhan1);
    }

    @Override
    public void update(BenhNhan benhNhan1) {
        benhNhan.update(benhNhan1);
    }

    @Override
    public List<BenhNhan> finAll() {
        return benhNhan.finAll();
    }

    @Override
    public BenhNhan finByID(String id) {
        return benhNhan.finByID(id);
    }
}
