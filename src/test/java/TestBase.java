import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestBase {

    protected WebDriver driver;
    protected WebElement element;
    protected final String BASE_URL = "http://www.automationpractice.pl/index.php";

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
