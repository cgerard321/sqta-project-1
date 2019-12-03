package org.springframework.samples.petclinic.pet;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;
import org.springframework.samples.petclinic.util.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SeleniumExtension.class)
public class PetControllerTest {
    private ChromeDriver driver;
    Utils utils;


    public PetControllerTest(ChromeDriver driver) {

        this.driver = driver;
        utils = new Utils(driver);
    }
     @Test
      void AddPet() throws ParseException {
         Pet newPet = new Pet();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd");
         String date = "2020-02-05";
         //convert String to LocalDate
         LocalDate localDate = LocalDate.parse(date, formatter);
         newPet.setBirthDate(localDate); //No fucking idea
         PetType np = new PetType();
         np.setName("cat");
         utils.pause(500);
         newPet.setType(np);
         newPet.setName("Pet1");
         utils.pause(500);
        utils.goToPage("owners/1/pets/new");
        driver.findElement(By.id("name")).sendKeys(newPet.getName());
        driver.findElement(By.id("birthDate")).sendKeys(newPet.getBirthDate().toString());
        WebElement typePet = driver.findElement(By.id("type"));
         utils.pause(500);
         Select dropdown = new Select(typePet);
         dropdown.selectByVisibleText(newPet.getType().toString());
         utils.pause(5000);
         driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button")).click();
         utils.pause(5000);

         WebElement name = driver.findElement(By.xpath("//*[text()='"+newPet.getName()+"']"));
         WebElement brd = driver.findElement(By.xpath("//*[text()='"+newPet.getBirthDate().toString()+"']"));
         WebElement typ =  driver.findElement(By.xpath("//*[text()='"+newPet.getType().toString()+"']"));
         assertTrue(name.isDisplayed());
         assertTrue(brd.isDisplayed());
         assertTrue(typ.isDisplayed());

         utils.pause(5000);

     }
}
