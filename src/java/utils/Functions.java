/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * @author Giang Minh
 */
public class Functions {

    public static void noty(HttpServletRequest request, boolean flag, String mess) {
        HttpSession session = request.getSession();
        session.setAttribute("pageName", mess);
        session.setAttribute("time", System.currentTimeMillis());

        if (flag) {
            session.setAttribute("noty", utils.Notifications.SUCCESS);
        } else {
            session.setAttribute("noty", utils.Notifications.FAILED);
        }
    }

    public static String getFullURL(HttpServletRequest request) {
        StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append('?').append(queryString).toString();
        }
    }
    
    public static String storeImage(HttpServletRequest request, String part, String pathTo) throws IOException, ServletException {
        Part filePart = request.getPart(part);
        // Get the filename from the Part header
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        if (fileName.isEmpty()) {
            return "";
        }
// Define the folder where you want to store the uploaded file
//D:/2023_SPRING/01_PRJ301/EOS_Admin/web/shared/images/CauHoi
        String uploadFolder = (pathTo);
//        System.out.println(getServletContext().getRealPath("/uploads"));
//        System.out.println(uploadFolder);
// Create a File object for the upload folder and the uploaded file
        File uploadDir = new File(uploadFolder);
//        File uploadFile = new File(uploadFolder + fileName);
// Check if the upload folder exists, if not create it
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

// Save the file to the uploads directory
        String filePath = uploadDir + File.separator + fileName;
        filePart.write(filePath);
        return fileName;
    }
}
