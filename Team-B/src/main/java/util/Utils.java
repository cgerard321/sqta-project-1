package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
    public static void accessFindOwnersPage_Test(ChromeDriver driver){
        driver.get("http://localhost:6969/");

        WebElement findOwner_navButton = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[3]"));
        findOwner_navButton.click();

        WebElement pTitle =driver.findElement(By.tagName("h2"));

        //   assertEquals(pTitle.getText(),"Find Owners");

    }
}
