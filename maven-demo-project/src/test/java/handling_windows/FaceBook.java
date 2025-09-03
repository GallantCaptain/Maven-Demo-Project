package handling_windows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FaceBook {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions()
				.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.facebook.com/");

//		1> get the home address/parent window session id
		String pid = driver.getWindowHandle();

//		2> perform the task which will open new window/s
		driver.findElement(By.linkText("Meta Pay")).click();

//		3> switch to that particular window
		Set<String> IDs = driver.getWindowHandles();

		for (String i : IDs) {
			driver.switchTo().window(i);
//			System.out.println(driver.getTitle());

			if (driver.getTitle().contains("Pay")) {
				break;
			}
		}

		driver.close();
		Thread.sleep(3000);

		driver.switchTo().window(pid);

		driver.close();

	}
}