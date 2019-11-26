package org.springframework.samples.petclinic.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
    ChromeDriver driver;

    public Utils(ChromeDriver driver){
        this.driver = driver;
    }

    public void goToPage(String page){
        driver.get("http://localhost:6969/"+page);
    }

    public void goToPage(){
        driver.get("http://localhost:6969/");
    }

    public void pause(int time){
        try{
            Thread.sleep(time);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
