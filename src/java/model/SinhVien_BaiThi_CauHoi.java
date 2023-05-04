/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class SinhVien_BaiThi_CauHoi {

    private SinhVien maSinhVien;
    private BaiThi maBaiThi;
    private CauHoi maCauHoi;

    public SinhVien_BaiThi_CauHoi() {
    }

    public SinhVien_BaiThi_CauHoi(SinhVien maSinhVien, BaiThi maBaiThi, CauHoi maCauHoi) {
        this.maSinhVien = maSinhVien;
        this.maBaiThi = maBaiThi;
        this.maCauHoi = maCauHoi;
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

    public CauHoi getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(CauHoi maCauHoi) {
        this.maCauHoi = maCauHoi;
    }
}
