package org.springframework.samples.petclinic;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.samples.petclinic.owner.Owner;
import util.Utils;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class PetClinicApplicationTest {
    private final String PATH="C:\\Users\\aladd\\IdeaProjects\\ChromeDriver\\chromedriver.exe";
    private final String BROWSER="webdriver.chrome.driver";

    public ChromeDriver driver;

    public PetClinicApplicationTest(ChromeDriver driver) {
        this.driver = driver;

        System.setProperty(BROWSER,PATH);
    }

    @Test
    public void searchForOwner_Test()
    {
        Utils.accessFindOwnersPage_Test(driver);

        WebElement searchOwnerBox= driver.findElement(By.id("lastname"));
        searchOwnerBox.sendKeys("Franklin");

        WebElement submitButton = driver.findElement(By.xpath("//div[@class='col-sm-offset-2 col-sm-10']/buttonp[1]"));
        submitButton.click();

        WebElement pTitle =driver.findElement(By.tagName("h2"));

        assertEquals(pTitle.getText(),"Owner Information");

    }

    @Test
    public void Select_Owner()
    {
        //Arrange
        Owner frank = new Owner();
        frank.setFirstName("George");
        frank.setLastName("Franklin");
        frank.setAddress("110 W. Liberty St.");
        frank.setCity("Madison");
        frank.setTelephone("6085551023");
        this.driver.get("localhost:6969");
        WebElement ownerlink =
            driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a"));
        ownerlink.click();
        WebElement lastName =
            driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastName.sendKeys(  frank.getFirstName());
        WebElement findOwner =
            driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button"));
        findOwner.click();

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
        try{

            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(firstLast, frank.getLastName()+" "+frank.getFirstName());
        assertEquals(address, frank.getAddress());
        assertEquals(city, frank.getCity());
        assertEquals(telephone, frank.getTelephone());
    }

    @Test
    public void Edit_Owner()
    {
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

        WebElement enterEdit =
            driver.findElement(By.linkText(frank.getFirstName() + " " + frank.getLastName()));
        enterEdit.click();
        WebElement clickEdit =
            driver.findElement(By.linkText("Edit Owner"));
        clickEdit.click();


        driver.findElement(By.id("fistName")).sendKeys(frank1.getFirstName());
        driver.findElement(By.id("lastName")).sendKeys(frank1.getLastName());
        driver.findElement(By.id("address")).sendKeys(frank1.getAddress());
        driver.findElement(By.id("city")).sendKeys(frank1.getCity());
        driver.findElement(By.id("telephone")).sendKeys(frank1.getTelephone());

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
        try{

            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(firstLast, frank1.getLastName()+" "+frank1.getFirstName());
        assertEquals(address, frank1.getAddress());
        assertEquals(city, frank1.getCity());
        assertEquals(telephone, frank1.getTelephone());

    }

}
