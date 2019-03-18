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
import resources.Log;
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

	
	//Edit Customer
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]") WebElement editCustomerBtn;
	@FindBy(xpath="//p[contains(text(),'Customer details updated Successfully!!!')]") WebElement custEditValidationMsg;
	

	public ManagerPageRepo(WebDriver driver) {
		this.driver=driver;
	}

	public void logout() throws Exception {

		if (foundAlert==false) {
			Log.info("User is logged in so logout is possible ... ");
			System.out.println("Logging out from the application .... ");
			Screenshot.takeScreenShot(driver, "Logout after Successful Login", "Logout");
			Log.info("Screenshot captured before logging out");
			Actions action = new Actions(driver);
			action.moveToElement(logoutLink).click().perform();
			System.out.println("Clicking on the OK button on the logout alert popup ... ");
			driver.switchTo().alert().accept();
			Log.info("Alert after logout is accepted");
		}
		else {
			Log.warn("Logout unsuccessful.. user is not logged in...");
			System.out.println("User is not logged in ... ");
		}

	}

	public void addNewCustomer(String custName, String gender, int dob, String address, 
			String city, String state, int pinno, long mobile, String email, int pass) throws Exception {
		wait = new WebDriverWait(driver, 10);
		if (foundAlert==false) {
			Log.info("User is logged in.. Adding a customer...");
			newCustLink.click();
			Log.info("Add new customer link is found and clicked");
			System.out.println("Adding a new customer");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'Add New Customer')]")));
			Log.info("System redirected to the add new customer page");
			Assert.assertEquals(addNewCustValidationMsg.isDisplayed(), true);
			System.out.println("Entering the customer details...");
			Log.info("Entering the customer details");

			this.custName.sendKeys(custName);
			Log.info("Customer name textbox is found and customer name is entered");
			if (gender.equalsIgnoreCase("m")) {
				maleRadio.click();
				Log.info("Male Radio button is found and checked");
			}
			else {
				femaleRadio.click();
				Log.info("Female Radio button is found and checked");
			}
			dateOfBirth.sendKeys(String.valueOf(dob));
			Log.info("DOB element is found and the data is entered");
			this.address.sendKeys(address);
			Log.info("Address text box is found and the address is entered");
			this.city.sendKeys(city);
			Log.info("City text box is found and the details are entered");
			this.state.sendKeys(state);
			Log.info("State text box is found and the details are entered");
			pinNo.sendKeys(String.valueOf(pinno));
			Log.info("Pin NO text box is found and the details are entered");
			phoneNo.sendKeys(String.valueOf(mobile));
			Log.info("Phone No text box is found and the details are entered");
			emailId.sendKeys(email);
			Log.info("Email text box is found and the details are entered");
			pwd.sendKeys(String.valueOf(pass));
			Log.info("Password text box is found and the details are entered");
			Screenshot.takeScreenShot(driver, "Entered Customer Details", "Customer");
			Log.info("Screenshot captured after entering the customer details");

			try {
				submitBtn.click();
				Log.info("Submit button found and clicked");
				wait.until(ExpectedConditions.alertIsPresent());
				Log.warn("Browser alert found.. please recheck the customer details and enter it again");
				System.out.println(driver.switchTo().alert().getText());
				Log.error(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				addCustSuccess=false;
			}
			catch(Exception e) {
				Assert.assertEquals(custAddValidationMsg.isDisplayed(), true);
				Log.info("Customer added successfully");
				System.out.println("Customer Added successfully... ");
				Screenshot.takeScreenShot(driver, "Customer Added Successfully", "Customer");
				Log.info("Screenshot captured with the cust ID");
				custID = cID.getText();
				System.out.println("Customer ID is: "+custID);
				continueBtn.click();
				Log.info("Continue button found after adding the customer and clicked");
				addCustSuccess=true;
			}
		}
	}
	
	//Edit the customer details
	public void editCustAcc(String CustID) {
		if (foundAlert==false) {
			Log.info("Manager is logged in .. Edit customer is possible");
			editCustomerBtn.click();
			Log.info("Edit Customer button is found and the details are entered");
			customerID.sendKeys(CustID);
			Log.info("Customer ID test box is found and the details are entered");
			submitBtn.click();
			Log.info("Submit Button is found and clicked");
			phoneNo.clear();
			Log.info("Phone number field is found and the data is cleared");
			phoneNo.sendKeys("999999999");
			Log.info("Changing the phone number... Phone number element is found and details are entered");
			try {
				submitBtn.click();
				Log.info("Submit button is found and clicked");
				wait.until(ExpectedConditions.alertIsPresent());
				Log.warn("Error post clicking on the submut button on the Edit customer page");
				System.out.println(driver.switchTo().alert().getText());
				Log.info(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
			}
			catch(Exception e) {
				Assert.assertEquals(custEditValidationMsg.isDisplayed(), true);
				Log.info("Customer details are updated successfully!!!");
				continueBtn.click();
				Log.info("Continue button is found and clicked!!!");
			}
		}
	}

	//creating an account for the already created customer

	public void createCustAcc(String custID, String accType, int initialDepAmt) {
		if (addCustSuccess==true) {
			Log.info("Creating an account for the customer added");
			wait = new WebDriverWait(driver, 10);
			System.out.println("Creating an account for the customer ... ");
			newAccountLink.click();
			Log.info("Clicking on the New Account link on the Bank Manager home page");
			customerID.sendKeys(custID);
			Log.info("Customer ID element is found and the details are entered");
			Select sel = new Select(accountType);
			sel.selectByValue(accType);
			Log.info("Acc type dropdown elementis found and a type is selected");
			try {
				if (initialDepAmt>1000) {
					initialDepositAmt.sendKeys(String.valueOf(initialDepAmt));
					Log.info("Initial deposit element is found and the details are entered");
				}
				else {
					System.out.println("Amount should be greater than 1000");
					Log.warn("Amount entered is less than 1000... ");
				}
				submitBtnAddAcc.click();
				Log.info("Submit button is found and clicked");
				wait.until(ExpectedConditions.alertIsPresent());
				Log.warn("Error post clicking on the submut button on the Add account page");
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				addAccSuccess=false;
			}catch(Exception e) {
				Assert.assertEquals(accountAddSuccessValidationMsg.isDisplayed(), true);
				Log.info("Customer Account created successfully");
				System.out.println("Customer Account created successfully ... ");
				accountID=aID.getText();
				System.out.println("Account ID for custID: "+custID+" is: "+accountID);
				continueBtn.click();
				Log.info("Clicking on the continue button after adding an account");
				addAccSuccess=true;
			}

		}
	}

}
