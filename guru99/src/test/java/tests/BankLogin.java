package tests;

import org.testng.annotations.Test;

import pageFactory.LoginPageRepo;
import pageFactory.ManagerPageRepo;
import resources.Browser;
import resources.Screenshot;
import resources.Util;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class BankLogin extends Util {

	/*	public void readPassword() {
		System.out.println("Please enter the password");
		Scanner s = new Scanner(System.in);
		password = s.nextLine();
	}*/

	@BeforeTest
	public void beforeTest() {
		b = new Browser();
		driver = b.selectBrowser(driver, browser);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lpr = PageFactory.initElements(driver, LoginPageRepo.class);
		mpr = PageFactory.initElements(driver, ManagerPageRepo.class);
	}

	@Test(dataProvider="data")
	public void bankLoginTest(String username, String password) throws Exception {
		String uid="Manger Id : "+username;
		lpr.login(username, password, uid);
		mpr.logout();
	}

	@DataProvider(name="data")
	public Object[][] testData() throws Exception{
		src = new File(filepath);
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		int maxRows = sh.getLastRowNum()+1;
		Object[][] data = new Object[maxRows-1][2];
		for (int i=1; i<maxRows;i++) {
			data[i-1][0] = sh.getRow(i).getCell(0).getStringCellValue();
			data[i-1][1] = sh.getRow(i).getCell(1).getStringCellValue();
		}
		return data;
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
