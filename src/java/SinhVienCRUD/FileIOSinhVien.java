/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SinhVienCRUD;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import model.Nganh;
import model.SinhVien;
import model.TaiKhoan;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "FileIOSinhVien", urlPatterns = {"/nhapxuatsinhvien"})
public class FileIOSinhVien extends HttpServlet {

    private final static String PATH_SINHVIEN = "D://2023_SPRING//01_PRJ301//EOS_Admin//resources//io//DanhSachSinhVien.xlsx";

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
        response.sendRedirect("danhsachsinhvien");
    }

    private boolean export() {
        DAO dao = new DAO();
        final List<SinhVien> listSinhVien = dao.getAllSinhVien();
        String arr[] = {"Mã sinh viên", "Mã ngành", "Họ", "Tên", "Ngày sinh", "Số điện thoại", "Ảnh đại diện", "Ghi chú", "Tên đăng nhập"};
        try {
            XSSFWorkbook wk = new XSSFWorkbook();
            XSSFSheet sheet = wk.createSheet("DanhSachSinhVien");
            XSSFRow row = sheet.createRow(0); // create row 0 for sheet name 'danhsach'
            Cell cell;

            for (int i = 0; i < arr.length; i++) {
                cell = row.createCell(i, CellType.STRING);
                cell.setCellValue(arr[i]);
            }

            for (int i = 0; i < listSinhVien.size(); i++) {
                row = sheet.createRow(i + 2);
                SinhVien sv = listSinhVien.get(i);
                Nganh n = sv.getMaNganh();
                TaiKhoan tk = sv.getMaTaiKhoan();

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(sv.getMaSinhVien());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(sv.getHo());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(sv.getTen());

                cell = row.createCell(4, CellType.STRING);
                if (sv.getNgaySinh() != null) {
                    cell.setCellValue(sv.getNgaySinh().toString());
                } else {
                    cell.setCellValue("");
                }

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(sv.getSoDienThoai());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(sv.getAnhDaiDien());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(sv.getMess());

                if (n != null) {
                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(n.getTenNganh());
                }

                if (tk != null) {
                    cell = row.createCell(8, CellType.STRING);
                    cell.setCellValue(tk.getTenDangNhap());
                }

            }

            File f = new File(PATH_SINHVIEN);
            try {
                try ( FileOutputStream fos = new FileOutputStream(f)) {
                    wk.write(fos);
                }
            } catch (IOException e) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Export_DanhSachSinhVien: " + e.getMessage());
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
