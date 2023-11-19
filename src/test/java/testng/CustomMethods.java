package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CustomMethods {
	
	 private WebDriver driver;
	
	@Test
	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\joshi\\Downloads\\chromedriver-win64\\chromedriver\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Users\\joshi\\Downloads\\chromedriver-win64\\chromedriver\\chromedriver.exe");
			EdgeDriver driver = new EdgeDriver();
		}
		
		
		
	}

}
