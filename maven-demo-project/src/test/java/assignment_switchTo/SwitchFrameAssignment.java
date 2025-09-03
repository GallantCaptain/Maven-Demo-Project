package assignment_switchTo;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SwitchFrameAssignment {
	public static void main(String[] args) throws InterruptedException {
		// These are reusable components, but since this is a standalone test, I won't
		// be making a
		// utility file for these.
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Actions action = new Actions(driver);

		// Sometimes Firefox doesn't load properly
		try {
			driver.get("https://ui.vision/demo/webtest/frames/");
		} catch (Exception WebDriverException) {
			driver.navigate().refresh();
		}

		Thread.sleep(3000);
		// List of all iFrames
		List<WebElement> allFrames = driver.findElements(By.tagName("frame"));
		System.out.println("Total iframes on page: " + allFrames.size());

		for (int i = 0; i < allFrames.size(); i++) {
			System.out.println("Frame index: " + i + " -> " + allFrames.get(i).getAttribute("name") + " | src: "
					+ allFrames.get(i).getAttribute("src"));
		}

		// frame 1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1); // passed frame as a webElement //switch to frame 1
		System.out.println("Switched to Frame 1.");
		// Submit value
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Java");

		Thread.sleep(500);
		driver.switchTo().defaultContent(); // go back to page
		System.out.println("Switched back to Main Frame.");

		// Frame2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		System.out.println("Switched to Frame 2.");
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");

		Thread.sleep(500);
		driver.switchTo().defaultContent(); // go back to page
		System.out.println("Switched back to Main Frame.");

		// frame 3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		System.out.println("Switched to Frame 3.");
		driver.findElement(By.xpath("//*[@id='id3']/div/input")).sendKeys("Playwright");

		// Inner Frame
		Thread.sleep(500);
		WebElement innerFrame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(innerFrame);
		System.out.println("Switched to Frame 3's Inner Frame.");

		// locate radio button
		WebElement rdbutton = driver.findElement(By.xpath("//*[@id=\"i6\"]/div[3]/div")); // I am UI
		// click using JavaScript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", rdbutton);

		// inner ifFrame of Frame 3
		driver.findElement(By.xpath("//*[@id=\"i21\"]/div[2]")).click();

		driver.findElement(By.xpath("//*[@id=\"i24\"]/div[2]")).click();

		driver.findElement(By.xpath("//*[@id=\"i27\"]/div[2]")).click();

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		rdbutton = driver.findElement(By.xpath("//*[@id='i9']/div[3]/div")); // I am human
		js.executeScript("arguments[0].click();", rdbutton); //
		Thread.sleep(500);

		// There is no select class here, so we will click on the forms to make the
		// options appear
		WebElement innerFrameFormOptionsDD = driver.findElement(
				By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div[1]/div[2]/div[3]/div/div/div[2]/div/div[1]/div[1]/div[1]"));
		innerFrameFormOptionsDD.click();
		// Options appear but it is not a select class
		WebElement selectOptions = driver.findElement(
				By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div[1]/div[2]/div[3]/div/div/div[2]/div/div[2]/div[4]/span"));
		Thread.sleep(500);
		action.scrollToElement(selectOptions);
		selectOptions.click();

		// Click on next
		Thread.sleep(200);
		driver.findElement(By.xpath("//span[text()='Next']")).click();

		// Short Answer Text Field
		Thread.sleep(500);
		WebElement enterShortText = driver.findElement(
				By.xpath("//*[@id='mG61Hd']/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/input"));
		enterShortText.sendKeys("Hi! My name is Avi! This is my Automation Test Script!");

		// Long Answer Text Field
		Thread.sleep(500);
		WebElement enterLongText = driver.findElement(
				By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div[1]/div[2]/div[3]/div/div/div[2]/div/div[1]/div[2]/textarea"));
		Thread.sleep(500);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		enterLongText.sendKeys(
				"Hi! My name is Avi! This is my Automation Test Script! This is my practise run at making great test scripts,"
						+ "and i hope to make even better and more accurate automated frameworks in the future. I am working hard on that future!");

		// Click on the submit button
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Submit']")).click();
		System.out.println("Submitted the form in Frame 3's Inner Frame. Now exiting the iFrame");

		// Go back to the main page
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		System.out.println("Switched back to Main Frame.");

		// frame 4
		WebElement frame4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		driver.switchTo().frame(frame4);
		System.out.println("Switched to Frame 4.");
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("Python");

		// Go back to the main page
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		System.out.println("Switched back to Main Frame.");

		// frame 5
		Thread.sleep(500);
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		System.out.println("Switched to Frame 5.");
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("Jira");

		// Bonus: Click on the link in frame 5 and open a new window
		Thread.sleep(500);
		WebElement newWindowLink = driver.findElement(By.xpath("/html/body/center/a"));
		String mainWindowHandle = driver.getWindowHandle(); // To get back to the main window
		// Try-Catch if link doesn't open
		try {
			newWindowLink.click();
			System.out.println("Clicked on the link in Frame 5.");
		}

		catch (Exception WebDriverException) {
			driver.navigate().refresh();
			System.out.println("Due to exception cannot open the web page");
		}

		// Now open the new window
		Thread.sleep(1000);
		WebDriver childWindowLink = driver.switchTo().newWindow(WindowType.TAB);
		childWindowLink.get("https://a9t9.com");
		System.out.println("The current url is: " + driver.getCurrentUrl());
		// Iterate to get the window handles and then switch back and forth
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> allWindowsIterator = allWindows.iterator();
		while (allWindowsIterator.hasNext()) {
			int i = 0;
			System.out.println("The window Handles:" + i + allWindowsIterator.next());
			i++;
		}

		// Go back to the main page
		Thread.sleep(1500);
		driver.switchTo().window(mainWindowHandle);
		System.out.println("The current url is: " + driver.getCurrentUrl());
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		System.out.println("Switched back to Main Frame.");
		//Popup addition for extra aura
		js.executeScript("alert('Test is successfully concluded!');");
		// Pause to let you see the popup
		Thread.sleep(3000);
		// Accept the alert automatically
		driver.switchTo().alert().accept(); // Handled the popup

		// Close the driver and quit the server
		Thread.sleep(500);
		System.out.println("Test successful! Now closing all windows, shutting driver and server!");
		driver.quit();
	}
}
