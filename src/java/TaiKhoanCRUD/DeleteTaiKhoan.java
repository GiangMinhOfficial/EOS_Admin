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
import model.SinhVien;
import model.TaiKhoan;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "DeleteTaiKhoan", urlPatterns = {"/deletetaikhoan"})
public class DeleteTaiKhoan extends HttpServlet {

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
            String tenDangNhap = request.getParameter("tendangnhap");
            TaiKhoan tk = dao.getTaiKhoanById(tenDangNhap);

            request.setAttribute("tk", tk);
            request.getRequestDispatcher("QuanLyTaiKhoan/DanhSachTaiKhoan/Delete.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("deletetaikhoan_doget" + e.getMessage());
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
        boolean isDeleted = false;
        try {
            DAO dao = new DAO();
            String tenDangNhap = request.getParameter("tendangnhap");
            TaiKhoan tk = dao.getTaiKhoanById(tenDangNhap);
            
            switch (tk.getCapDo().getMaLoai()) {
                case 1:
                    SinhVien sv = dao.getSinhVienByMaSinhVien(dao.getMaSinhVienFromTenDangNhap(tenDangNhap));
                    if (sv != null) {
                        // delete tendangnhap of sinhvien
                        isDeleted = dao.editSinhVien(String.valueOf(sv.getMaSinhVien()), sv.getHo(), sv.getTen(), sv.getMaNganh().getMaNganh(), sv.getNgaySinh(), sv.getSoDienThoai(), sv.getAnhDaiDien(), sv.getMess(), null);
                    }   // if edit success, delete taikhoan
                    if (isDeleted) {
                        isDeleted = dao.deleteTaiKhoan(tenDangNhap);
                    }
                    break;
                case 2:
                    isDeleted = dao.deleteTaiKhoan(tk.getTenDangNhap());
                    break;
                case 3:
                    isDeleted = dao.deleteTaiKhoan(tk.getTenDangNhap());
                    break;
                default:
                    break;
            }
            
        } catch (Exception e) {
            System.out.println("deletetaikhoan_dopost: " + e.getMessage());
        }
        
        utils.Functions.noty(request, isDeleted, "Xóa Tài Khoản");
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
