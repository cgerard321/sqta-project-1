package org.springframework.samples.petclinic.owner;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



@ExtendWith(SeleniumExtension.class)
public class SQTA_47_addVet {
    private final String PATH = "C:\\Users\\Haroon\\Desktop\\School\\Fall 2019\\Software Testing and QA\\ChromeDriver\\chromedriver.exe";
    private final String BROWSER = "webdriver.chrome.driver";
    ChromeDriver driver;
    String lName = "Franklin";
    public SQTA_47_addVet(ChromeDriver driver){
        this.driver = driver;
        System.setProperty(BROWSER, PATH);
    }
    @Test
    public void getPetClinicHomePage() {
        driver.get("localhost:8081");
    }
    @Test
    public void getFindOwnersPage() {
        getPetClinicHomePage();
        WebElement ownerPageHyperlink = driver.findElementByXPath("//*[@id=\"main-navbar\"]/ul/li[3]/a");
        ownerPageHyperlink.click();
    }

    @Test
    public void getOwner(){
        getFindOwnersPage();
        WebElement search= driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        search.sendKeys(lName);

        WebElement log= driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));
        log.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void addVisit(){
        getOwner();
        WebElement log = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[2]/a"));
        log.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void addVisitMethod()
    {
        addVisit();
        String desc = "Internal Check up";
        String date = "2020-11-30";

        WebElement logdate = driver.findElement(By.xpath("//*[@id=\"date\"]"));
        logdate.clear();
        logdate.sendKeys(date);
        WebElement log2= driver.findElement(By.xpath("//*[@id=\"description\"]"));
        log2.sendKeys(desc);


        WebElement sub = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));
        sub.click();



        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
