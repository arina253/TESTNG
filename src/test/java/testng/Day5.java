package testng;

    import static org.testng.Assert.assertEquals;

	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Day5 {
		
		ChromeDriver driver;
		
		@BeforeMethod
		public void OpenBroweser() {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\joshi\\Downloads\\chromedriver-win64\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.webdriveruniversity.com/");
			
		}
		
		
		@Test(priority = 1 , description = "login functionality")
		public void testOne(){
			String title = driver.getTitle();
			String expectedTitle = "WebDriverUniversity.com";
//			if(title.equals("WebDriverUniversity.com")) {
//				System.out.println("Test case pass");
//			}
//			else {
//				System.out.println("Test case fail");
//			}
//			
			Assert.assertEquals(title, expectedTitle);
			
		}
		
		@Test(priority = 2 , description = "validate the home page url")
		public void testTwo(){
			String url = driver.getCurrentUrl();
			boolean expected = url.contains("webdriveruniversity");
			Assert.assertEquals(expected, true);
			
		}
		
		@AfterMethod 
		public void CloseBroswe() {
			driver.close();
		}

	}


