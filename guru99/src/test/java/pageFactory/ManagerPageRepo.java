package pageFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.FontUnderline;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import resources.Util;

import resources.Screenshot;

public class ManagerPageRepo extends Util{

	@FindBy(xpath="//a[contains(text(),'Log out')]") WebElement logoutLink;
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee") WebElement validationMsg;

	//Add New Customer
	@FindBy(xpath="//a[contains(text(),'New Customer')]") WebElement newCustLink;
	@FindBy(xpath="//p[contains(text(),'Add New Customer')]") WebElement addNewCustValidationMsg;
	@FindBy(name="name") WebElement custName;
	@FindBy(xpath="//input[@value='m']") WebElement maleRadio;
	@FindBy(xpath="//input[@value='f']") WebElement femaleRadio;
	@FindBy(id="dob") WebElement dateOfBirth;
	@FindBy(name="addr") WebElement address;
	@FindBy(name="city") WebElement city;
	@FindBy(name="state") WebElement state;
	@FindBy(name="pinno") WebElement pinNo;
	@FindBy(name="telephoneno") WebElement phoneNo;
	@FindBy(name="emailid") WebElement emailId;
	@FindBy(name="password") WebElement pwd;
	@FindBy(xpath="//input[@value='Submit']") WebElement submitBtn;
	@FindBy(xpath="//p[contains(text(),'Customer Registered Successfully!!!')]") WebElement custAddValidationMsg;
	@FindBy(xpath="/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]") WebElement cID;
	@FindBy(xpath="//a[contains(text(),'Continue')]") WebElement continueBtn;

	//Add New Account
	@FindBy(xpath="//a[contains(text(),'New Account')]") WebElement newAccountLink;
	@FindBy(xpath="//p[contains(text(),'Add new account form')]") WebElement addNewAccountValidationMsg;
	@FindBy(name="cusid") WebElement customerID;
	@FindBy(name="selaccount") WebElement accountType;
	@FindBy(name="inideposit") WebElement initialDepositAmt;
	@FindBy(xpath="//input[@value='submit']") WebElement submitBtnAddAcc;
	@FindBy(xpath="//p[contains(text(),'Account Generated Successfully!!!')]") WebElement accountAddSuccessValidationMsg;
	@FindBy(xpath="/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]") WebElement aID;


	public ManagerPageRepo(WebDriver driver) {
		this.driver=driver;
	}

	public void logout() throws Exception {

		if (addCustSuccess==true) {
			System.out.println("Logging out from the application .... ");
			Screenshot.takeScreenShot(driver, "Logout after Successful Login", "Logout");
			Actions action = new Actions(driver);
			action.moveToElement(logoutLink).click().perform();
			System.out.println("Clicking on the OK button on the logout alert popup ... ");
			driver.switchTo().alert().accept();
		}
		else {
			System.out.println("Add Customer is not successful...");
		}

	}

	public void addNewCustomer(String custName, String gender, int dob, String address, 
			String city, String state, int pinno, long mobile, String email, int pass) throws Exception {
		wait = new WebDriverWait(driver, 10);
		if (foundAlert==false) {
			newCustLink.click();
			System.out.println("Adding a new customer");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'Add New Customer')]")));
			Assert.assertEquals(addNewCustValidationMsg.isDisplayed(), true);
			System.out.println("Entering the customer details...");

			this.custName.sendKeys(custName);
			if (gender.equalsIgnoreCase("m")) {
				maleRadio.click();
			}
			else {
				femaleRadio.click();
			}
			dateOfBirth.sendKeys(String.valueOf(dob));
			this.address.sendKeys(address);
			this.city.sendKeys(city);
			this.state.sendKeys(state);
			pinNo.sendKeys(String.valueOf(pinno));
			phoneNo.sendKeys(String.valueOf(mobile));
			emailId.sendKeys(email);
			pwd.sendKeys(String.valueOf(pass));
			Screenshot.takeScreenShot(driver, "Entered Customer Details", "Customer");

			try {
				submitBtn.click();
				wait.until(ExpectedConditions.alertIsPresent());
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				addCustSuccess=false;
			}
			catch(Exception e) {
				Assert.assertEquals(custAddValidationMsg.isDisplayed(), true);
				System.out.println("Customer Added successfully... ");
				Screenshot.takeScreenShot(driver, "Customer Added Successfully", "Customer");
				custID = cID.getText();
				System.out.println("Customer ID is: "+custID);
				continueBtn.click();
				addCustSuccess=true;
			}

		}
	}

	//creating an account for the already created customer

	public void createCustAcc(String custID, String accType, int initialDepAmt) {
		if (addCustSuccess==true) {
			wait = new WebDriverWait(driver, 10);
			System.out.println("Creating an account for the customer ... ");
			newAccountLink.click();
			customerID.sendKeys(custID);
			Select sel = new Select(accountType);
			sel.selectByValue(accType);
			try {
				if (initialDepAmt>1000) {
					initialDepositAmt.sendKeys(String.valueOf(initialDepAmt));
				}
				else {
					System.out.println("Amount should be greater than 1000");
				}
				submitBtnAddAcc.click();
				wait.until(ExpectedConditions.alertIsPresent());
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				addAccSuccess=false;
			}catch(Exception e) {
				Assert.assertEquals(accountAddSuccessValidationMsg.isDisplayed(), true);
				System.out.println("Customer Account created successfully ... ");
				accountID=aID.getText();
				System.out.println("Account ID for custID: "+custID+" is: "+accountID);
				continueBtn.click();
				addAccSuccess=true;
			}

		}
	}

}
