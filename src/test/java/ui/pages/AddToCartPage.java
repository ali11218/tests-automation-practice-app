package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelpers;

import static org.junit.Assert.fail;

public class AddToCartPage extends PageHelpers {

    //verifyTheShoppingCart_SDET_264
    private By shortSleeve = By.xpath("//*[@id=\"homefeatured\"]/li[1]");
    private By shortSleeveAddToCart = By.id("add_to_cart");
    private By confirmationMessage = By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2");

    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    public void addItemsInTheCart(){
        clickOnElement(shortSleeve);
        clickOnElement(shortSleeveAddToCart);
  //     if(!isElementDisplay(confirmationMessage)){
//            fail("Item added message did not display");
//        }
    }

    public String getConfirmationMessage(){
       return getString(confirmationMessage);
    }
}
