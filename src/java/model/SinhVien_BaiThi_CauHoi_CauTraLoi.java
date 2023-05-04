/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class SinhVien_BaiThi_CauHoi_CauTraLoi {

    private SinhVien sinhVien;
    private BaiThi baiThi;
    private CauHoi cauHoi;
    private String cauTraLoi;

    public SinhVien_BaiThi_CauHoi_CauTraLoi() {

    }

    public SinhVien_BaiThi_CauHoi_CauTraLoi(SinhVien sinhVien, BaiThi baiThi, CauHoi cauHoi, String cauTraLoi) {
        this.sinhVien = sinhVien;
        this.baiThi = baiThi;
        this.cauHoi = cauHoi;
        this.cauTraLoi = cauTraLoi;
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

    public CauHoi getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(CauHoi cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getCauTraLoi() {
        return cauTraLoi;
    }

    public void setCauTraLoi(String cauTraLoi) {
        this.cauTraLoi = cauTraLoi;
    }
}
