package onlineshopping.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class ShoppingCartSummaryPageRepo {
	
	WebDriver driver;
	
	@FindBy(xpath="//h1[@id='cart_title']") WebElement validationMsg;
	@FindBy(xpath="//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]") WebElement prcdToCheckoutBtn1;
	@FindBy(xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]") WebElement prcdToCheckoutBtn2;
	@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]") WebElement prcdToCheckoutBtn3;
	@FindBy(id="cgv") WebElement tOSCheckBox;
	@FindBy(xpath="//h1[contains(text(),'Please choose your payment method')]") WebElement paymentMethodTextMsg;
	@FindBy(xpath="//a[@title='Pay by bank wire']") WebElement payByWireBtn;
	@FindBy(xpath="//h1[contains(text(),'Order summary')]") WebElement orderSummaryTextMsg;
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]") WebElement confirmOrderBtn;
	@FindBy(xpath="//strong[contains(text(),'Your order on My Store is complete.')]") WebElement orderConfrmTextMsg;
	
	public ShoppingCartSummaryPageRepo() {
		this.driver=driver;
	}
	
	public void proceedToCheckout() {
		Assert.assertEquals(validationMsg.isDisplayed(), true);
		System.out.println("Proceeding to checkout ... ");
		prcdToCheckoutBtn1.click();
		prcdToCheckoutBtn2.click();
		System.out.println("Accepting the Terms of Service");
		tOSCheckBox.click();
		System.out.println("On Shipping tab: Proceeding further");
		prcdToCheckoutBtn3.click();
		System.out.println("Validating whether the user has reached till the Choose Payment page");
		Assert.assertEquals(paymentMethodTextMsg.isDisplayed(), true);
		System.out.println("Clicking on the Pay by Bank Wire option ... ");
		payByWireBtn.click();
		System.out.println("Validating whether the user has reached till the Order Summary page");
		Assert.assertEquals(orderSummaryTextMsg.isDisplayed(), true);
		System.out.println("Confirming the order");
		confirmOrderBtn.click();
		System.out.println("Validating whether the order has been successfully placed");
		Assert.assertEquals(orderConfrmTextMsg.isDisplayed(), true);
	}

}
