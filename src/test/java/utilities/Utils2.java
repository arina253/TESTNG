package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils2 {

    public static void waitForElementToBePresent(WebDriver driver, By by, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("screenshots/" + screenshotName + ".png"));
            System.out.println("Screenshot saved as " + screenshotName + ".png");
        } catch (IOException e) {
            System.err.println("Failed to take a screenshot: " + e.getMessage());
        }
    }
}


