/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    private LoaiTaiKhoan capDo;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenDangNhap, String matKhau, LoaiTaiKhoan capDo) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.capDo = capDo;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public LoaiTaiKhoan getCapDo() {
        return capDo;
    }

    public void setCapDo(LoaiTaiKhoan capDo) {
        this.capDo = capDo;
    }
}
