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
class UpdateOwnerSeleniumTest{

    private final String PATH = "C:\\Users\\ekjoh\\Desktop\\School\\Year4\\GerardSoftwareTesting\\1\\ChromeDriver\\chromedriver.exe";
    private final String BROWSER = "webdriver.chrome.driver";

    private final String FIRST_NAME = "Emma";
    private final String LAST_NAME = "Johnson";
    private final String ADDRESS = "588 chemin des Trente";
    private final String CITY = "St-Mathias";
    private final String TELEPHONE = "4504477324";

    ChromeDriver driver;

    public UpdateOwnerSeleniumTest(ChromeDriver driver)
    {
        this.driver = driver;
        System.setProperty(BROWSER, PATH);
    }

    @Test
    void Test_PetClinic_Update_Owner_Correct_Form_Displays() {
        driver.get("http:/localhost:1234/owners/1");

        //Find and click the edit owner button
        WebElement editOwner = driver.findElement(By.xpath("/html/body/div/div/a[1]"));
        editOwner.click();

        //Find all the inputs required to edit an owner
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        WebElement addressInput = driver.findElement(By.id("address"));
        WebElement cityInput = driver.findElement(By.id("city"));
        WebElement telephoneInput = driver.findElement(By.id("telephone"));
        WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));

        //Assert that the inputs are displayed on the page
        assertThat(firstNameInput.isDisplayed(), is(true));
        assertThat(lastNameInput.isDisplayed(), is(true));
        assertThat(addressInput.isDisplayed(), is(true));
        assertThat(cityInput.isDisplayed(), is(true));
        assertThat(telephoneInput.isDisplayed(), is(true));
        assertThat(updateButton.isDisplayed(), is(true));

        driver.quit();
    }

    @Test
    void Test_Updated_Owner_Details_Display() {
        driver.get("http:/localhost:1234/owners/1");

        //Find and click the edit owner button
        WebElement editOwnerButton = driver.findElement(By.xpath("/html/body/div/div/a[1]"));
        editOwnerButton.click();

        //Find all the inputs required to edit an owner
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        WebElement addressInput = driver.findElement(By.id("address"));
        WebElement cityInput = driver.findElement(By.id("city"));
        WebElement telephoneInput = driver.findElement(By.id("telephone"));
        WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));

        //Clear all the inputs that contain the owners information
        firstNameInput.clear();
        lastNameInput.clear();
        addressInput.clear();
        cityInput.clear();
        telephoneInput.clear();

        //Insert new information into the inputs
        firstNameInput.sendKeys(FIRST_NAME);
        lastNameInput.sendKeys(LAST_NAME);
        addressInput.sendKeys(ADDRESS);
        cityInput.sendKeys(CITY);
        telephoneInput.sendKeys(TELEPHONE);

        //Click the update button
        updateButton.click();

        //Find the new owner information
        String updatedName = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b")).getText();
        String updatedAddress = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td")).getText();
        String updatedCity = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[3]/td")).getText();
        String updatedTelephone = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[4]/td")).getText();

        //Assert that the owner information matches what was inserted
        assertTrue(updatedName.matches(FIRST_NAME+" "+LAST_NAME));
        assertTrue(updatedAddress.matches(ADDRESS));
        assertTrue(updatedCity.matches(CITY));
        assertTrue(updatedTelephone.matches(TELEPHONE));

        driver.quit();
    }
}

