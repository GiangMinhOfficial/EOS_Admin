/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package MonthiCRUD;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import model.MonHoc;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "FileIO", urlPatterns = {"/nhapxuatmonthi"})
public class FileIO extends HttpServlet {

    private final static String PATH_MONTHI = "D://2023_SPRING//01_PRJ301//EOS_Admin//resources//io//DanhSachMonHoc.xlsx";

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
            out.println("<title>Servlet FileIO</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FileIO at " + request.getContextPath() + "</h1>");
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
        boolean flag = export();
        utils.Functions.noty(request, flag, "Xuất File");
        response.sendRedirect("/EOS_Admin/danhsachmonthi");
    }

    private boolean export() {
        DAO dao = new DAO();
        final List<MonHoc> listMonHoc = dao.getAllMonHoc();

        try {
            XSSFWorkbook wk = new XSSFWorkbook();
            XSSFSheet sheet = wk.createSheet("DanhSachMonHoc");
            XSSFRow row;
            Cell cell;
            row = sheet.createRow(0); // create row 0 for sheet name 'danhsach'

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Mã Môn");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tên Môn");

            for (int i = 0; i < listMonHoc.size(); i++) {
                row = sheet.createRow(i + 1);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(listMonHoc.get(i).getMaMon());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(listMonHoc.get(i).getTenMon());
            }

            File f = new File(PATH_MONTHI);
            try {
                try ( FileOutputStream fos = new FileOutputStream(f)) {
                    wk.write(fos);
                }
            } catch (IOException e) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Export_DanhSachMonHoc: " + e.getMessage());
            return false;
        }
        return true;
    }

    private boolean imp() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        processRequest(request, response);
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
