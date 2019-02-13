package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPageRepository {
	
	WebDriver driver;
	By signIn = By.linkText("SignIn");
	By username = By.name("userName");
	By password = By.name("password");
	By loginBtn = By.name("Login");
	By error = By.id("errormsg");
	By home = By.xpath("//a[contains(text(),'Home')]");
	By signout = By.xpath("//a[contains(text(),'SignOut')]");
	
	public loginPageRepository(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickSignInLink() {
		driver.findElement(signIn).click();
	}
	
	public void typeUsername(String uid) {
		driver.findElement(username).sendKeys(uid);
	}
	
	public void typePassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginBtn).click();
	}
	
	public int checkError() {
		return driver.findElements(error).size();
	}
	
	public void clickHomeLink() {
		driver.findElement(home).click();
	}
	
	public void clickSignOutLink() {
		driver.findElement(signout).click();
	}

}
