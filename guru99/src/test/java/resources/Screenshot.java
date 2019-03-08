package resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void takeScreenShot(WebDriver driver, String screenshotName, String testName) throws Exception {
		try {
			File createFolder = new File("./Screenshots/"+testName);
			createFolder.mkdir();
		}catch (Exception e) {
			System.out.println("Folder already exists!!!!");
		}

		//capturing screenshots
		TakesScreenshot ts = (TakesScreenshot) driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(fs, new File("./Screenshots/"+testName+"/"+timeStamp()+"_"+testName+"_"+screenshotName+".png"));
	}

	public static String timeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
}
