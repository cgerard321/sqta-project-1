package org.springframework.samples.petclinic.owner;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SeleniumExtension.class)
public class STQA_46_addOwner {
    private final String BROWSER = "webdriver.chrome.driver";
    private final String PATH="C:\\Users\\fatsy\\IdeaProjects\\chromedriver.exe";
    ChromeDriver driver;

    public STQA_46_addOwner(ChromeDriver driver){
            this.driver=driver;
            //System.setProperty(BROWSER,PATH);
    }


    public void getHomePage() {
        driver.get("localhost:8080");
    }


    public void findOwnerPage(){
        getHomePage();
        WebElement ownerPageHyperlink = driver.findElementByXPath("/html/body/nav/div/div[2]/ul/li[3]/a");
        ownerPageHyperlink.click();
    }

    public void addOwnerPage(){
        findOwnerPage();
        WebElement addOwnerPageBtn= driver.findElementByXPath("/html/body/div/div/a");
        addOwnerPageBtn.click();
    }


    public void fillAddOwnerForm(){

        addOwnerPage();
    String fname="Fatsy",lname="Ramampi",address="900 Riverside",city="Mtl",tel="5147958399";

    driver.findElementByName("firstName").sendKeys(fname);
    driver.findElementByName("lastName").sendKeys(lname);
    driver.findElementByName("address").sendKeys(address);
    driver.findElementByName("city").sendKeys(city);
    driver.findElementByName("telephone").sendKeys(tel);

    WebElement addBtn=driver.findElementByXPath("/html/body/div/div/form/div[2]/div/button");
    addBtn.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkResults(){

    fillAddOwnerForm();

    //expected results
   String fname="Fatsy",lname="Ramampi",address="900 Riverside",city="Mtl",tel="5147958399";

   //actual values from table
    String actualFullname=driver.findElementByXPath("/html/body/div/div/table[1]/tbody/tr[1]/td/b").getText();
    String actualaddress=driver.findElementByXPath("/html/body/div/div/table[1]/tbody/tr[2]/td").getText();
    String actualCity=driver.findElementByXPath("/html/body/div/div/table[1]/tbody/tr[3]/td").getText();
    String actualPhone=driver.findElementByXPath("/html/body/div/div/table[1]/tbody/tr[4]/td").getText();

    //check if values match
   assertEquals(fname+" "+lname,actualFullname);
   assertEquals(address,actualaddress);
   assertEquals(city,actualCity);
   assertEquals(tel,actualPhone);

    }

}

