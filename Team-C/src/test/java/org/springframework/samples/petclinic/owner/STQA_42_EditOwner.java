package org.springframework.samples.petclinic.owner;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;


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

        //TODO now add method to edit a specific owner


        //Act

        //WebElement findOwnersButton = driver.findElementByXPath("//*[@id=\"search-owner-form\"]/div[2]/div/button");
        WebElement findOwnersButton = driver.findElement(By.cssSelector(".btn.btn-default"));
        findOwnersButton.click();

        WebElement ownersTable = driver.findElementByXPath("//*[@id=\"owners\"]");
        pause();

        //Assert

        assertThat(ownersTable.isDisplayed(), is(true));
        //assertEquals(header.getText().trim(),"Find Owners");
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
