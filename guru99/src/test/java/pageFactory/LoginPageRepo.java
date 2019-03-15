package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import resources.Log;
import resources.Screenshot;
import resources.Util;

public class LoginPageRepo extends Util{

	@FindBy(name="uid") WebElement uname;
	@FindBy(name="password") WebElement pwd;
	@FindBy(name="btnLogin") WebElement loginBtn;
	@FindBy(xpath="//td[contains(text(),'Manger Id : mngr182546')]") WebElement validationMsg;


	public LoginPageRepo(WebDriver driver) {
		this.driver=driver;
	}

	public void login(String username, String password, String uid) throws Exception {
		wait = new WebDriverWait(driver, 10);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnLogin")));
		Log.info("Page is loaded. Login Button found. Proceeding further...");
		System.out.println("Entering the credentials and logging in .... ");
		uname.sendKeys(username);
		Log.info("Username textbox found and the username is entered as :"+username);
		pwd.sendKeys(password);
		Log.info("Password textbox found and the password is entered");
		Screenshot.takeScreenShot(driver, "Login Page", "Login");
		Log.info("Screenshot is captured after entering the username and password");

		try {
			loginBtn.click();
			Log.info("Login button is found and clicked");
			wait.until(ExpectedConditions.alertIsPresent());
			Log.warn("Invalid credentials entered");
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			Log.info("Browser Alert is accepted");
			foundAlert=true;
			System.out.println("Login is unsuccessful.. please check and enter the credentials !!!!");
		}
		catch (TimeoutException e) {
			Log.info("Login is successful");
			System.out.println("Login is successful...");
			System.out.println("Validation message is: "+validationMsg.getText());
			Assert.assertEquals(validationMsg.getText(), uid);
			Screenshot.takeScreenShot(driver, "Successful Login", "Login");
			Log.info("Screenshot is captured after logging in..");
			foundAlert=false;
		}

	}

}
