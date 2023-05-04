/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CauHoiBaiThiCRUD;

import dal.DAO;
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
@WebServlet(name = "AddMore", urlPatterns = {"/addmore"})
public class AddMore extends HttpServlet {

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
            out.println("<title>Servlet AddMore</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddMore at " + request.getContextPath() + "</h1>");
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
        String maBaiThi = request.getParameter("mabaithi");
        String maMon = request.getParameter("mamon");

        if(!util.checkNumOfQues(request, response, maBaiThi)) {
            return;
        }
        
        DAO dao = new DAO();
        List<CauHoi> listCauHoi = dao.getAllCauHoiNotInBaiThiByMaMonMaBaiThi(maMon, maBaiThi);
        
        // add parameter got from AddMoreCauHoi.jsp
        if (request.getParameter("add") != null) {
//            for (CauHoi ch : listCauHoi) {
//                if (request.getParameter(String.valueOf(ch.getMaCauHoi())) != null) {
//                    dao.addCauHoiToBaiThi(maBaiThi, ch.getMaCauHoi());
//                }
//            }
            String maCauHoi[] = request.getParameterValues("macauhoi");
            for (String s : maCauHoi) {
                dao.addCauHoiToBaiThi(maBaiThi, Integer.parseInt(s));
            }
            response.sendRedirect("danhsachcauhoibaithi?mamon=" + maMon + "&&mabaithi=" + maBaiThi);
        // when i get in AddMoreCauHoi.jsp, load below data to page
        } else {
            request.setAttribute("listCauHoi", listCauHoi);
            request.setAttribute("maBaiThi", maBaiThi);
            request.setAttribute("maMon", maMon);
            request.getRequestDispatcher("QuanLyBaiThi/DanhSachCauHoiBaiThi/AddMoreCauHoi.jsp").forward(request, response);
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
        String maBaiThi = request.getParameter("mabaithi");
        Search search = new Search();
        List<CauHoi> searchList = search.getCauHoiNotInBaiThiByString(maBaiThi, text);
        if (searchList != null) {
            PrintWriter out = response.getWriter();
            int i = 0;
            for (CauHoi ch : searchList) {
                out.println("<tr>\n"
                        + "                                        <td>\n"
                        + "                                            <input type=\"checkbox\" name=\"" + ch.getMaCauHoi() + "\" value=\"" + ch.getMaCauHoi() + "\">\n"
                        + "                                        </td>\n"
                        + "                                        <td>" + (++i) + "</td>\n"
                        + "                                        <td class=\"text-left\">" + ch.getNoiDung() + "</td>\n"
                        + "                                        <td>" + ch.getHinhAnh() + "</td>\n"
                        + "                                        <td>" + ch.getDoKho() + "</td>\n"
                        + "                                    </tr>");
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
