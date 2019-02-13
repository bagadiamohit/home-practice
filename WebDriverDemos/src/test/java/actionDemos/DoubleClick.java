package actionDemos;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClick {

	@Test
	public void doubleClickTest() throws InterruptedException {
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://uitestpractice.com/");
		driver.manage().window().maximize();

		WebElement dclick = driver.findElement(By.name("dblClick"));

		Actions act = new Actions(driver);

		act.moveToElement(dclick).doubleClick().build().perform();
		//act.doubleClick(dclick).perform();

		//to handle the popups
		Alert alt = driver.switchTo().alert();
		String mesage = alt.getText();
		alt.accept();

		Thread.sleep(1000);
		driver.close();
		System.out.println(mesage);

	}
}
