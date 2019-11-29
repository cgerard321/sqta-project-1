package org.springframework.samples.petclinic.visit;


import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class VisitTest {
    // Change path depending on PC
    private final String PATH = "C:\\Users\\Kevin\\Desktop\\QA\\sqta-project-1\\Team-D\\ChromeDriver\\chromedriver78.exe";
    private final String BROWSER = "webdriver.chrome.driver";
    private final String SCREENSHOT = "C:\\Users\\Kevin\\Desktop\\QA\\sqta-project-1-master\\Team-D\\Screenshots";

    ChromeDriver driver;

//    public OwnerTest(ChromeDriver driver){
//        this.driver = driver;
//        System.setProperty(BROWSER,PATH);
//    }

    @Test
    public void visit_test() {

        System.setProperty(BROWSER,PATH);
        ChromeDriver driver = new ChromeDriver();

        //Open Page
        driver.get("localhost:8080");
        driver.manage().window().maximize();

        //Click owner page tab
        WebElement owner = driver.findElementByXPath("//a[@href='/owners/find']");
        owner.click();

        //Click find owner button
        WebElement findowner = driver.findElementByXPath("//button[@type='submit']");
        findowner.click();

        //Click Jeff User
        WebElement jeff = driver.findElementByXPath("//a[@href='/owners/7']");
        jeff.click();

        //Click edit Jeff User
        WebElement editjeff = driver.findElementByXPath("//a[@href='7/pets/9/visits/new']");

        editjeff.click();

        //Change lastname to white/black depending on current name
        WebElement lastname = driver.findElementById("description");


            lastname.sendKeys("CoolDescription");


        //Click submit button to save
        WebElement save = driver.findElementByXPath("//button[@type='submit']");
        save.click();

        // Assert test successful or not depending on previous last name

            WebElement name = driver.findElement(By.xpath("//*[contains(text(), 'CoolDescription')]"));
            String nameString = name.getText();
            assertEquals(nameString,"CoolDescription");


        // Close browser
        driver.close();
    }
}
