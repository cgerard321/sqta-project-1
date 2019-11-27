package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class FredTest {

    // Change path depending on PC
    private final String PATH = "C:\\Users\\Frederic\\Desktop\\Session 9\\QA\\sqta-project-1\\sqta-project-1\\Team-D\\ChromeDriver\\chromedriver78.exe";
    private final String BROWSER = "webdriver.chrome.driver";
    private final String SCREENSHOT = "C:\\Users\\Frederic\\Desktop\\Session 9\\QA\\sqta-project-1\\sqta-project-1\\Team-D\\screenshots";

    ChromeDriver driver;
    @Test
    public void addVisit_test() {
        System.setProperty(BROWSER,PATH);
        ChromeDriver driver = new ChromeDriver();

        //Open Page
        driver.get("localhost:8080/owners/1");
        driver.manage().window().maximize();

        //Click add visit button tab
        WebElement findvisit = driver.findElementByXPath("//a[@href='1/pets/1/visits/new']");
        findvisit.click();

        //wait 1 second
        try {Thread.sleep(1000);} catch (Exception e) {}
        WebElement description = driver.findElementById("description");
        description.sendKeys("Test Description!");
        description.submit();
        //wait 1 second

        try {Thread.sleep(1000);} catch (Exception e) {}
        WebElement descField = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[2]"));

        String descFieldString = descField.getText();
        assertEquals(descFieldString,"Test Description!");
        // Close browser
        driver.close();

    }
}
