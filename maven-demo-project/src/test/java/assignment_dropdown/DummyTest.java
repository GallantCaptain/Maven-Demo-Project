package assignment_dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DummyTest {
	public static void main(String[] args) {
		 // --- Setup ---
        ChromeOptions options = new ChromeOptions()
        		.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        // Using WebDriverWait is more reliable than Thread.sleep()
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		//Go to the web page login page
		driver.get("http://localhost:8888/"); //Opens the web page
		
		//Locate the various elements to login to the web page
		WebElement usrname = driver.findElement(By.name("user_name"));
		WebElement pswrd = driver.findElement(By.name("user_password"));
		
		usrname.sendKeys("admin");
		pswrd.sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
	}
}
