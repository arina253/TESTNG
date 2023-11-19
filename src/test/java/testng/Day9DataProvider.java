package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day9DataProvider {
	
//TestNG test class for automating login functionality on the 
//"https://www.saucedemo.com/" website using Selenium WebDriver.
	
	WebDriver driver;
	
	//DataProvider in testNg------to run a single test case with multiple set of data
	//DataProvider return type: multidimensional object array
	//Can provide data set with key value pairs
	
	@DataProvider(name = "loginData")
	public Object[][]providerLoginData(){
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"}
		};
		
		}
	
	@Test (dataProvider = "loginData")
	public void Login(String username,String pass) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver-win64\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login-button")).click();
		
		boolean avail = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avail);
		driver.close();

	}
	

}
