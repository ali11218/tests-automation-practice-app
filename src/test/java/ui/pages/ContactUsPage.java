package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelpers;

public class ContactUsPage extends PageHelpers {
    private By contactUsLink = By.id("contact-link");
    private By subjectHeading = By.id("id_contact");
    private String chooseSubject = "Customer service";
    private By emailField = By.id("email");
    private By attachFileField = By.xpath("//*[@id=\"fileUpload\"]");
    private By messageField = By.id("message");
    private By sendButton = By.id("submitMessage");
    private By statusMessage = By.xpath("//*[@id='center_column']/p");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void submitContactUsForm(String emailAddress, String filePath, String writeYourMessage) {
        clickOnElement(contactUsLink);
        selectByVisibilityOfText(subjectHeading, chooseSubject);
        setField(emailField, emailAddress);
        fileUpload(attachFileField, filePath);
        setField(messageField, writeYourMessage);
        clickOnElement(sendButton);

    }

    public String getStatusMessage(){
        return getString(statusMessage);

    }


}
