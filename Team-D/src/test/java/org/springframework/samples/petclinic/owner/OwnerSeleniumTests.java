package org.springframework.samples.petclinic.owner;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

@ExtendWith(SeleniumExtension.class)
public class OwnerSeleniumTests {

    ChromeDriver driver;

    @MockBean
    private OwnerRepository owners;

    public OwnerSeleniumTests(ChromeDriver driver) {
        this.driver = driver;
    }

    public void getPetClinicHomePage() {
        driver.get("localhost:8080");
    }
    public void getFindOwnersPage() {
        WebElement ownerPageHyperlink = driver.findElementByXPath("//*[@id=\"main-navbar\"]/ul/li[3]/a");
        ownerPageHyperlink.click();
    }
    public void getOwnersList() {
        WebElement findOwnersButton = driver.findElementByXPath("//*[@id=\"search-owner-form\"]/div[2]/div/button");
        findOwnersButton.click();
    }

    @Test
    public void test_InitPetClinicHomePage() {
        driver.get("localhost:8080");
        driver.manage().window().maximize();
    }

    @Test
    public void test_InitFindOwnerPage() {
        getPetClinicHomePage();

        WebElement ownerPageHyperlink = driver.findElementByXPath("//*[@id=\"main-navbar\"]/ul/li[3]/a");
        ownerPageHyperlink.click();

        WebElement ownerPageVerify = driver.findElementByXPath("/html/body/div/div/h2");

        assertThat(ownerPageVerify.isDisplayed(), is(true));
    }

    @Test
    public void test_InitOwnerList() {
        getPetClinicHomePage();
        getFindOwnersPage();

        WebElement findOwnersButton = driver.findElementByXPath("//*[@id=\"search-owner-form\"]/div[2]/div/button");
        findOwnersButton.click();

        WebElement ownersTableVerify = driver.findElementByXPath("//*[@id=\"owners\"]");

        assertThat(ownersTableVerify.isDisplayed(), is(true));
    }

    /*@Test
    public void verifyValuesInOwnerTable() {
        getPetClinicHomePage();
        getFindOwnersPage();
        getOwnersList();

        Collection<Owner> ownerListExpected = owners.findByLastName("");

        WebElement ownerListActual = driver.findElementByXPath("//*[@id=\"owners\"]/tbody");
        List<WebElement> ownerNameList= ownerListActual.findElements(By.tagName("a"));

        List<String> ownerNames = new ArrayList<String>();

        for ( WebElement wbe: ownerNameList) {
            ownerNames.add(wbe.getText());
        }*/

}
