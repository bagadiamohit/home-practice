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
		System.out.println("Entering the credentials and logging in .... ");
		uname.sendKeys(username);
		pwd.sendKeys(password);
		Screenshot.takeScreenShot(driver, "Login Page", "Login");

		try {
			loginBtn.click();
			wait.until(ExpectedConditions.alertIsPresent());
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			foundAlert=true;
			System.out.println("Login is unsuccessful.. please check and enter the credentials !!!!");
		}
		catch (TimeoutException e) {
			System.out.println("Login is successful...");
			System.out.println("Validation message is: "+validationMsg.getText());
			Assert.assertEquals(validationMsg.getText(), uid);
			Screenshot.takeScreenShot(driver, "Successful Login", "Login");
			foundAlert=false;
		}

	}

}
