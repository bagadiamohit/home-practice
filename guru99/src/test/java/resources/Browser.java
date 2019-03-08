package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class Browser extends Util{

	public WebDriver selectBrowser(WebDriver driver, String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverDirectory+"chromedriver.exe");
			System.out.println("Launching Chrome browser");
			return new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myProfile = profile.getProfile("TestProfile");
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(myProfile);
			System.setProperty("webdriver.gecko.driver", driverDirectory+"geckodriver.exe");
			System.out.println("Launching the firefox browser");
			return new FirefoxDriver(option);
		}
		else {
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myProfile = profile.getProfile("TestProfile");
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(myProfile);
			System.setProperty("webdriver.gecko.driver", driverDirectory+"geckodriver.exe");
			System.out.println("Launching the firefox browser");
			return new FirefoxDriver(option);
		}
	}

}
