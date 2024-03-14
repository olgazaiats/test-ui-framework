package pageobjects;

import base.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonPage {

    private By usernameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUsernameValue() {
        waitVisibilityOfElement(usernameOnDashboard, 10);
        return getElement(usernameOnDashboard).getText();
    }

}
