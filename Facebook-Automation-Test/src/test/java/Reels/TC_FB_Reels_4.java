package Reels;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.time.Duration;

public class TC_FB_Reels_4 {
    WebDriver driver;

        @BeforeMethod
        public void TC_FB_Reels_4() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBrowserVersion("121");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            driver.get("https://www.facebook.com/");
        }

        @Test
        public void TC_FB_Reels_4Test() throws InterruptedException {
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

            //Visit to reels
            WebElement Reels = driver.findElement(By.xpath("//a[@href='/reel/?s=bookmark']//div[@class='x6s0dn4 x1q0q8m5 x1qhh985 xu3j5b3 xcfux6l x26u7qi xm0m39n x13fuv20 x972fbf x9f619 x78zum5 x1q0g3np x1iyjqo2 xs83m0k x1qughib xat24cr x11i5rnm x1mh8g0r xdj266r xeuugli x18d9i69 x1sxyh0 xurb0ha xexx8yu x1n2onr6 x1ja2u2z x1gg8mnh']"));
            Reels.click();
            Thread.sleep(5000);

            //Pause and play
            WebElement pauseAndPlay = driver.findElement(By.xpath("//div[@class='x1ey2m1c x78zum5 xdt5ytf xozqiw3 x17qophe x13a6bvl x10l6tqk x13vifvy xq2gx43 xh8yej3']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(pauseAndPlay).perform();
            pauseAndPlay.click();
            Thread.sleep(2500);
            pauseAndPlay.click();

            //swipe to next
            actions.moveToElement(pauseAndPlay).sendKeys(Keys.ARROW_RIGHT).perform();
            Thread.sleep(3500);

            //swipe to previous
            actions.moveToElement(pauseAndPlay).sendKeys(Keys.ARROW_LEFT).perform();
            Thread.sleep(3500);



            driver.quit();

        }
    }




