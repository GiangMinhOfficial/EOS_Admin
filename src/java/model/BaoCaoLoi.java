/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class BaoCaoLoi {
//    MaSo INT PRIMARY KEY,
//	MoTa NVARCHAR(MAX),
//	TaiKhoanBaoCao INT REFERENCES [dbo].[TaiKhoan]([MaSo]),
//	TrangThai BIT DEFAULT(0)

    private int maSo;
    private String moTa;
    private TaiKhoan taiKhoanBaoCao;
    private boolean trangThai;

    public BaoCaoLoi() {
        this.trangThai = false;
    }

    public BaoCaoLoi(int maSo, String moTa, TaiKhoan taiKhoanBaoCao, boolean trangThai) {
        this.maSo = maSo;
        this.moTa = moTa;
        this.taiKhoanBaoCao = taiKhoanBaoCao;
        this.trangThai = trangThai;
    }

    public int getMaSo() {
        return maSo;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public TaiKhoan getTaiKhoanBaoCao() {
        return taiKhoanBaoCao;
    }

    public void setTaiKhoanBaoCao(TaiKhoan taiKhoanBaoCao) {
        this.taiKhoanBaoCao = taiKhoanBaoCao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

}
