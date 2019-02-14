package actionDemos;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenShotDemo {

	@Test
	public void screehshotDemo() throws InterruptedException, IOException {
		WebDriver driver;
		//using the generic class for capturing the screenshots
		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://uitestpractice.com/Students/Actions");
		driver.manage().window().maximize();
		WebElement n1 = driver.findElement(By.name("one"));
		WebElement n3 = driver.findElement(By.name("three"));
		WebElement n7 = driver.findElement(By.name("seven"));
		WebElement n12 = driver.findElement(By.name("twelve"));
		WebElement cc = driver.findElement(By.id("div2"));
		
		ScreenShotGeneric.captureScreenshot(driver, "_After launching the page");
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(n12).click(n3).click(n1).click(n7).keyUp(Keys.CONTROL).build().perform();
		ScreenShotGeneric.captureScreenshot(driver, "_After selecting the numbers");
		//getCurrent Date
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		//screenshot
		/*TakesScreenshot ts = (TakesScreenshot)driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(fs, new File("./Screenshots/screenshot_"+timeStamp+".png"));*/
		
		Thread.sleep(5000);
		driver.close();
	}
}
