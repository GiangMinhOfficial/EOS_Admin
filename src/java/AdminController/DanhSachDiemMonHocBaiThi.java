/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminController;

import dal.DAO;
import dal.PhanTrang;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import model.BaiThi;
import model.DapAn;
import model.LoaiBaiThi;
import model.SinhVien_BaiThi_CauHoi_CauTraLoi;
import model.MonHoc;
import model.MonHoc_Diem;
import model.SinhVien;

/**
 *
 * @author Giang Minh
 */
@WebServlet(name = "DanhSachDiemMonHocBaiThi", urlPatterns = {"/danhsachdiemmonhocbaithi"})
public class DanhSachDiemMonHocBaiThi extends HttpServlet {

    private static final DecimalFormat df = new DecimalFormat("0.00");
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
            out.println("<title>Servlet DanhSachDiemMonHocBaiThi</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DanhSachDiemMonHocBaiThi at " + request.getContextPath() + "</h1>");
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
        // DATA OF THIS PAGE IS NOT SAVED TO DATABASE
        try {
            int maSinhVien = Integer.parseInt(request.getParameter("masinhvien"));
            DAO dao = new DAO();
            SinhVien sv = dao.getSinhVienByMaSinhVien(maSinhVien);
            List<BaiThi> listBaiThi = dao.getAllBaiThiByMaSinhVien(maSinhVien);
            List<MonHoc> listMocHoc = dao.getAllMonHocByMaSinhVien(maSinhVien);

            List<MonHoc_Diem> listMonHoc_Diem = new ArrayList<>();
            
            // calculate mark for each monhoc
            for (MonHoc mh : listMocHoc) {
                // create object to save temporary monhoc, diem of the student
                // this is not saved to db
                MonHoc_Diem smd = new MonHoc_Diem();
                smd.setSinhVien(sv);
                smd.setMonHoc(mh);
                
                // list to get all baithi of the above monhoc
                List<BaiThi> listBaiThiOfMonHoc = new ArrayList<>();
                for (BaiThi bt : listBaiThi) {
                    if (bt.getMonHoc().getMaMon().equalsIgnoreCase(mh.getMaMon())) {
                        listBaiThiOfMonHoc.add(bt);
                    }
                }
                
                for (BaiThi bt : listBaiThiOfMonHoc) {
                    // -1: student have not done baithi, 0: did baithi
                    double diem = dao.checkStatusSinhVienBaiThi(maSinhVien, bt.getMaBaiThi());
                    // get mark of each question
                    PhanTrang pt = new PhanTrang();
                    // calculate mark of each ques based on number of ques in baithi, not type of that baithi
                    double soDiemMoiCau = 10.0 / pt.getNumeberOf("BaiThi_CauHoi where MaBaiThi = " + bt.getMaBaiThi());
                    
                    // this object just need CauHoi_CauTraLoi for return
                    List<SinhVien_BaiThi_CauHoi_CauTraLoi> listSinhVien_BaiThi_CauHoi_CauTraLoi = dao.getAllSinhVien_BaiThi_CauHoi_CauTraLoiByMaSinhVienMaBaiThi(maSinhVien, bt.getMaBaiThi());
                    
                    for (SinhVien_BaiThi_CauHoi_CauTraLoi sbcc : listSinhVien_BaiThi_CauHoi_CauTraLoi) {
                        DapAn da = dao.getDapAnByMaCauHoi(sbcc.getCauHoi().getMaCauHoi());
                        if (da != null && da.getNoiDung().equalsIgnoreCase(sbcc.getCauTraLoi())) {
                            diem += soDiemMoiCau;
                        }
                    }
                    
                    // get loaibaithi to add score
                    int loaiBaiThi = bt.getLoaiBaiThi().getMaLoaiBaiThi();
                    // HARD CODE
                    switch (loaiBaiThi) {
                        case 1:
                            smd.setProgressTest1(diem);
                            break;
                        case 2:
                            smd.setProgressTest2(diem);
                            break;
                        case 3:
                            smd.setProgressTest3(diem);
                            break;
                        case 4:
                            smd.setMidtermTest(diem);
                            break;
                        case 5:
                            smd.setFinalExam(diem);
                            break;
                    }
                }
                listMonHoc_Diem.add(smd);
            }
            request.setAttribute("listMonHoc_Diem", listMonHoc_Diem);
            
            //save this list for preparing to export to file if needed
            HttpSession ss = request.getSession();
            ss.setAttribute("listMonHoc_Diem", listMonHoc_Diem);
            request.getRequestDispatcher("QuanLyDiem/DanhSachDiemMonHocBaiThi.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("danhsachdiemmonhocbaithi_doget: " + e.getMessage());
            response.sendRedirect("shared/Page404.jsp");
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
        try {
            int maSinhVien = Integer.parseInt(request.getParameter("masinhvien"));
            DAO dao = new DAO();
            SinhVien sv = dao.getSinhVienByMaSinhVien(maSinhVien);
            List<LoaiBaiThi> listLoaiBaiThi = dao.getAllLoaiBaiThi();
            List<MonHoc> listMocHoc = dao.getAllMonHocByMaSinhVien(maSinhVien);
            
            request.setAttribute("listLoaiBaiThi", listLoaiBaiThi);
            request.setAttribute("listMocHoc", listMocHoc);
            request.getRequestDispatcher("QuanLyDiem/DiemSinhVien.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("danhsachdiemmonhocbaithi_dopost " + e.getMessage());
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
