/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Giang Minh
 */
public class SinhVien {

    private int maSinhVien;
    private Nganh maNganh;
    private String ho;
    private String ten;
    private Date ngaySinh;
    private String soDienThoai;
    private String anhDaiDien;
    private String mess;
    private TaiKhoan maTaiKhoan;

    public SinhVien() {
    }

    public SinhVien(int maSinhVien, Nganh maNganh, String ho, String ten, Date ngaySinh, String soDienThoai, String anhDaiDien, String mess, TaiKhoan maTaiKhoan) {
        this.maSinhVien = maSinhVien;
        this.maNganh = maNganh;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.anhDaiDien = anhDaiDien;
        this.mess = mess;
        this.maTaiKhoan = maTaiKhoan;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public Nganh getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(Nganh maNganh) {
        this.maNganh = maNganh;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public TaiKhoan getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(TaiKhoan maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

}
