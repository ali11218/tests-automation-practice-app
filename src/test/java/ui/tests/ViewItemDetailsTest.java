package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelpers;
import ui.pages.ViewItemDetailsPage;

public class ViewItemDetailsTest extends TestHelpers {
    @Test
    public void verifyItemDetails(){
        new ViewItemDetailsPage(driver).viewItemDetails();


    }
}
