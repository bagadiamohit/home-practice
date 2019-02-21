package onlineshopping.pageFactory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import onlineshopping.resources.ScreenShotGeneric;

public class HomePagePageRepo {
	
	WebDriver driver;
	String testCaseName="homePage";
	@FindBy(xpath="//a[@title='Log in to your customer account']") WebElement signInLink;
	@FindBy(xpath="//h3[contains(text(),'Already registered?')]") WebElement loginPageMsg;
	
	public HomePagePageRepo(WebDriver driver) {
		this.driver=driver;
	}
	
	public void signInLink() throws Exception {
		signInLink.click();
		System.out.println("User has clicked on the sign in link");
		Assert.assertTrue(loginPageMsg.isDisplayed());
		System.out.println("User has reached on the login page");
		ScreenShotGeneric.captureScreenshot(driver, "After clicking the sign in link", testCaseName);
	}
	
}
