package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class WomenPage extends PageBase {

    public WomenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']/ul/li[*]/div/div[2]/div[1]/span[1]")
    List<WebElement> priceList;

    public List<String> getZeroPrice() {

        return priceList.stream()
                .map(s -> s.getText().substring(1))
                .collect(Collectors.toList())
                .stream()
                .filter(s -> s.equals("0.00"))
                .collect(Collectors.toList());
    }
}
