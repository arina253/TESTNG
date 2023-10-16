package testng;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day15LinkChecker {
	
	private WebDriver driver;

	    @BeforeTest
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.webdriveruniversity.com/");
	    }

	    @Test
	    public void testLinkChecker() {
	        List<WebElement> links = driver.findElements(By.tagName("a"));
	        int brokenLinkCount = 0;

	        for (WebElement link : links) {
	            String url = link.getAttribute("href");
	            if (url != null && !url.isEmpty()) {
	                try {
	                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	                    connection.setRequestMethod("HEAD");
	                    connection.connect();
	                    int responseCode = connection.getResponseCode();
	                    if (responseCode >= 400) {
	                        System.out.println("Broken link: " + url);
	                        brokenLinkCount++;
	                    }
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        System.out.println("Total links: " + links.size());
	        System.out.println("Broken links: " + brokenLinkCount);
	    }

	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
	}

/*******************************************************************************/

/*Set up your TestNG project:

Create a new TestNG project in your preferred Java IDE (e.g., Eclipse, IntelliJ IDEA).
Make sure you have TestNG and Selenium WebDriver installed and configured.
Write a TestNG test class:

Create a TestNG test class that will be responsible for checking the links on the website.
Add the necessary imports for TestNG, Selenium WebDriver, and related libraries.
Initialize WebDriver and navigate to the website:

In your test class, initialize a WebDriver instance (e.g., ChromeDriver) and navigate to the website you want to check.
Find all links on the webpage:

Use Selenium WebDriver to locate all the links on the webpage. You can do this by finding all a elements.
Iterate through the links and check their status:

Loop through the list of links and make an HTTP request to each link to determine its status code.
If the status code indicates a broken link (e.g., 404 Not Found), increment a counter for broken links.
Print the total number of links and broken links:

After checking all links, print out the total number of links and the number of broken links.

*/
