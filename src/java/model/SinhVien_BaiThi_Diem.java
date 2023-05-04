/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class SinhVien_BaiThi_Diem {
    private SinhVien sinhVien;
    private BaiThi baiThi;
    private double diem;

    public SinhVien_BaiThi_Diem() {
    }

    public SinhVien_BaiThi_Diem(SinhVien sinhVien, BaiThi baiThi, double diem) {
        this.sinhVien = sinhVien;
        this.baiThi = baiThi;
        this.diem = diem;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public BaiThi getBaiThi() {
        return baiThi;
    }

    public void setBaiThi(BaiThi baiThi) {
        this.baiThi = baiThi;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
}
