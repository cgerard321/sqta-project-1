package org.springframework.samples.petclinic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class sqta8Test {
    // Change path depending on PC
    private final String PATH = "C:\\Users\\Frederic\\Desktop\\Session 9\\QA\\sqta-project-1\\sqta-project-1\\Team-D\\ChromeDriver\\chromedriver78.exe";
    private final String BROWSER = "webdriver.chrome.driver";
    private final String SCREENSHOT = "C:\\Users\\Frederic\\Desktop\\Session 9\\QA\\sqta-project-1\\sqta-project-1\\Team-D\\screenshots";

    ChromeDriver driver;
    @Test
    public void addPet_test() {
        System.setProperty(BROWSER,PATH);
        ChromeDriver driver = new ChromeDriver();

        //Open Page
        driver.get("localhost:8080/owners/1");
        driver.manage().window().maximize();

        //Click add visit button tab
        WebElement addPetButton = driver.findElementByXPath("//a[@href='1/pets/new']");
        addPetButton.click();

        //wait 1 second
        try {Thread.sleep(1000);} catch (Exception e) {}
        WebElement name = driver.findElementById("name");
        name.sendKeys("petNameTest3");
        WebElement petBirthDate = driver.findElementById("birthDate");
        petBirthDate.sendKeys("2015-10-15");
        name.submit();
        //wait 1 second

        try {Thread.sleep(1000);} catch (Exception e) {}
        WebElement nameField = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr[last()]/td[1]/dl/dd[1]"));
        String nameFieldString = nameField.getText();
        assertEquals(nameFieldString,"petNameTest3");
        // Close browser
        driver.close();

    }
}