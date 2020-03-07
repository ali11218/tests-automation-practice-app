package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelpers;

import static org.junit.Assert.fail;

public class HomePage extends PageHelpers {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By womanTab = By.xpath("//*[@id='block_top_menu']/ul/li/a");
    private By evinningDresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[2]");
    private By eveningDressVerify = By.className("cat-name");

    public void womenEveningDress(){
        mouseHover(womanTab, evinningDresses);
        if(!isElementDisplay(eveningDressVerify)){
            fail("Evening dress verification failed");
        }

    }
}
