package PageObjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excel.ScreenShotGeneric;

public class TestLoginDDTPageObjectModel {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh1;

	WebDriver driver;
	String testCaseName="LoginUsingNONPageFactoryDDT";

	@BeforeClass
	public void start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//creating a object of the ChromeDriver class which will launch the browser
		driver.manage().window().maximize();
		driver.get("http://10.188.144.28:8083/TestMeApp");//opening a URL
		Thread.sleep(5000);
	}

	@Test(dataProvider="sampledata")
	public void loginCheckusingDataProvider(String username, String password) throws Exception {
		loginPageRepository lpr = new loginPageRepository(driver);
		lpr.clickSignInLink();
		lpr.typeUsername(username);
		lpr.typePassword(password);
		lpr.clickLoginButton();
		Thread.sleep(3000);
		
		if (lpr.checkError()!=0) {
			ScreenShotGeneric.captureScreenshot(driver, "invalid credentials",testCaseName);
			lpr.clickHomeLink();
			Thread.sleep(500);
			lpr.clickSignOutLink();
			Thread.sleep(2000);
		}
		else {
			ScreenShotGeneric.captureScreenshot(driver, "Login", testCaseName);
			lpr.clickSignOutLink();
			ScreenShotGeneric.captureScreenshot(driver, "Logout",testCaseName);
			Thread.sleep(3000);			
		}
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
		driver.close();
	}
}
