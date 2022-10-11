package Util;

import Base.Testbase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends Testbase {
    public static long implicit_wait=30;
    public static long pageloadtimeout=30;
    public static String Excelpath="./TestData/CRMtestdata.xlsx";
    static XSSFWorkbook book;
    static Sheet sheet;
    public static Object[][] Gettestdata(String sheetname){
        FileInputStream file=null;
        try {
            file=new FileInputStream(Excelpath);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try {
            book=new XSSFWorkbook(file);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        sheet=book.getSheet(sheetname);
        Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i=0;i<sheet.getLastRowNum();i++){
            for (int k=0;k<sheet.getRow(0).getLastCellNum();k++){
                data[i][k]=sheet.getRow(i+1).getCell(k).toString();
            }
        }
        return data;
    }
    public static void Takescreenshotendoftest() throws IOException {
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("./Screenshots"+System.currentTimeMillis()+".png"));
    }
}
