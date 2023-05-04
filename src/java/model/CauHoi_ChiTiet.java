/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class CauHoi_ChiTiet {
//    	MaCauHoi INT PRIMARY KEY REFERENCES [dbo].[CauHoi]([MaCauHoi]),
//	LoaiCauHoi INT REFERENCES [dbo].[LoaiCauHoi]([MaLoai]) NOT NULL,
//	A NVARCHAR(150) DEFAULT('True'),
//	B NVARCHAR(150) DEFAULT('False'),
//	C NVARCHAR(150),
//	D NVARCHAR(150),

    private CauHoi maCauHoi;
    private LoaiCauHoi loaiCauHoi;
    private String A;
    private String B;
    private String C;
    private String D;

    public CauHoi_ChiTiet() {
        A = "True";
        B = "False";
    }

    public CauHoi_ChiTiet(CauHoi maCauHoi, LoaiCauHoi loaiCauHoi, String A, String B, String C, String D) {
        this.maCauHoi = maCauHoi;
        this.loaiCauHoi = loaiCauHoi;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    public CauHoi getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(CauHoi maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public LoaiCauHoi getLoaiCauHoi() {
        return loaiCauHoi;
    }

    public void setLoaiCauHoi(LoaiCauHoi loaiCauHoi) {
        this.loaiCauHoi = loaiCauHoi;
    }

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }

    
}
