/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class SinhVien_BaiThi {
    private SinhVien maSinhVien;
    private BaiThi maBaiThi;

    public SinhVien_BaiThi() {
    }

    public SinhVien_BaiThi(SinhVien maSinhVien, BaiThi maBaiThi) {
        this.maSinhVien = maSinhVien;
        this.maBaiThi = maBaiThi;
    }

    public SinhVien getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(SinhVien maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public BaiThi getMaBaiThi() {
        return maBaiThi;
    }

    public void setMaBaiThi(BaiThi maBaiThi) {
        this.maBaiThi = maBaiThi;
    }
}
