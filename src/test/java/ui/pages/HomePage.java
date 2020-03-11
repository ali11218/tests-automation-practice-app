package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelpers;

import static org.junit.Assert.fail;

public class HomePage extends PageHelpers {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //womenEveningDress
    private By womanTab = By.xpath("//*[@id='block_top_menu']//a[contains(text(),'Women')]");
    private By eveningDresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[2]");
                                            //*[@id='block_top_menu']//a[contains(text(),'Evening Dresses')]
    private By eveningDressVerify = By.className("cat-name");

    public void womenEveningDress(){
        moveToChildElementAndClick(womanTab, eveningDresses);
//        if(!isElementDisplay(eveningDressVerify)){
//            fail("Evening dress verification failed");
//        }

    }


    public String geEveningDressTitleText() {
        return getString(eveningDressVerify);
    }
}
