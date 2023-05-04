/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author Giang Minh
 */
public class DAO extends DBContext {

    public List<TaiKhoan> getAllTaiKhoan() {
        List<TaiKhoan> list = new ArrayList<>();
        String sql = "select * from taikhoan";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setTenDangNhap(rs.getString("tendangnhap"));
                tk.setMatKhau(rs.getString("matkhau"));
                tk.setCapDo(getLoaiTaiKhoan(rs.getInt("capdo")));
                list.add(tk);
            }
        } catch (SQLException e) {
            System.out.println("getAllTaiKhoan: " + e.getMessage());
        }
        return list;
    }

    public TaiKhoan getTaiKhoanByUserAndPass(String user, String pass) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String sql = "select * from [TaiKhoan] where TenDangNhap=? and MatKhau=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, utils.Hash.hashPassword(pass));
            System.out.println(utils.Hash.hashPassword(pass));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setTenDangNhap(rs.getString("tendangnhap"));
                tk.setMatKhau(rs.getString("matkhau"));
                tk.setCapDo(getLoaiTaiKhoan(rs.getInt("capdo")));
                return tk;
            }
        } catch (SQLException e) {
            System.out.println("getTaiKhoanByUserAndPass: " + e.getMessage());
        }
        return null;
    }

    public LoaiTaiKhoan getLoaiTaiKhoan(int capDo) {
        String sql = "select * from loaitaikhoan where maloai = " + capDo;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                LoaiTaiKhoan ltk = new LoaiTaiKhoan();
                ltk.setMaLoai(rs.getInt("maloai"));
                ltk.setTenLoai(rs.getString("tenloai"));
                return ltk;
            }
        } catch (SQLException e) {
            System.out.println("getLoaiTaiKhoan" + e.getMessage());
        }
        return null;
    }

    public List<MonHoc> getAllMonHoc() {
        List<MonHoc> list = new ArrayList<>();
        String sql = "select * from monhoc";
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
            System.out.println("getAllMonHoc" + e.getMessage());
        }
        return list;
    }

    public List<BaiThi> getAllBaiThi() {
        List<BaiThi> list = new ArrayList<>();
        String sql = "select * from baithi";
        try {
            System.out.println("1");
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaiThi bt = new BaiThi();
                bt.setMaBaiThi(rs.getString("maBaiThi"));
                bt.setMonHoc(getMonHocById(rs.getString("mamon")));
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
                bt.setLoaiBaiThi(getLoaiBaiThiById(rs.getInt("maLoaiBaiThi")));
                list.add(bt);
            }
        } catch (SQLException e) {
            System.out.println("getAllBaiThi" + e.getMessage());
        }
        return list;
    }

    public List<BaiThi> getAllBaiThiByMaMon(String maMon) {
        List<BaiThi> list = new ArrayList<>();
        String sql = "select * from baithi where mamon = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaiThi bt = new BaiThi();
                bt.setMaBaiThi(rs.getString("maBaiThi"));
                bt.setMonHoc(getMonHocById(rs.getString("mamon")));
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
                bt.setLoaiBaiThi(getLoaiBaiThiById(rs.getInt("maLoaiBaiThi")));
                list.add(bt);
            }
        } catch (SQLException e) {
            System.out.println("getAllBaiThiByMaMon" + e.getMessage());
        }
        return list;
    }

    public LoaiBaiThi getLoaiBaiThiById(int maLoaiBaiThi) {
        String sql = "select * from loaibaithi where MaLoaiBaiThi = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maLoaiBaiThi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                LoaiBaiThi lbt = new LoaiBaiThi();
                lbt.setThoiGianLamBai(rs.getInt("thoigianlambai"));
                lbt.setSoCau(rs.getInt("socau"));
                lbt.setMaLoaiBaiThi(rs.getInt("maloaibaithi"));
                lbt.setTenLoaiBaiThi(rs.getString("tenloaibaithi"));
                return lbt;
            }
        } catch (SQLException e) {
            System.out.println("getLoaiBaiThiById" + e.getMessage());
        }
        return null;
    }

    public List<LoaiBaiThi> getAllLoaiBaiThi() {
        String sql = "select * from loaibaithi";
        List<LoaiBaiThi> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiBaiThi lbt = new LoaiBaiThi();
                lbt.setThoiGianLamBai(rs.getInt("thoigianlambai"));
                lbt.setSoCau(rs.getInt("socau"));
                lbt.setMaLoaiBaiThi(rs.getInt("maloaibaithi"));
                lbt.setTenLoaiBaiThi(rs.getString("tenloaibaithi"));
                list.add(lbt);
            }
        } catch (SQLException e) {
            System.out.println("getAllLoaiBaiThi" + e.getMessage());
        }
        return list;
    }
    
    public List<LoaiBaiThi> getAllLoaiBaiThiOfMonHoc(String maMon) {
        String sql = "select * from MonHoc_LoaiBaiThi where mamon = ?";
        List<LoaiBaiThi> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiBaiThi lbt = getLoaiBaiThiById(rs.getInt(2));
                list.add(lbt);
            }
        } catch (SQLException e) {
            System.out.println("getAllLoaiBaiThiOfMonHoc" + e.getMessage());
        }
        return list;
    }

    public MonHoc getMonHocById(String maMon) {
        String sql = "select * from monhoc where mamon = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMon);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMon(rs.getString("mamon"));
                mh.setTenMon(rs.getString("tenmon"));
                return mh;
            }
        } catch (SQLException e) {
            System.out.println("getMonHocById: " + e.getMessage());
        }
        return null;
    }

    public List<CauHoi> getCauHoiByMaMon(String maMon) {
        List<CauHoi> list = new ArrayList<>();
        String sql = "select * from cauhoi where mamon = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CauHoi ch = new CauHoi();
                ch.setMaCauHoi(rs.getInt("macauhoi"));
                ch.setNoiDung(rs.getString("noidung"));
                ch.setHinhAnh(rs.getString("hinhanh"));
                ch.setMaMon(getMonHocById(rs.getString("mamon")));
                ch.setDoKho(rs.getInt("dokho"));
                list.add(ch);
            }
        } catch (SQLException e) {
            System.out.println("getCauHoiByMaMon" + e.getMessage());
        }
        return list;
    }

    public CauHoi getCauHoiByMaMonMaCauHoi(int maCauHoi, String maMon) {
        String sql = "select * from cauhoi where mamon = ? and macauhoi = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMon);
            ps.setInt(2, maCauHoi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
//                getCauHoiByMaMon(rs.getString("mamon"));
                CauHoi ch = new CauHoi();
                ch.setMaCauHoi(rs.getInt("macauhoi"));
                ch.setNoiDung(rs.getString("noidung"));
                ch.setHinhAnh(rs.getString("hinhanh"));
                ch.setMaMon(getMonHocById(rs.getString("mamon")));
                ch.setDoKho(rs.getInt("dokho"));
                return ch;
            }
        } catch (SQLException e) {
            System.out.println("getCauHoiByMaMonMaCauHoi" + e.getMessage());
        }
        return null;
    }

    public CauHoi getCauHoiByMaCauHoi(int maCauHoi) {
        String sql = "select * from cauhoi where macauhoi = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maCauHoi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CauHoi ch = new CauHoi();
                ch.setMaCauHoi(rs.getInt("macauhoi"));
                ch.setNoiDung(rs.getString("noidung"));
                ch.setHinhAnh(rs.getString("hinhanh"));
                ch.setMaMon(getMonHocById(rs.getString("mamon")));
                ch.setDoKho(rs.getInt("dokho"));
                return ch;
            }
        } catch (SQLException e) {
            System.out.println("getCauHoiByMaCauHoi" + e.getMessage());
        }
        return null;
    }

