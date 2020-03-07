package ui.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageHelpers {
    private WebDriver driver;

    public PageHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilVisibilityOfElementLocatedBy(By byElement) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(byElement));
    }

    public void clickOnElement(By byElement) {
        driver.findElement(byElement).click();
    }

    public void setField(By byElement, CharSequence value) {
        driver.findElement(byElement).clear();
        driver.findElement(byElement).sendKeys(value);
    }

    public void setCheckBox(By byElement) {
        if (!driver.findElement(byElement).isSelected()) {
            driver.findElement(byElement).click();
        }
    }

    public void mouseHover(By byElement, By bySubElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(byElement)).moveToElement(driver.findElement(bySubElement))
                .click().build().perform();
    }

    public boolean isElementDisplay(By byElemnent){
        boolean isFound;
        try {
            waitUntilVisibilityOfElementLocatedBy(byElemnent);
            isFound = true;
        } catch (Exception ignore){
            isFound = false;
        }
        return isFound;
    }

    public void selectByVisibilityOfText(){
        //todo
    }

    public void getText (By byElement) {
        driver.findElement(byElement).getText();
    }

    public void getStringLists(){
        //todo
    }

    public void findyElement(){
        //todo
    }

    public void findWebElement(){
        //todo
    }


}
