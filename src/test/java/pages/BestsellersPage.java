package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class BestsellersPage extends PageBase {
    public BestsellersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#home-page-tabs .blockbestsellers")
    WebElement bestsellersButton;

    public void clickBestsellersButton() {
        bestsellersButton.click();
    }

    @FindBy(css = "#blockbestsellers .product-name")
    List<WebElement> bestsellersNames;

    public List<String> getBestsellersNames() {
        return bestsellersNames.stream()
                .map(s -> s.getText().trim())
                .collect(Collectors.toList());
    }
}

