/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class CauHoi {

    private int maCauHoi;
    private String noiDung;
    private String hinhAnh;
    private MonHoc maMon;
    private int doKho; //1 - 5

    public CauHoi() {
    }

    public CauHoi(int maCauHoi, String noiDung, String hinhAnh, MonHoc maMon, int doKho) {
        this.maCauHoi = maCauHoi;
        this.noiDung = noiDung;
        this.hinhAnh = hinhAnh;
        this.maMon = maMon;
        this.doKho = doKho;
    }

    public int getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public MonHoc getMaMon() {
        return maMon;
    }

    public void setMaMon(MonHoc maMon) {
        this.maMon = maMon;
    }

    public int getDoKho() {
        return doKho;
    }

    public void setDoKho(int doKho) {
        this.doKho = doKho;
    }

}
