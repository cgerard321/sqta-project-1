package org.springframework.samples.petclinic.owner;
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
    ChromeDriver driver = new ChromeDriver();

    @Test
    public void Test_petClinic_OpenFindOwnersPage(){
        driver.get("http://localhost:8090");

        //find a name on the page and click
        WebElement findOwnersLink = driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a"));
        findOwnersLink.click();

        //find elements
        WebElement titleFindOwners = driver.findElement(By.xpath("/html/body/div/div/h2"));

        //assert the element is on the page
        assertThat(titleFindOwners.isDisplayed(), is(true));
        assertThat(titleFindOwners.getText(), is("Find Owners"));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }

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

        for (WebElement webElement : petsList) {
            all_pets.add(webElement.getText());
        }

        //click on the name
        nameLink.click();

        //find elements on the details page
        WebElement newName = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b"));

        //assert the element name is on the page
        assertThat(newName.getText(), is(name));

        for (String petsText : all_pets) {
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

/*****************************************
This is a test comment added by cgerard321
Added by a different student
This is a comment to simulate a merge conflict....
---------------------------------------------------
Old comment is above
First new comment is below
--------------------------------------------------
added as part of MERGE-1
I am showing how to resolve a merge conflict.Comments added by second developer to simulate a merge conflict
 ******************************************/

