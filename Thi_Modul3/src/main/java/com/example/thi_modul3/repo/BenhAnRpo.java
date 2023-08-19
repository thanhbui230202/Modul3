package com.example.thi_modul3.repo;

import com.example.thi_modul3.model.BenhAn;

import java.util.List;

public interface BenhAnRpo {
    List<BenhAn> findAll();
    BenhAn findByID(String id);
}
