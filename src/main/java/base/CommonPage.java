package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPage {

    WebDriver driver;
    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    //Waits
    public void implicitWait(long seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    // Common Functions
    public void clickElement(By element) {
        driver.findElement(element).click();
    }

    public WebElement waitPresenceForElement(By element, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public WebElement waitVisibilityOfElement(By element, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void enterInput(By element, String key) {
        driver.findElement(element).sendKeys(key);
    }

    protected WebElement getElement(By element) {
        return driver.findElement(element);
    }



}
