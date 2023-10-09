package testng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day6 {
	
	ChromeDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.webdriveruniversity.com");
	}
	
	@Test
	public void test1() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "WebDriverUniversity.com";
		Assert.assertEquals(actualTitle, expectedTitle);
				
	}
	
	@Test 
	public void test2() {
		String actualURL = driver.getCurrentUrl();
		boolean expectedURL = actualURL.contains("webdriveruniversity");
		Assert.assertEquals(expectedURL,true);
	}
	
	@AfterMethod
	public void browserClose() {
		driver.close();
	}
	
	
}
	
