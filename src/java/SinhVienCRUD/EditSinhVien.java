/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SinhVienCRUD;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Date;
import java.util.List;
import model.Nganh;
import model.SinhVien;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "EditSinhVien", urlPatterns = {"/editsinhvien"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class EditSinhVien extends HttpServlet {

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
            out.println("<title>Servlet Edit</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Edit at " + request.getContextPath() + "</h1>");
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
            int maSinhVien = Integer.parseInt(request.getParameter("masinhvien"));
            SinhVien sv = dao.getSinhVienByMaSinhVien(maSinhVien);
            List<Nganh> listNganh = dao.getAllNganh();

            request.setAttribute("sv", sv);
            request.setAttribute("listNganh", listNganh);
            request.getRequestDispatcher("QuanLyDiem/DanhSachSinhVien/Edit.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("editsinhvien_doget: " + e.getMessage());
        }
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
        boolean check = false;
        try {
            String maSinhVien = request.getParameter("masinhvien");
            String ho = request.getParameter("ho");
            String ten = request.getParameter("ten");
            String maNganh = request.getParameter("manganh");
            Date ngaySinh = request.getParameter("ngaysinh") == null ? null : Date.valueOf(request.getParameter("ngaysinh"));
            String soDienThoai = request.getParameter("sodienthoai");
            String mess = request.getParameter("ghichu");
            String tenDangNhap = "".equals(request.getParameter("tendangnhap")) ? null : request.getParameter("tendangnhap");

            DAO dao = new DAO();
            SinhVien sv = dao.getSinhVienByMaSinhVien(Integer.parseInt(maSinhVien));
            String fileName = utils.Functions.storeImage(request, "anhdaidien", CreateSinhVien.PATH_TO_SINHVIEN);
            String anhDaiDien = fileName.isEmpty() ? sv.getAnhDaiDien() : fileName;
            String imagePath = CreateSinhVien.PATH_TO_SINHVIEN + "/" + sv.getAnhDaiDien();
            if (!anhDaiDien.equals(sv.getAnhDaiDien())) {
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                    imageFile.delete();
                }
            }

            check = dao.editSinhVien(maSinhVien, ho, ten, maNganh, ngaySinh, soDienThoai, anhDaiDien, mess, tenDangNhap);
        } catch (Exception e) {
            System.out.println("post_editsinhvien " + e.getMessage());
        }
        
        utils.Functions.noty(request, check, "Thay đổi sinh viên");
        response.sendRedirect("/EOS_Admin/danhsachsinhvien");
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
