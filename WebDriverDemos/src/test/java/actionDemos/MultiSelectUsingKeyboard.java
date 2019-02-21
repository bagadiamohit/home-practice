package actionDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MultiSelectUsingKeyboard {
	@Test
	public void multiSelectBox() throws InterruptedException {
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://uitestpractice.com/Students/Actions");
		driver.manage().window().maximize();
		WebElement n1 = driver.findElement(By.name("one"));
		WebElement n3 = driver.findElement(By.name("three"));
		WebElement n7 = driver.findElement(By.name("seven"));
		WebElement n12 = driver.findElement(By.name("twelve"));
		WebElement cc = driver.findElement(By.id("div2"));
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(n12).click(n3).click(n1).click(n7).keyUp(Keys.CONTROL).build().perform();
		
		Thread.sleep(5000);
		act.moveToElement(cc).perform();
		Thread.sleep(500);
		driver.close();

	}
}
