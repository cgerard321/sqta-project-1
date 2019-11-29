package org.springframework.samples.petclinic.owner;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class CheckIfOwnerExistsTest {

    private final String PATH = "C:\\Users\\Karim\\IdeaProjects\\ChromeDrive";
    private final String BROWSER = "webdriver.chrome.driver";
    private final String SCREENSHOT = "C:\\Users\\Karim\\Google Drive\\Champlain Work\\Semester 5\\Quality Assurance";

    ChromeDriver driver;

    public CheckIfOwnerExistsTest(ChromeDriver driver) {
        this.driver = driver;
        System.setProperty(BROWSER,PATH);
    }

    @Test
    public void AddOwner(){
        driver.get("localhost:8090");

        WebElement findButton = driver.findElementByXPath("//*[@id=\"main-navbar\"]/ul/li[3]/a");
        findButton.click();

        WebElement addOwnerButton = driver.findElementByXPath("/html/body/div/div/a");
        addOwnerButton.click();


        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Karim");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Ibrahim");

        WebElement address = driver.findElement(By.name("address"));
        address.sendKeys("123 demo");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("demo city");

        WebElement phone = driver.findElement(By.name("telephone"));
        phone.sendKeys("1234567890");

        WebElement addButton = driver.findElementByXPath("//*[@id=\"add-owner-form\"]/div[2]/div/button");
        addButton.click();

        assertThat(driver.getPageSource().contains("Owner Information"), is(true));

    }

}
