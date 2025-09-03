package assignment1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

/* Q. Locate and interact with the username, password, and login button using all types of Selenium locators 
(id, name, className, tagName, cssSelector, xpath).
URL: https://practicetestautomation.com/practice-test-login/
*/
public class Q1 {
	public static void main(String[] args) throws InterruptedException, TimeoutException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://practicetestautomation.com/practice-test-login/");

		// Use ctrl+shift+c to quickly interact with Webelements & inspect it
		WebElement username_by_id = driver.findElement(By.id("username"));
		WebElement password_by_id = driver.findElement(By.id("password"));
		WebElement submit_by_id = driver.findElement(By.id("submit"));

		// Using Name
		WebElement username_by_name = driver.findElement(By.name("username"));
		WebElement password_by_name = driver.findElement(By.name("password"));
		// The login button does not have a 'name' attribute, so this locator cannot be
		// used for it.

		/*
		 * // Using Class Name // Class names are not always unique. It is least
		 * recommended approach. WebElement password_by_class =
		 * driver.findElement(By.className("form-control")); // This might find user
		 * name too
		 * 
		 * // Using Tag Name (Often finds multiple elements) WebElement username_by_tag
		 * = driver.findElement(By.tagName("input")); // This will likely find the user
		 * name field first List<WebElement> all_inputs =
		 * driver.findElements(By.tagName("input")); // Finds all input elements.
		 * Returns List of all WebElements.
		 */

		/*
		 * //Getting error on this, so commenting it out for now. // Using CSS Selector
		 * //(Very powerful and flexible) WebElement username_by_css =
		 * driver.findElement(By.cssSelector("username")); // By ID WebElement
		 * password_by_css =
		 * driver.findElement(By.cssSelector("input[name='password']")); // By tag and
		 * attribute WebElement login_btn_by_css =
		 * driver.findElement(By.cssSelector(".btn")); // By class
		 */

		// Using XPath (Most powerful, can find any element)
		WebElement username_by_xpath = driver.findElement(By.xpath("//*[@id='username']")); // By ID
		WebElement password_by_xpath = driver.findElement(By.xpath("//input[@name='password']")); // By tag and
																									// attribute
		WebElement login_btn_by_xpath = driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")); // By

		// Login to the dummy web page
		Thread.sleep(1000);
		username_by_id.sendKeys("student");
		Thread.sleep(1000);
		password_by_id.sendKeys("Password123");
		Thread.sleep(1000);
		if (submit_by_id.isDisplayed() && submit_by_id.isEnabled()) {
			submit_by_id.click();
		}
		else {
			driver.close();
		}

		Thread.sleep(2000);

		// Ensure that we close all the Webpages opened by the driver
		driver.quit();

	}
}
