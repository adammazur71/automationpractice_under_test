package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenu extends PageBase {
    public TopMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#contact-link")
    WebElement contactUsLink;
    @FindBy(css = ".product_list")
    WebElement productList;
    @FindBy(css = ".center_column")
    WebElement centerColumn;
    @FindBy(id = "search_query_top")
    WebElement searchQueryTop;
    @FindBy(name = "submit_search")
    WebElement submitSearchButton;
    @FindBy(css = ".header_user_info")
    WebElement signInButton;


    public void clickOnContactUsLink() {
        contactUsLink.click();
    }

    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    WebElement womenButton;

    public void clickOnWomenButton() {
        womenButton.click();
        wait.until(ExpectedConditions.visibilityOf(productList));
    }

    public void enterSearchQueryTop(String searchQuery) {
        searchQueryTop.click();
        searchQueryTop.sendKeys(searchQuery);
        submitSearchButton.click();
        wait.until(ExpectedConditions.visibilityOf(centerColumn));
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }
}
