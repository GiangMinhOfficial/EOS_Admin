/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CauHoiBaiThiCRUD;

import dal.DAO;
import dal.PhanTrang;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Giang Minh
 */
public class util {

    public static boolean checkNumOfQues(HttpServletRequest request, HttpServletResponse response, String maBaiThi) throws IOException {
        DAO dao = new DAO();
        PhanTrang pt = new PhanTrang();
        // get current number of questions in baithi
        int curNumOfQues = pt.getNumeberOf("BaiThi_CauHoi where mabaithi = '" + maBaiThi + "'");
        // get max number of questions in this baithi
        int maxNumOfQues = dao.getBaiThiByMaBaiThi(maBaiThi).getLoaiBaiThi().getSoCau();
        if (curNumOfQues >= maxNumOfQues) {
            HttpSession session = request.getSession();
            session.setAttribute("pageName", "Add Questions");
            session.setAttribute("time", System.currentTimeMillis());

            session.setAttribute("noty", "Max number of questions!");
            response.sendRedirect("/EOS_Admin/danhsachcauhoibaithi?mabaithi=" + maBaiThi);
            return false;
        }
        return true;
    }
}
