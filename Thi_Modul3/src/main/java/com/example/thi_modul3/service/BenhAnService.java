package com.example.thi_modul3.service;

import com.example.thi_modul3.model.BenhAn;

import java.util.List;

public interface BenhAnService {
    List<BenhAn> findAll();
    BenhAn findByID(String id);
}
