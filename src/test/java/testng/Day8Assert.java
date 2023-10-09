package testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day8Assert {

	// assert in testNg
	// assertEquals(expected,actual)
	// assertNotEquals(expected,actual)
	// assertTrue(condition)
	// assertFalse(condition)

	// API
	// assertNull(object)
	// assertNotNull (object)

	WebDriver driver;

	@BeforeMethod
	public void BeforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webdriveruniversity.com/");

	}

	@Test
	public void Testcase1() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "WebDriverUniversity.com";
		assertEquals(actualTitle, expectedTitle);

		WebElement contactus = driver.findElement(By.cssSelector("#contact-us"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].removeAttribute('target')", contactus);
		contactus.click();
		actualTitle = driver.getTitle();
		assertNotEquals(actualTitle, expectedTitle);

	}

	@Test
	public void TestcaseTwo() {
		// WebDriverUniversity.com

		String currentUrl = driver.getCurrentUrl();
		boolean avail = currentUrl.contains("university");
		assertTrue(avail);

		// google
		driver.get("https://www.google.com/");
		boolean availl = driver.getCurrentUrl().contains("university");
		assertFalse(availl);
	}

	@AfterMethod
	public void AfterMethod() {
		driver.close();
	}
}