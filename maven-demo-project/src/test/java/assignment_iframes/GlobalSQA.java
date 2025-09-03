package assignment_iframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class GlobalSQA {
	public static void main(String[] args) throws InterruptedException, WebDriverException {
		ChromeOptions options = new ChromeOptions()
				.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Fetch the web page using fully qualified path
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

		// Create actions object to act on web elements
		Actions act = new Actions(driver);

		// Click on the web element tab
		WebElement photoManagerTab = driver.findElement(By.id("Photo Manager"));
		photoManagerTab.click();

		// Wait then switch to Accepted Elements tab
		Thread.sleep(1000);
		WebElement acceptedElementsTab = driver.findElement(By.id("Accepted Elements"));
		acceptedElementsTab.click();

		// Wait then switch to Propagation tab
		Thread.sleep(1000);
		WebElement propogationTab = driver.findElement(By.id("Propagation"));
		propogationTab.click();

		// Come back to the original photo manager tab
		Thread.sleep(1000);
		photoManagerTab.click();

		// Create iFrame object to store the iFrame information, then switch to it later
		WebElement iframe1 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iframe1);

		// Now store the draggable elements in suitable objects
		//Element 1 
		WebElement dragTatras1 = driver.findElement(By.cssSelector("img[alt=\"The peaks of High Tatras\"]"));
		//Element 2 
		WebElement dragTatras2 = driver.findElement(By.cssSelector("img[alt=\"The chalet at the Green mountain lake\"]"));
		//Element 3 
		WebElement dragTatras3 = driver.findElement(By.cssSelector("img[alt=\"Planning the ascent\"]"));
		//Element 4 
		WebElement dragTatras4 = driver.findElement(By.cssSelector("img[alt=\"On top of Kozi kopka\"]"));
		//Element Trash Bin 
		WebElement trashBin = driver.findElement(By.id("trash"));
		//Element Gallery
		WebElement gallery = driver.findElement(By.id("gallery"));

		// Now that we have located the web elements that we want to perform actions, we use the actions class
		// We drag & drop all the draggable objects into the trash bin
		// Object 1
		Thread.sleep(500);
		act.clickAndHold(dragTatras1);
		// Drag & drop element 1 to trash
		Thread.sleep(500);
		act.dragAndDrop(dragTatras1, trashBin).build().perform();
		// Drag & drop element 2 to trash
		Thread.sleep(500);
		act.dragAndDrop(dragTatras2, trashBin).build().perform();
		// Drag & drop element 3 to trash
		Thread.sleep(500);
		act.dragAndDrop(dragTatras3, trashBin).build().perform();
		// Drag & drop element 4 to trash
		Thread.sleep(500);
		act.dragAndDrop(dragTatras4, trashBin).build().perform();
		
		//Now we restore some elements while we delete the rest
		// Drag & drop element 1 to gallery
		Thread.sleep(500);
		act.dragAndDrop(dragTatras1, gallery).build().perform();
		// Drag & drop element 2 to gallery
		Thread.sleep(500);
		act.dragAndDrop(dragTatras2, gallery).build().perform();
		// Drag & drop element 3 to gallery
		Thread.sleep(500);
		act.dragAndDrop(dragTatras3, gallery).build().perform();
		// Drag & drop element 4 to gallery
		Thread.sleep(500);
		act.dragAndDrop(dragTatras4, gallery).build().perform();
		
		 // --- IMPORTANT: Switch back to the main page content ---
        driver.switchTo().defaultContent();
        System.out.println("Switched back to the main page.");
        
		//Switch to Accepted Elements tab and perform actions on it
		Thread.sleep(500);
		acceptedElementsTab.click();
		//Locate the draggable but not droppable element 
		Thread.sleep(500);
		WebElement onlyDraggable = driver.findElement(By.id("draggable-nonvalid"));
		//Locate the draggable but not droppable element 
		Thread.sleep(500);
		WebElement dragToTarget = driver.findElement(By.id("draggable"));
		//Locate the droppable element 
		Thread.sleep(500);
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		//Act on the only draggable element
		Thread.sleep(500);
		act.moveToElement(onlyDraggable).moveByOffset(50, 0).click().build().perform();
		//Act on the drag To target element and drop it in the droppable element
		Thread.sleep(500);
		act.dragAndDrop(dragToTarget, droppable).build().perform();

		// Wait for some time then quit
		Thread.sleep(5000);
		driver.quit(); // Closes all tabs & browsers, shuts server
	}
}
