package org.springframework.samples.petclinic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class VetTest {
    private final String PATH = "C:\\ChromeDriver\\chromedriver.exe";
    private final String BROWSER = "webdriver.chrome.driver";
    private final String SCREENSHOTS = "C:\\ChromeDriver\\Screenshots";
    private ChromeDriver driver;

    public VetTest(ChromeDriver driver) {
        this.driver = driver;
        System.setProperty(BROWSER,PATH);
    }

    @Test
    void VerifyOpenVets(){
        driver.get("http://localhost:6969");
        GoToVetPage();
        pause();

        WebElement header = driver.findElement(By.tagName("h2"));

        assertEquals(header.getText().trim(),"Veterinarians");
    }
    void GoToVetPage(){
        driver.get("http://localhost:6969");
        WebElement vetlink = driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[4]/a"));

        vetlink.click();
    }

    void pause(){
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
