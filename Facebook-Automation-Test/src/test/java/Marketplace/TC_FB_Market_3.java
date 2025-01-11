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

public class TC_FB_Market_3 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Market_3(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Market_3Test() throws InterruptedException {
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
        Search.sendKeys("asdsadsadas" + Keys.ENTER);

        WebElement Message = driver.findElement(By.xpath("//div[@class='html-div xdj266r x11i5rnm xat24cr x1mh8g0r x6s0dn4 x78zum5 xdt5ytf xl56j7k x1p5oq8j xxbr6pl xwxc41k xbbxn1n']"));
        String MessageText = Message.getText();
        System.out.println("Shows a Message as: " + MessageText);

        Thread.sleep(2500);
        driver.quit();
    }

}
