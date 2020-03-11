package sanity;

import org.junit.Test;
import ui.helpers.TestHelpers;
import ui.pages.HomePage;
import static org.junit.Assert.assertEquals;

public class SanityTest extends TestHelpers {

    @Test
    public void womenEveningDress() {
        HomePage homePage = new HomePage(driver);
        homePage.womenEveningDress();
        String actualTitle = homePage.getEveningDressTitleText();
        assertEquals("EVENING DRESSES", actualTitle);

    }

}
