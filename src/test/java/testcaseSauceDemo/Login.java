package testcaseSauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductsPage;

public class Login {
	private WebDriver driver;
	private LoginPage loginPage;

	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
	}

	@Test
	public void testSuccessfulLogin() {
		driver.get("https://www.saucedemo.com");
		loginPage.login("standard_user", "secret_sauce");

		// Verify that the user is logged in (e.g., check for products)
//		ProductsPage productsPage = new ProductsPage(driver);
		// Assert.assertTrue(productsPage.isPageOpened(), "Products page is not
		// opened.");
	}

	@Test
	public void testLoginWithoutPassword() {
		driver.get("https://www.saucedemo.com");
		loginPage.loginWithoutPassword("standard_user");

		// Verify the error state
		Assert.assertTrue(loginPage.isErrorState(), "Error message is not displayed.");
	}

	@Test
	public void testLoginWithoutUsername() {
		driver.get("https://www.saucedemo.com");
		loginPage.loginWithoutUsername("your_password");
		boolean avail = loginPage.isErrorState();

		// Verify the error state
//		Assert.assertTrue(loginPage.isErrorState(), "Error message is not displayed.");
        Assert.assertTrue(avail);	
	}

	@Test
	public void verifyTitleForLogin() {
		String actual = driver.getTitle();
		String expected = "Swag Labs";
		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
