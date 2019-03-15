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
			Log.info("Browser is specified");
			System.setProperty("webdriver.chrome.driver", driverDirectory+"chromedriver.exe");
			System.out.println("Launching Chrome browser");
			Log.info("Browser launched");
			return new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			Log.info("Browser is specified");
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myProfile = profile.getProfile("TestProfile");
			Log.info("Firefox profile is selected");
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(myProfile);
			Log.info("Firefox profile is set");
			System.setProperty("webdriver.gecko.driver", driverDirectory+"geckodriver.exe");
			System.out.println("Launching the firefox browser");
			Log.info("Browser launched");
			return new FirefoxDriver(option);
		}
		else {
			Log.info("Browser is specified");
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myProfile = profile.getProfile("TestProfile");
			Log.info("Firefox profile is selected");
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(myProfile);
			Log.info("Firefox profile is set");
			System.setProperty("webdriver.gecko.driver", driverDirectory+"geckodriver.exe");
			System.out.println("Launching the firefox browser");
			Log.info("Browser launched");
			return new FirefoxDriver(option);
		}
	}

}
