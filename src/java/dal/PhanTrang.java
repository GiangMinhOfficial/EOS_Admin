/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.BaiThi;
import model.BaiThi_CauHoi;
import model.CauHoi;
import model.MonHoc;
import model.SinhVien;
import model.TaiKhoan;

/**
 *
 * @author Giang Minh
 */
public class PhanTrang extends DBContext {

    DAO dao = new DAO();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public int getNumeberOf(String obj) {
        String sql = "select count(*) from " + obj;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getNumeberOf: " + e.getMessage());
        }
        return 0;
    }

    public List<MonHoc> pagingMonHoc(int index) {
        List<MonHoc> list = new ArrayList<>();
        String sql = "select * from MonHoc\n"
                + "order by MaMon\n"
                + "offset ? rows fetch next 5 rows only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMon(rs.getString("mamon"));
                mh.setTenMon(rs.getString("tenmon"));
                list.add(mh);
            }
        } catch (SQLException e) {
            System.out.println("pagingMonHoc: " + e.getMessage());
        }
        return list;
    }

    public List<CauHoi> pagingCauHoi(int index, String maMon) {
        List<CauHoi> list = new ArrayList<>();
        String sql = "select * from CauHoi where mamon = ?\n"
                + "order by MaCauHoi\n"
                + "offset ? rows fetch next 5 rows only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMon);
            ps.setInt(2, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CauHoi ch = new CauHoi();
                ch.setMaCauHoi(rs.getInt("macauhoi"));
                ch.setNoiDung(rs.getString("noidung"));
                ch.setHinhAnh(rs.getString("hinhanh"));
                ch.setMaMon(dao.getMonHocById(rs.getString("mamon")));
                ch.setDoKho(rs.getInt("dokho"));
                list.add(ch);
            }
        } catch (SQLException e) {
            System.out.println("pagingMonHoc: " + e.getMessage());
        }
        return list;
    }

    public List<CauHoi> pagingCauHoiV2(int index, String maMon, String maBaiThi) {
        List<CauHoi> list = new ArrayList<>();
        String sql = "select * from CauHoi\n"
                + "where MaCauHoi not in\n"
                + "(select MaCauHoi from BaiThi_CauHoi where MaBaiThi = ?)\n"
                + "and MaMon = ?\n"
                + "order by MaCauHoi\n"
                + "offset ? rows fetch next 5 rows only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maBaiThi);
            ps.setString(2, maMon);
            ps.setInt(3, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CauHoi ch = new CauHoi();
                ch.setMaCauHoi(rs.getInt("macauhoi"));
                ch.setNoiDung(rs.getString("noidung"));
                ch.setHinhAnh(rs.getString("hinhanh"));
                ch.setMaMon(dao.getMonHocById(rs.getString("mamon")));
                ch.setDoKho(rs.getInt("dokho"));
                list.add(ch);
            }
        } catch (SQLException e) {
            System.out.println("pagingMonHoc: " + e.getMessage());
        }
        return list;
    }

    public List<BaiThi> pagingBaiThi(int index, String maMon) {
        List<BaiThi> list = new ArrayList<>();
        String sql = "select * from BaiThi where mamon = ?\n"
                + "order by MaBaiThi\n"
                + "offset ? rows fetch next 5 rows only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMon);
            ps.setInt(2, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaiThi bt = new BaiThi();
                bt.setMaBaiThi(rs.getString(1));
                bt.setLoaiBaiThi(dao.getLoaiBaiThiById(rs.getInt(2)));
                bt.setMonHoc(dao.getMonHocById(rs.getString(3)));
                if (rs.getTimestamp("tgmode") != null) {
                    bt.setThoiGianMoDe(rs.getTimestamp("tgmode").toLocalDateTime());
                } else {
                    bt.setThoiGianMoDe(null);
                }
                if (rs.getTimestamp("tgdongde") != null) {
                    bt.setThoiGianDongDe(rs.getTimestamp("tgdongde").toLocalDateTime());
                } else {
                    bt.setThoiGianDongDe(null);
                }
                list.add(bt);
            }
        } catch (SQLException e) {
            System.out.println("pagingMonHoc: " + e.getMessage());
        }

        return list;
    }

    public List<BaiThi_CauHoi> pagingBaiThi_CauHoi(int index, String maBaiThi) {
        List<BaiThi_CauHoi> list = new ArrayList<>();
        String sql = "select * from BaiThi_CauHoi where mabaithi = ?\n"
                + "order by MaCauHoi\n"
                + "offset ? rows fetch next 5 rows only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maBaiThi);
            ps.setInt(2, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaiThi_CauHoi btch = new BaiThi_CauHoi();
                btch.setMaBaiThi(dao.getBaiThiByMaBaiThi(rs.getString(1)));
                btch.setMaCauHoi(dao.getCauHoiByMaCauHoi(rs.getInt(2)));
                list.add(btch);
            }
        } catch (SQLException e) {
            System.out.println("pagingMonHoc: " + e.getMessage());
        }
        return list;
    }

    public List<SinhVien> pagingSinhVien(int index) {
        List<SinhVien> list = new ArrayList<>();
        String sql = "select * from SinhVien\n"
                + "order by MaSinhVien\n"
                + "offset ? rows fetch next 5 rows only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSinhVien(rs.getInt("masinhvien"));
                sv.setMaNganh(dao.getNganhById(rs.getString("manganh")));
                sv.setHo(rs.getString("ho"));
                sv.setTen(rs.getString("ten"));
                sv.setNgaySinh(rs.getDate("ngaysinh"));
                sv.setSoDienThoai(rs.getString("sodienthoai"));
                sv.setAnhDaiDien(rs.getString("anhdaidien"));
                sv.setMess(rs.getString("mess"));
                sv.setMaTaiKhoan(dao.getTaiKhoanById(rs.getString("tendangnhap")));
                list.add(sv);
            }
        } catch (SQLException e) {
            System.out.println("pagingSinhVien: " + e.getMessage());
        }
        return list;
    }

    public List<TaiKhoan> pagingTaiKhoan(int index) {
        List<TaiKhoan> list = new ArrayList<>();
        String sql = "select * from TaiKhoan\n"
                + "order by CapDo\n"
                + "offset ? rows fetch next 5 rows only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setTenDangNhap(rs.getString(1));
                tk.setMatKhau(rs.getString(2));
                tk.setCapDo(dao.getLoaiTaiKhoan(rs.getInt(3)));
                list.add(tk);
            }
        } catch (SQLException e) {
            System.out.println("pagingSinhVien: " + e.getMessage());
        }
        return list;
    }
}
