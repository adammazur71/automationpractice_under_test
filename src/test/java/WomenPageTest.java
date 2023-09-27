import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TopMenu;
import pages.WomenPage;
import utils.PageTitleUtils;

import java.util.List;

public class WomenPageTest extends TestBase {

    private WomenPage womenPage;
    private TopMenu topMenu;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        System.out.println(driver.getTitle());
        Assertions.assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);
        womenPage = new WomenPage(driver);
        topMenu = new TopMenu(driver);
    }

    @Test
    public void checkIfWomenItemsPriceAreNotZero() {
        topMenu.clickOnWomenButton();
        List<String> womenPriceList = womenPage.getZeroPrice();
        Assertions.assertThat(womenPriceList).isEmpty();
    }
}

