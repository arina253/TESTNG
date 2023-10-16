package testng;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15ScreenShot {

	// Taking a screenshot in Selenium

	WebDriver driver;

	@Test
	public void TestCaseOne() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webdriveruniversity.com/");

		driver.findElement(By.id("contact-us")).click();
		Set<String> handles = driver.getWindowHandles();
		boolean windowFound = false;
		for (String wd : handles) {
			System.out.println(wd);
			driver.switchTo().window(wd);

			if (driver.getCurrentUrl().contains("Contact-Us")) {
				windowFound = true;
			}
		}
		Assert.assertTrue(windowFound);

		// Taking screenshots

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		// Capturing the screenshot as file
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\joshi\\eclipse-workspace\\testng\\src\\test\\java\\testng\\img.png";
		File destination = new File(path);

		// Copying the Screenshot File:
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// We need to add a dependency for the FileUtils class
		// Go to pom.xml &copy paste the dependency for FileUtils class
		// Right click on project folder-Go to properties-Copy path
		
		//Line No.44-55

		// This code sets up the capability to take screenshots using TakesScreenshot.
		// getScreenshotAs(OutputType.FILE) captures the screenshot as a file (src).
		// A file path (path) is specified where the screenshot will be saved.
		// A File object for the destination is created.
		// uses Apache Commons IO's FileUtils.copyFile method to copy the screenshot
		// (src) to the specified destination (destination).
		// In case of any IO exceptions, it prints a stack trace.

	}

}
