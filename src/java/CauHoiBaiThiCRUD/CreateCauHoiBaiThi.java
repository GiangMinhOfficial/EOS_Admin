/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CauHoiBaiThiCRUD;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.BaiThi;
import model.LoaiCauHoi;
import model.MonHoc;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "CreateCauHoiBaiThi", urlPatterns = {"/createcauhoibaithi"})
public class CreateCauHoiBaiThi extends HttpServlet {

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
        DAO dao = new DAO();
        String maBaiThi = request.getParameter("mabaithi");
        if (!util.checkNumOfQues(request, response, maBaiThi)) {
            return;
        }
        List<LoaiCauHoi> listLoaiCauhoi = dao.getAllLoaiCauHoi();
        MonHoc mh = dao.getMonHocById(request.getParameter("mamon"));
        BaiThi bt = dao.getBaiThiByMaBaiThi(request.getParameter("mabaithi"));

        request.setAttribute("mh", mh);
        request.setAttribute("bt", bt);
        request.setAttribute("listLoaiCauhoi", listLoaiCauhoi);
        request.getRequestDispatcher("QuanLyBaiThi/DanhSachCauHoiBaiThi/Create.jsp").forward(request, response);
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
        String maBaiThi = request.getParameter("mabaithi");
        DAO dao = new DAO();
        boolean flag = false;
        try {
            int maCauHoi = Integer.parseInt(request.getParameter("macauhoi"));
            String maMon = request.getParameter("mamon");
            String noiDung = request.getParameter("noidung");
            String a = request.getParameter("a");
            String b = request.getParameter("b");
            String c = request.getParameter("c");
            String d = request.getParameter("d");
            String dapAn = request.getParameter("dapan");
            String hinhAnh = request.getParameter("hinhanh");
            int doKho = Integer.parseInt(request.getParameter("dokho"));
            int loaiCauHoi = Integer.parseInt(request.getParameter("loaicauhoi"));

            flag = dao.createNewCauHoiBaiThi(maCauHoi, maBaiThi, noiDung, hinhAnh, doKho, maMon, a, b, c, d, loaiCauHoi, dapAn);
        } catch (Exception e) {
            System.out.println("createcauhoibaithi_doget: " + e.getMessage());
        }
        utils.Functions.noty(request, flag, "Thêm mới câu hỏi");
        response.sendRedirect("/EOS_Admin/danhsachcauhoibaithi?mabaithi=" + maBaiThi);
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
