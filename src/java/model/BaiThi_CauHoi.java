/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class BaiThi_CauHoi {
//    MaBaiThi VARCHAR(50) NOT NULL,
//	MaCauHoi INT REFERENCES [dbo].[CauHoi]([MaCauHoi]) NOT NULL,
//	PRIMARY KEY([MaBaiThi], [MaCauHoi])
    
    private BaiThi maBaiThi;
    private CauHoi maCauHoi;

    public BaiThi_CauHoi() {
    }

    public BaiThi_CauHoi(BaiThi maBaiThi, CauHoi maCauHoi) {
        this.maBaiThi = maBaiThi;
        this.maCauHoi = maCauHoi;
    }

    public BaiThi getMaBaiThi() {
        return maBaiThi;
    }

    public void setMaBaiThi(BaiThi maBaiThi) {
        this.maBaiThi = maBaiThi;
    }

    public CauHoi getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(CauHoi maCauHoi) {
        this.maCauHoi = maCauHoi;
    }
    
}
