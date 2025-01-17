package Reels;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Reels_6 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Reels_6() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Reels_6Test() throws InterruptedException {
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("jegoh94617@konican.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //Visit to videos
        WebElement Videos = driver.findElement(By.xpath("//a[@aria-label='Video']"));
        Videos.click();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight / 10)");

        //Comment Post
        WebElement Comment = driver.findElement(By.xpath("//div[@class='x1jx94hy x1lq5wgf xgqcy7u x30kzoy x9jhf4c x78zum5 x6ikm8r x10wlt62 x1n2onr6 xzueoph']//div[@class='xh8yej3']//div[@class='x78zum5 xdt5ytf x1iyjqo2 x1pg5gke']//div[@class='x1xmf6yo xq8finb x1e56ztr x16n37ib']//div//span[@class='html-span xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd x1hl2dhg x16tdsg8 x1vvkbs'][normalize-space()='Comment']"));
        Comment.click();
        WebElement TextBox = driver.findElement(By.xpath("//div[@aria-label='Write a comment…']"));
        TextBox.sendKeys("This is a test comment, From KAVISHKA");
        WebElement Emoji = driver.findElement(By.xpath("//div[@aria-label='Insert an emoji']"));
        Emoji.click();
        WebElement Insert = driver.findElement(By.xpath("//img[@alt='\uD83D\uDE00']"));
        Insert.click();
        TextBox.sendKeys(Keys.ENTER);

        WebElement Publish = driver.findElement(By.xpath("//div[@aria-label='Comment']"));
        Publish.click();
        Thread.sleep(2500);

        driver.quit();
    }
}
