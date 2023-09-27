package pages;

import model.Message;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ContactForm extends PageBase {

    public ContactForm(WebDriver driver) {
        super(driver);


    }

    @FindBy(id = "email")
    WebElement emailPlace;
    @FindBy(css = "#submitMessage")
    WebElement submitMessageButton;
    @FindBy(css = "#center_column .alert-danger")
    WebElement alertBox;
    @FindBy(css = "#center_column .alert-success")
    WebElement greenAlertBox;
    @FindBy(id = "id_contact")
    WebElement subjectSelect;
    @FindBy(id = "id_order")
    WebElement orderInput;
    @FindBy(id = "message")
    WebElement messageInput;

    public void insertEmail(String email) {
        emailPlace.sendKeys(email);
    }

    public void clickSubmitMessageButton() {
        submitMessageButton.click();
    }

    public boolean checkIfAlertBoxIsPresent() {
        return checkIfBoxIsPresent(alertBox);
    }

    public boolean checkIfBoxIsPresent(WebElement box) {
        wait.until(ExpectedConditions.visibilityOf(box));
        boolean isDisplayed = false;
        try {
            isDisplayed = box.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("No such element!");
        }
        return isDisplayed;
    }

    public boolean checkIfGreenAlertBoxIsPresent() {
        return checkIfBoxIsPresent(greenAlertBox);
    }

    public void submitContactForm(Message message) {
        Select subject = new Select(subjectSelect);
        subject.selectByVisibleText(message.getMessageSubject().getValue());
        emailPlace.sendKeys(message.getEmail());
        orderInput.sendKeys(message.getOrderReference());
        messageInput.sendKeys(message.getMessage());
        clickSubmitMessageButton();
    }
}
