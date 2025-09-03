package assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class synchronizationTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		//Now to get the fully qualified path of the web site we want to test
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		WebElement checkBox = driver.findElement(By.id("checkbox"));
		if (checkBox.isEnabled() && checkBox.isDisplayed()) {
			checkBox.click();			
		}
		
	    //To get the remove Webelement and click on it
		// WebDriver removeButton = driver.findElement(By.xpath("//button[text()='Enable']")).click();
				
		
		
		//Sleep & Close after a while 
		Thread.sleep(5000);
		driver.quit();
		
	}
}
