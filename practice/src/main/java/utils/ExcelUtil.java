package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtil {

    public static Object[][] getData(String filePath, String sheetName) {
        Object[][] data = null;

        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+filePath);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);

            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(1).getLastCellNum();

            data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = row.getCell(j).toString();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}


















































//package utils;
//
//import java.io.FileInputStream;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelUtil {
//
//    private static Workbook workbook;
//    private static Sheet sheet;
//
//    public static void loadExcel(String path, String sheetName) {
//
//        try {
//
//            FileInputStream fis = new FileInputStream(path);
//
//            workbook = new XSSFWorkbook(fis);
//
//            sheet = workbook.getSheet(sheetName);
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//    }
//
//    public static int getRowCount() {
//
//        return sheet.getPhysicalNumberOfRows();
//    }
//
//    public static int getColumnCount() {
//
//        return sheet.getRow(0).getPhysicalNumberOfCells();
//    }
//
//    public static String getCellData(int row, int col) {
//
//        DataFormatter formatter = new DataFormatter();
//
//        return formatter.formatCellValue(sheet.getRow(row).getCell(col));
//    }
//
//}




































