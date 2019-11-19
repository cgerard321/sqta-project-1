package org.springframework.samples.petclinic;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import util.Utils;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class PetClinicApplicationTest {
    private final String PATH="C:\\Users\\aladd\\IdeaProjects\\ChromeDriver\\chromedriver.exe";
    private final String BROWSER="webdriver.chrome.driver";

    public ChromeDriver driver;

    public PetClinicApplicationTest(ChromeDriver driver) {
        this.driver = driver;

        System.setProperty(BROWSER,PATH);
    }

    @Test
    public void searchForOwner_Test()
    {
        Utils.accessFindOwnersPage_Test(driver);

        WebElement searchOwnerBox= driver.findElement(By.id("lastname"));
        searchOwnerBox.sendKeys("Franklin");

        WebElement submitButton = driver.findElement(By.xpath("//div[@class='col-sm-offset-2 col-sm-10']/buttonp[1]"));
        submitButton.click();

        WebElement pTitle =driver.findElement(By.tagName("h2"));

        assertEquals(pTitle.getText(),"Owner Information");

    }

}
