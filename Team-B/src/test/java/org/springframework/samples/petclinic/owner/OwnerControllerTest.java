package org.springframework.samples.petclinic.owner;

import com.github.javafaker.Faker;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class OwnerControllerTest {
    ChromeDriver driver;

    OwnerControllerTest(ChromeDriver driver) {
        this.driver = driver;
    }

    //Fake data info to be used for tests with a canadian name locale
    Faker faker = new Faker(new Locale("en-CA"));
    //private WebDriver driver = new ChromeDriver();

    @Test
    public void TestPressingTheAddOwnerButtonOpensThePage() throws InterruptedException {
        driver.get("http://localhost:6969/owners/find");
        driver.findElement(By.xpath("/html/body/div/div/a")).click();

        Thread.sleep(500);

        assertEquals("Add Owner",driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button")).getText());
    }

    @Test
    public void TestSubmittingWithEmptyFieldsRaisesErrors() throws InterruptedException {
        driver.get("http://localhost:6969/owners/new");
        driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button")).click();

        Thread.sleep(500);

        assertEquals("must not be empty", driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[1]/div[1]/div/span[2]")).getText());
    }

    @Test
    public void TestSuccessfulOwnerCreation() throws InterruptedException {
        driver.get("http://localhost:6969/owners/new");

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String address = faker.address().streetAddress();
        String city = faker.address().city();
        String phoneNumber = faker.phoneNumber().cellPhone();

        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lastName);
        driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys(address);
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(city);
        driver.findElement(By.xpath("//*[@id=\"telephone\"]")).sendKeys(phoneNumber.substring(0, 3) + phoneNumber.substring(4, 7) + phoneNumber.substring(8, 12));

        driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button")).click();

        Thread.sleep(500);

        assertEquals(firstName +" "+lastName, driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td")).getText());
        assertEquals(address, driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td")).getText());
    }
}
