/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class LoaiBaiThi {

    private int maLoaiBaiThi;
    private String tenLoaiBaiThi;
    private int soCau;
    private int thoiGianLamBai;

    public LoaiBaiThi() {
    }

    public LoaiBaiThi(int maLoaiBaiThi, String tenLoaiBaiThi, int soCau, int thoiGianLamBai) {
        this.maLoaiBaiThi = maLoaiBaiThi;
        this.tenLoaiBaiThi = tenLoaiBaiThi;
        this.soCau = soCau;
        this.thoiGianLamBai = thoiGianLamBai;
    }

    public int getMaLoaiBaiThi() {
        return maLoaiBaiThi;
    }

    public void setMaLoaiBaiThi(int maLoaiBaiThi) {
        this.maLoaiBaiThi = maLoaiBaiThi;
    }

    public String getTenLoaiBaiThi() {
        return tenLoaiBaiThi;
    }

    public void setTenLoaiBaiThi(String tenLoaiBaiThi) {
        this.tenLoaiBaiThi = tenLoaiBaiThi;
    }

    public int getSoCau() {
        return soCau;
    }

    public void setSoCau(int soCau) {
        this.soCau = soCau;
    }

    public int getThoiGianLamBai() {
        return thoiGianLamBai;
    }

    public void setThoiGianLamBai(int thoiGianLamBai) {
        this.thoiGianLamBai = thoiGianLamBai;
    }

}
