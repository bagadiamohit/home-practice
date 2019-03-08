package resources;

import org.openqa.selenium.WebDriver;

import pageFactory.LoginPageRepo;
import pageFactory.ManagerPageRepo;

public class Util {

	///BankLogin.Java
	protected WebDriver driver;
	protected Browser b;
	protected Screenshot capture;

	protected String browser = "firefox";
	protected String url = "http://www.demo.guru99.com/V4/";
	protected String username="mngr182546";
	protected String password; //myjyvYj

	protected LoginPageRepo lpr;
	protected ManagerPageRepo mpr;

	//Browser.Java
	protected String driverDirectory="C:\\SeleniumLearning\\drivers\\";

}
