package testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day16Calendar {

    WebDriver driver;

    @Test
    public void CalendarTest() {
        String month = "January";
        String year = "2024";
        String date = "19";

        System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joshi\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.get("https://www.webdriveruniversity.com/Datepicker/index.html");
     
        driver.findElement(By.id("datepicker")).click();
        selectDate(driver,month,year,date);
        
    }
    
    public static void selectDate(WebDriver driver,String month,String year,String date ) {
    	String text = driver.findElement(By.className("datepicker-switch")).getText();
         System.out.println(text);
         String actualMonth =text.split(" ")[0];
         String actualYear = text.split(" ")[1];
         System.out.println(actualMonth);
         System.out.println(actualYear);
         
   
     while(!(actualMonth.equals(month)&& actualYear.equals(year))) {
    	driver.findElement(By.className("next")).click();
         text = driver.findElement(By.className("datepicker-switch")).getText();
    	 actualMonth =text.split(" ")[0];
         actualYear = text.split(" ")[1];
         System.out.println(actualMonth);
         System.out.println(actualYear);
         }
     
     List <WebElement> actualDate = driver.findElements(By.className("day"));
     for (int i = 0; i < actualDate.size(); i++) {
    	if( actualDate.get(i).getText().equals(date)) {
    		actualDate.get(i).click();
    		break;
    	}
     }
    
}
}

