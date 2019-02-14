package robotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class DownloadFileUsingRobot {
	@Test
	public void downloadingAFile() throws Exception {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Mohit\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//creating a object of the ChromeDriver class which will launch the browser
		driver.manage().window().maximize(); //maximizing a window
		driver.get("http://uitestpractice.com/Students/Widgets");//opening a URL
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[contains(text(),'Download a image')]")).click();
		Thread.sleep(2000);

		Robot robot = new Robot();
		robot.setAutoDelay(3000);

		File f = new File("C:\\Users\\training_h1b.06.15\\Downloads\\images.png");
		if(f.renameTo 
				(new File("./Screenshots/downloaded/Sample_1.png"))) 
		{ 
			// if file copied successfully then delete the original file 
			f.delete(); 
			System.out.println("File moved successfully"); 
		} 
		else
		{ 
			System.out.println("Failed to move the file"); 
		} 
		driver.close();
	}
}
