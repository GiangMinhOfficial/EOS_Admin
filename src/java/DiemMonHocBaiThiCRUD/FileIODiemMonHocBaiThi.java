/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package DiemMonHocBaiThiCRUD;

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
import model.MonHoc_Diem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "FileIODiemMonHocBaiThi", urlPatterns = {"/nhapxuatdiemmonhocbaithi"})
public class FileIODiemMonHocBaiThi extends HttpServlet {

    private final static String PATH_DIEM = "D://2023_SPRING//01_PRJ301//EOS_Admin//resources//io//DanhSachDiem.xlsx";

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
        HttpSession session = request.getSession();
        // this List<MonHoc_Diem> list prevent compiler from clean and build
        @SuppressWarnings("unchecked")
        List<MonHoc_Diem> listMonHoc_Diem = (List<MonHoc_Diem>) session.getAttribute("listMonHoc_Diem");
        boolean flag = export(listMonHoc_Diem);
        session.removeAttribute("listMonHoc_Diem");
        utils.Functions.noty(request, flag, "Xuất File");
        response.sendRedirect("danhsachdiemmonhocbaithi?masinhvien=" + request.getParameter("masinhvien"));
    }

    private boolean export(List<MonHoc_Diem> lMonHoc_Diem) {
        final List<MonHoc_Diem> listMonHoc_Diem = lMonHoc_Diem;
        String arr[] = {"Môn Học", "Progress Test 1", "Progress Test 2", "Progress Test 3", "Mid-term Test", "Final Exam"};
        try {
            XSSFWorkbook wk = new XSSFWorkbook();
            XSSFSheet sheet = wk.createSheet("DanhSachMonHoc");
            XSSFRow row;
            Cell cell;

            row = sheet.createRow(0); // create row 0 for sheet name 'danhsach'

            for (int i = 0; i < arr.length; i++) {
                cell = row.createCell(i, CellType.STRING);
                cell.setCellValue(arr[i]);
            }

            for (int i = 0; i < listMonHoc_Diem.size(); i++) {
                row = sheet.createRow(i + 2);
                MonHoc_Diem mhd = listMonHoc_Diem.get(i);
                MonHoc mh = mhd.getMonHoc();

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(mh.getTenMon());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(String.format("%.2f", mhd.getProgressTest1()));

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(String.format("%.2f", mhd.getProgressTest2()));

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(String.format("%.2f", mhd.getProgressTest3()));

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(String.format("%.2f", mhd.getMidtermTest()));

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(String.format("%.2f", mhd.getFinalExam()));
            }
            File f = new File(PATH_DIEM);
            try {
                try ( FileOutputStream fos = new FileOutputStream(f)) {
                    wk.write(fos);
                }
            } catch (IOException e) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Export_DanhSachDiem: " + e.getMessage());
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
