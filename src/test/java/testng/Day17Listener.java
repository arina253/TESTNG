package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.Base;

public class Day17Listener  extends Base{
	
	@Test
	public void searchGoogle() {
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("TestNG Selenium");
		searchBox.submit();
		Assert.assertTrue(false);
	}

}
