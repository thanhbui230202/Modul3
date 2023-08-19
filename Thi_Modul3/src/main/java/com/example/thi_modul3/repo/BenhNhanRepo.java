package com.example.thi_modul3.repo;

import com.example.thi_modul3.model.BenhAn;
import com.example.thi_modul3.model.BenhNhan;

import java.util.List;

public interface BenhNhanRepo {

    void delete(BenhNhan benhNhan);
    void update(BenhNhan benhNhan);
    List<BenhNhan> finAll();
    BenhNhan finByID(String id);
}
