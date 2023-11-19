package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	
	private WebDriver driver;
	
	//All elements with respect to ProductPage
    private By productItems = By.className("inventory_item");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getProductItems() {
        return driver.findElements(productItems);
    }
    
    public String isPageOpened() {
    	return driver.getCurrentUrl();
	}
}
