import enums.MessageSubject;
import model.Message;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactForm;
import pages.TopMenu;
import utils.PageTitleUtils;


public class ContactFormTest extends TestBase {
    private ContactForm contactForm;
    private TopMenu topMenu;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        System.out.println(driver.getTitle());
        Assertions.assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        contactForm = new ContactForm(driver);
        topMenu = new TopMenu(driver);
    }


    @Test
    public void shouldSeeErrorInfoAfterCleanSubmit() {

        topMenu.clickOnContactUsLink();
        contactForm.clickSubmitMessageButton();
        Assertions.assertThat(contactForm.checkIfAlertBoxIsPresent()).isTrue();
    }

    @Test
    public void shouldSeeErrorInfoAfterSubmitWithEmailOnly() {
        topMenu.clickOnContactUsLink();
        contactForm.insertEmail("adam@adam.pl");
        contactForm.clickSubmitMessageButton();
        Assertions.assertThat(contactForm.checkIfAlertBoxIsPresent()).isTrue();
    }

    @Test
    public void shouldSeeOkInfoAfterSubmitWithCorrectAllData() {
        topMenu.clickOnContactUsLink();
        Message message = new Message();
        message.setMessageSubject(MessageSubject.WEBMASTER);
        message.setOrderReference("1234");
        message.setEmail("hzdkv@example.com");
        message.setMessage("jakas ciekawa wiadomosc");
        contactForm.submitContactForm(message);
        Assertions.assertThat(contactForm.checkIfGreenAlertBoxIsPresent()).isTrue();
    }
}
