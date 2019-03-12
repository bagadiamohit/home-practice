package resources;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageFactory.LoginPageRepo;
import pageFactory.ManagerPageRepo;

public class Util {

	///BankLogin.Java
	protected WebDriver driver;
	protected Browser b;

	protected String browser = "firefox";
	protected String url = "http://www.demo.guru99.com/V4/";
	/*protected String username="mngr182546";
	protected String password; //myjyvYj
*/
	protected LoginPageRepo lpr;
	protected ManagerPageRepo mpr;

	//Browser.Java
	protected String driverDirectory="C:\\SeleniumLearning\\drivers\\";
	
	protected String filepath="C:\\SeleniumLearning\\gitRepo\\home-practice\\guru99\\src\\test\\java\\resources\\testdata.xlsx";
	protected File src;
	protected FileInputStream fis;
	protected XSSFWorkbook wb;
	protected XSSFSheet sh;
	
	protected WebDriverWait wait;
	protected boolean foundAlert;

}
