package org.springframework.samples.petclinic.owner;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.Console;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


@ExtendWith(SeleniumExtension.class)
public class STQA_HORIA_PENDING_testIfGetOwnerFormSticky {
    ChromeDriver driver;

    public STQA_HORIA_PENDING_testIfGetOwnerFormSticky(ChromeDriver driver)
    {
        this.driver = driver;
    }

    @Test
    public void TestIfOwnerFormSticky(){
        driver.get("http://localhost:8080");

        WebElement findOwnersPage = driver.findElementByXPath("/html/body/nav/div/div[2]/ul/li[3]/a");
        findOwnersPage.click();

        WebElement findOwnersButton = driver.findElementByXPath("/html/body/div/div/form/div[2]/div/button");
        findOwnersButton.click();

        Owner owner = new Owner();
        WebElement fullName = driver.findElementByXPath("/html/body/div/div/table/tbody/tr[2]/td[1]/a");
        WebElement address = driver.findElementByXPath("/html/body/div/div/table/tbody/tr[2]/td[2]");
        WebElement city = driver.findElementByXPath("/html/body/div/div/table/tbody/tr[2]/td[3]");
        WebElement phone = driver.findElementByXPath("/html/body/div/div/table/tbody/tr[2]/td[4]");
        String[]fullNameArray = fullName.getText().split(" ");

        owner.setFirstName(fullNameArray[0]);
        owner.setLastName(fullNameArray[1]);
        owner.setAddress(address.getText());
        owner.setCity(city.getText());
        owner.setTelephone(phone.getText());

        fullName.click();

        WebElement editOwnerButton = driver.findElementByXPath("/html/body/div/div/a[1]");
        editOwnerButton.click();

        String fieldFirstName = driver.findElementByXPath("/html/body/div/div/form/div[1]/div[1]/div/div/input").getAttribute("value");
        String fieldLastName = driver.findElementByXPath("/html/body/div/div/form/div[1]/div[2]/div/div/input").getAttribute("value");
        String fieldAddress = driver.findElementByXPath("/html/body/div/div/form/div[1]/div[3]/div/div/input").getAttribute("value");
        String fieldCity = driver.findElementByXPath("/html/body/div/div/form/div[1]/div[4]/div/div/input").getAttribute("value");
        String fieldTelephone = driver.findElementByXPath("/html/body/div/div/form/div[1]/div[5]/div/div/input").getAttribute("value");

        assertEquals(owner.getFirstName(),fieldFirstName);
        assertEquals(owner.getLastName(),fieldLastName);
        assertEquals(owner.getAddress(),fieldAddress);
        assertEquals(owner.getCity(),fieldCity);
        assertEquals(owner.getTelephone(),fieldTelephone);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }

}
