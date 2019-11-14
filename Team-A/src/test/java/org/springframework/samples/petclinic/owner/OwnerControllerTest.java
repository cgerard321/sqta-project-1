package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.*;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SeleniumExtension.class)
class OwnerControllerTest {


    @Test
    public void Test_petClinic_OpenDetailsOfOwnerPage(ChromeDriver driver){
        driver.get("http://localhost:8090/owners?lastName=");

        //find a name on the page and click
        WebElement nameLink = driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[7]/td[1]/a"));
        nameLink.click();

        //find element
        WebElement titleDetails = driver.findElement(By.xpath("/html/body/div/div/h2[1]"));

        //assert the element is on the page
        assertThat(titleDetails.isDisplayed(), is(true));
        assertThat(titleDetails.getText(), is("Owner Information"));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void Test_petClinic_RightDetailsOfOwner(ChromeDriver driver){
        driver.get("http://localhost:8090/owners?lastName=");

        //find a name on the page
        WebElement nameLink = driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[1]/a"));
        String name = nameLink.getText();

        //find address
        WebElement addressText = driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[2]"));
        String address = addressText.getText();

        //find city
        WebElement cityText = driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[3]"));
        String city = cityText.getText();

        //find telephone
        WebElement telephoneText = driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[4]"));
        String telephone = telephoneText.getText();

        //click on the name
        nameLink.click();

        //find elements on the details page
        WebElement newName = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b"));
        WebElement newAddress = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td"));
        WebElement newCity = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[3]/td"));
        WebElement newTelephone = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[4]/td"));

        //assert the element is on the page
        assertThat(newName.getText(), is(name));
        assertThat(newAddress.getText(), is(address));
        assertThat(newCity.getText(), is(city));
        assertThat(newTelephone.getText(), is(telephone));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void Test_petClinic_RightPetsDetailsOfOwner(ChromeDriver driver){
        driver.get("http://localhost:8090/owners?lastName=");


        //find a name on the page
        WebElement nameLink = driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[6]/td[1]/a"));
        String name = nameLink.getText();

        //find pets
        List<WebElement> petsList = driver.findElements(By.xpath("//*[@id=\"owners\"]/tbody/tr[6]/td[5]/span"));
        List<String> all_pets = new ArrayList<>();
//        assertThat(petsList.size(), is(2));

        for (WebElement webElement : petsList) {
            all_pets.add(webElement.getText());
        }

        //click on the name
        nameLink.click();

        //find elements on the details page
        WebElement newName = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b"));

        //assert the element name is on the page
        assertThat(newName.getText(), is(name));


//        assertThat(all_pets.size(), is(2));


        for (String petsText : all_pets) {
//            System.out.println(petsText);
            // WebElement pett = driver.findElement(By.xpath("//*[text()='Max']"));
            WebElement pet = driver.findElement(By.xpath("//*[text()='"+petsText+"']"));
            assertThat(pet.isDisplayed(), is(true));
        }


        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
