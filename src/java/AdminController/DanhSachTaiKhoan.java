/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminController;

import dal.PhanTrang;
import dal.Search;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.TaiKhoan;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "DanhSachTaiKhoan", urlPatterns = {"/danhsachtaikhoan"})
public class DanhSachTaiKhoan extends HttpServlet {

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
            out.println("<title>Servlet DanhSachTaiKhoan</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DanhSachTaiKhoan at " + request.getContextPath() + "</h1>");
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
//        DAO dao = new DAO();
//        List<TaiKhoan> listTaiKhoan = dao.getAllTaiKhoan();
//        request.setAttribute("listTaiKhoan", listTaiKhoan);
//        request.getRequestDispatcher("QuanLyTaiKhoan/DanhSachTaiKhoan.jsp").forward(request, response);

        try {
            PhanTrang pt = new PhanTrang();
            int count = pt.getNumeberOf("taikhoan");
            int endPage = count % 5 == 0 ? count / 5 : count / 5 + 1;
            int indexPage = request.getParameter("index") != null ? Integer.parseInt(request.getParameter("index")) : 1;

            List<TaiKhoan> listTaiKhoan = pt.pagingTaiKhoan(indexPage);
            request.setAttribute("listTaiKhoan", listTaiKhoan);
            request.setAttribute("currentPage", indexPage);
            request.setAttribute("endPage", endPage);
            request.setAttribute("totalSize", count);

            request.getRequestDispatcher("QuanLyTaiKhoan/DanhSachTaiKhoan.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("danhsachsinhvien_doget: " + e.getMessage());
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
        String text = request.getParameter("text");
        Search search = new Search();
        List<TaiKhoan> searchList = search.getTaiKhoanByString(text);
        if (searchList != null) {
            PrintWriter out = response.getWriter();
            int i = 0;
            for (TaiKhoan tk : searchList) {
                out.println("<tr>\n"
                        + "                                    <td>" + (++i) + "</td>\n"
                        + "                                    <td>" + tk.getTenDangNhap() + "</td>\n"
                        + "                                    <td>" + tk.getMatKhau() + "</td>\n"
                        + "                                    <td>" + tk.getCapDo().getTenLoai() + "</td>\n"
                        + "                                    <td>\n"
                        + "                                        <a href=\"viewtaikhoan?tendangnhap=" + tk.getTenDangNhap() + "\" class=\"view\" title=\"View\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE417;</i></a>\n"
                        + "                                        <a href=\"edittaikhoan?tendangnhap=" + tk.getTenDangNhap() + "\" class=\"edit\" title=\"Edit\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a>\n"
                        + "                                        <a href=\"deletetaikhoan?tendangnhap=" + tk.getTenDangNhap() + "\" class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a>\n"
                        + "                                    </td>\n"
                        + "                                </tr>");
            }
        }
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
