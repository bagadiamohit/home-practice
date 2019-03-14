package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
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

	protected String browser = "chrome";
	protected String url = "http://www.demo.guru99.com/V4/";
	/*protected String username="mngr182546";
	protected String password; //myjyvYj
	 */
	protected LoginPageRepo lpr;
	protected ManagerPageRepo mpr;

	//Browser.Java
	protected String driverDirectory="C:\\SeleniumLearning\\drivers\\";

	protected static String filepath="C:\\SeleniumLearning\\gitRepo\\home-practice\\guru99\\src\\test\\java\\resources\\testdata.xlsx";
	protected static File src;
	protected static FileInputStream fis;
	protected static FileOutputStream fos;
	protected static XSSFWorkbook wb;
	protected static XSSFSheet sh1;
	protected static XSSFSheet sh2;
	protected static XSSFSheet sh3;
	protected static XSSFSheet sh4;
	protected static XSSFSheet sh5;
	protected static XSSFRow r1;
	protected static XSSFRow r2;
	protected static int tempRow1 = 1;
	protected static int tempRow2 = 1;

	protected WebDriverWait wait;
	protected static boolean foundAlert;

	protected static String custID;
	protected static boolean addCustSuccess;

	protected static String accountID;
	protected static boolean addAccSuccess;

}
