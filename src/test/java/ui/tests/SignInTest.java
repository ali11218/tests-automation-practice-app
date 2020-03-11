package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelpers;
import ui.pages.SignInPage;

public class SignInTest extends TestHelpers {
    @Test
    public void signInToThePage() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("test@testy.com", "testy");
        String actualSignInMessage = signInPage.getSignInconfirmation();
        String expectedSignInMessage = "Sign out";
        verifyEquals("", expectedSignInMessage, actualSignInMessage);

    }
}
