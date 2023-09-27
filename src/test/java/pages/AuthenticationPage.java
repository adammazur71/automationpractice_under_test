package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthenticationPage extends PageBase {


    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;
    @FindBy(id = "email_create")
    WebElement newEmailInputField;
    @FindBy(id = "account-creation_form")
    WebElement centerColumn;

    public void createAnAccount(String email) {
        newEmailInputField.sendKeys(email);
        createAccountButton.click();
        wait.until(ExpectedConditions.visibilityOf(centerColumn));
    }
}
