package actionDemos;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptTest {
	@Test
	public void javaScriptAlert() throws InterruptedException, IOException {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//creating a object of the ChromeDriver class which will launch the browser

		driver.manage().window().maximize(); //maximizing a window
		driver.get("http://10.188.144.28:8083/TestMeApp");//opening a URL

		Thread.sleep(500);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Java Script to create an alert message
		
		js.executeScript("alert('Welcome to Java Script Executor')");
		
		//Fetching the domain name of the site. '.toString()' will change the object to name
		String domainName = js.executeScript("return document.domain;").toString();
		System.out.println("Domain Name of the site is: "+domainName);
		
		//Fetching URl of the site
		String url = js.executeScript("return document.URL;").toString();
		System.out.println("URL of the site is: "+url);
		
		//Fetching the title of the page
		String titleName = js.executeScript("return document.title;").toString();
		System.out.println("Title of the page is: "+titleName);
		if (titleName.equalsIgnoreCase(driver.getTitle()))
			System.out.println("Title is same as expected");
		
		//Navigating to any other site while on the same page
		js.executeScript("window.location = 'http://demo.gugu99.com/V4'");
		/*Alert alt = driver.switchTo().alert();
		alt.accept();
		ScreenShotGeneric.captureScreenshot(driver, "JavScriptDemo");*/
		Thread.sleep(1000);
		driver.close();
	}
}
