/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Giang Minh
 */
public class MonHoc_LoaiBaiThi {
    private MonHoc monHoc;
    private LoaiBaiThi laoBaiThi;

    public MonHoc_LoaiBaiThi() {
    }

    public MonHoc_LoaiBaiThi(MonHoc monHoc, LoaiBaiThi laoBaiThi) {
        this.monHoc = monHoc;
        this.laoBaiThi = laoBaiThi;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public LoaiBaiThi getLaoBaiThi() {
        return laoBaiThi;
    }

    public void setLaoBaiThi(LoaiBaiThi laoBaiThi) {
        this.laoBaiThi = laoBaiThi;
    }
    
}
