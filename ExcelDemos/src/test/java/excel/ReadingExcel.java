package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingExcel {
	@Test
	public void readExcel() throws IOException {

		//Create an object of File class to open xlsx file & to specify the file location
		File src = new File("C:\\Mohit\\sample.xlsx");

		//Create an object of FileInputStrea, class to read the excel file
		FileInputStream fis = new FileInputStream(src);

		//create an object of the XSSFWorkbook class
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);

		XSSFSheet sheet1=wb1.getSheetAt(0);
		String data00=sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println(data00);

		String data01 = sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println(data01);

		/*//to print all the values of an excel sheet
		int rows=sheet1.getLastRowNum()+1;
		XSSFRow row = sheet1.getRow(0);
		int cols = row.getLastCellNum();
		System.out.println("Rows: "+rows);
		System.out.println("Cols: "+cols);
		
		//printing all the values
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols;j++) {
				System.out.print(sheet1.getRow(i).getCell(j).getStringCellValue()+"\t");
			}
			System.out.println("\n");
		}*/
		
		wb1.close();

	}
}
