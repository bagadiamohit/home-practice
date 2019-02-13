package actionDemos;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotGeneric {
	
	public static void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(fs, new File("./Screenshots/"+timeStamp()+screenshotName+".png"));
	}
	
	public static String timeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
