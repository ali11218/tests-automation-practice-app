package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelpers;
import ui.pages.AddToCartPage;

public class AddToCartTest extends TestHelpers {

    @Test
    public void verifyTheShoppingCart_SDET_264() {
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.addItemsInTheCart();

        String actualMessage = addToCartPage.getConfirmationMessage();
        String expectedMessage = "Product successfully added to your shopping cart";
        verifyEquals("Test failed: Expected element doesn't match with actual.", expectedMessage, actualMessage);
    }


}
