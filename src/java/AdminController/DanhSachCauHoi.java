/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminController;

import dal.DAO;
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
import model.CauHoi;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "DanhSachCauHoi", urlPatterns = {"/danhsachcauhoi"})
public class DanhSachCauHoi extends HttpServlet {

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
            out.println("<title>Servlet DanhSachCauHoi</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DanhSachCauHoi at " + request.getContextPath() + "</h1>");
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
        String maMon = request.getParameter("mamon");
        PhanTrang pt = new PhanTrang();
        int count = pt.getNumeberOf("cauhoi where mamon = '" + maMon + "'");
        int endPage = count % 5 == 0 ? count / 5 : count / 5 + 1;
        try {

            int indexPage = request.getParameter("index") != null ? Integer.parseInt(request.getParameter("index")) : 1;
            List<CauHoi> listCauHoi = pt.pagingCauHoi(indexPage, maMon);

            request.setAttribute("listCauHoi", listCauHoi);
            request.setAttribute("currentPage", indexPage);
            request.setAttribute("maMon", maMon);
            request.setAttribute("endPage", endPage);
            request.setAttribute("listSize", count);
        } catch (Exception e) {
            System.out.println("danhsachcauhoi_doget: " + e.getMessage());
        }

        DAO dao = new DAO();
        String tenMon = dao.getMonHocById(maMon).getTenMon();
        tenMon = tenMon.substring(0, 1).toUpperCase() + tenMon.substring(1).toLowerCase();
        request.setAttribute("tenMon", tenMon);

        request.getRequestDispatcher("QuanLyBaiThi/DanhSachCauHoi.jsp").forward(request, response);
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
        List<CauHoi> searchList = search.getCauHoiByString(text);
        if (searchList != null) {
            PrintWriter out = response.getWriter();
            int i = 0;
            for (CauHoi ch : searchList) {
                out.println("<tr>\n"
                        + "                                    <td>" + (++i) + "</td>\n"
                        + "                                    <td>" + ch.getNoiDung() + "</td>\n"
                        + "                                    <td>" + ch.getDoKho() + "</td>\n"
                        + "                                    <td>\n"
                        + "                                        <a href=\"\" class=\"view\" title=\"View\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE417;</i></a>\n"
                        + "                                        <a href=\"#\" class=\"edit\" title=\"Edit\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a>\n"
                        + "                                        <a href=\"#\" class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a>\n"
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
