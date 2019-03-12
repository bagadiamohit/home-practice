package onlineshopping.pageFactory;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import onlineshopping.resources.ScreenShotGeneric;

public class LoginPagePageRepo {
	WebDriver driver;
	String testCaseName="Login";
	@FindBy(id="email") WebElement emailBox;
	@FindBy(id="passwd") WebElement passBox;
	@FindBy(id="SubmitLogin") WebElement signInBtn;
	@FindBy(xpath="//span[contains(text(),'Philip Oliver')]") WebElement userName;
	@FindBy(xpath="//a[@title='Log me out']") WebElement signOutLink;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]") WebElement authErrorMsg;
	@FindBy(xpath="//span[contains(text(),'Home')]") WebElement homeBtn;

	public LoginPagePageRepo(WebDriver driver) {
		this.driver=driver;
	}

	public void login(String email, String pass) throws Exception {
		System.out.println("Entering the email and password");
		emailBox.sendKeys(email);
		passBox.sendKeys(pass);
		System.out.println("Clicking on the sign in button");
		signInBtn.click();
		System.out.println("Verifying if the user was able to login successfully");
		try {
		if (driver.findElements(By.xpath("//span[contains(text(),'Philip Oliver')]")).size()!=0) {
			System.out.println("User login successful!!!");
			//Assert.assertTrue(res);
			ScreenShotGeneric.captureScreenshot(driver, "Successful Login", testCaseName);
			System.out.println("Navigating to the home page......");
			homeBtn.click();
			ScreenShotGeneric.captureScreenshot(driver, "Home Page After Login", testCaseName);
		}
		else {
			System.out.println("Un-successful login");
			ScreenShotGeneric.captureScreenshot(driver, "Un-Successful Login", testCaseName);
			throw new AssertionError("Unsuccessful Login Attempt");
		}
		}catch(Exception e) {
			System.out.println("Unsuccessful Login Attempt caught");
		}
	}

	public void logout() throws Exception {
		if (driver.findElements(By.xpath("//p[contains(text(),'There is 1 error')]")).size()!=0) {
			System.out.println("Error is: "+authErrorMsg.getText());
			ScreenShotGeneric.captureScreenshot(driver, "Authentication Failed", testCaseName);
		}
		else {
			System.out.println("Logging out...");
			signOutLink.click();
			System.out.println("User is successfully logged out from the application!!!");
			ScreenShotGeneric.captureScreenshot(driver, "After logout", testCaseName);
		}

	}

}
