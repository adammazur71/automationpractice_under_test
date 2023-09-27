import enums.MonthOfBirth;
import model.PersonalData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AuthenticationPage;
import pages.ContactForm;
import pages.PersonalInformationFormPage;
import pages.TopMenu;
import utils.PageTitleUtils;

public class NewUserRegistrationTest extends TestBase {
    private TopMenu topMenu;
    private AuthenticationPage authenticationPage;
    private PersonalInformationFormPage personalInformationFormPage;
    private ContactForm contactForm;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        System.out.println(driver.getTitle());
        Assertions.assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenu = new TopMenu(driver);
        authenticationPage = new AuthenticationPage(driver);
        personalInformationFormPage = new PersonalInformationFormPage(driver);
        contactForm = new ContactForm(driver);
    }

    @Test
    public void registerNewUser() {
        topMenu.clickOnSignInButton();
        authenticationPage.createAnAccount("kolo1@web.pl");
        PersonalData personalData = new PersonalData();
        personalData.setNewPassword("karmagedon");
        personalData.setLastName("Marcinkiewicz");
        personalData.setFirstName("Marcin");
        personalData.setMonthOfBirth(MonthOfBirth.AUGUST);
        personalInformationFormPage.sendRegistrationForm(personalData);

        Assertions.assertThat(contactForm.checkIfGreenAlertBoxIsPresent()).isTrue();

    }
}
