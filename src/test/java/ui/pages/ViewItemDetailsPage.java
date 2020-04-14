package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelpers;

public class ViewItemDetailsPage extends PageHelpers {
    private By mouseHoverItem = By.xpath("//*[@id='homefeatured']/li[1]");
    private By moreButton = By.xpath("//*[@id='homefeatured']/li[1]//a/span[contains(text(),'More')]");
    private By verifyItemName = By.xpath("//*[@id=\"center_column\"]//h1");

    public ViewItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void viewItemDetails(){
        moveToChildElementAndClick(mouseHoverItem, moreButton);
    }
    public String getItemDetails(){
        return getString(verifyItemName);
    }



}
