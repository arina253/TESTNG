package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day7Actions {
	
	//SELENIUM ACTION CLASS
	
	WebDriver driver;
	Actions ac;
	
	@BeforeMethod
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webdriveruniversity.com/Actions/index.html");
	      ac = new Actions(driver);
		
		}
	
	
	//dragging and dropping
	
	@Test
	public void TestCase() {
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		ac.dragAndDrop(draggable,droppable).build().perform();
		Assert.assertEquals(droppable.getText(),"Dropped!" );
		driver.close();
}
	
	
	//double clicking and validating from attribute and value
	
	@Test
	public void TestCaseTwo() {
		WebElement ele = driver.findElement(By.id("double-click"));
		ac.doubleClick(ele).build().perform();
//after clicking the value if class attribute will change that is what we are validating
//class="div-double-click double" -------- expected class attribute after double click
		

		String expectedClass = ele.getAttribute("class");
		Assert.assertEquals(expectedClass, "div-double-click double");
		
}
	
	
	//click AND hold
	@Test
	public void TestCaseThree() {
		WebElement ele1 = driver.findElement(By.id("click-box"));
		ac.clickAndHold(ele1).build().perform();
		Assert.assertEquals(ele1.getText(),"Well done! keep holding that click now.....");
	}
	
	
	////Hover and validate the new element displayed after hover
	@Test
	public void TestCaseFour() {
		WebElement ele = driver.findElement(By.cssSelector("#div-hover > div.dropdown.hover > button"));
		ac.moveToElement(ele).build().perform();
		boolean visible = driver.findElement(By.cssSelector("#div-hover > div.dropdown.hover > div > a")).isDisplayed();
        Assert.assertTrue(visible);
	}
	
	
	//Right click on a particular element-context click
	@Test
	public void TestCaseFive() {
		WebElement ele = driver.findElement(By.cssSelector("#double-click"));
		ac.contextClick().build().perform();
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		//driver.close();
		
	}
}

/******************************************************************************/

/* ac = new Actions(driver);
Actions ac;
ac.dragAndDrop().build().perform();
ac.doubleClick().build().perform();
ac.clickAndHold().build().perform();
ac.moveToElement().build().perform();
ac.contextClick().build().perform();
*/