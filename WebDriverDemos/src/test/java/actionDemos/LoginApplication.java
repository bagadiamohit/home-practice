package actionDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginApplication {
	WebDriver driver;
	@Test
	public void loginTestCase() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//creating a object of the ChromeDriver class which will launch the browser
		driver.get("http://10.188.144.28:8083/TestMeApp");//opening a URL
		Thread.sleep(10000);
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.name("userName")).sendKeys("lalitha");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();

		driver.close();//closing the browser
	}
}
