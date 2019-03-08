package pageFactory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import resources.Screenshot;

public class ManagerPageRepo {
	
	WebDriver driver;
	Screenshot capture;
	
	@FindBy(linkText="Log out") WebElement logoutLink;
	
	
	public ManagerPageRepo(WebDriver driver) {
		this.driver=driver;
	}
	
	public void logout() throws Exception {
		System.out.println("Logging out from the application .... ");
		logoutLink.click();
		System.out.println("Clicking on the OK button on the logout alert popup ... ");
		driver.switchTo().alert().accept();
		capture.takeScreenShot(driver, "Logout", "LogOutTest");
	}

}
