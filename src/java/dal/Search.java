/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BaiThi;
import model.CauHoi;
import model.MonHoc;
import model.SinhVien;
import model.TaiKhoan;

/**
 *
 * @author Giang Minh
 */
public class Search extends DBContext {

    DAO dao = new DAO();

    public List<MonHoc> getMonHocByString(String val) {
        if (val == null) {
            return null;
        }
        List<MonHoc> list = new ArrayList<>();
        String sql = "select * from monhoc where tenmon like N'%" + val + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMon(rs.getString("mamon"));
                mh.setTenMon(rs.getString("tenmon"));
                list.add(mh);
            }
        } catch (SQLException e) {
            System.out.println("getMonHocByString: " + e.getMessage());
        }
        return list;
    }

    public List<CauHoi> getCauHoiByString(String val) {
        if (val == null) {
            return null;
        }
        List<CauHoi> list = new ArrayList<>();
        String sql = "select * from cauhoi where noidung like N'%" + val + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
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
            System.out.println("getCauHoiByString: " + e.getMessage());
        }
        return list;
    }

    public List<BaiThi> getBaiThiByString(String val, String maMon) {
        if (val == null) {
            return null;
        }
        List<BaiThi> list = new ArrayList<>();
        String sql = "select * from baithi\n"
                + "where maloaibaithi in \n"
                + "(select maLoaiBaiThi from LoaiBaiThi where TenLoaiBaiThi like N'%" + val + "%')\n"
                + "and mamon = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMon);
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
            System.out.println("getBaiThiByString: " + e.getMessage());
        }
        return list;
    }

    public List<CauHoi> getCauHoiBaiThiByString(String val, String maBaiThi) {
        if (val == null) {
            return null;
        }
        List<CauHoi> list = new ArrayList<>();
        String sql = "select * from CauHoi\n"
                + "where MaCauHoi in \n"
                + "(select MaCauHoi from BaiThi_CauHoi where MaBaiThi = ?)\n"
                + "and NoiDung like N'%" + val + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maBaiThi);
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
            System.out.println("getCauHoiByString: " + e.getMessage());
        }
        return list;
    }

    public List<SinhVien> getSinhVienByString(String val) {
        if (val == null) {
            return null;
        }
        List<SinhVien> list = new ArrayList<>();
        String sql = "select * from SinhVien\n"
                + "where Ho + ' ' + Ten like N'%" + val + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
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
            System.out.println("getCauHoiByString: " + e.getMessage());
        }
        return list;
    }

    public List<TaiKhoan> getTaiKhoanByString(String val) {
        if (val == null) {
            return null;
        }
        List<TaiKhoan> list = new ArrayList<>();
        String sql = "select * from TaiKhoan where TenDangNhap like N'%" + val + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setTenDangNhap(rs.getString(1));
                tk.setMatKhau(rs.getString(2));
                tk.setCapDo(dao.getLoaiTaiKhoan(rs.getInt(3)));
                list.add(tk);
            }
        } catch (SQLException e) {
            System.out.println("getTaiKhoanByString: " + e.getMessage());
        }
        return list;
    }

    public List<CauHoi> getCauHoiFromBaiThiByString(String maBaiThi, String val) {
        if (val == null) {
            return null;
        }
        List<CauHoi> list = new ArrayList<>();
        String sql = "select * from BaiThi_CauHoi\n"
                + "where MaBaiThi = ?\n"
                + "and MaCauHoi in \n"
                + "(select MaCauHoi from CauHoi where NoiDung like N'%" + val + "%')";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maBaiThi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CauHoi ch = dao.getCauHoiByMaCauHoi(rs.getInt(2));
                list.add(ch);
            }
        } catch (SQLException e) {
            System.out.println("getCauHoiFromBaiThiByString: " + e.getMessage());
        }
        return list;
    }

    public List<CauHoi> getCauHoiNotInBaiThiByString(String maBaiThi, String val) {
        if (val == null) {
            return null;
        }
        List<CauHoi> list = new ArrayList<>();
        String sql = "select * from CauHoi\n"
                + "where MaCauHoi not in\n"
                + "(select MaCauHoi from BaiThi_CauHoi where MaBaiThi = ?)\n"
                + "and NoiDung like N'%" + val + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maBaiThi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CauHoi ch = dao.getCauHoiByMaCauHoi(rs.getInt(1));
                list.add(ch);
            }
        } catch (SQLException e) {
            System.out.println("getCauHoiNotInBaiThiByString: " + e.getMessage());
        }
        return list;
    }

}
