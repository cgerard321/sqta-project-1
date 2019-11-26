package org.springframework.samples.petclinic.owner;

import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class OwnerTest {
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
    public void addOwner_test() {

        System.setProperty(BROWSER,PATH);
        ChromeDriver driver = new ChromeDriver();

        //Open Page
        driver.get("localhost:8080");
        driver.manage().window().maximize();

        //Click owner page tab
        WebElement findowner = driver.findElementByXPath("//a[@href='/owners/find']");
        findowner.click();

        //Click Add owner button
        WebElement addowner = driver.findElementByXPath("//a[@href='/owners/new']");
        addowner.click();

        // Find Form inputs
        WebElement fname = driver.findElementById("firstname");
        WebElement lname = driver.findElementById("lastname");
        WebElement address = driver.findElementById("address");
        WebElement city = driver.findElementById("city");
        WebElement telephone = driver.findElementById("telephone");

        // Send data to form
        fname.sendKeys("Kevin");
        lname.sendKeys("Hong");
        address.sendKeys("1111 Dog");
        city.sendKeys("Quebec");
        telephone.sendKeys("5141234567");

        // Submits form
        fname.submit();

        // Assert test successful or not
        WebElement editowner = driver.findElement(By.xpath("//*[contains(text(), 'Owner Information')]"));
        String editownerString = editowner.getText();
        assertEquals(editownerString,"Owner Information");

        // Close browser
        driver.close();
    }
}
