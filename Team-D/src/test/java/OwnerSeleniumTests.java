import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

@ExtendWith(SeleniumExtension.class)
public class OwnerSeleniumTests {

    ChromeDriver driver;

    public OwnerSeleniumTests(ChromeDriver driver) {
        this.driver = driver;
    }

    @Test
    public void test_petClinicHomePage() {
        driver.get("localhost:8080");
        driver.manage().window().maximize();
    }
}
