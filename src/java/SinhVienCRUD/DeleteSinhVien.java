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
import model.SinhVien;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "DeleteSinhVien", urlPatterns = {"/deletesinhvien"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class DeleteSinhVien extends HttpServlet {

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
            out.println("<title>Servlet Delete</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Delete at " + request.getContextPath() + "</h1>");
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

            request.setAttribute("sv", sv);
            request.getRequestDispatcher("QuanLyDiem/DanhSachSinhVien/Delete.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("deletesinhvien_doget" + e.getMessage());
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
        try {
            DAO dao = new DAO();
            int maSinhVien = Integer.parseInt(request.getParameter("masinhvien"));
            SinhVien sv = dao.getSinhVienByMaSinhVien(maSinhVien);
            String imagePath = CreateSinhVien.PATH_TO_SINHVIEN + "/" + sv.getAnhDaiDien();
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                imageFile.delete();
            }
            boolean isDeleted = dao.deleteSinhVien(maSinhVien);
            if (sv.getMaTaiKhoan() != null) {
                dao.deleteAccount(sv.getMaTaiKhoan().getTenDangNhap());
            }

            utils.Functions.noty(request, isDeleted, "Xóa sinh viên");
        } catch (Exception e) {
            System.out.println("deletesinhvien_dopost: " + e.getMessage());
        }

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
