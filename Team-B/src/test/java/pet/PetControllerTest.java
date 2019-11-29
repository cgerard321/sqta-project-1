package pet;


import com.github.javafaker.Faker;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.samples.petclinic.util.Utils;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)


public class PetControllerTest {

    private ChromeDriver driver;
    private Utils utils;
    private Faker faker;

    PetControllerTest(ChromeDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
        faker = new Faker(new Locale("en-CA"));
    }

    @Test //Amin This is the test that verifies if pet values can be updated
  public void editPet_Test() throws InterruptedException {
        String petName="Zizou";
        String date="2000-01-02";
        String type="dog";

        utils.goToPage("owners?lastName=");

        WebElement anOwner =driver.findElement(By.xpath("//table[@id='owners']/tbody/tr/td[1]/a"));
        anOwner.click();

        WebElement editPetLink = driver.findElement(By.linkText("Edit Pet"));
        editPetLink.click();

        WebElement petNameTxtBox = driver.findElement(By.id("name"));
        petNameTxtBox.clear();
        petNameTxtBox.sendKeys(petName);

        WebElement birthDateTxtBox = driver.findElement(By.id("birthDate"));
        birthDateTxtBox.clear();
        birthDateTxtBox.sendKeys(date);

        Select dropType = new Select(driver.findElement(By.name("type")));
        dropType.selectByVisibleText(type);

        WebElement updateButton = driver.findElement(By.xpath("//button[@type='submit']"));
        updateButton.click();

        WebElement newPetName =driver.findElement(By.xpath("//table[@class='table table-striped'][2]/tbody/tr/td/dl/dd[1]"));
        WebElement newBirthDate =driver.findElement(By.xpath("//table[@class='table table-striped'][2]/tbody/tr/td/dl/dd[2]"));
        WebElement newType =driver.findElement(By.xpath("//table[@class='table table-striped'][2]/tbody/tr/td/dl/dd[3]"));

        assertEquals(newPetName.getText(),petName);
        assertEquals(newBirthDate.getText(),date);
        assertEquals(newType.getText(),type);
    }
}
