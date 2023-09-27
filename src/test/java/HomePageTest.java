import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BestsellersPage;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageTest extends TestBase {
    private BestsellersPage bestsellersPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        System.out.println(driver.getTitle());
        Assertions.assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        bestsellersPage = new BestsellersPage(driver);
    }

    @Test
    public void shouldSeeBestsellers() {

        bestsellersPage.clickBestsellersButton();
        List<String> bestsellersNamesList = bestsellersPage.getBestsellersNames();

        List<String> bestsellersEmptyNamesList = bestsellersNamesList.stream()
                .filter(String::isEmpty)
                .collect(Collectors.toList());

        Assertions.assertThat(bestsellersEmptyNamesList).isEmpty();
    }
}
