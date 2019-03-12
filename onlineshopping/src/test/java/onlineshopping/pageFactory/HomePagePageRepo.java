package onlineshopping.pageFactory;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import okio.Timeout;
import onlineshopping.resources.ScreenShotGeneric;

public class HomePagePageRepo {

	WebDriver driver;
	String testCaseName="homePage";
	@FindBy(xpath="//a[@title='Log in to your customer account']") WebElement signInLink;
	@FindBy(xpath="//h3[contains(text(),'Already registered?')]") WebElement loginPageMsg;
	@FindBy(xpath="//a[@class='homefeatured']") WebElement homePageMsg;
	//@FindBy(linkText="Women") WebElement womenLink;
	@FindBy(xpath="//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[@title='Women'][contains(text(),'Women')]") WebElement womenLink;
	@FindBy(xpath="//a[@title='T-shirts']") WebElement tshirtLink;
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']") WebElement fadedTshirtImg;
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span") WebElement addToCartBtn;
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]") WebElement successMsg;
	//@FindBy(xpath="//span[@title='Close window']") WebElement closeBtn;
	@FindBy(xpath="//iframe[@class='fancybox-iframe']") WebElement quickViewFrame;
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]") WebElement prcdToCheckoutBtn;


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

	public void addProduct() {
		Assert.assertTrue(homePageMsg.isDisplayed());
		System.out.println("User is on the home page. Adding a product...");
		Actions act = new Actions(driver);
		act.moveToElement(womenLink).pause(2).perform();
		act.moveToElement(tshirtLink).click().build().perform();
		//((JavascriptExecutor) driver).executeScript("document.getElementByXpath('//a[@title='T-shirts']').click();");
		System.out.println("Adding to Cart");
		act.moveToElement(fadedTshirtImg).click().perform();
		driver.switchTo().frame(quickViewFrame);
		act.moveToElement(addToCartBtn).click().build().perform();
		Assert.assertTrue(successMsg.isDisplayed());
		System.out.println("Product is successfully added to the cart. Proceed to Checkout.....");
		prcdToCheckoutBtn.click();
	}

}
