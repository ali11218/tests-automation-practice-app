package ui.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

public class CommonHelper {

    private static WebDriver driver;


    /**
     * Load WebDriver based on the user driver type: chrome, ie, firefox.
     * Using WebDriver manager to download and set the executable driver path based on the Operating System
     *
     * @return
     */
    public static WebDriver loadWebDriver() {

        String driverType = System.getenv("DRIVER_TYPE"); //Get driver type from user environment

        //Load driver based on user driver type
        if ("chrome".equalsIgnoreCase(driverType)) {

            WebDriverManager.chromedriver().setup();

            //Chrome browser settings
            Map<String, String> prefMap = new HashMap<>();
            prefMap.put("download.default_directory", getSeleniumDownloadDirectoryPath()); //Setting browser download directory
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.setExperimentalOption("prefs", prefMap);
            //TODO add more chrome setting options

            driver = new ChromeDriver(chromeOptions);

        } else if ("firefox".equalsIgnoreCase(driverType)) {
            WebDriverManager.firefoxdriver().setup();

            //Firefox browser settings
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("browser.download.dri", getSeleniumDownloadDirectoryPath());
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("disable-infobars");
            firefoxOptions.setProfile(firefoxProfile);
            //TODO add more chrome setting options

            driver = new FirefoxDriver(firefoxOptions);

        } else if ("ie".equalsIgnoreCase(driverType) && SystemUtils.IS_OS_WINDOWS) {
            WebDriverManager.iedriver().setup();
            //TODO add IE setting options
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    /**
     * Creates a directory in your home if not exists for all tests downloads
     *
     * @return
     */
    public static String getSeleniumDownloadDirectoryPath() {
        String defaultDownloadPath = SystemUtils.IS_OS_WINDOWS ? "C:\\selenium-tests-downloads\\" : System.getProperty("user.home") + "/selenium-tests-downloads/";
        File directory = new File(defaultDownloadPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
        System.out.println("++++++++++ All Selenium Test downloads located: " + defaultDownloadPath + " ++++++++++");
        return defaultDownloadPath;
    }

    /**
     * Get environment properties value
     *
     * @param propertyName
     * @return
     */
    public static String getEnvironmentProperty(String propertyName) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(getEnvironment());
        return resourceBundle.getString(propertyName);
    }

    private static String getEnvironment() {
        String env = null;
        try {
            env = System.getenv("ENVIRONMENT").toLowerCase();
        } catch (Exception e) {
            fail("Please enter a valid environment, please use one of the valid environment name: test, preprod, prod");
        }
        return env;
    }


}

