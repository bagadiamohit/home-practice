package cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CookieTest {
	@Test
	public void workingWithCookies() throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\M\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//creating a object of the ChromeDriver class which will launch the browser
		driver.manage().window().maximize(); //maximizing a window
		driver.get("http://facebook.com");//opening a URL

		Thread.sleep(1000);

		Set<Cookie> scookie=driver.manage().getCookies();
		System.out.println("Count of Cookies before adding "+scookie.size()); //Printing count of all the cookies.
		Cookie ncookie=new Cookie("username","TestMeApp");
		driver.manage().addCookie(ncookie);
		Set<Cookie> nacookie=driver.manage().getCookies();
		System.out.println("Count of Cookies after adding "+nacookie.size()); //Printing count of all the cookies.

		int i=1;
		for(Cookie cookie:nacookie) {
			System.out.println(i+"Cookie domain:"+cookie.getDomain());
			System.out.println(i+"Cookie name:"+cookie.getName());
			System.out.println(i+"Cookie path:"+cookie.getPath());
			System.out.println(i+"Cookie domain:"+cookie.getValue());
			System.out.println(i+"Cooke Expiry:"+cookie.getExpiry());
			System.out.println("------------------------------");
			i =  i + 1;
		}

		//How to delete all the cookies
		driver.manage().deleteAllCookies();
		Set<Cookie> acookie=driver.manage().getCookies();
		System.out.println("Count of after delete Cookies"+acookie.size()); //Printing count of all the cookies.
		driver.close();
	}
}
