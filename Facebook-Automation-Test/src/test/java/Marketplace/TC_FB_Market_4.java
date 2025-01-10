package Marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Market_4 {
    WebDriver driver;
    @BeforeMethod
    public void TC_FB_Market_2(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Market_2Test() throws InterruptedException {
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("patali9600@gmail.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //Access Marketplace
        WebElement Marketplace = driver.findElement(By.xpath("//span[contains(text(),'Marketplace')]"));
        Marketplace.click();

        //Search Keyword
        WebElement Search = driver.findElement(By.xpath("//input[@placeholder='Search Marketplace']"));
        Search.sendKeys("Iphone 13" + Keys.ENTER);

        //Apply Filters
        //Price Range Filter
        WebElement MinPrice = driver.findElement(By.xpath("//input[@placeholder='Min.']"));
        MinPrice.sendKeys("30000");
        WebElement MaxPrice = driver.findElement(By.xpath("//input[@placeholder='Max.']"));
        MaxPrice.sendKeys("50000");

        //Condition Filter
        WebElement Condition = driver.findElement(By.xpath("//span[contains(text(),'Condition')]"));
        Condition.click();

        //Check whether condition is selected
        WebElement newCondition = driver.findElement(By.id(":Rp9qkmj4qj6illkqismipapd5aq:"));
        newCondition.click();


        Thread.sleep(2500);
        driver.quit();
    }
}
