package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelpers;

import static org.junit.Assert.fail;

public class SignInPage extends PageHelpers {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private By emailAddress = By.id("email");
    private By passWord = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By clickOnForSignInPage = By.className("login");
    private By verifySignInPage = By.className("logout");



    public void signIn(String email, String password){
        clickOnElement(clickOnForSignInPage);
        setField(emailAddress, email);
        setField(passWord, password);
        clickOnElement(signInButton);
        if(!isElementDisplay(verifySignInPage)){
            fail("Sign in was failed.");
        }
    }
}
