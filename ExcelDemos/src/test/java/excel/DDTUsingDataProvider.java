package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTUsingDataProvider {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh1;

	WebDriver driver;

	@BeforeClass
	public void start() throws InterruptedException {
		LoginApplicationDataDriven.startUp();
	}

	@Test(dataProvider="sampledata")
	public void loginCheckusingDataProvider(String username, String password) throws Exception {
		LoginApplicationDataDriven.loginTestCase(username, password,"logintest6");
	}

	@DataProvider(name="sampledata")
	public Object[][] TestData() throws IOException {

		File src = new File("C:\\Mohit\\sample.xlsx");
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sh1=wb.getSheetAt(0);

		int rows=sh1.getLastRowNum()+1;

		Object[][] data = new Object[rows][2];

		for(int i=0; i<rows;i++) {
			data[i][0]=sh1.getRow(i).getCell(0).getStringCellValue();
			data[i][1]=sh1.getRow(i).getCell(1).getStringCellValue();
		}
		return data;
	}
	@AfterClass
	public void tearDown() {
		LoginApplicationDataDriven.tearDown();
	}
}
