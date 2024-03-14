package pageobjects;

import base.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyReader;

public class LoginPage extends CommonPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    public void loginToVWO(String userNameValue, String passwordValue) throws Exception {
        waitVisibilityOfElement(username, 10);
        enterInput(username, userNameValue);
        enterInput(password, passwordValue);
        clickElement(signButton);
    }

    public WebElement getErrorInvalidLogin() {
        waitVisibilityOfElement(error_message, 10);
        return getElement(error_message);
    }



}
