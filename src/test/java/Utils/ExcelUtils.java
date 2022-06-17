package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    static String Path;
    static XSSFWorkbook wb;
    static XSSFSheet sheet;

    public Object[][] DataProvider() throws IOException {
        Path = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(Path+"/resources/Emails_Data.xlsx");
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("sheet1");
        int rowCount =  sheet.getPhysicalNumberOfRows();
        int colCount =  sheet.getRow(0).getPhysicalNumberOfCells();
        Object data[][] = new Object[rowCount-1][colCount];
        for (int i=1;i<rowCount ;i++){
            for (int j=0;j<colCount;j++){
                String cellData = sheet.getRow(i).getCell(j).getStringCellValue();
               // System.out.println(cellData);
                data[i-1][j]=cellData;
            }
        }
        return data;
    }

}