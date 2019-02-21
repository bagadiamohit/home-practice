package onlineshopping.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	WebDriver driver;
	static String driversPath = "C:\\SeleniumLearning\\drivers\\";

	public static WebDriver selectBrowser(String browser, WebDriver driver) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driversPath+"chromedriver.exe");
			System.out.println("Launching the browser");
			return new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driversPath+"geckodriver.exe");
			System.out.println("Launching the browser");
			return new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", driversPath+"chromedriver.exe");
			System.out.println("Launching the browser");
			return new ChromeDriver();
		}

	}

}
