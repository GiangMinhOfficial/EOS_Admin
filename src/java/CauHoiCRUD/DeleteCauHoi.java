/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CauHoiCRUD;

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
import model.CauHoi;
import model.CauHoi_ChiTiet;
import model.DapAn;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "Delete", urlPatterns = {"/deletecauhoi"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class DeleteCauHoi extends HttpServlet {

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
        DAO dao = new DAO();
        int maCauHoi = Integer.parseInt(request.getParameter("macauhoi"));
        String maMon = request.getParameter("mamon");
        CauHoi ch = dao.getCauHoiByMaMonMaCauHoi(maCauHoi, maMon);
        DapAn da = dao.getDapAnByMaCauHoi(maCauHoi);
        CauHoi_ChiTiet chct = dao.getCauHoiChiTietByMaCauHoi(maCauHoi);

        request.setAttribute("ch", ch);
        request.setAttribute("da", da);
        request.setAttribute("chct", chct);

        request.getRequestDispatcher("QuanLyBaiThi/DanhSachCauHoi/Delete.jsp").forward(request, response);
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
        DAO dao = new DAO();
        String maMon = request.getParameter("mamon");
        String tenMon = dao.getMonHocById(maMon).getTenMon();
        try {
            int maCauHoi = Integer.parseInt(request.getParameter("macauhoi"));
            CauHoi ch = dao.getCauHoiByMaCauHoi(maCauHoi);
            String imagePath = CreateCauHoi.PATH_TO_CAUHOI + "/" + ch.getHinhAnh();
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                imageFile.delete();
            }
            
            boolean isDeleted = dao.deleteCauHoi(maCauHoi);
            utils.Functions.noty(request, isDeleted, "Xóa Câu Hỏi");
        } catch (Exception e) {
            System.out.println("deletecauhoi_post" + e.getMessage());
        }

        response.sendRedirect("/EOS_Admin/danhsachcauhoi?mamon=" + maMon.trim() + "&tenmon=" + tenMon);
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
