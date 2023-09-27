package pages;

import model.PersonalData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PersonalInformationFormPage extends PageBase {

    public PersonalInformationFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    WebElement genderMrRadioButton;
    @FindBy(id = "id_gender2")
    WebElement genderMrsRadioButton;
    @FindBy(id = "customer_firstname")
    WebElement firstNameInputField;
    @FindBy(id = "customer_lastname")
    WebElement lastNameInputField;
    @FindBy(id = "passwd")
    WebElement newPasswordInputField;
    @FindBy(id = "days")
    WebElement daySelectField;
    @FindBy(id = "months")
    WebElement monthSelectField;
    @FindBy(id = "years")
    WebElement yearSelectField;
    @FindBy(id = "submitAccount")
    WebElement submitAccount;
    @FindBy(css = "#center_column .alert-success")
    WebElement greenAlertBox;

    public void sendRegistrationForm(PersonalData personalData) {
        genderMrRadioButton.click();
        firstNameInputField.sendKeys(personalData.getFirstName());
        lastNameInputField.sendKeys(personalData.getLastName());
        newPasswordInputField.sendKeys(personalData.getNewPassword());
        Select selectByMonth = new Select(monthSelectField);
        selectByMonth.selectByVisibleText(personalData.getMonthOfBirth().getValue());
        Select selectByYear = new Select(yearSelectField);
        selectByYear.selectByValue("2000");
        Select selectByDay = new Select(daySelectField);
        selectByDay.selectByValue("2");
        submitAccount.click();
    }
}
