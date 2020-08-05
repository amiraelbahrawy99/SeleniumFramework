package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static FileInputStream fis=null;
	
	public FileInputStream getFileInputStream ()
	{
	
			String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\registerData.xlsx";
			File srcFile= new File(filePath);
			try {
				fis=new FileInputStream(srcFile);
			} catch (FileNotFoundException e) {
				System.out.println("Data File not found.Termination Process!!  ,plz check its path");
				System.exit(0);
			}
			return fis;
	}
	
	
	
	public Object[][] getExcelData() throws IOException
	{
		
		
		
		fis=getFileInputStream();
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		
		int totalNumsOfColumns=4;
		int totalNumsOfRows=sheet.getLastRowNum()+1;
		String[][] arrayOfExcelData=new String[totalNumsOfRows][totalNumsOfColumns];
		
		for (int i = 0; i < totalNumsOfRows; i++) {
			
			for (int j = 0; j < totalNumsOfColumns; j++) {
				
			XSSFRow row=sheet.getRow(i);
			arrayOfExcelData[i][j]=row.getCell(j).toString();
				
			}
			
		}
		wb.close();
		return arrayOfExcelData;
		
	}
	

}
