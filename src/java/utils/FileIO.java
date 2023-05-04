/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import dal.DAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class FileIO {

    public static void main(String[] args) {
        DAO dao = new DAO();
        final List<MonHoc> listMonHoc = dao.getAllMonHoc();

        try {
            XSSFWorkbook wk = new XSSFWorkbook();
            XSSFSheet sheet = wk.createSheet("danhsach");
            XSSFRow row;
            Cell cell;
            row = sheet.createRow(0); // create row 0 for sheet name 'danhsach'
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("ID");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("NAME");

            for (int i = 0; i < listMonHoc.size(); i++) {
                row = sheet.createRow(i + 1);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(listMonHoc.get(i).getMaMon());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(listMonHoc.get(i).getTenMon());
            }

            File f = new File("D://2023_SPRING//01_PRJ301//EOS_Admin//resources//io//file.xlsx");
            try {
                FileOutputStream fos = new FileOutputStream(f);
                wk.write(fos);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
