package excel;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotGeneric {

	public static void captureScreenshot(WebDriver driver, String screenshotName, String testCaseName) throws IOException {
		String name = testCaseName;
		try {
			File newfolder = new File("./Screenshots/"+name);
			newfolder.mkdir();
		}catch(Exception e)
		{
			System.out.println("Folder Exception caught");
		}
		TakesScreenshot ts = (TakesScreenshot)driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(fs, new File("./Screenshots/"+name+"/"+timeStamp()+"_"+testCaseName+"_"+screenshotName+".png"));
	}

	public static String timeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
