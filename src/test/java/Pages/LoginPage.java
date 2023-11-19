

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    
    //All elements with respect to LoginPage
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorState = By.tagName("h3");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();                         //Modular Programming
    }

    public void loginWithoutPassword(String username) {
        enterUsername(username);
        clickLogin();
    }

    public void loginWithoutUsername(String password) {
        enterPassword(password);
        clickLogin();
    }

    public boolean isErrorState() {
        return driver.findElement(errorState).isDisplayed();
    }
    
    public String verifyTitle() {
    	return driver.getTitle(); 
    	}
}

