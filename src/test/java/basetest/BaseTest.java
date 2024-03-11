package basetest;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.PropertyReader;


public class BaseTest {

    public WebDriver driver;


    @BeforeSuite(alwaysRun = true)
    public void setUpBrowserDriver() throws Exception {
        String browser = PropertyReader.readKey("browser");
        if (browser != null) {
            switch(browser) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
            }
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }




}
