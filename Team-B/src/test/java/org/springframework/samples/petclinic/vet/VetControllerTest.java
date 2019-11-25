package org.springframework.samples.petclinic.vet;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.util.Utils;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class VetControllerTest {
    private ChromeDriver driver;
    Utils utils;

    public VetControllerTest(ChromeDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

    @Test   //Kris - This tests whether the Vets page opens when pressed.
    void VerifyOpenVets(){
        utils.goToPage();
        WebElement vetlink = driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[4]/a"));
        vetlink.click();
        utils.pause(500);

        WebElement header = driver.findElement(By.tagName("h2"));

        assertEquals(header.getText().trim(),"Veterinarians");
    }



}
