/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package TaiKhoanCRUD;

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
import model.LoaiTaiKhoan;
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
@WebServlet(name = "FileIOTaiKhoan", urlPatterns = {"/nhapxuattaikhoan"})
public class FileIOTaiKhoan extends HttpServlet {

    private final static String PATH_TAIKHOAN = "D://2023_SPRING//01_PRJ301//EOS_Admin//resources//io//DanhSachTaiKhoan.xlsx";

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
        request.getRequestDispatcher("/danhsachtaikhoan").forward(request, response);
    }

    private boolean export() {
        DAO dao = new DAO();
        final List<TaiKhoan> listTaiKhoan = dao.getAllTaiKhoan();
        String arr[] = {"Tên đăng nhập", "Mật khẩu", "Quyền"};
        try {
            XSSFWorkbook wk = new XSSFWorkbook();
            XSSFSheet sheet = wk.createSheet("DanhSachTaiKhoan");
            XSSFRow row = sheet.createRow(0); // create row 0 for sheet name 'danhsach'
            Cell cell;

            for (int i = 0; i < arr.length; i++) {
                cell = row.createCell(i, CellType.STRING);
                cell.setCellValue(arr[i]);
            }

            for (int i = 0; i < listTaiKhoan.size(); i++) {
                row = sheet.createRow(i + 2);
                TaiKhoan tk = listTaiKhoan.get(i);
                LoaiTaiKhoan ltk = dao.getLoaiTaiKhoan(tk.getCapDo().getMaLoai());

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(tk.getTenDangNhap());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(tk.getMatKhau());

                if (ltk != null) {
                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue(ltk.getTenLoai());
                }
            }

            File f = new File(PATH_TAIKHOAN);

            try {
                try ( FileOutputStream fos = new FileOutputStream(f)) {
                    wk.write(fos);
                }
            } catch (IOException e) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Export_DanhSachTaiKhoan: " + e.getMessage());
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
