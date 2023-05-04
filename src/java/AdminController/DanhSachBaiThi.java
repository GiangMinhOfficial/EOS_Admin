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
import model.BaiThi;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "DanhSachBaiThi", urlPatterns = {"/danhsachbaithi"})
public class DanhSachBaiThi extends HttpServlet {

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
            out.println("<title>Servlet DeThiManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeThiManager at " + request.getContextPath() + "</h1>");
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
            String maMon = request.getParameter("mamon");
            DAO dao = new DAO();
            String tenMon = dao.getMonHocById(maMon).getTenMon();
            PhanTrang pt = new PhanTrang();
            int count = pt.getNumeberOf("baithi where mamon = '" + maMon + "'");
            int endPage = count % 5 == 0 ? count / 5 : count / 5 + 1;
            int indexPage = request.getParameter("index") != null ? Integer.parseInt(request.getParameter("index")) : 1;
            List<BaiThi> listBaiThi = pt.pagingBaiThi(indexPage, maMon);

            request.setAttribute("listBaiThi", listBaiThi);
            request.setAttribute("currentPage", indexPage);
            request.setAttribute("maMon", maMon);
            request.setAttribute("tenMon", tenMon.substring(0, 1).toUpperCase() + tenMon.substring(1).toLowerCase());
            request.setAttribute("endPage", endPage);
            request.setAttribute("listSize", count);
            request.getRequestDispatcher("QuanLyBaiThi/DanhSachBaiThi.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("danhsachbaithi_doget: " + e.getMessage());
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
        String maMon = request.getParameter("mamon");
        Search search = new Search();
        List<BaiThi> searchList = search.getBaiThiByString(text, maMon);
        if (searchList != null) {
            PrintWriter out = response.getWriter();
            int i = 0;
            for (BaiThi bt : searchList) {
                out.println("<tr>\n"
                        + "                                    <td>" + (++i) + "</td>\n"
                        //                        + "                                    <td>" + bt.getMaBaiThi() + "</td>\n"
                        + "                                    <td>" + bt.getLoaiBaiThi().getTenLoaiBaiThi() + "</td>\n"
                        + "                                    <td>" + bt.getLoaiBaiThi().getSoCau() + "</td>\n"
                        + "                                    <td>" + bt.getLoaiBaiThi().getThoiGianLamBai() + "</td>\n"
                        + "<td><a href=\"danhsachcauhoibaithi?mabaithi=" + bt.getMaBaiThi() + "&mamon=" + bt.getMonHoc().getMaMon() + "\"><i class=\"fa fa-question-circle\" aria-hidden=\"true\"></i></a></td>"
                        + "                                    <td>\n"
                        + "                                        <a href=\"viewbaithi?mabaithi=" + bt.getMaBaiThi() + "\" class=\"view\" title=\"View\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE417;</i></a>\n"
                        + "                                        <a href=\"editbaithi?mabaithi=" + bt.getMaBaiThi() + "\" class=\"edit\" title=\"Edit\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a>\n"
                        + "                                        <a href=\"deletebaithi?mabaithi=" + bt.getMaBaiThi() + "\" class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a>\n"
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
