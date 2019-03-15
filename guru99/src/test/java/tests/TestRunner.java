package tests;

import org.testng.annotations.Test;

import pageFactory.LoginPageRepo;
import pageFactory.ManagerPageRepo;
import resources.Browser;
import resources.Log;
import resources.Screenshot;
import resources.Util;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class TestRunner extends Util {


	@BeforeTest
	public void beforeTest() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		b = new Browser();
		driver = b.selectBrowser(driver, browser);
		driver.manage().window().maximize();
		Log.info("Browser window is maximized");
		driver.get(url);
		Log.info("Launched the application under test");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lpr = PageFactory.initElements(driver, LoginPageRepo.class);
		mpr = PageFactory.initElements(driver, ManagerPageRepo.class);
		src = new File(filepath);
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
	}

	@Test(dataProvider="credentials",priority=1)
	public void bankLoginTest(String username, String password) throws Exception {
		Log.startTestCase("Bank Login Functionality");
		String uid="Manger Id : "+username;
		Log.info("Calling the login function");
		lpr.login(username, password, uid);
		Log.endTestCase("Bank Login Functionality");
	}

	@Test(dataProvider="CustData", priority=2)
	public void addCustomerTest(String custName, String gender, int dob, String address, 
			String city, String state, int pinno, long mobile, String email, int pass) throws Exception {
		Log.startTestCase("Add Customer Functionality");
		Log.info("Calling the Add customer function");
		sh4 = wb.getSheetAt(1);
		//int maxCols = sh4.getRow(0).getLastCellNum();
		mpr.addNewCustomer(custName, gender, dob, address, city, state, pinno, mobile, email, pass);
		Log.info("Writing the customer ID back to the excel file");
		fos = new FileOutputStream(src);
		r1 = sh4.getRow(tempRow1);
		r1.createCell(10).setCellValue(custID);
		wb.write(fos);
		fos.close();
		tempRow1+=1;
		//wb.close();
		Log.endTestCase("Add Customer Functionality");
	}

	@Test(dataProvider="AccountData", priority=3)
	public void createAccount(String custID, String accType, int initialDepAmt) throws IOException {
		Log.startTestCase("Add Account Functionality");
		Log.info("Calling the add account function");
		sh5 = wb.getSheetAt(1);
		int maxCols = sh5.getRow(0).getLastCellNum();
		mpr.createCustAcc(custID, accType, initialDepAmt);
		Log.info("Writing the account no to the excel file");
		fos = new FileOutputStream(src);
		r2 = sh5.getRow(tempRow2);
		r2.createCell(maxCols-1).setCellValue(accountID);
		wb.write(fos);
		fos.close();
		tempRow2+=1;
		Log.endTestCase("Add Account Functionality");
	}

	@Test(priority=4)
	public void logOutTest() throws Exception {
		Log.startTestCase("Logout Functionality");
		Log.info("Calling the logout function");
		mpr.logout();
		Log.endTestCase("Logout Functionality");
	}

	@DataProvider(name="credentials")
	public Object[][] testData() throws Exception{
		sh1 = wb.getSheetAt(0);
		int maxRows = sh1.getLastRowNum()+1;
		Object[][] data = new Object[maxRows-1][2];
		for (int i=1; i<maxRows;i++) {
			data[i-1][0] = sh1.getRow(i).getCell(0).getStringCellValue();
			data[i-1][1] = sh1.getRow(i).getCell(1).getStringCellValue();
		}
		//fis.close();
		return data;
	}

	@DataProvider(name="CustData")
	public Object[][] testData1() throws Exception{
		sh2 = wb.getSheetAt(1);
		int maxRows = sh2.getLastRowNum()+1;
		Object[][] data = new Object[maxRows-1][10];
		for (int i=1; i<maxRows;i++) {
			data[i-1][0] = sh2.getRow(i).getCell(0).getStringCellValue();
			data[i-1][1] = sh2.getRow(i).getCell(1).getStringCellValue();
			data[i-1][2] = (int) sh2.getRow(i).getCell(2).getNumericCellValue();
			data[i-1][3] = sh2.getRow(i).getCell(3).getStringCellValue();
			data[i-1][4] = sh2.getRow(i).getCell(4).getStringCellValue();
			data[i-1][5] = sh2.getRow(i).getCell(5).getStringCellValue();
			data[i-1][6] = (int) sh2.getRow(i).getCell(6).getNumericCellValue();
			data[i-1][7] = (int) sh2.getRow(i).getCell(7).getNumericCellValue();
			data[i-1][8] = sh2.getRow(i).getCell(8).getStringCellValue();
			data[i-1][9] = (int) sh2.getRow(i).getCell(9).getNumericCellValue();
		}
		return data;
	}

	@DataProvider(name="AccountData")
	public Object[][] testData2(){
		sh3 = wb.getSheetAt(1);
		int maxRows = sh3.getLastRowNum()+1;
		Object[][] data = new Object[maxRows-1][3];
		for (int i=1; i<maxRows; i++) {
			data[i-1][0] = sh3.getRow(i).getCell(10).getStringCellValue();
			data[i-1][1] = sh3.getRow(i).getCell(11).getStringCellValue();
			data[i-1][2] = (int) sh3.getRow(i).getCell(12).getNumericCellValue();
		}
		return data;
	}

	@AfterTest
	public void afterTest() throws Exception {
		driver.quit();
		wb.close();
		Log.endTestCase("Bank Test Completed");
	}
}
