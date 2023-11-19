package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day11 {
	
	//xml file
	
	WebDriver driver;
	@Parameters({"username","password"})
	
	
	@Test
	public void TestCase1(String un, String pwd) {
		System.out.println("Test case one");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver-win64\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		
		boolean avail = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avail);
		driver.close();
	}
	
@Parameters({"username","password"})
	
	
	@Test
	public void TestCase2(String un, String pwd) {
		System.out.println("Test case two");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver-win64\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		
		boolean avail = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avail);
		driver.close();
	}

@Parameters({"username","password"})


@Test
public void TestCase3(String un, String pwd) {
	System.out.println("Test case three");
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\joshi\\Downloads\\chromedriver-win64\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	
	driver.findElement(By.id("user-name")).sendKeys(un);
	driver.findElement(By.id("password")).sendKeys(pwd);
	driver.findElement(By.id("login-button")).click();
	
	boolean avail = driver.getCurrentUrl().contains("inventory");
	Assert.assertTrue(avail);
	driver.close();
}

@Parameters({"username","password"})


@Test
public void TestCase4(String un, String pwd) {
	System.out.println("Test case four");
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\joshi\\Downloads\\chromedriver-win64\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	
	driver.findElement(By.id("user-name")).sendKeys(un);
	driver.findElement(By.id("password")).sendKeys(pwd);
	driver.findElement(By.id("login-button")).click();
	
	boolean avail = driver.getCurrentUrl().contains("inventory");
	Assert.assertTrue(avail);
	driver.close();
}

}

/********************************************************************************/

//Adding parameter in suite level at xml file with username and password as parameters
//Annotation to read Parameter : @Parameters({})
//We can choose to run only one method also
//<methods></methods>
//<include></include>
//<exclude></exclude>

//Creating xml file

//Day11 Right click-----TestNG------Convert to TestNG-----Location: testng11----Finish
//Suite level-----Parameter (username & password)available across all suite

//Running xml file
//We cannot run directly test case but run xml file
//testng11.xml-----Rightclick-----Runas----1TestNG suite
