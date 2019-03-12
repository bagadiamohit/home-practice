package pageFactory;

import org.apache.poi.ss.usermodel.FontUnderline;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.Util;

import resources.Screenshot;

public class ManagerPageRepo extends Util{

	@FindBy(linkText="Log out") WebElement logoutLink;
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee") WebElement validationMsg;


	public ManagerPageRepo(WebDriver driver) {
		this.driver=driver;
	}

	public void logout() throws Exception {
		
		if (foundAlert==false) {
			System.out.println("Logging out from the application .... ");
			Screenshot.takeScreenShot(driver, "Logout after Successful Login", "Logout");
			logoutLink.click();
			System.out.println("Clicking on the OK button on the logout alert popup ... ");
			driver.switchTo().alert().accept();
		}
		else {
			System.out.println("Unsuccessful Login...");
		}
		
	}

}
