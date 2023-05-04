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
import java.util.List;
import model.CauHoi;
import model.CauHoi_ChiTiet;
import model.DapAn;
import model.LoaiCauHoi;
import model.MonHoc;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "EditCauHoi", urlPatterns = {"/editcauhoi"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class EditCauHoi extends HttpServlet {

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
        DAO dao = new DAO();
        try {
            int maCauHoi = Integer.parseInt(request.getParameter("macauhoi"));
            CauHoi ch = dao.getCauHoiByMaMonMaCauHoi(maCauHoi, request.getParameter("mamon"));
            DapAn da = dao.getDapAnByMaCauHoi(maCauHoi);
            CauHoi_ChiTiet chct = dao.getCauHoiChiTietByMaCauHoi(maCauHoi);
            List<MonHoc> listMonHoc = dao.getAllMonHoc();
            List<LoaiCauHoi> listLoaiCauhoi = dao.getAllLoaiCauHoi();
            if (da != null) {
                String noiDung = "";
                switch (da.getNoiDung()) {
                    case "a":
                        noiDung = chct.getA();
                        break;
                    case "b":
                        noiDung = chct.getB();
                        break;
                    case "c":
                        noiDung = chct.getC();
                        break;
                    case "d":
                        noiDung = chct.getD();
                        break;
                    default:
                        break;
                }
                request.setAttribute("da", da);
                request.setAttribute("noiDung", noiDung);
            }

            request.setAttribute("ch", ch);
            request.setAttribute("chct", chct);
            request.setAttribute("listMonHoc", listMonHoc);
            request.setAttribute("listLoaiCauhoi", listLoaiCauhoi);

        } catch (Exception e) {
            System.out.println("editcauhoi_doget: " + e.getMessage());
        }
        request.getRequestDispatcher("QuanLyBaiThi/DanhSachCauHoi/Edit.jsp").forward(request, response);
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
        String maCauHoi = request.getParameter("macauhoi");

        try {
            // delete saved image of the ques in db
            CauHoi ch = dao.getCauHoiByMaCauHoi(Integer.parseInt(maCauHoi));
            String fileName = utils.Functions.storeImage(request, "hinhanh", CreateCauHoi.PATH_TO_CAUHOI);
            // if no image uploaded, filename will be empty --> keep old hinhanh
            String hinhAnh = fileName.isEmpty() ? ch.getHinhAnh() : fileName;
            // get path to hinhanh
            String imagePath = CreateCauHoi.PATH_TO_CAUHOI + "/" + ch.getHinhAnh();
            // if edited image is different from preImage, remove preImage
            if (!hinhAnh.equals(ch.getHinhAnh())) {
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                    imageFile.delete();
                }
            }

            String noiDung = request.getParameter("noidung");
            String a = request.getParameter("a");
            String b = request.getParameter("b");
            String c = request.getParameter("c");
            String d = request.getParameter("d");
            String dapAn = request.getParameter("dapan");
            String doKho = request.getParameter("dokho");
            int loaiCauHoi = Integer.parseInt(request.getParameter("loaicauhoi"));
            
            boolean check = dao.editCauHoi(Integer.parseInt(maCauHoi), noiDung, hinhAnh, Integer.parseInt(doKho), maMon, a, b, c, d, loaiCauHoi, dapAn);
            utils.Functions.noty(request, check, "Sửa Câu Hỏi");
        } catch (Exception e) {
            System.out.println("editcauhoi_dopost");
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
