/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class SinhVien_MonHoc {

    private SinhVien sinhVien;
    private MonHoc monHoc;

    public SinhVien_MonHoc() {
    }

    public SinhVien_MonHoc(SinhVien sinhVien, MonHoc monHoc) {
        this.sinhVien = sinhVien;
        this.monHoc = monHoc;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }
}
