package org.springframework.samples.petclinic.pet;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

@ExtendWith(SeleniumExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EditPetDetailsSeleniumTests {

    private ChromeDriver driver;

    public EditPetDetailsSeleniumTests(ChromeDriver driver) {
        this.driver = driver;
    }

    public void getPetClinicHomePage() {
        driver.get("http://localhost:8080/owners/1");
        driver.manage().window().maximize();
    }
    public void initEditPetPage() {
        WebElement editPetHyperlink = driver.findElementByXPath("/html/body/div/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[1]/a");
        editPetHyperlink.click();
    }
    public void rebasePetDetails() {
        getPetClinicHomePage();
        initEditPetPage();
        WebElement petNameEditBox = driver.findElementByXPath("//*[@id=\"name\"]");
        petNameEditBox.clear();
        petNameEditBox.sendKeys("Leo");
        WebElement submitButton = driver.findElementByXPath("/html/body/div/div/form/div[2]/div/button");
        submitButton.click();
    }

    @Test
    @Order(0)
    public void test_InitPetClinicHomePage() {
        driver.get("http://localhost:8080/owners/1");
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void test_InitFindEditPetPage() {
        getPetClinicHomePage();

        String petName = driver.findElementByXPath("/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[1]").getText();
        String birthDate = driver.findElementByXPath("/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[2]").getText();
        String petType = driver.findElementByXPath("/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[3]").getText();

        WebElement editPetHyperlink = driver.findElementByXPath("/html/body/div/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[1]/a");
        editPetHyperlink.click();

        WebElement verifyEditPageInit = driver.findElementByXPath("/html/body/div/div/h2");

        String petNameActual = driver.findElementByXPath("//*[@id=\"name\"]").getAttribute("value");
        String petBirthDateActual = driver.findElementByXPath("//*[@id=\"birthDate\"]").getAttribute("value");
        Select select = new Select(driver.findElementByXPath("//*[@id=\"type\"]"));
        WebElement option = select.getFirstSelectedOption();
        String petTypeActual = option.getText();

        assertThat(verifyEditPageInit.isDisplayed(), is(true));
        assertThat(petNameActual.trim().equals(petName.trim()), is(true));
        assertThat(petBirthDateActual.trim().equals(birthDate.trim()), is(true));
        assertThat(petType.trim().equals(petTypeActual.trim()), is(true));
    }

    @Test
    @Order(2)
    public void test_changeValuesInEditForm() {
        rebasePetDetails();
        initEditPetPage();

        String expectedName = "Amin";

        WebElement petNameEditBox = driver.findElementByXPath("//*[@id=\"name\"]");
        petNameEditBox.clear();
        petNameEditBox.sendKeys(expectedName);

        WebElement submitButton = driver.findElementByXPath("/html/body/div/div/form/div[2]/div/button");
        submitButton.click();

        WebElement editSuccessful = driver.findElementByXPath("/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[1]");

        assertThat(expectedName.equals(editSuccessful.getText()), is(true));
    }

}
