package com.example.thi_modul3.model;

import java.time.LocalDate;

public class BenhNhan {
    private String maBenhNhan;
    private BenhAn maBenhAn;
    private String tenBenhNhan;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private String lyDo;

    public BenhNhan() {
    }

    public BenhNhan( String maBenhNhan,BenhAn maBenhAn, String tenBenhNhan, LocalDate dateBegin, LocalDate dateEnd, String lyDo) {
        this.maBenhNhan = maBenhNhan;
        this.maBenhAn = maBenhAn;
        this.tenBenhNhan = tenBenhNhan;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.lyDo = lyDo;
    }

    public BenhNhan(String id, String id1, String name, LocalDate date1, LocalDate date2, String lydo) {

    }

    public BenhAn getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(BenhAn maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public LocalDate getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(LocalDate dateBegin) {
        this.dateBegin = dateBegin;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
}
