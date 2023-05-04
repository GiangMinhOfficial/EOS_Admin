/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package BaiThiCRUD;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.BaiThi;
import model.LoaiBaiThi;
import model.MonHoc;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "EditBaiThi", urlPatterns = {"/editbaithi"})
public class EditBaiThi extends HttpServlet {

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
            String maBaiThi = request.getParameter("mabaithi");

            BaiThi bt = dao.getBaiThiByMaBaiThi(maBaiThi);
            LoaiBaiThi lbt = dao.getLoaiBaiThiById(bt.getLoaiBaiThi().getMaLoaiBaiThi());
            List<LoaiBaiThi> listLoaiBaiThi = dao.getAllLoaiBaiThi();
            List<MonHoc> listMonHoc = dao.getAllMonHoc();

            request.setAttribute("bt", bt);
            request.setAttribute("lbt", lbt);
            request.setAttribute("listLoaiBaiThi", listLoaiBaiThi);
            request.setAttribute("listMonHoc", listMonHoc);
        } catch (Exception e) {
            System.out.println("editbaithi_doget: " + e.getMessage());
        }
        request.getRequestDispatcher("QuanLyBaiThi/DanhSachBaiThi/Edit.jsp").forward(request, response);
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
        String maMon = request.getParameter("mamon");
        try {
            String maBaiThi = request.getParameter("mabaithi");
            int maLoaiBaiThi = Integer.parseInt(request.getParameter("maloaibaithi"));
            String thoiGianMoDe = request.getParameter("thoigianmode");
            String thoiGianDongDe = request.getParameter("thoigiandongde");

            DAO dao = new DAO();
            boolean check = dao.editBaiThi(maBaiThi, maMon, maLoaiBaiThi, thoiGianMoDe, thoiGianDongDe);
            utils.Functions.noty(request, check, "Thay đổi bài thi");
        } catch (Exception e) {
            System.out.println("editbaithi_dopost");
        }
        response.sendRedirect("/EOS_Admin/danhsachbaithi?mamon=" + maMon);
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
