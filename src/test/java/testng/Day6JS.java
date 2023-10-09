package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day6JS {

	// JAVASCRIPT EXECUTOR
	
	//We cannot find certain elements in selenium

	ChromeDriver driver;

	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.webdriveruniversity.com/index.html");
	}
	
	
	//Use of Selenium to click an  element
		
		@Test
		public void testCase() {
			driver.get("https://www.webdriveruniversity.com/index.html");
			WebElement contactUsLink = driver.findElement(By.id("contact-us"));
			contactUsLink.click();
			driver.close();
			
			}
		
		/// Javascript executor to click an element
	

	@Test
	public void testCase1() {
		driver.get("https://www.webdriveruniversity.com/");
		WebElement contactUsLink = driver.findElement(By.id("contact-us"));
		JavascriptExecutor jsE = (JavascriptExecutor) driver;
		jsE.executeScript("arguments[0].click()", contactUsLink);
		driver.close();
	}

	// Javascript executor for scrolling around

	@Test
	public void testCase2() { 
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webdriveruniversity.com/");
		
		WebElement scrollElement = driver.findElement(By.id("scrolling-around"));
		String script = "arguments[0].scrollIntoView(true)";
		JavascriptExecutor jsE = (JavascriptExecutor) driver;
		jsE.executeScript(script, scrollElement);
		driver.close();
		}
	
	
	//Javascript executor for Setting up new attribute to an  element
	
	@Test
	public void testcase3() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webdriveruniversity.com/");
		
		WebElement scrollElement = driver.findElement(By.id("scrolling-around"));
		String script = "arguments[0].setAttribute('data-cy','two')";
		//String script = "argument[0].removeAttribute('data-cy')"
		JavascriptExecutor jsE = (JavascriptExecutor) driver;
		jsE.executeScript(script,scrollElement);
		String attributeVal =scrollElement.getAttribute("data-cy");
		System.out.println(attributeVal);
		Assert.assertEquals(attributeVal, "two");
		//driver.close();
	}
	
	
	//Get title of the page with JS executor
	
	
	@Test
	public void testcase4 () {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webdriveruniversity.com/");
		
		//String title = driver.getTitle();
		//Assert.assertEquals(title, "WebDriverUniversity.com");
		
		
		String script = "return document.title";
		JavascriptExecutor jsE = (JavascriptExecutor) driver;
		String actualtitle = (String)jsE.executeScript(script);
		//First parameter of JavascriptExecutor is script
		Assert.assertEquals(actualtitle, "WebDriverUniversity.com");
		driver.close();
	
	
	}
	
	

}
