package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day8a {
	
	//Hard Assertion and Soft Assertion
	
	WebDriver driver;
	
	@Test
	public void testCaseOne() {
		//Hard Assertion
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver-win64\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webdriveruniversity.com/");
		
		//Verify title
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,"WebDriverUniversity.com");
		
		//Verify url
		boolean avail = driver.getCurrentUrl().contains("more");
		Assert.assertTrue(avail);
		//This test  will fail which will result in not executing other tests, 
		// so to avoid that we use soft assert
		
		//Verify element displayed
		boolean avail2 = driver.findElement(By.cssSelector("contact-us")).isDisplayed();
        Assert.assertTrue(avail2);
        driver.close();
}
	
	
	//Soft Assertion
	
	@Test
	public void testCaseTwo() {
		//Soft Assertion
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver-win64\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webdriveruniversity.com/");
		
		// creating soft assert class
		SoftAssert ss = new SoftAssert();
		
		//Verify title
		String actualTitle = driver.getTitle();
		ss.assertEquals(actualTitle,"WebDriverUniversity.com");
		
		//Verify url
		boolean avail = driver.getCurrentUrl().contains("more");
		ss.assertTrue(avail);
		//now even though this test fails it will execute other tests
		
		//Verify element displayed
		boolean avail2 = driver.findElement(By.cssSelector("#contact-us")).isDisplayed();
		ss.assertTrue(avail2);
		
		driver.close();
		
		ss.assertAll();
		
		
/*******************************************************************************/
		
/*Hard Assertion: If any one of the assertion fails,other lines are not executed
and it will not close the driver
		
Soft Assertion: will not halt the execution and checks every assertion
It continues execution though any one of the assertion fails,go to the
last and close the driver
We have to create object of SoftAssert class
		
ss.AssertAll(): To check all the assertion at the last
Fail the test case if any assertion is failed
Mark as pass if any assertion is passed.*/
		
		}
	
}
