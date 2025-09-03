package working_with_popups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class W3Schools {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions()
				.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");

		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
//		Prompt popup
		
		Alert ale = driver.switchTo().alert();
		ale.sendKeys("Dingesh");
		ale.accept();

		Thread.sleep(5000);
		driver.quit();

	}
}