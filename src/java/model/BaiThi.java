/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Giang Minh
 */
public class BaiThi {
    private String maBaiThi;
    private LoaiBaiThi loaiBaiThi;
    private MonHoc monHoc;
    private LocalDateTime thoiGianMoDe;
    private LocalDateTime thoiGianDongDe;

    public BaiThi() {
    }

    public BaiThi(String maBaiThi, LoaiBaiThi loaiBaiThi, MonHoc monHoc, LocalDateTime thoiGianMoDe, LocalDateTime thoiGianDongDe) {
        this.maBaiThi = maBaiThi;
        this.loaiBaiThi = loaiBaiThi;
        this.monHoc = monHoc;
        this.thoiGianMoDe = thoiGianMoDe;
        this.thoiGianDongDe = thoiGianDongDe;
    }

    public String getMaBaiThi() {
        return maBaiThi;
    }

    public void setMaBaiThi(String maBaiThi) {
        this.maBaiThi = maBaiThi;
    }

    public LoaiBaiThi getLoaiBaiThi() {
        return loaiBaiThi;
    }

    public void setLoaiBaiThi(LoaiBaiThi loaiBaiThi) {
        this.loaiBaiThi = loaiBaiThi;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public LocalDateTime getThoiGianMoDe() {
        return thoiGianMoDe;
    }

    public void setThoiGianMoDe(LocalDateTime thoiGianMoDe) {
        this.thoiGianMoDe = thoiGianMoDe;
    }

    public LocalDateTime getThoiGianDongDe() {
        return thoiGianDongDe;
    }

    public void setThoiGianDongDe(LocalDateTime thoiGianDongDe) {
        this.thoiGianDongDe = thoiGianDongDe;
    }
    
}
