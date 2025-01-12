package Marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Market_8 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Market_8() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Market_8Test() throws InterruptedException {
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

        //visit to item
        WebElement visit = driver.findElement(By.xpath("//span[normalize-space()='LKR95,000']"));
        visit.click();

        //Save Item
        WebElement Save = driver.findElement(By.xpath("//div[@class='x1emribx']//span[@class='x4k7w5x x1h91t0o x1h9r5lt x1jfb8zj xv2umb2 x1beo9mf xaigb6o x12ejxvf x3igimt xarpa2k xedcshv x1lytzrv x1t2pt76 x7ja8zs x1qrby5j']//div[@class='xjp7ctv']//div//div[@aria-label='Save']//i[@class='x1b0d499 xep6ejk']"));
        Save.click();

        System.out.println("Successfully saved the item");
        Thread.sleep(2500);
        driver.quit();

    }
}
