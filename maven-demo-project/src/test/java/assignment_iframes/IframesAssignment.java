package assignment_iframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IframesAssignment {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Fetch the web page using fully qualified path
		driver.get("https://demoqa.com/frames");
		
		//Create iFrame object to store the iFrame information, then switch to it later
		WebElement iframe1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframe1);
		iframe1.click();
		System.out.println(iframe1.getText());
		System.out.println(iframe1.getClass());
		
		//Create and get frame 2 text
		/*
		 * WebElement iframe2 = driver.findElement(By.id("frame2"));
		 * driver.switchTo().frame(iframe2); iframe2.click();
		 * System.out.println(iframe2.getText());
		 * System.out.println(iframe2.getClass());
		 */
		
		//Wait for some time then quit
		Thread.sleep(5000);
		driver.quit(); //Closes all tabs & browsers, shuts server
	}
}
