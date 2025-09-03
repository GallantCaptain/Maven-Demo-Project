package assignment_iframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GSQA {
    public static void main(String[] args) {
        // --- Setup ---
        ChromeOptions options = new ChromeOptions()
                .setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        // Using WebDriverWait is more reliable than Thread.sleep()
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        // Fetch the web page
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        // Create an Actions object to perform complex user gestures
        Actions act = new Actions(driver);

        // --- Photo Manager Tab ---
        
        // Find and switch to the correct iframe for the "Photo Manager" tab
        WebElement photoManagerIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe.demo-frame")));
        driver.switchTo().frame(photoManagerIframe);
        System.out.println("Switched to Photo Manager iframe.");

        // Now locate the elements within the iframe
        WebElement dragTatras1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='The peaks of High Tatras']")));
        WebElement dragTatras2 = driver.findElement(By.cssSelector("img[alt='The chalet at the Green mountain lake']"));
        WebElement dragTatras3 = driver.findElement(By.cssSelector("img[alt='Planning the ascent']"));
        WebElement dragTatras4 = driver.findElement(By.cssSelector("img[alt='On top of Kozi kopka']"));
        WebElement trashBin = driver.findElement(By.id("trash"));
        WebElement gallery = driver.findElement(By.id("gallery"));

        // Drag and drop all images to the trash
        System.out.println("Dragging images to trash...");
        act.dragAndDrop(dragTatras1, trashBin).perform();
        act.dragAndDrop(dragTatras2, trashBin).perform();
        act.dragAndDrop(dragTatras3, trashBin).perform();
        act.dragAndDrop(dragTatras4, trashBin).perform();
        
        // Restore all images back to the gallery
        System.out.println("Restoring images to gallery...");
        // Need to re-find the elements as they are now children of the trash bin
        WebElement droppedTatras1 = trashBin.findElement(By.cssSelector("img[alt='The peaks of High Tatras']"));
        WebElement droppedTatras2 = trashBin.findElement(By.cssSelector("img[alt='The chalet at the Green mountain lake']"));
        WebElement droppedTatras3 = trashBin.findElement(By.cssSelector("img[alt='Planning the ascent']"));
        WebElement droppedTatras4 = trashBin.findElement(By.cssSelector("img[alt='On top of Kozi kopka']"));

        act.dragAndDrop(droppedTatras1, gallery).perform();
        act.dragAndDrop(droppedTatras2, gallery).perform();
        act.dragAndDrop(droppedTatras3, gallery).perform();
        act.dragAndDrop(droppedTatras4, gallery).perform();

        // --- IMPORTANT: Switch back to the main page content ---
        driver.switchTo().defaultContent();
        System.out.println("Switched back to the main page.");

        // --- Accepted Elements Tab ---

        // Now that we are on the main page, we can click the next tab
        WebElement acceptedElementsTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("Accepted Elements")));
        acceptedElementsTab.click();
        System.out.println("Clicked on 'Accepted Elements' tab.");

        // Switch to the new iframe for this tab
        WebElement acceptedElementsIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[data-src*='accepted-elements']")));
        driver.switchTo().frame(acceptedElementsIframe);
        System.out.println("Switched to Accepted Elements iframe.");

        // Locate the elements within the "Accepted Elements" iframe
        WebElement onlyDraggable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable-nonvalid")));
        WebElement dragToTarget = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        // Perform the drag and drop action
        System.out.println("Performing drag and drop in Accepted Elements.");
        act.dragAndDrop(dragToTarget, droppable).build().perform();
        
        // You can add actions for the "Propagation" tab here following the same pattern:
        // 1. Switch to defaultContent()
        // 2. Click the Propagation tab
        // 3. Switch to the new iframe
        // 4. Perform actions

        // --- Cleanup ---
        System.out.println("Script finished. Closing driver.");
        try {
            Thread.sleep(3000); // Pause to see the final result
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
