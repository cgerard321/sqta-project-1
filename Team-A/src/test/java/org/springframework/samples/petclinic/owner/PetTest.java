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
        WebElement editPetLink = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[1]/a"));
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
        assertThat(name.getAttribute("value"), is(petname));
        assertThat(birthDate.getAttribute("value"), is(petbirthDate));
        assertThat(type.getAttribute("value"), is(petType));

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
        name.clear();
        name.sendKeys("Cookie");
        birthday.clear();
        birthday.sendKeys("2019-05-07");
        dropdownType.selectByVisibleText("dog");

        //click on the submit button
        updatePet.click();

        WebElement editPetLink = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[1]/a"));
        editPetLink.click();

        //get information on the page
        WebElement nameupdated = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement birthUpdated = driver.findElement(By.xpath("//*[@id=\"birthDate\"]"));
        WebElement typeUpdated = driver.findElement(By.xpath("//*[@id=\"type\"]"));

        //create strings to compare the displayed information
        String petname = "Cookie";
        String petbirthDate = "2019-05-07";
        String petType = "dog";

        //assert the elements on the page are correct
        assertThat(nameupdated.getAttribute("value"), is(petname));
        assertThat(birthUpdated.getAttribute("value"), is(petbirthDate));
        assertThat(typeUpdated.getAttribute("value"), is(petType));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void Test_petClinic_NoDataEntered(ChromeDriver driver){
        driver.get("http://localhost:8084/owners/1/pets/1/edit");

        //get textboxes on the page
        WebElement name = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement birthday = driver.findElement(By.xpath("//*[@id=\"birthDate\"]"));
        WebElement updatePet = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));

        //enter values in the form
        name.clear();
        birthday.clear();

        //click on the submit button
        updatePet.click();

        //get information on the page
        WebElement error1 = driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[2]/div/span[2]"));
        WebElement error2 = driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[3]/div/span[2]"));

        //create strings to compare the displayed information
        String errorMessage1 = "is required";
        String errorMessage2 = "is required";

        //assert the elements on the page are correct
        assertThat(error1.getText(), is(errorMessage1));
        assertThat(error2.getText(), is(errorMessage2));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }

}
