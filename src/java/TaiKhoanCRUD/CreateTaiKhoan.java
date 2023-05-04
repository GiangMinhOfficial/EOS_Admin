/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package TaiKhoanCRUD;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.LoaiTaiKhoan;
import model.SinhVien;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "CreateTaiKhoan", urlPatterns = {"/createtaikhoan"})
public class CreateTaiKhoan extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Create</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Create at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DAO dao = new DAO();
            List<LoaiTaiKhoan> listLoaiTaiKhoan = dao.getAllLoaiTaiKhoan();
            request.setAttribute("listLoaiTaiKhoan", listLoaiTaiKhoan);
        } catch (Exception e) {
            System.out.println("createtaikhoan_doget: " + e.getMessage());
        }
        request.getRequestDispatcher("QuanLyTaiKhoan/DanhSachTaiKhoan/Create.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean check = true;
        try {
            DAO dao = new DAO();
            String matKhau = request.getParameter("matkhau");
            int capDo = Integer.parseInt(request.getParameter("capdo"));

            switch (capDo) {
                case 1:
                    // instead of filling username, we force user to fill their masinhvien in order to autogenerate user account of out form
                    int maSinhVien = Integer.parseInt(request.getParameter("masinhvien"));
                    SinhVien sv = dao.getSinhVienByMaSinhVien(maSinhVien);
                    if (sv != null) {
                        String tenDangNhap = dao.generateAccountFromSinhVien(String.valueOf(maSinhVien), sv.getHo(), sv.getTen(), sv.getMaNganh().getMaNganh());
                        check = dao.createNewTaiKhoan(tenDangNhap, matKhau, capDo);
                        // set mataikhoan to object sinhvien
                        sv.setMaTaiKhoan(dao.getTaiKhoanById(tenDangNhap));
                        // update tendangnhap to sinhvien in db
                        dao.editSinhVien(String.valueOf(sv.getMaSinhVien()), sv.getHo(), sv.getTen(), sv.getMaNganh().getMaNganh(), sv.getNgaySinh(), sv.getSoDienThoai(), sv.getAnhDaiDien(), sv.getMess(), sv.getMaTaiKhoan().getTenDangNhap());
                    } else {
                        // masinhvien do not exist
                        // => no account created
                        check = false;
                    }
                    break;
                case 2:
                    String maGiaoVien = request.getParameter("magiaovien");
                    check = dao.createNewTaiKhoan(maGiaoVien, matKhau, capDo);
                    break;
                case 3:
                    String admin = request.getParameter("admin");
                    check = dao.createNewTaiKhoan(admin, matKhau, capDo);
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println("createtaikhoan_dopost:" + e.getMessage());
        }
        utils.Functions.noty(request, check, "Tạo Tài Khoản");
        response.sendRedirect("/EOS_Admin/danhsachtaikhoan");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
