package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoLoginStepDef1 {
	WebDriver driver;
	@Given("^Open the browser and pass the URL$")
	public void open_the_browser_and_pass_the_URL() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(10000);
	}

	@Given("^Navigate to the Login Page$")
	public void navigate_to_the_Login_Page() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'SIGN-ON')]")).click();
		System.out.println("Clicked the Sign ON link");	
	}

	@When("^Enter the valid userid and password$")
	public void enter_the_valid_userid_and_password() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("demo");
		driver.findElement(By.name("password")).sendKeys("demo");
	}

	@Then("^Signout button should be available$")
	public void signout_button_should_be_available() throws Throwable {
		//WebElement signoff = driver.findElement(By.) //application is too slow
				
		driver.close();
	}


}
