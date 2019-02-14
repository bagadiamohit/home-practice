package actionDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHoverUsingActions {
	WebDriver driver;
	@Test
	public void mouseHover() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//creating a object of the ChromeDriver class which will launch the browser
		
		driver.manage().window().maximize(); //maximizing a window
		driver.get("http://10.188.144.28:8083/TestMeApp");//opening a URL
		
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.name("userName")).sendKeys("lalitha");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
		Thread.sleep(2000);
		
		WebElement aa = driver.findElement(By.xpath("//*[text()='AboutUs']"));
		WebElement oo = driver.findElement(By.xpath("//*[text()='Our Offices']"));
		WebElement ch = driver.findElement(By.xpath("//*[text()='Chennai']"));
		WebElement ac = driver.findElement(By.xpath("//*[text()='All Categories']"));
		WebElement ele = driver.findElement(By.xpath("//*[text()='Electronics']"));

		Actions act = new Actions(driver);
		//code for mouse hovering
		/*
		 * When we are performing more than 1 step in a single line then we need do a .build() and then perform();
		 * perform() is used to perform a certain action
		 * In the below case, we are doing a moveToElement and then performing that action
		 */
		act.moveToElement(aa).moveToElement(oo).moveToElement(ch).click().build().perform();
		act.moveToElement(ac).moveToElement(ele).click().build().perform();
		Thread.sleep(1000);
		WebElement hp = driver.findElement(By.xpath("//*[text()='Head Phone']"));
		act.moveToElement(hp).click().perform();
		
		driver.close();
	}
}
