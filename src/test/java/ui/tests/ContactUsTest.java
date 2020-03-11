package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelpers;
import ui.pages.ContactUsPage;

import java.io.File;

public class ContactUsTest extends TestHelpers {
    //private File filePath = new File("src/test/resources/test-data/test.txt");
    @Test
    public void customerContactUs() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.submitContactUsForm("test@testy.com",
                "C:\\Users\\Ali\\Desktop\\Test-file-upload.pdf", "Hello world");

        String actualMessage = contactUsPage.getStatusMessage();
        String expectedMessage = "Your message has been successfully sent to our team.";
        verifyEquals("", expectedMessage, actualMessage);
    }
}
