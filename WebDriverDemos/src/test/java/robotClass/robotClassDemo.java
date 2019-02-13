package robotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class robotClassDemo {

	@Test
	public void robotKeyPress() throws InterruptedException, AWTException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//creating a object of the ChromeDriver class which will launch the browser
		driver.manage().window().maximize(); //maximizing a window
		driver.get("http://facebook.com");//opening a URL

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("abc");

		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(1000);
		driver.quit();

	}
}
