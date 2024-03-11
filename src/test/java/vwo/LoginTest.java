package vwo;

import basetest.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.DashboardPage;
import pageobjects.LoginPage;
import utils.PropertyReader;

public class LoginTest extends BaseTest {


    @Test(groups = {"valid"})
    public void loginValidTest() throws Exception {
        String username = PropertyReader.getValueFromProperties("username");
        String password = PropertyReader.readKey("password");

        driver.get(PropertyReader.readKey("url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWO(username, password);

        DashboardPage dashboardPage = new DashboardPage(driver);
        String actualUsername = dashboardPage.getLoggedInUsernameValue();

        Assert.assertTrue(dashboardPage.getLoggedInUsernameValue().contains(actualUsername), "Login was not successful");
    }

    @Test
    public void loginInvalidPassTest() throws Exception {
        String username = PropertyReader.readKey("username");
        String password = "invalid password";

        driver.get(PropertyReader.readKey("url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWO(username, password);

        String errorText = "Your email, password, IP address or location did not match";
        Assert.assertTrue(loginPage.getErrorInvalidLogin().getText().equals(errorText), "Error text does not match");
    }
}
