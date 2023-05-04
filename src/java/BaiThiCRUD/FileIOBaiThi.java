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
import jakarta.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import model.BaiThi;
import model.CauHoi;
import model.CauHoi_ChiTiet;
import model.DapAn;
import model.LoaiBaiThi;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "FileIOBaiThi", urlPatterns = {"/nhapxuatbaithi"})
public class FileIOBaiThi extends HttpServlet {

    private final static String PATH_BAITHI = "D://2023_SPRING//01_PRJ301//EOS_Admin//resources//io//DanhSachBaiThi.xlsx";

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
        String maMon = request.getParameter("mamon");
        boolean flag = export(maMon);
        utils.Functions.noty(request, flag, "Xuất File");
        request.getRequestDispatcher("/danhsachbaithi?mamon=" + maMon).forward(request, response);
    }

    private boolean export(String maMon) {
        DAO dao = new DAO();
        final List<BaiThi> listBaiThi = dao.getAllBaiThiByMaMon(maMon);
        String arr[] = {"Mã bài thi", "Môn học", "Loại bài thi", "Số câu", "Thời gian làm bài", "Thời gian mở đề", "Thời gian đóng đề"};
        try {
            XSSFWorkbook wk = new XSSFWorkbook();
            XSSFSheet sheet = wk.createSheet("DanhSachBaiThi");
            XSSFRow row = sheet.createRow(0); // create row 0 for sheet name 'danhsach'
            Cell cell;

            for (int i = 0; i < arr.length; i++) {
                cell = row.createCell(i, CellType.STRING);
                cell.setCellValue(arr[i]);
            }

            for (int i = 0; i < listBaiThi.size(); i++) {
                row = sheet.createRow(i + 2);
                BaiThi bt = listBaiThi.get(i);
                LoaiBaiThi lbt = dao.getLoaiBaiThiById(bt.getLoaiBaiThi().getMaLoaiBaiThi());

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(bt.getMaBaiThi());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(bt.getMonHoc().getTenMon());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(lbt.getTenLoaiBaiThi());

                cell = row.createCell(3, CellType.NUMERIC);
                cell.setCellValue(lbt.getSoCau());

                cell = row.createCell(4, CellType.NUMERIC);
                cell.setCellValue(lbt.getThoiGianLamBai());

                cell = row.createCell(5, CellType.STRING);
                if (bt.getThoiGianMoDe() != null) {
                    cell.setCellValue(bt.getThoiGianMoDe().toString());
                }

                cell = row.createCell(6, CellType.STRING);
                if (bt.getThoiGianDongDe() != null) {
                    cell.setCellValue(bt.getThoiGianDongDe().toString());
                }
            }

            File f = new File(PATH_BAITHI);

            try {
                try ( FileOutputStream fos = new FileOutputStream(f)) {
                    wk.write(fos);
                }
            } catch (IOException e) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Export_DanhSachBaiThi: " + e.getMessage());
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
