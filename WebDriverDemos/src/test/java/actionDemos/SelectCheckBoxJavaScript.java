package actionDemos;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectCheckBoxJavaScript {
	@Test
	public void selectUnselectCheckBox() throws InterruptedException, IOException {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//creating a object of the ChromeDriver class which will launch the browser

		driver.manage().window().maximize(); //maximizing a window
		driver.get("http://uitestpractice.com/Students/Form");//opening a URL

		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelectorAll('input[value=read]')[0].click()");
		js.executeScript("document.querySelectorAll('input[value=cricket]')[0].click()");
		
		Thread.sleep(500);
		js.executeScript("document.querySelectorAll('input[value=read]')[0].click()");
		Thread.sleep(500);
		ScreenShotGeneric.captureScreenshot(driver, "_checkBoxSelecunselect_1");
		js.executeScript("window.scrollBy(0,500)");
		ScreenShotGeneric.captureScreenshot(driver, "_checkBoxSelecunselect_2");
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(500);
		driver.close();
	}
}
