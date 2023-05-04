/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CauHoiBaiThiCRUD;

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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "FileIOCauHoiBaiThi", urlPatterns = {"/nhapxuatcauhoibaithi"})
public class FileIOCauHoiBaiThi extends HttpServlet {

    private final static String PATH_CAUHOI_BAITHI = "D://2023_SPRING//01_PRJ301//EOS_Admin//resources//io//DanhSachCauHoiBaiThi.xlsx";

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
        String func = request.getParameter("func");
        String maBaiThi = request.getParameter("mabaithi");

        HttpSession session = request.getSession();
        session.setAttribute("pageName", "Xuất File");
        session.setAttribute("time", System.currentTimeMillis());

        if (func.equals("export")) {
            boolean flag = export(maBaiThi);
            if (flag) {
                session.setAttribute("noty", utils.Notifications.SUCCESS);
            } else {
                session.setAttribute("noty", utils.Notifications.FAILED);
            }
//            request.getRequestDispatcher("/danhsachbaithi?mabaithi=" + maBaiThi).forward(request, response);
            response.sendRedirect("danhsachcauhoibaithi?mabaithi=" + maBaiThi);
        }
    }

    private boolean export(String maBaiThi) {
        DAO dao = new DAO();
        final List<CauHoi> listCauHoi = dao.getAllCauHoiByMaBaiThi(maBaiThi);
        BaiThi bt = dao.getBaiThiByMaBaiThi(maBaiThi);
        String arr[] = {"Mã câu hỏi", "Môn học", "Nội dung", "Loại câu hỏi", "A", "B", "C", "D", "Đáp án", "Hình ảnh", "Độ khó"};
        try {
            XSSFWorkbook wk = new XSSFWorkbook();
            XSSFSheet sheet = wk.createSheet(bt.getLoaiBaiThi().getTenLoaiBaiThi());
            XSSFRow row = sheet.createRow(0); // create row 0 for sheet name 'danhsach'
            Cell cell;

            for (int i = 0; i < arr.length; i++) {
                cell = row.createCell(i, CellType.STRING);
                cell.setCellValue(arr[i]);
            }

            for (int i = 0; i < listCauHoi.size(); i++) {
                row = sheet.createRow(i + 2);
                CauHoi ch = listCauHoi.get(i);
                CauHoi_ChiTiet chct = dao.getCauHoiChiTietByMaCauHoi(ch.getMaCauHoi());
                DapAn da = dao.getDapAnByMaCauHoi(ch.getMaCauHoi());

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(ch.getMaCauHoi());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(ch.getNoiDung());

                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(ch.getHinhAnh());

                cell = row.createCell(1, CellType.NUMERIC);
                cell.setCellValue(ch.getMaMon().getTenMon());

                cell = row.createCell(10, CellType.NUMERIC);
                cell.setCellValue(ch.getDoKho());

                if (chct != null) {
                    cell = row.createCell(3, CellType.STRING);
                    cell.setCellValue(chct.getLoaiCauHoi().getTenLoai());

                    cell = row.createCell(4, CellType.STRING);
                    cell.setCellValue(chct.getA());

                    cell = row.createCell(5, CellType.STRING);
                    cell.setCellValue(chct.getB());

                    cell = row.createCell(6, CellType.STRING);
                    cell.setCellValue(chct.getC());

                    cell = row.createCell(7, CellType.STRING);
                    cell.setCellValue(chct.getD());
                }

                if (da != null) {
                    cell = row.createCell(8, CellType.STRING);
                    cell.setCellValue(da.getNoiDung());
                }
            }

            File f = new File(PATH_CAUHOI_BAITHI);

            try {
                try ( FileOutputStream fos = new FileOutputStream(f)) {
                    wk.write(fos);
                }
            } catch (IOException e) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Export_DanhSachCauHoiBaiThi: " + e.getMessage());
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
