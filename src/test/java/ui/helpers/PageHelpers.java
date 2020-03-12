package ui.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;

public abstract class PageHelpers {
    public WebDriver driver;

    public PageHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilVisibilityOfElementLocatedBy(By byElement) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(byElement));
    }

    public void clickOnElement(By byElement) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(byElement));
        driver.findElement(byElement).click();
    }

    public void setField(By byElement, String value) {
        waitUntilVisibilityOfElementLocatedBy(byElement);
        driver.findElement(byElement).clear();
        driver.findElement(byElement).sendKeys(value);
    }

    public void fileUpload(By byElement, String filePath) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(byElement));
        driver.findElement(byElement).sendKeys(filePath);

    }

    public void setCheckBox(By byElement) {
        if (!driver.findElement(byElement).isSelected()) {
            driver.findElement(byElement).click();
        }
    }

    public void moveToChildElementAndClick(By byElement, By bySubElement) { //moved to element
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(byElement)).moveToElement(driver.findElement(bySubElement))
                .click().build().perform();
    }

    public boolean isElementDisplay(By byElement) {
        boolean isFound;
        try {
            waitUntilVisibilityOfElementLocatedBy(byElement);
            isFound = true;
        } catch (Exception ignore) {
            isFound = false;
        }
        return isFound;
    }

    public void selectByVisibilityOfText(By byElement, String value) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(byElement));
        Select select = new Select(driver.findElement(byElement));
        select.selectByVisibleText(value);
    }


    //getting text and trimming space from beginning and end of the line.
    public String getString(By byElement) {
        waitUntilVisibilityOfElementLocatedBy(byElement);
        return driver.findElement(byElement).getText().trim();
    }

    public List<String> getStringLists(By byElements) {
        //Collection List variable = findElements class inheriting List interface.
        List<WebElement> webElementList = driver.findElements(byElements);
        //Cannot create object out of interface, ArrayList class implements List interface.
        List<String> stringList = new ArrayList<>();
        for (WebElement element : webElementList) {
            stringList.add(element.getText().trim());
        }
        return stringList;
    }

    public Map<String, String> getTableMap(List<String> fieldName, List<String> fieldValue) {
        Map<String, String> empDetailsInfoMap = new HashMap<>();
        for (int i = 0; i < fieldName.size(); i++) {
            empDetailsInfoMap.put(fieldName.get(i).trim(), fieldValue.get(i).trim());
        }
        return empDetailsInfoMap;
    }

//    public WebElement findByWebElement(By byElement) {
//        WebElement webElement = null;
//        try {
//            waitUntilVisibilityOfElementLocatedBy(5, byElement);
//            webElement = driver.findElement(byElement);
//        } catch (Exception e) {
//            captureScreenshot();
//            fail("Failed locate element using By: " + byElement + "\nCheck Screenshot \n" + e.getStackTrace());
//        }
//        return webElement;
//    }


    public void findElement() {
        //todo
    }


}
