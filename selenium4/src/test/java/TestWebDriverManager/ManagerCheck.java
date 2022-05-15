package TestWebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManagerCheck {

	@Test
	public void testData()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println("Current url-- "+driver.getCurrentUrl());
		driver.quit();

	}

}
