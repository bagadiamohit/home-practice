package robotClass;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadFileUsingRobot {
	@Test
	public void uploadFile() throws InterruptedException, AWTException, IOException {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//creating a object of the ChromeDriver class which will launch the browser
		driver.manage().window().maximize(); //maximizing a window
		driver.get("http://uitestpractice.com/Students/Widgets");//opening a URL
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='image_file']")).click();
		Thread.sleep(500);

		Robot robot = new Robot();
		robot.setAutoDelay(3000);

		//below lines are used to specify which file we need to upload and then copy them into the clipboard

		StringSelection ssel = new StringSelection("C:\\Users\\training_h1b.06.15\\Downloads\\images.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ssel, null);
		robot.setAutoDelay(500);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.setAutoDelay(2000);

		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Java Script to create an alert message
		js.executeScript("alert('Creating an alert to capture the popup screenshot using robot class')");

		// Get screen size
		Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

		// Capturing screenshot by providing size
		BufferedImage tmp = robot.createScreenCapture(screenSize);

		// Defining destination file path
		//String path=System.getProperty("user.dir")+"/ScreenCapturesPNG/"+"uploadFile_"+timeStamp()+".png";
		String path="C:\\Mohit\\WS\\WebDriverDemos\\Screenshots\\uploadFile_"+timeStamp()+".png";
		
		// To copy temp image in to permanent file
		ImageIO.write(tmp, "png",new File(path));

		driver.quit();
	}

	public static String timeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
}
