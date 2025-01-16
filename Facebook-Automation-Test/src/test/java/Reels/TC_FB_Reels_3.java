package Reels;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class TC_FB_Reels_3 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Reels_3() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Reels_3Test() throws InterruptedException {
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

        //Video Actions
        Actions actions = new Actions(driver);
        WebElement Wholevideo = driver.findElement(By.xpath("//div[@class='x1jx94hy x1lq5wgf xgqcy7u x30kzoy x9jhf4c x78zum5 x6ikm8r x10wlt62 x1n2onr6 xzueoph']//div[@class='xh8yej3']//div[@class='x1n2onr6']//div[@class='x4k3uqp x1bifzbx xh8yej3']//div[@class='xal61yo x5yr21d x6ikm8r x10wlt62 x1n2onr6 xh8yej3']//div[@class='x1lliihq x5yr21d x1n2onr6 xh8yej3 x1ja2u2z']//div//div[@class='x5yr21d x10l6tqk x13vifvy xh8yej3']//div//div[@role='presentation']"));
        actions.moveToElement(Wholevideo).perform();
        WebElement bar = driver.findElement(By.xpath("//div[@class='x1jx94hy x1lq5wgf xgqcy7u x30kzoy x9jhf4c x78zum5 x6ikm8r x10wlt62 x1n2onr6 xzueoph']//div[@class='xh8yej3']//div[@class='x1n2onr6']//div[@class='x4k3uqp x1bifzbx xh8yej3']//div[@class='xal61yo x5yr21d x6ikm8r x10wlt62 x1n2onr6 xh8yej3']//div[@class='x1lliihq x5yr21d x1n2onr6 xh8yej3 x1ja2u2z']//div//div[@class='x5yr21d x10l6tqk x13vifvy xh8yej3']//div//div[@class='x1ey2m1c x10l6tqk x1d8287x x6o7n8i xl405pv xh8yej3 x11uqc5h x6s0dn4 xzt5al7 x78zum5 x1q0g3np']"));
        actions.moveToElement(bar).perform();

        ///Play/Pause Video
        WebElement Pause = driver.findElement(By.xpath("//div[@aria-label='Pause']//i[@class='x1b0d499 xaj1gnb']"));
        Pause.click();
        Thread.sleep(3000);
        WebElement Play = driver.findElement(By.xpath("//div[@class='x6s0dn4 x78zum5 x1q0g3np x2lah0s xozqiw3 xexx8yu x1mpkggp x18d9i69 x1t2a60a x1hc1fzr']//div[@aria-label='Play']"));
        Play.click();

        //Unmute
        WebElement Unmute = driver.findElement(By.xpath("//div[@class='x6s0dn4 x78zum5 x1q0g3np x2lah0s xozqiw3 xexx8yu x1mpkggp x18d9i69 xkhd6sd x1hc1fzr']//i[@class='x1b0d499 xaj1gnb']"));
        Unmute.click();
        Thread.sleep(3000);

        //FullScreen
        WebElement FullScreen = driver.findElement(By.xpath("//div[@class='x6s0dn4 x78zum5 x1q0g3np x2lah0s xozqiw3 xexx8yu x18d9i69 x4uap5 xkhd6sd x1hc1fzr']//span[@class='xuk3077 x78zum5 x14atkfc']//span[@class='xuk3077 x78zum5 x14atkfc']"));
        FullScreen.click();
        Thread.sleep(3000);

        //Picture on picture
        WebElement Piconpic = driver.findElement(By.xpath("//div[@class='x6s0dn4 x78zum5 x1q0g3np x2lah0s xozqiw3 xexx8yu x1mpkggp x18d9i69 x1t2a60a x1hc1fzr']//div//span[@class='xuk3077 x78zum5 x14atkfc']//i[@class='x1b0d499 xaj1gnb']"));
        Piconpic.click();
        Thread.sleep(3000);

        driver.quit();

    }
}


