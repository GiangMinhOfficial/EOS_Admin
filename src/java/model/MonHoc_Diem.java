/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class MonHoc_Diem {

    private SinhVien sinhVien;
    private MonHoc monHoc;
    private double progressTest1 = -2;
    private double progressTest2 = -2;
    private double progressTest3 = -2;
    private double midtermTest = -2;
    private double finalExam = -2;

    public MonHoc_Diem() {
    }

    public MonHoc_Diem(SinhVien sinhvien, MonHoc monHoc, double progressTest1, double progressTest2, double progressTest3, double midtermTest, double finalExam) {
        this.sinhVien = sinhVien;
        this.monHoc = monHoc;
        this.progressTest1 = progressTest1;
        this.progressTest2 = progressTest2;
        this.progressTest3 = progressTest3;
        this.midtermTest = midtermTest;
        this.finalExam = finalExam;
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

    public double getProgressTest1() {
        return progressTest1;
    }

    public void setProgressTest1(double progressTest1) {
        this.progressTest1 = progressTest1;
    }

    public double getProgressTest2() {
        return progressTest2;
    }

    public void setProgressTest2(double progressTest2) {
        this.progressTest2 = progressTest2;
    }

    public double getProgressTest3() {
        return progressTest3;
    }

    public void setProgressTest3(double progressTest3) {
        this.progressTest3 = progressTest3;
    }

    public double getMidtermTest() {
        return midtermTest;
    }

    public void setMidtermTest(double midtermTest) {
        this.midtermTest = midtermTest;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }
    
}
