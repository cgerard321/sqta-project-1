package org.springframework.samples.petclinic.owner;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;
//import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SeleniumExtension.class)
public class STQA_42_EditOwner {

    ChromeDriver driver;

    public STQA_42_EditOwner(ChromeDriver driver)
    {
        this.driver = driver;
    }



    //Test method to see if table with owner list is displayed
    @Test
    void EditOwners(){

        //Arrange
        OpenOwnerPage();
        pause();

        // Owner modified
        Owner georgeEdited = new Owner();
        georgeEdited.setFirstName("George");
        georgeEdited.setLastName("Franklin");
        georgeEdited.setAddress("110 W. Liberty St.");
        //georgeEdited.setCity("Madison");
        georgeEdited.setCity("Montreal");
        georgeEdited.setTelephone("6085551023");


        //TODO now add method to edit a specific owner
        //Act

        //WebElement findOwnersButton = driver.findElementByXPath("//*[@id=\"search-owner-form\"]/div[2]/div/button");
        WebElement findOwnersButton = driver.findElement(By.cssSelector(".btn.btn-default"));
        findOwnersButton.click();

        WebElement openOwner = driver.findElement(By.linkText(georgeEdited.getFirstName() + " " + georgeEdited.getLastName()));
        //WebElement openOwner = driver.findElement(By.linkText("George Franklin"));
        //George Franklin

        openOwner.click();


        pause();

        WebElement clickEdit =
            driver.findElement(By.linkText("Edit Owner"));
        clickEdit.click();

        pause();


        // Editing the Owner

        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys(georgeEdited.getAddress());
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(georgeEdited.getCity());
        driver.findElement(By.id("telephone")).clear();
        driver.findElement(By.id("telephone")).sendKeys(georgeEdited.getTelephone());

        pause();

        //
        WebElement UpdateOwner =
            driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button"));
        UpdateOwner.click();

        pause();


        //Get info from
        WebElement findOwnerFullName =
            driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b"));
        String fullName = findOwnerFullName.getText();

        WebElement findOwnerAddress =
            driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td"));
        String address = findOwnerAddress.getText();

        WebElement findOwnerCity =
            driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[3]/td"));
        String city = findOwnerCity.getText();

        WebElement findOwnerTelephnone =
            driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[4]/td"));
        String telephone = findOwnerTelephnone.getText();

        pause();

        //Assert

        assertEquals(fullName, georgeEdited.getFirstName()+" "+georgeEdited.getLastName());
        assertEquals(address, georgeEdited.getAddress());
        assertEquals(city, georgeEdited.getCity());
        assertEquals(telephone, georgeEdited.getTelephone());

    }


    //Method that open FindOwner Webpage from nav
    public void OpenOwnerPage(){

        driver.get("localhost:8080");

        driver.manage().window().maximize();

        WebElement findOwner = driver.findElementByXPath("//a[@href='/owners/find']");
        //WebElement findOwner = driver.findElement(By.partialLinkText("Find owners"));

        findOwner.click();

    }

    //Method that make the process pause for 2 second
    void pause(){
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
