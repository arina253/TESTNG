//package testcaseSauceDemo;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import Pages.LoginPage;
//import Pages.ProductsPage;
//import utilities.Utils;
//
//public class Product {
//	
//	private WebDriver driver;
//	private LoginPage loginPage;
//	private ProductsPage productsPage;
//	private Utils utils;
//	
//	@BeforeTest
//	public void setUp() {
//
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\joshi\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("https://www.saucedemo.com");
//		loginPage = new LoginPage(driver);
//		ProductsPage productsPage = new ProductsPage(driver);
//		loginPage.login("standard_user", "secret_sauce");
//		utils = new Utils(driver);
//	}
//	
//	@Test
//	public void verifyTitleforProduct() {
//		boolean result = utils.verifyTitle(driver, "Swag Labs");
//		Assert.assertTrue(result);
//		}
//	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
//
//
//}
package testcaseSauceDemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductsPage;
import utilities.Utils;

public class Product {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private Utils utils;

    @BeforeTest
    public void setup() {
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        utils = new Utils(driver);
    }

    @Test
    public void VerifyTitleForProduct() {
        boolean result = utils.verifyTitle(driver, "Swag Labs");
        Assert.assertTrue(result);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
