package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelpers;
import ui.pages.AddToCartPage;
import ui.pages.CheckoutPage;

public class CheckoutTest extends TestHelpers {
    @Test
    public void addItemAndCheckout() {
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.addItemsInTheCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckOut();

        String actualMessage = checkoutPage.getVerificationText();
        verifyEquals("Test failed: Expected element doesn't match with actual.", "Your shopping cart", actualMessage);

    }
}
