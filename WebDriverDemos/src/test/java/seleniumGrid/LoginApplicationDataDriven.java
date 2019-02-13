package seleniumGrid;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginApplicationDataDriven {
	static WebDriver driver;
	static String nodeurl;
	@BeforeClass
	public static void startUp() throws Exception {
		/*System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//creating a object of the ChromeDriver class which will launch the browser
		driver.manage().window().maximize();
		driver.get("http://10.188.144.28:8083/TestMeApp");//opening a URL
		Thread.sleep(5000);*/
		nodeurl="http://localhost:4480/wd/hub";
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		driver=new RemoteWebDriver(new URL(nodeurl), cap);
		driver.manage().window().maximize();
		driver.get("http://10.188.144.28:8083/TestMeApp");//opening a URL
		Thread.sleep(5000);
	}
	
	@Test
	public static void loginTestCase() throws InterruptedException, IOException {	
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.name("userName")).sendKeys("lalitha");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.id("errormsg")).size()!=0) {
			ScreenShotGeneric.captureScreenshot(driver, "invalid credentials","seleniumGrid");
			driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//a[contains(text(),'SignOut')]")).click();
			Thread.sleep(2000);
		}
		else {
			ScreenShotGeneric.captureScreenshot(driver, "Login", "seleniumGrid");
			driver.findElement(By.linkText("SignOut")).click();
			ScreenShotGeneric.captureScreenshot(driver, "Logout","seleniumGrid");
			Thread.sleep(3000);			
		}
		
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();//closing the browser
	}
	
}
