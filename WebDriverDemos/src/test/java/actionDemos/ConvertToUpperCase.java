package actionDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ConvertToUpperCase {
	@Test
	public void convert() throws InterruptedException {
		
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://google.com/");
		driver.manage().window().maximize();
		
		WebElement in = driver.findElement(By.name("q"));
		
		Actions act = new Actions(driver);
		String name = "accenture";
		
		act.keyDown(Keys.SHIFT).sendKeys(name).perform();;
		act.keyUp(Keys.SHIFT).release().perform();
		
		act.doubleClick(in).perform();
		act.contextClick().perform();
		/*driver.switchTo().activeElement().se
		act.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).click().build().perform();*/
		Thread.sleep(1000);	
		
		driver.close();
	}
}
