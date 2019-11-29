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
class AddPetSeleniumTest {

    private final String PATH = "C:\\Users\\ekjoh\\Desktop\\School\\Year4\\GerardSoftwareTesting\\1\\ChromeDriver\\chromedriver.exe";
    private final String BROWSER = "webdriver.chrome.driver";

    private final String PET_NAME = "Lester";
    private final String BIRTHDATE = "2018-02-14";
    private final String TYPE = "snake";

    ChromeDriver driver;

    public AddPetSeleniumTest(ChromeDriver driver)
    {
        this.driver = driver;
        System.setProperty(BROWSER, PATH);
    }

    @Test
    void Test_PetClinic_Add_Pet_Correct_Form_Displays() {
        driver.get("http:/localhost:1234/owners/1");

        //Find and click the Add New Pet owner button
        WebElement newPet = driver.findElement(By.xpath("/html/body/div/div/a[2]"));

        newPet.click();

        //Find all the inputs required to add a pet
        WebElement name = driver.findElement(By.id("name"));
        WebElement birthDate = driver.findElement(By.id("birthDate"));
        WebElement type = driver.findElement(By.id("type"));
        WebElement addPet = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));

        //Assert that the inputs are displayed on the page
        assertThat(name.isDisplayed(), is(true));
        assertThat(birthDate.isDisplayed(), is(true));
        assertThat(type.isDisplayed(), is(true));
        assertThat(addPet.isDisplayed(), is(true));

        driver.quit();
    }

    @Test
    void Test_New_Pet_Details_Display() {
        driver.get("http:/localhost:1234/owners/1");

        //Find and click the Add New Pet owner button
        WebElement newPet = driver.findElement(By.xpath("/html/body/div/div/a[2]"));

        newPet.click();

        //Find all the inputs required to add a pet
        WebElement name = driver.findElement(By.id("name"));
        WebElement birthDate = driver.findElement(By.id("birthDate"));
        WebElement typeSnake = driver.findElement(By.xpath("//*[@id=\"type\"]/option[6]"));
        WebElement addPet = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));


        //Insert pet information into the inputs
        name.sendKeys(PET_NAME);
        birthDate.sendKeys(BIRTHDATE);
        typeSnake.click();

        //Click the add pet button
        addPet.click();

        //Find the new pet information
        WebElement petName = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr[2]/td[1]/dl/dd[1]"));
        WebElement petBDay = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr[2]/td[1]/dl/dd[2]"));
        WebElement petType = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr[2]/td[1]/dl/dd[3]"));

        String displayName = petName.getText();
        String displayBDay = petBDay.getText();
        String displayType = petType.getText();

        //Assert that the pet information matches what was inserted
        assertThat(displayName.contains(PET_NAME), is(true));
        assertThat(displayBDay.contains(BIRTHDATE), is(true));
        assertThat(displayType.contains(TYPE), is(true));

    }

}
