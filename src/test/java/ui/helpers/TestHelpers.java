package ui.helpers;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static ui.helpers.CommonHelper.loadWebDriver;

public class TestHelpers {

    public WebDriver driver;

    @Before
    public void setDriver() {
        driver = loadWebDriver();
//        System.setProperty("webdriver.chrome.driver", "C:\\projects\\Lib\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);SECONDS
        driver.get("http://automationpractice.com/index.php");
        //        //driver.manage().window().maximize();
    }

    @After
    public void tearDownDriver() {
        if(driver !=null) {
            driver.quit();
        }
    }

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    public void verifyEquals(String message, String expected, String actual) {
        try {
            assertEquals(message, expected, actual);
        } catch (AssertionError e) {
            errorCollector.addError(e);
        }
    }

    public void verifyTrue(String message, boolean actual) {
        try {
            assertEquals(message, actual);
        } catch (AssertionError e) {
            errorCollector.addError(e);
        }
    }

    public void verifyFalse(String message, boolean actual) {
        try {
            assertEquals(message, actual);
        } catch (AssertionError e) {
            errorCollector.addError(e);
        }
    }


}
