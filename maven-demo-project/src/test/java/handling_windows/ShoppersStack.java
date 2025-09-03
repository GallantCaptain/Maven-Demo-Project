package handling_windows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShoppersStack {
	public static void main(String[] args) throws InterruptedException {
		String binaryPath = "C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe";
		ChromeOptions options = new ChromeOptions().setBinary(binaryPath);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.shoppersstack.com/products_page/39");
		
		driver.findElement(By.id("compare")).click();
		
		
		Thread.sleep(15000);
		driver.quit();
	}
}