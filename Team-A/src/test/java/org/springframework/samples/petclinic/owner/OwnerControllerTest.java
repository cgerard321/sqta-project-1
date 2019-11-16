package org.springframework.samples.petclinic.owner;

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
public class OwnerControllerTest {

    ChromeDriver driver;

    public OwnerControllerTest(ChromeDriver driver) {
        this.driver = driver;
    }

    @Test
    public void Test_petClinic_UniqueName(ChromeDriver driver){
        driver.get("http://localhost:8090/owners/find");

        //find textbox on the page
        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));

        //enter a unique name in the textbox, which is Franklin in this case
        textBox.sendKeys("Franklin");

        //hit the "find owners" button
        WebElement findOwnerButton = driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button"));
        findOwnerButton.click();

        //get information on the page
        WebElement webfullName = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td"));
        WebElement webaddress = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td"));
        WebElement webcity = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[3]/td"));
        WebElement webtelephone = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[4]/td"));

        //create strings to compare the displayed information
        String name = "George Franklin";
        String address = "110 W. Liberty St.";
        String city = "Madison";
        String phone = "6085551023";

        //assert the elements on the page are correct
        assertThat(webfullName.getText(), is(name));
        assertThat(webaddress.getText(), is(address));
        assertThat(webcity.getText(), is(city));
        assertThat(webtelephone.getText(), is(phone));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();

    }

    @Test
    public void Test_petClinic_CommonNames(ChromeDriver driver){
        driver.get("http://localhost:8090/owners/find");

        //find textbox on the page
        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));

        //enter a common name in the textbox, which is Davis in this case
        textBox.sendKeys("Davis");

        //hit the "find owners" button
        WebElement findOwnerButton = driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button"));
        findOwnerButton.click();

        //get information on the page
        WebElement webFirstOwner = driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[1]"));
        WebElement webSecondOwner = driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[2]/td[1]"));

        //create strings to compare the displayed information
        String firstOwnerName = "Betty Davis";
        String secondOwnerName = "Harold Davis";

        //assert the elements on the page are correct
        assertThat(webFirstOwner.getText(), is(firstOwnerName));
        assertThat(webSecondOwner.getText(), is(secondOwnerName));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();

    }

    @Test
    public void Test_petClinic_SubstringName(ChromeDriver driver){
        driver.get("http://localhost:8090/owners/find");

        //find textbox on the page
        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));

        //enter a substring of a name in the textbox, which is Fran in this case
        textBox.sendKeys("Fran");

        //hit the "find owners" button
        WebElement findOwnerButton = driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button"));
        findOwnerButton.click();

        //get information on the page
        WebElement webfullName = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td"));
        WebElement webaddress = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td"));
        WebElement webcity = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[3]/td"));
        WebElement webtelephone = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[4]/td"));

        //create strings to compare the displayed information
        String name = "George Franklin";
        String address = "110 W. Liberty St.";
        String city = "Madison";
        String phone = "6085551023";

        //assert the elements on the page are correct
        assertThat(webfullName.getText(), is(name));
        assertThat(webaddress.getText(), is(address));
        assertThat(webcity.getText(), is(city));
        assertThat(webtelephone.getText(), is(phone));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();

    }

    @Test
    public void Test_petClinic_NotCaseSensitiveName(ChromeDriver driver){
        driver.get("http://localhost:8090/owners/find");

        //find textbox on the page
        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));

        //enter a name with random capital letter in the textbox, which is fRaNkLiN in this case
        textBox.sendKeys("fRaNkLiN");

        //hit the "find owners" button
        WebElement findOwnerButton = driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button"));
        findOwnerButton.click();

        //get information on the page
        WebElement webfullName = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td"));
        WebElement webaddress = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td"));
        WebElement webcity = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[3]/td"));
        WebElement webtelephone = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[4]/td"));

        //create strings to compare the displayed information
        String name = "George Franklin";
        String address = "110 W. Liberty St.";
        String city = "Madison";
        String phone = "6085551023";

        //assert the elements on the page are correct
        assertThat(webfullName.getText(), is(name));
        assertThat(webaddress.getText(), is(address));
        assertThat(webcity.getText(), is(city));
        assertThat(webtelephone.getText(), is(phone));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();

    }

    @Test
    public void Test_petClinic_NoNameEntered(ChromeDriver driver){
        driver.get("http://localhost:8090/owners/find");

        //find textbox on the page
        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));

        //enter a name which doesnt exist, which is Ariane in this case
        textBox.sendKeys("Ariane");

        //hit the "find owners" button
        WebElement findOwnerButton = driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button"));
        findOwnerButton.click();

        //get information on the page
        WebElement notFoundError = driver.findElement(By.xpath("//*[@id=\"lastNameGroup\"]/div/span/div/p"));

        //create strings to compare the displayed information
        String error = "has not been found";

        //assert the elements on the page are correct
        assertThat(notFoundError.getText(), is(error));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();

    }

}
