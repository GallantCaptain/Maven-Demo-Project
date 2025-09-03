package working_with_popups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoWebShop {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions()
				.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
	    WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://demowebshop.tricentis.com/");

		driver.findElement(By.cssSelector("input[type='submit']")).click();

		Alert ale = driver.switchTo().alert();
		Thread.sleep(5000);
		ale.dismiss();

		driver.quit();

	}
}