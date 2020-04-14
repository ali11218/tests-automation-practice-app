package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelpers;
import ui.pages.ViewItemDetailsPage;

public class ViewItemDetailsTest extends TestHelpers {
    @Test
    public void verifyItemDetails() {
        ViewItemDetailsPage viewItemDetailsPage = new ViewItemDetailsPage(driver);
        viewItemDetailsPage.viewItemDetails();

        String actualMessage = viewItemDetailsPage.getItemDetails();
        String expectedMessage = "Faded Short Sleeve T-shirts";
        verifyEquals("Test failed: Expected element doesn't match with actual.", expectedMessage, actualMessage);


    }
}
