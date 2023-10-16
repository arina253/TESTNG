package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day9b {
	
	//Passing the parameter via xml file---Parameter is not for dataset
	//DataProvider is for dataset
	
	WebDriver driver;
	@Parameters({"username","password"})
	
	
	@Test()
	public void login(String un, String pwd) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
	}
	
	

}
