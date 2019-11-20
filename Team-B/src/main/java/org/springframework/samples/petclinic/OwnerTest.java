package org.springframework.samples.petclinic;

    import io.github.bonigarcia.seljup.SeleniumExtension;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;

    import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SeleniumExtension.class)
class OwnerTest {
    private final String PATH = "C:\\ChromeDriver\\chromedriver.exe";
    private final String BROWSER = "webdriver.chrome.driver";
    private final String SCREENSHOTS = "C:\\ChromeDriver\\Screenshots";
    private ChromeDriver driver;

    public OwnerTest(ChromeDriver driver) {
        this.driver = driver;
        System.setProperty(BROWSER,PATH);
    }

    @Test
    void VerifyOpenFindOwners(){
        driver.get("http://localhost:6969");
        GoToOwnersPage();
        pause();

        WebElement header = driver.findElement(By.tagName("h2"));

        assertEquals(header.getText().trim(),"Find Owners");
    }

    @Test
    void TestSelectOwner() {
        GoToOwnersListPage();

        WebElement ownerLink = driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[1]/a"));
        ownerLink.click();

        WebElement ownerInformationHeader = driver.findElement(By.xpath("/html/body/div/div/h2[1]"));
        WebElement petAndVisitsHeader = driver.findElement(By.xpath("/html/body/div/div/h2[2]"));

        assertEquals(ownerInformationHeader.getText().trim(),"Owner Information");
        assertEquals(petAndVisitsHeader.getText().trim(),"Pets and Visits");
    }

    void GoToOwnersPage(){
        driver.get("http://localhost:6969");
        WebElement ownerlink = driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a"));

        ownerlink.click();
    }

    void GoToOwnersListPage() {
        driver.get("localhost:6969/owners");
        pause();
    }

    void pause(){
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
