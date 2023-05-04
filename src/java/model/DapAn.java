/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class DapAn {

    private CauHoi maDapAn;
    private String noiDung;
    private boolean dungSai;

    public DapAn() {
    }

    public DapAn(CauHoi maDapAn, String noiDung, boolean dungSai) {
        this.maDapAn = maDapAn;
        this.noiDung = noiDung;
        this.dungSai = dungSai;
    }

    public CauHoi getMaDapAn() {
        return maDapAn;
    }

    public void setMaDapAn(CauHoi maDapAn) {
        this.maDapAn = maDapAn;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public boolean isDungSai() {
        return dungSai;
    }

    public void setDungSai(boolean dungSai) {
        this.dungSai = dungSai;
    }

}
