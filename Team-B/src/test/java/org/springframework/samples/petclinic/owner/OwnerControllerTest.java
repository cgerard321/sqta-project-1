package org.springframework.samples.petclinic.owner;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class OwnerControllerTest {
    ChromeDriver driver;
    OwnerControllerTest(ChromeDriver driver){
        this.driver = driver;
    }


    //private WebDriver driver = new ChromeDriver();

    @Test
    public void TryToOpenTheWebpage(){


    }
}
