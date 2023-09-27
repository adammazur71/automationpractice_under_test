package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends PageBase {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#center_column .lighter")
    WebElement searchQuery;
    @FindBy(xpath = "//*[@id='center_column']/ul/li[*]/div/div[2]/h5/a")
    List<WebElement> searchResultList;

    public long getCountOfMatchedResults() {
        int queryLength = searchQuery.getText().length();
        return searchResultList.stream()
                .filter(element -> element.getText().toUpperCase().contains(searchQuery.getText().substring(1, queryLength - 1).toUpperCase())).count();

    }

    public long getCountOfSearchResults() {
        return searchResultList.size();
    }
}
