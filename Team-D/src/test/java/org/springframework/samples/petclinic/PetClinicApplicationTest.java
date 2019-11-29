package org.springframework.samples.petclinic;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class PetClinicApplicationTest {

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
    public void homepage_test(){
        // Test to see if homepage button works.
        // Open website, changes page then return to homepage through home button in the nav bar.

        System.setProperty(BROWSER,PATH);
        ChromeDriver driver = new ChromeDriver();

        //Open Website
        driver.get("localhost:8080");
        driver.manage().window().maximize();

        //Click owner page tab
        WebElement findowner = driver.findElementByXPath("//a[@href='/owners/find']");
        findowner.click();

        //Click home page tab
        WebElement homepage = driver.findElementByXPath("//a[@title='home page']");
        homepage.click();

        // Assert test successful or not
        String url = driver.getCurrentUrl();
        System.out.println("url = "+url);
        assertEquals(url,"http://localhost:8080/");

        // Close browser
        driver.close();
    }

}
