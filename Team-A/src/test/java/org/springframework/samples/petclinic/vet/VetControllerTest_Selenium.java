package org.springframework.samples.petclinic.vet;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SeleniumExtension.class)
class VetControllerTest_Selenium {
    private final String SCREENSHOTS = "C:\\Users\\MegMeg\\IdeaProjects\\Screenshots\\screen.png";
    private final String BROWSER = "webdriver.chrome.driver";
    private final String PATH = "C:\\Users\\MegMeg\\Documents\\Champlain\\Semester_5\\Software_Testing\\Selenium\\chromedriver.exe";

    ChromeDriver driver;

    public VetControllerTest_Selenium(ChromeDriver driver) {
        this.driver = driver;
        System.setProperty(BROWSER, PATH);
    }

    @Test
    void showVetList() throws Exception {
        //Open up the webpage
        driver.get("http://localhost:8090/");

        //find vet button in the nav a nd click on it
        WebElement showVetsBTN = driver.findElement(By.xpath("//*[@title='veterinarians']"));
        showVetsBTN.click();


        //find Veterinarians title
        WebElement veterinarianTitle = driver.findElement(By.xpath("/html/body/div/div/h2"));
        //assert the element is displayed and correct
        assertThat(veterinarianTitle.isDisplayed(), is(true));
        assertThat(veterinarianTitle.getText(), is("Veterinarians"));

        //find a veterinarian object to make sure they are displayed
        WebElement veterinarianName = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[1]"));
        WebElement veterinarianSpecialty = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[2]/span"));
        //assert the element is displayed and correct
        assertThat(veterinarianName.getText(), is("James Carter"));
        assertThat(veterinarianSpecialty.getText(), is("none"));

        //take snapshot for confirmation
        takeSnapShot(driver, SCREENSHOTS);

    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

}
