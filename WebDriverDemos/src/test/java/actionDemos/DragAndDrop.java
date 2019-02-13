package actionDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

	@Test
	public void dragDrop() throws InterruptedException {

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://uitestpractice.com/");
		driver.manage().window().maximize();
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		//act.clickAndHold(drag).perform();
		//act.moveToElement(drop).click().build().perform();
		//act.moveToElement(drop).release().perform();
		
		act.dragAndDrop(drag, drop).perform();
		
		Thread.sleep(3000);
		driver.close();
		
	}
}
