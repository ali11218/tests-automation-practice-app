package sanity;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ui.helpers.TestHelpers;
import ui.pages.HomePage;

public class SanityTest extends TestHelpers {


    @Test
    public void womenEveningDress(){
        HomePage homePage = new HomePage(driver);
        homePage.womenEveningDress();
    }

}
