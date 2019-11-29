package org.springframework.samples.petclinic.owner;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;


import java.util.Random;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SeleniumExtension.class)
class OwnerControllerTest {

    private final String FIRST_NAME_U = "Emma";
    private final String LAST_NAME_U = "Johnson";
    private final String ADDRESS_U = "588 chemin des Trente";
    private final String CITY_U = "St-Mathias";
    private final String TELEPHONE_U = "4504477324";

    @Test
    public void Test_petClinic_OpenFindOwnersPage(ChromeDriver driver){
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


    @Test
    void Test_PetClinic_Update_Owner_Correct_Form_Displays(ChromeDriver driver) {
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
    void Test_Updated_Owner_Details_Display(ChromeDriver driver) {
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
        firstNameInput.sendKeys(FIRST_NAME_U);
        lastNameInput.sendKeys(LAST_NAME_U);
        addressInput.sendKeys(ADDRESS_U);
        cityInput.sendKeys(CITY_U);
        telephoneInput.sendKeys(TELEPHONE_U);

        //Click the update button
        updateButton.click();

        //Find the new owner information
        String updatedName = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b")).getText();
        String updatedAddress = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td")).getText();
        String updatedCity = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[3]/td")).getText();
        String updatedTelephone = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[4]/td")).getText();

        //Assert that the owner information matches what was inserted
        assertTrue(updatedName.matches(FIRST_NAME_U + " " + LAST_NAME_U));
        assertTrue(updatedAddress.matches(ADDRESS_U));
        assertTrue(updatedCity.matches(CITY_U));
        assertTrue(updatedTelephone.matches(TELEPHONE_U));

    }

    @Test
    public void Test_petClinic_RightOwnerFound_as_Dev(ChromeDriver driver)

    {
        driver.get("http://localhost:8090/owners/find");

        //find and click the add owner button
        WebElement btn_addOwner = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));
        btn_addOwner.click();

        //random number will be appended to a user that is created (this is done to generate a random username)
        Random rand = new Random();
        int num_random = rand.nextInt(1000);
        String test_user_lname = "test_user_"+num_random;

        //now enter data to create a test owner that will we then try to find

        //first name
        WebElement fld_entry_fname = driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[1]/div/div/input"));
        fld_entry_fname.sendKeys("test");

        //last name
        WebElement fld_entry_lname = driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[2]/div/div/input"));
        fld_entry_lname.sendKeys(test_user_lname);

        //address
        WebElement fld_entry_address = driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[3]/div/div/input"));
        fld_entry_address.sendKeys("test");

        //city
        WebElement fld_entry_city = driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[4]/div/div/input"));
        fld_entry_city.sendKeys("test");

        //telephone
        WebElement fld_entry_telephone = driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div[5]/div/div/input"));
        fld_entry_telephone.sendKeys("test");

        //submit button
        WebElement fld_entry_submit = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));
        fld_entry_submit.click();

        //go back to find owners page
        WebElement btn_nav = driver.findElement(By.xpath("/html/body/nav/div/div[1]/button"));
        btn_nav.click();

        //find and click find owners in the nav
        WebElement btn_find_owners = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a/span[2]"));
        btn_find_owners.click();

        //send keys to the lastname search fields
        WebElement fld_lastName = driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div/div/input"));
        fld_lastName.sendKeys(test_user_lname);

        //search for the owner that was created in this test
        btn_addOwner.click();

        //find the name of the owner after the last name search method has been used
        WebElement right_owner_name = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b"));

        //assert that the owner names match
        assertThat(right_owner_name.getText(), is(test_user_lname));

        try{
            Thread.sleep(5000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
