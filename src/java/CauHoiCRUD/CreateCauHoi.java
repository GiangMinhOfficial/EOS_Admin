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
import java.util.List;
import model.LoaiCauHoi;
import model.MonHoc;

/**
 *
 * @author Giang Minh
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)

@WebServlet(name = "CreateCauHoi", urlPatterns = {"/createcauhoi"})
public class CreateCauHoi extends HttpServlet {
    
    protected static String PATH_TO_CAUHOI = "D:/2023_SPRING/01_PRJ301/EOS_Admin/web/shared/images/CauHoi";

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
        List<MonHoc> listMonHoc = dao.getAllMonHoc();
        List<LoaiCauHoi> listLoaiCauhoi = dao.getAllLoaiCauHoi();

        request.setAttribute("listMonHoc", listMonHoc);
        request.setAttribute("listLoaiCauhoi", listLoaiCauhoi);
        request.getRequestDispatcher("QuanLyBaiThi/DanhSachCauHoi/Create.jsp").forward(request, response);
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
            DAO dao = new DAO();
            String maCauHoi = request.getParameter("macauhoi");
            String noiDung = request.getParameter("noidung");
            String a = request.getParameter("a");
            String b = request.getParameter("b");
            String c = request.getParameter("c");
            String d = request.getParameter("d");
            String dapAn = request.getParameter("dapan");
            String hinhAnh = utils.Functions.storeImage(request, "hinhanh", PATH_TO_CAUHOI);
            String doKho = request.getParameter("dokho");
            int loaiCauHoi = Integer.parseInt(request.getParameter("loaicauhoi"));

            boolean check = dao.createNewCauHoi(Integer.parseInt(maCauHoi), noiDung, hinhAnh, Integer.parseInt(doKho), maMon, a, b, c, d, loaiCauHoi, dapAn);
            utils.Functions.noty(request, check, "Tạo Câu Hỏi");
        } catch (Exception e) {
            System.out.println("createcauhoi_doget: " + e.getMessage());
        }
        response.sendRedirect("/EOS_Admin/danhsachcauhoi?mamon=" + maMon.trim());
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
