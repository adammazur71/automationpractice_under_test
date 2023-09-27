import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchResultPage;
import pages.TopMenu;
import pages.WomenPage;
import utils.PageTitleUtils;

import java.util.List;

public class SearchResultTest extends TestBase {
    private TopMenu topMenu;
    private SearchResultPage searchResultPage;
    private WomenPage womenPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        System.out.println(driver.getTitle());
        Assertions.assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        searchResultPage = new SearchResultPage(driver);
        topMenu = new TopMenu(driver);
        womenPage = new WomenPage(driver);

    }

    @Test
    public void searchTest() {
        topMenu.enterSearchQueryTop("blouse");
        org.junit.jupiter.api.Assertions.assertEquals(searchResultPage.getCountOfMatchedResults(), searchResultPage.getCountOfSearchResults());
    }

    @Test
    public void checkIfSearchedItemsPriceAreNotZero() {
        topMenu.enterSearchQueryTop("blouse");
        List<String> searchResultPriceList = womenPage.getZeroPrice();

        Assertions.assertThat(searchResultPriceList).isEmpty();
    }
}
