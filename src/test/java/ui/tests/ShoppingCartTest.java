package ui.tests;

import org.junit.Ignore;
import org.junit.Test;
import ui.helpers.TestHelpers;
import ui.pages.AddToCartPage;
import ui.pages.ContactUsPage;
import ui.pages.SignInPage;

public class ShoppingCartTest extends TestHelpers {

    @Test
    public void verifyTheShoppingCart_SDET_264(){
        new AddToCartPage(driver)
                .addItems();
    }

    @Test
    public void signInToThePage(){
        new SignInPage(driver)
                .signIn("test@testy.com","testy");
    }

//    @Test @Ignore
//    public void ContactUsTest(){
//        new ContactUsPage(driver).contactUs(value);
//    }

}
