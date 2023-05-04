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
import model.MonHoc;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "DanhSachMonThi", urlPatterns = {"/danhsachmonthi"})
public class DanhSachMonThi extends HttpServlet {

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
            out.println("<title>Servlet DanhSachMonThi</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DanhSachMonThi at " + request.getContextPath() + "</h1>");
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
        PhanTrang pt = new PhanTrang();
        int count = pt.getNumeberOf("monhoc");
        int endPage = count % 5 == 0 ? count / 5 : count / 5 + 1;
        try {
            int indexPage = request.getParameter("index") != null ? Integer.parseInt(request.getParameter("index")) : 1;
            List<MonHoc> listMonHoc = pt.pagingMonHoc(indexPage);
            request.setAttribute("listMonHoc", listMonHoc);
            request.setAttribute("currentPage", indexPage);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        request.setAttribute("endPage", endPage);
        request.setAttribute("listSize", count);
        request.getRequestDispatcher("QuanLyBaiThi/DanhSachMonThi.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        String text = request.getParameter("text");
        Search search = new Search();
        List<MonHoc> searchList = search.getMonHocByString(text);
        if (searchList != null) {
            PrintWriter out = response.getWriter();
            int i = 0;
            for (MonHoc mh : searchList) {
                out.println("<tr>\n"
                        + "                                    <td>" + (++i) + "</td>\n"
                        + "                                    <td>" + mh.getTenMon() + "</td>\n"
                        + "                                    <td>\n"
                        + "                                        <a href=\"danhsachcauhoi?mamon=" + mh.getMaMon().trim() + "&&tenmon=" + mh.getTenMon() + "\"><i class=\"fa-regular fa-circle-question\" style=\"font-size: 50px\"></i></a>\n"
                        + "                                    </td>\n"
                        + "                                    <td>\n"
                        + "                                        <a href=\"danhsachbaithi?mamon=" + mh.getMaMon().trim() + "\"><i class=\"fa-solid fa-file-circle-question\" style=\"font-size: 50px\"></i></a>\n"
                        + "                                    </td>\n"
                        + "                                    <td>\n"
                        + "                                        <a href=\"viewmonthi?mamon="+mh.getMaMon().trim()+"\" class=\"view\" title=\"View\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE417;</i></a>\n"
                        + "                                        <a href=\"editmonthi?mamon="+mh.getMaMon().trim()+"\" class=\"edit\" title=\"Edit\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a>\n"
                        + "                                        <a href=\"deletemonthi?mamon="+mh.getMaMon().trim()+"\" class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a>\n"
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
