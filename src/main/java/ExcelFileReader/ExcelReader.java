package ExcelFileReader;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

    // @DataProvider // supplying data for a test method.

    public Object[][] getData() throws IOException {
        String Path = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(Path+"/resources/Emails_Data.xlsx"); // Your .xlsx file name along with path

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        // Find number of rows in excel file

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();
        System.out.println("Row Count is: " + rowCount
                + " *** Column count is: " + colCount);
        Object data[][] = new Object[rowCount - 1][colCount];
        for (int rNum = 2; rNum <= rowCount; rNum++) {
            for (int cNum = 0; cNum < colCount; cNum++) {
                data[rNum - 2][cNum] = sheet.getCellComment(cNum, rNum); //Your sheet name
            }
            System.out.println();
        }
        return data;
    }

    public static void getCellData(int rownum , int column) throws IOException {
        String Path = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(Path+"/resources/Emails_Data.xlsx"); // Your .xlsx file name along with path
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        String celldata = sheet.getRow(rownum).getCell(column).getStringCellValue();
    }
    public static void getCellDataNumber() throws IOException {
        String Path = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(Path+"/resources/Emails_Data.xlsx"); // Your .xlsx file name along with path
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        double celldata = sheet.getRow(1).getCell(1).getNumericCellValue();
    }
}