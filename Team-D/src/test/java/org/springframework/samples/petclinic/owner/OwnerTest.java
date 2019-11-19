package org.springframework.samples.petclinic.owner;

import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class VetTest {

    ChromeDriver driver;

    private final String PATH = "C:\\Users\\F248Master\\Downloads\\sqtaProject\\sqta-project-1\\Team-D\\ChromeDriver2\\chromedriver.exe";
    private final String BROWSER = "webdriver.chrome.driver";

//    public VetTest(ChromeDriver driver) {
//        System.setProperty(BROWSER, PATH);
//        this.driver = driver;
//    }

    @Test
    public void viewVetListTest() {

        System.setProperty(BROWSER,PATH);
        ChromeDriver driver = new ChromeDriver();

        //Open Page
        driver.get("localhost:8080");
        driver.manage().window().maximize();

        //Click veterinarians
        WebElement vet = driver.findElementByXPath("//a[@href='/vets.html']");
        vet.click();

        //Assert
        WebElement vet5 = driver.findElement(By.xpath("//*[contains(text(), 'Henry Stevens')]"));
        String henry = vet5.getText();
        assertEquals(henry,"Henry Stevens");
    }

}