//    public List<BaiThi_CauHoi> getBaiThi_CauHoiByMaBaiThi(String maBaiThi) {
//        List<BaiThi_CauHoi> list = new ArrayList<>();
//        String sql = "select * from baithi_cauhoi where mabaithi = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, maBaiThi);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                BaiThi_CauHoi btch = new BaiThi_CauHoi();
//                BaiThi bt = getBaiThiByMaBaiThi(rs.getString("mabaithi"));
//                CauHoi ch = getCauHoiByMaCauHoi(rs.getInt("macauhoi"));
//                btch.setMaBaiThi(bt);
//                btch.setMaCauHoi(ch);
//                list.add(btch);
//            }
//        } catch (SQLException e) {
//            System.out.println("getBaiThi_CauHoiByMaBaiThi" + e.getMessage());
//        }
//        return list;
//    }

    public List<SinhVien> getAllSinhVien() {
        List<SinhVien> list = new ArrayList<>();
        String sql = "select * from sinhvien";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSinhVien(rs.getInt("masinhvien"));
                sv.setMaNganh(getNganhById(rs.getString("manganh")));
                sv.setHo(rs.getString("ho"));
                sv.setTen(rs.getString("ten"));
                sv.setNgaySinh(rs.getDate("ngaysinh"));
                sv.setSoDienThoai(rs.getString("sodienthoai"));
                sv.setAnhDaiDien(rs.getString("anhdaidien"));
                sv.setMess(rs.getString("mess"));
                sv.setMaTaiKhoan(getTaiKhoanById(rs.getString("tendangnhap")));
                list.add(sv);
            }
        } catch (SQLException e) {
            System.out.println("getAllSinhVien" + e.getMessage());
        }
        return list;
    }

    public Nganh getNganhById(String maNganh) {
        String sql = "select * from nganh where MaNganh = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maNganh);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Nganh n = new Nganh();
                n.setMaNganh(rs.getString("manganh"));
                n.setTenNganh(rs.getString("tennganh"));
                return n;
            }
        } catch (SQLException e) {
            System.out.println("getNganhById" + e.getMessage());
        }
        return null;
    }

    public TaiKhoan getTaiKhoanById(String tenDangNhap) {
        String sql = "select * from taikhoan where tendangnhap = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setTenDangNhap(rs.getString("tendangnhap"));
                tk.setMatKhau(rs.getString("matkhau"));
                tk.setCapDo(getLoaiTaiKhoan(rs.getInt("capdo")));
                return tk;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

//    public List<SinhVien_BaiThi> getAllSinhVienBaiThiByMaSinhVien(int maSinhVien) {
//        List<SinhVien_BaiThi> list = new ArrayList<>();
//        String sql = "select * from sinhvien_baithi where masinhvien = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, maSinhVien);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                SinhVien_BaiThi svbt = new SinhVien_BaiThi();
//                SinhVien sv = getSinhVienByMaSinhVien(rs.getInt("maSinhVien"));
//                BaiThi bt = getBaiThiByMaBaiThi(rs.getString("mabaithi"));
//                svbt.setMaSinhVien(sv);
//                svbt.setMaBaiThi(bt);
//                list.add(svbt);
//            }
//        } catch (SQLException e) {
//            System.out.println("getAllSinhVienBaiThiByMaSinhVien" + e.getMessage());
//        }
//        return list;
//    }

//    public List<SinhVien_MonHoc> getAllSinhVienMonHocByMaSinhVien(int maSinhVien) {
//        List<SinhVien_MonHoc> list = new ArrayList<>();
//        String sql = "select * from sinhvien_monhoc where masinhvien = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, maSinhVien);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                SinhVien_MonHoc svmh = new SinhVien_MonHoc();
//                svmh.setSinhVien(getSinhVienByMaSinhVien(rs.getInt(1)));
//                svmh.setMonHoc(getMonHocById(rs.getString(2)));
//                list.add(svmh);
//            }
//        } catch (SQLException e) {
//            System.out.println("getAllSinhVienMonHocByMaSinhVien: " + e.getMessage());
//        }
//        return list;
//    }

    public SinhVien getSinhVienByMaSinhVien(int maSinhVien) {
        String sql = "select * from sinhvien where masinhvien = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maSinhVien);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSinhVien(rs.getInt("masinhvien"));
                sv.setMaNganh(getNganhById(rs.getString("manganh")));
                sv.setHo(rs.getString("ho"));
                sv.setTen(rs.getString("ten"));
                sv.setNgaySinh(rs.getDate("ngaysinh"));
                sv.setSoDienThoai(rs.getString("sodienthoai"));
                sv.setAnhDaiDien(rs.getString("anhdaidien"));
                sv.setMess(rs.getString("mess"));
                sv.setMaTaiKhoan(getTaiKhoanById(rs.getString("tendangnhap")));
                return sv;
            }
        } catch (SQLException e) {
            System.out.println("getSinhVienByMaSinhVien: " + e.getMessage());
        }
        return null;
    }

    public BaiThi getBaiThiByMaBaiThi(String maBaiThi) {
        String sql = "select * from baithi where mabaithi = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maBaiThi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                BaiThi bt = new BaiThi();
                bt.setMaBaiThi(rs.getString("maBaiThi"));
                bt.setLoaiBaiThi(getLoaiBaiThiById(rs.getInt("maloaibaithi")));
                bt.setMonHoc(getMonHocById(rs.getString("mamon")));
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

                return bt;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //madapan reference den macauhoi
    public DapAn getDapAnByMaCauHoi(int maCauHoi) {
        String sql = "select * from dapan where MaDapAn = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maCauHoi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DapAn da = new DapAn();
                da.setMaDapAn(getCauHoiByMaCauHoi(rs.getInt("madapan")));
                da.setNoiDung(rs.getString("noidung"));
                da.setDungSai(rs.getBoolean("dungsai"));
                return da;
            }
        } catch (SQLException e) {
            System.out.println("getDapAnByMaCauHoi: " + e.getMessage());
        }
        return null;
    }

    public List<SinhVien_BaiThi_CauHoi_CauTraLoi> getAllSinhVien_BaiThi_CauHoi_CauTraLoiByMaSinhVienMaBaiThi(int maSinhVien, String maBaiThi) {
        List<SinhVien_BaiThi_CauHoi_CauTraLoi> list = new ArrayList<>();
        String sql = "select * from sinhvien_baithi_cauhoi_cautraloi where masinhvien = ? and mabaithi = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maSinhVien);
            ps.setString(2, maBaiThi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien_BaiThi_CauHoi_CauTraLoi sbcc = new SinhVien_BaiThi_CauHoi_CauTraLoi();
                SinhVien sv = getSinhVienByMaSinhVien(rs.getInt("masinhvien"));
                BaiThi bt = getBaiThiByMaBaiThi(rs.getString("mabaithi"));
                int maCauHoi = rs.getInt("macauhoi");
                CauHoi ch = getCauHoiByMaCauHoi(maCauHoi);
//                DapAn da = getDapAnByMaCauHoi(maCauHoi);
                sbcc.setSinhVien(sv);
                sbcc.setBaiThi(bt);
                sbcc.setCauHoi(ch);
                sbcc.setCauTraLoi(rs.getString("cautraloi"));
                list.add(sbcc);
            }
        } catch (SQLException e) {
            System.out.println("getAllSinhVien_BaiThi_CauHoi_CauTraLoiByMaSinhVienMaBaiThi: " + e.getMessage());
        }
        return list;
    }

    public List<CauHoi> getAllCauHoiByMaMon(String maMon) {
        List<CauHoi> list = new ArrayList<>();
        String sql = "select * from cauhoi where mamon = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CauHoi ch = new CauHoi();
                ch.setMaCauHoi(rs.getInt("macauhoi"));
                ch.setNoiDung(rs.getString("noidung"));
                ch.setHinhAnh(rs.getString("hinhanh"));
                ch.setMaMon(getMonHocById(rs.getString("mamon")));
                ch.setDoKho(rs.getInt("dokho"));
                list.add(ch);
            }
        } catch (SQLException e) {
            System.out.println("getAllCauHoiByMaMon" + e.getMessage());
        }
        return list;
    }

    public CauHoi_ChiTiet getCauHoiChiTietByMaCauHoi(int maCauHoi) {
        String sql = "select * from cauhoi_chitiet where macauhoi = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maCauHoi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CauHoi_ChiTiet chct = new CauHoi_ChiTiet();
                chct.setMaCauHoi(getCauHoiByMaCauHoi(rs.getInt(1)));
                chct.setLoaiCauHoi(getLoaiCauHoiByMaLoai(rs.getInt(2)));
                chct.setA(rs.getString(3));
                chct.setB(rs.getString(4));
                chct.setC(rs.getString(5));
                chct.setD(rs.getString(6));
                return chct;
            }
        } catch (SQLException e) {
            System.out.println("getCauHoiChiTietByMaCauHoi" + e.getMessage());
        }
        return null;
    }

    public LoaiCauHoi getLoaiCauHoiByMaLoai(int loaiCauHoi) {
        String sql = "select * from loaicauhoi where maloai = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, loaiCauHoi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                LoaiCauHoi lch = new LoaiCauHoi();
                lch.setMaLoai(rs.getInt(1));
                lch.setTenLoai(rs.getString(2));
                return lch;
            }
        } catch (SQLException e) {
            System.out.println("getLoaiCauHoiByMaLoai" + e.getMessage());
        }
        return null;
    }

    public boolean createNewMonThi(String maMon, String tenMon) {
        String sql = "insert into monhoc values(?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMon);
            ps.setString(2, tenMon);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("createNewMonThi: " + e.getMessage());
        }
        return false;
    }

    public boolean editMonThi(String maMon, String tenMon) {
        String sql = "update MonHoc\n"
                + "set TenMon = ?\n"
                + "where MaMon = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenMon);
            ps.setString(2, maMon);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("editMonThi: " + e.getMessage());
        }
        return false;
    }

    public boolean deleleMonThi(String maMon) {
        String sql = "delete from MonHoc\n"
                + "where mamon = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMon);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("deleleMonThi: " + e.getMessage());
        }
        return false;
    }

    public boolean editCauHoi(int maCauHoi, String noiDung, String hinhAnh, int doKho, String maMon, String a, String b, String c, String d, int loaiCauHoi, String dapAn) {
        String sql1 = "update CauHoi\n"
                + "set NoiDung = ?,\n"
                + "hinhanh = ?,\n"
                + "dokho = ?,\n"
                + "mamon = ?\n"
                + "where MaCauHoi = ?\n";

        String sql2 = "update CauHoi_ChiTiet\n"
                + "set A = ?,\n"
                + "B = ?,\n"
                + "C = ?,\n"
                + "D = ?,\n"
                + "LoaiCauHoi = ?\n"
                + "where MaCauHoi = ?\n";

        String sql3 = "update DapAn\n"
                + "set NoiDung = ?\n"
                + "where MaDapAn = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setString(1, noiDung);
            ps.setString(2, hinhAnh);
            ps.setInt(3, doKho);
            ps.setString(4, maMon);
            ps.setInt(5, maCauHoi);
            ps.executeUpdate();

            ps = connection.prepareStatement(sql2);
            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);
            ps.setString(4, d);
            ps.setInt(5, loaiCauHoi);
            ps.setInt(6, maCauHoi);
            ps.executeUpdate();

            ps = connection.prepareStatement(sql3);
            ps.setString(1, dapAn);
            ps.setInt(2, maCauHoi);
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println("editCauHoi: " + e.getMessage());
        }
        return false;
    }

    public boolean createNewCauHoi(int maCauHoi, String noiDung, String hinhAnh, int doKho, String maMon, String a, String b, String c, String d, int loaiCauHoi, String dapAn) {
        String sql1 = "insert into CauHoi (MaCauHoi, NoiDung, HinhAnh, MaMon, DoKho) values (?, ?, ?, ?, ?)";
        String sql2 = "insert into CauHoi_ChiTiet (A, B, C, D, LoaiCauHoi, MaCauHoi) values (?, ?, ?, ?, ?, ?)";
        String sql3 = "insert into DapAn (MaDapAn, NoiDung) values(?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, maCauHoi);
            ps.setString(2, noiDung);
            ps.setString(3, hinhAnh);
            ps.setString(4, maMon);
            ps.setInt(5, doKho);
            if (ps.executeUpdate() == 0) {
                return false;
            }

            ps = connection.prepareStatement(sql2);
            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);
            ps.setString(4, d);
            ps.setInt(5, loaiCauHoi);
            ps.setInt(6, maCauHoi);
            if (ps.executeUpdate() == 0) {
                return false;
            }

            ps = connection.prepareStatement(sql3);
            ps.setInt(1, maCauHoi);
            ps.setString(2, dapAn);
            if (ps.executeUpdate() == 0) {
                return false;
            }

            return true;
        } catch (Exception e) {
            System.out.println("createNewCauHoi: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteCauHoi(int maCauHoi) {
        String sql1 = "delete from cauhoi_chitiet where macauhoi = ?";
        String sql2 = "delete from dapan where madapan = ?";
        String sql3 = "delete from cauhoi where macauhoi = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, maCauHoi);
            ps.executeUpdate();

            ps = connection.prepareStatement(sql2);
            ps.setInt(1, maCauHoi);
            ps.executeUpdate();

            ps = connection.prepareStatement(sql3);
            ps.setInt(1, maCauHoi);
            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("deleteCauHoi: " + e.getMessage());
        }

        return false;
    }

    public boolean editBaiThi(String maBaiThi, String maMon, int maLoaiBaiThi, String thoiGianMoDe, String thoiGianDongDe) {
        String sql = "update baithi\n"
                + "set maloaibaithi = ?,\n"
                + "mamon = ?,\n"
                + "tgmode = ?,\n"
                + "tgdongde = ?\n"
                + "where mabaithi = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maLoaiBaiThi);
            ps.setString(2, maMon);
            ps.setString(3, thoiGianMoDe);
            ps.setString(4, thoiGianDongDe);
            ps.setString(5, maBaiThi);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("editMonThi: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteBaiThi(String maBaiThi) {
        String sql = "delete from baithi\n"
                + "where mabaithi = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maBaiThi);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("deleleMonThi: " + e.getMessage());
        }
        return false;
    }

    public boolean createNewBaiThi(String maBaiThi, String maMon, int maLoaiBaiThi, String thoiGianMoDe, String thoiGianDongDe) {
        String sql = "insert into baithi values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maBaiThi);
            ps.setInt(2, maLoaiBaiThi);
            ps.setString(3, maMon);
            ps.setObject(4, LocalDateTime.parse(thoiGianMoDe));
            ps.setObject(5, LocalDateTime.parse(thoiGianDongDe));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("createNewBaiThi: " + e.getMessage());
        }
        return false;
    }

    public List<LoaiCauHoi> getAllLoaiCauHoi() {
        String sql = "select * from loaicauhoi";
        List<LoaiCauHoi> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiCauHoi lch = new LoaiCauHoi();
                lch.setMaLoai(rs.getInt(1));
                lch.setTenLoai(rs.getString(2));
                list.add(lch);
            }
        } catch (Exception e) {
            System.out.println("getAllLoaiCauHoi: " + e.getMessage());
        }
        return list;
    }

    public boolean createNewCauHoiBaiThi(int maCauHoi, String maBaiThi, String noiDung, String hinhAnh, int doKho, String maMon, String a, String b, String c, String d, int loaiCauHoi, String dapAn) {
        boolean flag = createNewCauHoi(maCauHoi, noiDung, hinhAnh, doKho, maMon, a, b, c, d, loaiCauHoi, dapAn);
        if (!flag) {
            return false;
        }
        String sql = "insert into BaiThi_CauHoi values (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maBaiThi);
            ps.setInt(2, maCauHoi);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("createNewCauHoiBaiThi: " + e.getMessage());
        }

        return true;
    }

    public void addCauHoiToBaiThi(String maBaiThi, int maCauHoi) {
        String sql = "insert into BaiThi_CauHoi values (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maBaiThi);
            ps.setInt(2, maCauHoi);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("addCauHoiToBaiThi: " + e.getMessage());
        }
    }

    public List<CauHoi> getAllCauHoiNotInBaiThiByMaMonMaBaiThi(String maMon, String maBaiThi) {
        List<CauHoi> list = new ArrayList<>();
        String sql = "select * from CauHoi\n"
                + "where MaCauHoi not in\n"
                + "(select MaCauHoi from BaiThi_CauHoi where MaBaiThi = ?)\n"
                + "and MaMon = ?\n"
                + "order by MaCauHoi";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maBaiThi);
            ps.setString(2, maMon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CauHoi ch = new CauHoi();
                ch.setMaCauHoi(rs.getInt("macauhoi"));
                ch.setNoiDung(rs.getString("noidung"));
                ch.setHinhAnh(rs.getString("hinhanh"));
                ch.setMaMon(getMonHocById(rs.getString("mamon")));
                ch.setDoKho(rs.getInt("dokho"));
                list.add(ch);
            }
        } catch (SQLException e) {
            System.out.println("getAllCauHoiByMaMonMaBaiThi: " + e.getMessage());
        }
        return list;
    }

    public List<Nganh> getAllNganh() {
        List<Nganh> list = new ArrayList<>();
        String sql = "select * from nganh";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Nganh n = new Nganh();
                n.setMaNganh(rs.getString(1));
                n.setTenNganh(rs.getString(2));
                list.add(n);
            }
        } catch (SQLException e) {
            System.out.println("getAllCauHoiByMaMonMaBaiThi: " + e.getMessage());
        }
        return list;
    }

    public boolean createNewSinhVien(String maSinhVien, String ho, String ten, String maNganh, String ngaySinh, String soDienThoai, String anhDaiDien, String mess) {
        String tenDangNhap = generateAccountFromSinhVien(maSinhVien, ho, ten, maNganh);
        if (!isExistedAccount(tenDangNhap)) {
            // default pass when create sinhvien
            if (!createNewTaiKhoan(tenDangNhap, "123", utils.Notifications.CAPDO_SINHVIEN)) {
                return false;
            }
        }
        String sql = "insert into SinhVien values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maSinhVien);
            ps.setString(2, maNganh);
            ps.setString(3, ho);
            ps.setString(4, ten);
            ps.setDate(5, Date.valueOf(ngaySinh));
            ps.setString(6, soDienThoai);
            ps.setString(7, anhDaiDien);
            ps.setString(8, mess);
            ps.setString(9, tenDangNhap);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("createNewSinhVien: " + e.getMessage());
        }
        return false;
    }

    public String generateAccountFromSinhVien(String maSinhVien, String ho, String ten, String maNganh) {
        ho = utils.NlpUtils.removeAccent(ho);
        ten = utils.NlpUtils.removeAccent(ten);
        String mangTen[] = ten.split(" ");
        int lengthMangTen = mangTen.length;
        String tenDangNhap = mangTen[lengthMangTen - 1].substring(0, 1).toUpperCase() + mangTen[lengthMangTen - 1].substring(1).trim() + ho.substring(0, 1);
        for (int i = 0; i < mangTen.length; i++) {
            if (i == lengthMangTen - 1) {
                break;
            }
            tenDangNhap += Character.toString(mangTen[i].charAt(0)).toUpperCase();
        }
        tenDangNhap += maNganh.trim() + maSinhVien.trim();
        return tenDangNhap;
    }

    public boolean createNewTaiKhoan(String tenDangNhap, String matKhau, int capDo) {
        if (isExistedAccount(tenDangNhap)) {
            return false;
        }
        String sql = "insert into taikhoan values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
//            ps.setString(2, matKhau);
            ps.setString(2, utils.Hash.hashPassword(matKhau));
            ps.setInt(3, capDo);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("createNewTaiKhoan: " + e.getMessage());
        }
        return false;
    }

    private boolean isExistedAccount(String tenDangNhap) {
        String sql = "select * from taikhoan";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equalsIgnoreCase(tenDangNhap)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("isExistedAccount: " + e.getMessage());
        }
        return false;
    }

    public int getMaSinhVienFromTenDangNhap(String tenDangNhap) {
        String ret = "";
        for (int i = 0; i < tenDangNhap.length(); i++) {
            if (Character.isDigit(tenDangNhap.charAt(i))) {
                ret += tenDangNhap.charAt(i);
            }
        }
        return ret.isEmpty() ? -1 : Integer.valueOf(ret);
    }

    public boolean deleteSinhVien(int maSinhVien) {
        String sql = "delete from SinhVien\n"
                + "where masinhvien = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maSinhVien);
            SinhVien sv = getSinhVienByMaSinhVien(maSinhVien);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("deleteSinhVien: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteAccount(String tenDangNhap) {
        String sql = "delete from taikhoan where tendangnhap = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("deleteAccount: " + e.getMessage());
        }
        return false;
    }

    public boolean editSinhVien(String maSinhVien, String ho, String ten, String maNganh, Date ngaySinh, String soDienThoai, String anhDaiDien, String mess, String tenDangNhap) {
        String sql = "update SinhVien\n"
                + "set MaNganh = ?,\n"
                + "Ho = ?,\n"
                + "Ten = ?,\n"
                + "NgaySinh = ?,\n"
                + "SoDienThoai = ?,\n"
                + "AnhDaiDien = ?,\n"
                + "Mess = ?,\n"
                + "TenDangNhap = ?\n"
                + "where MaSinhVien = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maNganh);
            ps.setString(2, ho);
            ps.setString(3, ten);
            if (ngaySinh != null) {
                ps.setDate(4, ngaySinh);
            } else {
                ps.setString(4, "");
            }
            ps.setString(5, soDienThoai);
            ps.setString(6, anhDaiDien);
            ps.setString(7, mess);
            ps.setString(8, tenDangNhap);
            ps.setString(9, maSinhVien);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("editSinhVien: " + e.getMessage());
        }
        return false;
    }

    public List<BaiThi> getAllBaiThiByMaSinhVien(int maSinhVien) {
        List<BaiThi> list = new ArrayList<>();
        String sql = "select * from SinhVien_BaiThi where masinhvien = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maSinhVien);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaiThi bt = getBaiThiByMaBaiThi(rs.getString(2));
                list.add(bt);
            }
        } catch (Exception e) {
            System.out.println("getAllBaiThiByMaSinhVien: " + e.getMessage());
        }
        return list;
    }

    public List<MonHoc> getAllMonHocByMaSinhVien(int maSinhVien) {
        String sql = "select * from sinhvien_monhoc where masinhvien = ?";
        List<MonHoc> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maSinhVien);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = getMonHocById(rs.getString(2));
                if (!list.contains(mh)) {
                    list.add(mh);
                }
            }
        } catch (Exception e) {
            System.out.println("getAllMonHocByMaSinhVien: " + e.getMessage());
        }
        return list;
    }

    public double checkStatusSinhVienBaiThi(int maSinhVien, String maBaiThi) {
        String sql = "select * from SinhVien_BaiThi where masinhvien = ? and mabaithi = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maSinhVien);
            ps.setString(2, maBaiThi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (!rs.getBoolean(3)) {
                    return -1;
                }
            }
        } catch (Exception e) {
            System.out.println("checkStatusSinhVienBaiThi: " + e.getMessage());
        }
        return 0;
    }

    public List<LoaiTaiKhoan> getAllLoaiTaiKhoan() {
        List<LoaiTaiKhoan> list = new ArrayList<>();
        String sql = "select * from loaitaikhoan";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiTaiKhoan ltk = new LoaiTaiKhoan();
                ltk.setMaLoai(rs.getInt(1));
                ltk.setTenLoai(rs.getString(2));
                list.add(ltk);
            }
        } catch (SQLException e) {
            System.out.println("getAllLoaiTaiKhoan: " + e.getMessage());
        }
        return list;
    }

    public boolean editTaiKhoan(String tenDangNhap, String matKhau, int capDo) {
        String sql = "update TaiKhoan\n"
                + "set MatKhau = ?,\n"
                + "CapDo = ?\n"
                + "where TenDangNhap = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, matKhau);
            ps.setString(1, utils.Hash.hashPassword(matKhau));
            ps.setInt(2, capDo);
            ps.setString(3, tenDangNhap);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("editTaiKhoan: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteTaiKhoan(String tenDangNhap) {
        String sql = "delete from TaiKhoan\n"
                + "where TenDangNhap = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("deleteTaiKhoan: " + e.getMessage());
        }
        return false;
    }

    public List<CauHoi> getAllCauHoiByMaBaiThi(String maBaiThi) {
        List<CauHoi> list = new ArrayList<>();
        String sql = "select * from BaiThi_CauHoi where mabaithi = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maBaiThi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CauHoi ch = getCauHoiByMaCauHoi(rs.getInt(2));
                list.add(ch);
            }

        } catch (Exception e) {
            System.out.println("getAllCauHoiByMaBaiThi " + e.getMessage());
        }
        return list;
    }

    public boolean deleteCauHoiFromBaiThi(int maCauHoi) {
        String sql = "delete from baithi_cauhoi where macauhoi = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maCauHoi);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("deleteCauHoiFromBaiThi " + e.getMessage());
        }
        return false;
    }
}
