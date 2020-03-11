package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelpers;

import static org.junit.Assert.fail;

public class AddToCartPage extends PageHelpers {

    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    //verifyTheShoppingCart_SDET_264
    private By shortSleeve = By.xpath("//*[@id=\"homefeatured\"]/li[1]");
    private By shortSleeveAddToCart = By.id("add_to_cart");
    private By verifyShortSleeveAddedToCart = By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2");


    public void addItems(){
        clickOnElement(shortSleeve);
        clickOnElement(shortSleeveAddToCart);
        if(!isElementDisplay(verifyShortSleeveAddedToCart)){
            fail("Item added messege did not display");
        }
    }
}
