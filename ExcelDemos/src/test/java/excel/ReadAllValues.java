package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadAllValues {
	@Test
	public void readExcellAllValues() throws IOException, Throwable {

		//Create an object of File class to open xlsx file & to specify the file location
		File src = new File("C:\\Mohit\\sample.xlsx");
		//Create an object of FileInputStrea, class to read the excel file
		FileInputStream fis = new FileInputStream(src);
		//create an object of the XSSFWorkbook class
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb1.getSheetAt(0);

		//to print all the values of an excel sheet
		int rows=sheet1.getLastRowNum()+1;
		System.out.println("No. of Rows: "+rows);
		LoginApplicationDataDriven.startUp();
		for (int i=0; i<rows; i++) {
			String uid = sheet1.getRow(i).getCell(0).getStringCellValue();
			String pwd = sheet1.getRow(i).getCell(1).getStringCellValue();
			LoginApplicationDataDriven.loginTestCase(uid, pwd,"TestRun5");
		}
		LoginApplicationDataDriven.tearDown();
		wb1.close();
	}
}
