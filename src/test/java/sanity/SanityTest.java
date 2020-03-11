package sanity;

         import org.junit.Test;
         import org.openqa.selenium.WebDriver;
         import ui.helpers.TestHelpers;
         import ui.pages.HomePage;

         import static org.junit.Assert.assertEquals;
         import static org.junit.Assert.assertTrue;

public class SanityTest extends TestHelpers {


    @Test
    public void womenEveningDress(){
        HomePage homePage = new HomePage(driver);
        homePage.womenEveningDress();
       String actualTitle = homePage.geEveningDressTitleText();
       assertEquals("EVENING DRESSES", actualTitle);

    }

}
