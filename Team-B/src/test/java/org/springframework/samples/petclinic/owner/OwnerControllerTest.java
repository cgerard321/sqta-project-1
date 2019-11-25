package org.springframework.samples.petclinic.owner;

import com.github.javafaker.Faker;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.util.Utils;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class OwnerControllerTest {
    private ChromeDriver driver;
    private Utils utils;
    private Faker faker;

    OwnerControllerTest(ChromeDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
        faker = new Faker(new Locale("en-CA"));
    }


    @Test   //Remi - This tests whether or not "Add Owner" button opens the page.
    public void TestPressingTheAddOwnerButtonOpensThePage() throws InterruptedException {
        utils.goToPage("owners/find");
        driver.findElement(By.xpath("/html/body/div/div/a")).click();

        utils.pause(500);

        assertEquals("Add Owner",driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button")).getText());
    }

    @Test   //Remi - This tests whether or not validation detects empty fields.
    public void TestSubmittingWithEmptyFieldsRaisesErrors() throws InterruptedException {
        utils.goToPage("owners/new");
        driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button")).click();

        utils.pause(500);

        assertEquals("must not be empty", driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[1]/div[1]/div/span[2]")).getText());
    }

    @Test   //Remi - This tests whether or not owners can be created.
    public void TestSuccessfulOwnerCreation() throws InterruptedException {
        utils.goToPage("owners/new");

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String address = faker.address().streetAddress();
        String city = faker.address().city();
        String phoneNumber = "1111111111";

        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lastName);
        driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys(address);
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(city);
        driver.findElement(By.xpath("//*[@id=\"telephone\"]")).sendKeys(phoneNumber.substring(0, 3) + phoneNumber.substring(4, 7) + phoneNumber.substring(8, 12));

        driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button")).click();

        utils.pause(5000);

        assertEquals(firstName +" "+lastName, driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td")).getText());
        assertEquals(address, driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td")).getText());
    }

    @Test   //Amin - This tests whether or not the user can search for owners.
    public void SearchForOwnerTest() throws InterruptedException {
        utils.goToPage("owners/find");

        WebElement searchOwnerBox= driver.findElement(By.id("lastname"));
        searchOwnerBox.sendKeys("Franklin");

        WebElement submitButton = driver.findElement(By.xpath("//div[@class='col-sm-offset-2 col-sm-10']/button[1]"));
        submitButton.click();

        WebElement pTitle =driver.findElement(By.tagName("h2"));

        assertEquals(pTitle.getText(),"Owner Information");

    }

    @Test   //Kris - This tests whether or not "Find Owners" button opens the page.
    void OpenFindOwnersTest() throws InterruptedException{
        utils.goToPage();
        WebElement ownerlink = driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a"));

        ownerlink.click();
        utils.pause(500);

        WebElement header = driver.findElement(By.tagName("h2"));

        assertEquals(header.getText().trim(),"Find Owners");
    }

    @Test   //Danyyil - This tests whether or not users can select an owner.
    public void SelectOwnerTest() throws InterruptedException {
        //Arrange
        Owner frank = new Owner();
        frank.setFirstName("George");
        frank.setLastName("Franklin");
        frank.setAddress("110 W. Liberty St.");
        frank.setCity("Madison");
        frank.setTelephone("6085551023");

        utils.goToPage("owners?lastName=");
/*
        WebElement ownerlink =
            driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a"));
        ownerlink.click();
        WebElement lastName =
            driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastName.sendKeys(  frank.getFirstName());
        WebElement findOwner =
            driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button"));
        findOwner.click();*/

        //Assert
        WebElement findOwnerLastFirstName =
            driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[1]/a"));
        String firstLast = findOwnerLastFirstName.getText();
        WebElement findOwnerAddress =
            driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[2]"));
        String address = findOwnerAddress.getText();
        WebElement findOwnerCity =
            driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[3]"));
        String city = findOwnerCity.getText();
        WebElement findOwnerTelephnone =
            driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[4]"));
        String telephone = findOwnerTelephnone.getText();

        utils.pause(500);
        assertEquals(firstLast, frank.getFirstName()+" "+frank.getLastName());
        assertEquals(address, frank.getAddress());
        assertEquals(city, frank.getCity());
        assertEquals(telephone, frank.getTelephone());
    }

    @Test   //Danyyil - This tests whether or not users can edit owners.
    public void EditOwnerTest() throws InterruptedException {
        //Arrange
        Owner frank = new Owner();
        frank.setFirstName("George");
        frank.setLastName("Franklin");
        frank.setAddress("110 W. Liberty St.");
        frank.setCity("Madison");
        frank.setTelephone("6085551023");

        Owner frank1 = new Owner();
        frank1.setFirstName("GeorGe");
        frank1.setLastName("FrankLin");
        frank1.setAddress("110 W. Liberty St.");
        frank1.setCity("MadiSon");
        frank.setTelephone("60855510231");

        //Act
        utils.goToPage("owners?lastName=");
        WebElement enterEdit =
            driver.findElement(By.linkText(frank.getFirstName() + " " + frank.getLastName()));
        enterEdit.click();
        WebElement clickEdit =
            driver.findElement(By.linkText("Edit Owner"));
        clickEdit.click();

        utils.pause(3000);

        driver.findElement(By.id("firstName")).sendKeys(frank1.getFirstName());
        driver.findElement(By.id("lastName")).sendKeys(frank1.getLastName());
        driver.findElement(By.id("address")).sendKeys(frank1.getAddress());
        driver.findElement(By.id("city")).sendKeys(frank1.getCity());
        driver.findElement(By.id("telephone")).sendKeys(frank1.getTelephone());
        utils.pause(3000);
        WebElement UpdateOwner =
            driver.findElement(By.linkText("Update Owner"));
        UpdateOwner.click();


        //Assert
        WebElement findOwnerLastFirstName =
            driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[1]/a"));
        String firstLast = findOwnerLastFirstName.getText();
        WebElement findOwnerAddress =
            driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[2]"));
        String address = findOwnerAddress.getText();
        WebElement findOwnerCity =
            driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[3]"));
        String city = findOwnerCity.getText();
        WebElement findOwnerTelephnone =
            driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[4]"));
        String telephone = findOwnerTelephnone.getText();

        utils.pause(3000);

        assertEquals(firstLast, frank1.getLastName()+" "+frank1.getFirstName());
        assertEquals(address, frank1.getAddress());
        assertEquals(city, frank1.getCity());
        assertEquals(telephone, frank1.getTelephone());

    }
}
