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
import java.util.List;
import model.Nganh;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "CreateSinhVien", urlPatterns = {"/createsinhvien"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CreateSinhVien extends HttpServlet {
    
    protected static String PATH_TO_SINHVIEN = "D:/2023_SPRING/01_PRJ301/EOS_Admin/web/shared/images/SinhVien";

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
            List<Nganh> listNganh = dao.getAllNganh();
            request.setAttribute("listNganh", listNganh);
            request.getRequestDispatcher("QuanLyDiem/DanhSachSinhVien/Create.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("createsinhvien_doget: " + e.getMessage());
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
        String maSinhVien = request.getParameter("masinhvien");
        String ho = request.getParameter("ho");
        String ten = request.getParameter("ten");
        String maNganh = request.getParameter("manganh");
        String ngaySinh = request.getParameter("ngaysinh");
        String soDienThoai = request.getParameter("sodienthoai");
        String anhDaiDien = utils.Functions.storeImage(request, "anhdaidien", PATH_TO_SINHVIEN);
        String mess = request.getParameter("ghichu");

        DAO dao = new DAO();
        boolean check = dao.createNewSinhVien(maSinhVien, ho, ten, maNganh, ngaySinh, soDienThoai, anhDaiDien, mess);

        utils.Functions.noty(request, check, "Thêm mới sinh viên");
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
