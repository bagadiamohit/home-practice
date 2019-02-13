package excel;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginApplicationDataDriven {
	static WebDriver driver;
	@BeforeClass
	public static void startUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//creating a object of the ChromeDriver class which will launch the browser
		driver.manage().window().maximize();
		driver.get("http://10.188.144.28:8083/TestMeApp");//opening a URL
		Thread.sleep(5000);
	}
	
	@Test
	public static void loginTestCase(String username, String password, String testCaseName) throws InterruptedException, IOException {	
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("Login")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.id("errormsg")).size()!=0) {
			ScreenShotGeneric.captureScreenshot(driver, "invalid credentials",testCaseName);
			driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//a[contains(text(),'SignOut')]")).click();
			Thread.sleep(2000);
		}
		else {
			ScreenShotGeneric.captureScreenshot(driver, "Login", testCaseName);
			driver.findElement(By.linkText("SignOut")).click();
			ScreenShotGeneric.captureScreenshot(driver, "Logout",testCaseName);
			Thread.sleep(3000);			
		}
		
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();//closing the browser
	}
	
}
