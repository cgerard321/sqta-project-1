package org.springframework.samples.petclinic.owner;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

    @ExtendWith(SeleniumExtension.class)

    class OwnerControllerTest {
        ChromeDriver driver = new ChromeDriver();

        @Test
        public void Test_petClinic_OpenFindOwnersPage(){
            driver.get("http://localhost:8090");
//        driver.manage().window().maximize();

//
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


    }


