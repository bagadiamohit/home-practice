package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;
import resources.Util;

public class LoginPageRepo extends Util{

	@FindBy(name="uid") WebElement uname;
	@FindBy(name="password") WebElement pwd;
	@FindBy(name="btnLogin") WebElement loginBtn;
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee") WebElement validationMsg;


	public LoginPageRepo(WebDriver driver) {
		this.driver=driver;
	}

	public void login(String username, String password) {
		System.out.println("Entering the credentials and logging in .... ");
		uname.sendKeys(username);
		pwd.sendKeys(password);
		loginBtn.click();
		boolean b = validationMsg.isDisplayed();
		Assert.assertEquals(b, true);
		System.out.println("Login is successful...");
		System.out.println("Validation message is: "+validationMsg.getText());
	}

}
