package working_with_popups;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Objective: Go to Naukri.com and register as a new candidate. In the form, click on experienced candidate,
 * then handle the file upload. 
 */

@SuppressWarnings("unused")
public class Naukri_Handle_Popup {
	public static void main(String[] args) throws InterruptedException {
		// --- Initial Setup ---
		WebDriver driver = new FirefoxDriver();

		// Get the browser window maximized and then have an implicit wait time
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Get the web page to perform the testing
		driver.get("https://www.naukri.com/registration/createAccount?othersrcp=22636");
		
		
        //Code to click on that particular link
		Thread.sleep(500);
		WebElement experiencedUpload = driver.findElement(By.xpath("//p[text()='  I have work experience (excluding internships)']"));
		experiencedUpload.click();
		
		//Now to click on upload and avoid the popup
		Thread.sleep(5000);
		WebElement uploadResume = driver.findElement(By.id("resumeUpload")); 
		//File uploadResumeLaptop = new File ("C:/Users/avira/OneDrive/Pictures/Invoker_CheatSheet.pdf");
		uploadResume.sendKeys("C:\\Users\\avira\\OneDrive\\Desktop\\Invoker_CheatSheet.pdf\\");
		System.out.println("Handled the file upload popup");
				
		
		Thread.sleep(2000);
		driver.quit();		
		
	}
}