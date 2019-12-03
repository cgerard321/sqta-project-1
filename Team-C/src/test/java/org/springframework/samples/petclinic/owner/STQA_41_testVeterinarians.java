package org.springframework.samples.petclinic.owner;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

@ExtendWith(SeleniumExtension.class)
class STQA_41_testVeterinarians {

    ChromeDriver driver;

    public STQA_41_testVeterinarians(ChromeDriver driver)
    {
        this.driver = driver;
    }

    @Test
    public void Test_Nav_To_Veterinarians(){
        driver.get("http://localhost:8080");

        WebElement findOwnersPage = driver.findElementByXPath("//*[@id=\"main-navbar\"]/ul/li[4]/a");
        findOwnersPage.click();

        WebElement findOwnersTitle = driver.findElementByXPath("/html/body/div/div/h2");
        assertThat(findOwnersTitle.getText(),is("Veterinarians"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }

}
