package onlineshopping.tests;

import org.testng.annotations.Test;

import onlineshopping.pageFactory.HomePagePageRepo;
import onlineshopping.pageFactory.LoginPagePageRepo;
import onlineshopping.resources.Browser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class LoginTest {
	
	WebDriver driver;
	String browser="chrome";
	String url="http://automationpractice.com/index.php";
	/*String email="phillip.olivier@cowstore.net";
	String password="Monu@123";*/
	HomePagePageRepo home;
	LoginPagePageRepo login;
	FileInputStream fs;
	XSSFWorkbook wb;
	XSSFSheet sh;
	
	@BeforeTest
	public void initialize() {
		driver=Browser.selectBrowser(browser, driver);
		driver.manage().window().maximize();
		System.out.println("Navigating to the application under test");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		home = PageFactory.initElements(driver, HomePagePageRepo.class);
		login = PageFactory.initElements(driver, LoginPagePageRepo.class);
	}

	@Test(dataProvider="testdata")
	public void loginTest(String email, String password) throws Exception {
		home.signInLink();
		login.login(email, password);
		login.logout();
	}
	
	@DataProvider(name="testdata")
	public Object[][] testData() throws Exception{
		File src = new File("C:\\SeleniumLearning\\WS\\onlineshopping\\resources\\TestData.xlsx");
		fs = new FileInputStream(src);
		wb = new XSSFWorkbook(fs);
		sh = wb.getSheetAt(0);
		int lastRow = sh.getLastRowNum();
		System.out.println(lastRow);
		Object[][] data = new Object[lastRow][2];
		for(int i=1; i<=lastRow;i++) {
			data[i-1][0]=sh.getRow(i).getCell(0).getStringCellValue();
			data[i-1][1]=sh.getRow(i).getCell(1).getStringCellValue();
		}
		return data;
	}

	@AfterTest
	public void afterTest() throws Exception {
		System.out.println("Closing the browser");
		driver.quit();
	}

}
