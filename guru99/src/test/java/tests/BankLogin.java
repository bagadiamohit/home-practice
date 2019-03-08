package tests;

import org.testng.annotations.Test;

import pageFactory.LoginPageRepo;
import pageFactory.ManagerPageRepo;
import resources.Browser;
import resources.Screenshot;
import resources.Util;

import org.testng.annotations.BeforeTest;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class BankLogin extends Util {

	public void readPassword() {
		System.out.println("Please enter the password");
		Scanner s = new Scanner(System.in);
		password = s.nextLine();
	}

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

	@Test
	public void bankLoginTest() throws Exception {
		readPassword();
		capture.takeScreenShot(driver, "Before Login", "LoginTest");
		lpr.login(username, password);
		capture.takeScreenShot(driver, "After Login", "LoginTest");
		mpr.logout();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
