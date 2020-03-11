package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelpers;

public class CheckoutPage extends PageHelpers {
    private By checkOutButton = By.cssSelector("[title='Proceed to checkout']");
    private By cartConfirmation = By.className("navigation_page");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckOut() {
        clickOnElement(checkOutButton);
    }

    public String getVerificationText() {
        return getString(cartConfirmation);
    }


}
