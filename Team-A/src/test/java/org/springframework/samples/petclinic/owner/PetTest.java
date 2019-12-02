package org.springframework.samples.petclinic.owner;

import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class PetTest {

    ChromeDriver driver;

    public PetTest(ChromeDriver driver) {
        this.driver = driver;
    }

    @Test
    public void Test_petClinic_RightPetInfo(ChromeDriver driver){
        driver.get("http://localhost:8084/owners/1");

        //find editpet link on the page
        WebElement editPetLink = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[1]"));
        editPetLink.click();

        //get information on the page
        WebElement owner = driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[1]/div"));
        WebElement name = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement birthDate = driver.findElement(By.xpath("//*[@id=\"birthDate\"]"));
        WebElement type = driver.findElement(By.xpath("//*[@id=\"type\"]"));

        //create strings to compare the displayed information
        String ownername = "George Franklin";
        String petname = "Leo";
        String petbirthDate = "2010-09-07";
        String petType = "cat";

        //assert the elements on the page are correct
        assertThat(owner.getText(), is(ownername));
        assertThat(name.getText(), is(petname));
        assertThat(birthDate.getText(), is(petbirthDate));
        assertThat(type.getText(), is(petType));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void Test_petClinic_EditPetInfo(ChromeDriver driver){
        driver.get("http://localhost:8084/owners/1/pets/1/edit");

        //get textboxes on the page
        WebElement name = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement birthday = driver.findElement(By.xpath("//*[@id=\"birthDate\"]"));
        Select dropdownType = new Select(driver.findElement(By.xpath("//*[@id=\"type\"]")));
        WebElement updatePet = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));

        //enter values in the form
        name.sendKeys("Cookie");
        birthday.sendKeys("2019-05-07");
        dropdownType.selectByVisibleText("dog");

        //click on the submit button
        updatePet.click();

        //get information on the page
        WebElement nameUpdated = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[1]"));
        WebElement birthDateUpdated = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[2]"));
        WebElement typeUpdated = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[3]"));

        //create strings to compare the displayed information
        String petname = "Cookie";
        String petbirthDate = "2019-05-07";
        String petType = "dog";

        //assert the elements on the page are correct
        assertThat(nameUpdated.getText(), is(petname));
        assertThat(birthDateUpdated.getText(), is(petbirthDate));
        assertThat(typeUpdated.getText(), is(petType));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }

}
