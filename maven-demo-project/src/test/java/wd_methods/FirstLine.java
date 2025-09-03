package wd_methods;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
*/
public class FirstLine {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//        driver = new FirefoxDriver();
 		//        driver = new EdgeDriver();d
		/* Start the server 
		 * Launch the empty chrome browser
		 * load, register, re-initialize the non-static members
		 */
		
		driver.get("https://www.instagram.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getPageSource());
	}
}

