package Reels;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Reels_5 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Reels_5() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Reels_5Test() throws InterruptedException {
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

        //React Post
        WebElement React = driver.findElement(By.xpath("//div[@class='x1jx94hy x1lq5wgf xgqcy7u x30kzoy x9jhf4c x78zum5 x6ikm8r x10wlt62 x1n2onr6 xzueoph']//div[@class='xh8yej3']//div[@class='x78zum5 xdt5ytf x1iyjqo2 x1pg5gke']//div[@class='x1xmf6yo xq8finb x1e56ztr x16n37ib']//div//span[@data-ad-rendering-role='like_button'][normalize-space()='Like']"));
        Actions ReactAction = new Actions(driver);


        //Like
        ReactAction.moveToElement(React).perform();
        Thread.sleep(1500);
        WebElement Like = driver.findElement(By.xpath("//div[@aria-label='Like']//div//canvas"));
        Like.click();

        //Love
        ReactAction.moveToElement(React).perform();
        Thread.sleep(1500);
        WebElement Love = driver.findElement(By.xpath("//div[@aria-label='Love']//div//canvas"));
        Love.click();

        //Care
        ReactAction.moveToElement(React).perform();
        Thread.sleep(1500);
        WebElement Care = driver.findElement(By.xpath("//div[@aria-label='Care']//div//canvas"));
        Care.click();

        //Haha
        ReactAction.moveToElement(React).perform();
        Thread.sleep(1500);
        WebElement Haha = driver.findElement(By.xpath("//div[@aria-label='Haha']//div//canvas"));
        Haha.click();

        //Wow
        ReactAction.moveToElement(React).perform();
        Thread.sleep(1500);
        WebElement Wow = driver.findElement(By.xpath("//div[@aria-label='Wow']//div//canvas"));
        Wow.click();

        //Sad
        ReactAction.moveToElement(React).perform();
        Thread.sleep(1500);
        WebElement Sad = driver.findElement(By.xpath("//div[@aria-label='Sad']//div//canvas"));
        Sad.click();

        //Angry
        ReactAction.moveToElement(React).perform();
        Thread.sleep(1500);
        WebElement Angry = driver.findElement(By.xpath("//div[@aria-label='Angry']//div//canvas"));
        Angry.click();

        driver.quit();

    }
}
