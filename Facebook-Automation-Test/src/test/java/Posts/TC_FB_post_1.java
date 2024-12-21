package Posts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_post_1 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Post_1() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Post_1Test() throws InterruptedException {
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("jigiwi7156@jofuso.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("Celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //Sometimes while Anonymous Login it is requiring the password again, for that;
        WebElement AnonymousLoginPassword = driver.findElement(By.id("pass"));
        AnonymousLoginPassword.sendKeys("Celkon");

        WebElement AnonymousLoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        AnonymousLoginButton.click();
//
//        WebElement pass = driver.findElement(By.name("pass"));
//        pass.sendKeys("Celkon");
//        driver.findElement(By.name("login")).click();

        driver.findElement(By.xpath("//div[@class='x1i10hfl x1ejq31n xd10rxx x1sy0etr x17r0tee x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x1ypdohk xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8 x1hl2dhg xggy1nq x87ps6o x1lku1pv x1a2a7pz x6s0dn4 xmjcpbm x107yiy2 xv8uw2v x1tfwpuw x2g32xy x78zum5 x1q0g3np x1iyjqo2 x1nhvcw1 x1n2onr6 xt7dq6l x1ba4aug x1y1aw1k xn6708d xwib8y2 x1ye3gou']")).click();
        WebElement post = driver.findElement(By.xpath("//p[@class='xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8']"));
        post.sendKeys("Hi everyone, This is a Test Post, -KAVISHKA-");

        Thread.sleep(2000);

        WebElement Location = driver.findElement(By.xpath("//div[@aria-label='Check in']//div//div//img[@class='x1b0d499 xl1xv1r']"));
        Location.click();
        WebElement SelectLocation = driver.findElement(By.xpath("//input[@placeholder='Where are you?']"));
        SelectLocation.sendKeys("Colombo" + Keys.ENTER);
        Thread.sleep(2500);
        driver.findElement(By.xpath("//li[@id='108602292505393']//div[@class='x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x193iq5w xeuugli x1r8uery x1iyjqo2 xs83m0k xsyo7zv x16hj40l x10b6aqq x1yrsyyn']")).click();
        driver.findElement(By.xpath("//div[@aria-label='Remove Post Attachment']//i[@class='x1b0d499 x1d69dk1']")).click();

        Thread.sleep(2000);
        WebElement Tag = driver.findElement(By.xpath("//div[@aria-label='Tag people']//div//div//img[@class='x1b0d499 xl1xv1r']"));
        Tag.click();
        WebElement SelectTag = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        SelectTag.sendKeys("Kohli");
        Thread.sleep(2000);
        WebElement Tagfriend = driver.findElement(By.xpath("//li[@id='100044473084573']//div[@class='x78zum5 xdt5ytf x16n37ib']"));
        Tagfriend.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click();

        Thread.sleep(2000);
        WebElement Feeling = driver.findElement(By.xpath("//div[@aria-label='Feeling/activity']//div//div//img[@class='x1b0d499 xl1xv1r']"));
        Feeling.click();
        WebElement SelectFeeling = driver.findElement(By.xpath("//div[contains(text(),'happy')]"));
        SelectFeeling.click();

        Thread.sleep(2000);


        WebElement Background = driver.findElement(By.xpath("//span[@class='x139jcc6 x1kgmq87']//img[@class='xz74otr']"));
        Background.click();
        WebElement selectBackground = driver.findElement(By.xpath("//div[@aria-label='Solid black, background']//div[@class='x25l62i x1lq5wgf xgqcy7u x30kzoy x9jhf4c x10w6t97 x1td3qas']"));
        selectBackground.click();

        WebElement Post = driver.findElement(By.xpath("//div[@aria-label='Post']//div[@class='x6s0dn4 x78zum5 xl56j7k x1608yet xljgi0e x1e0frkt']"));
        Post.click();
        Thread.sleep(4000);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight / 35)");

        
    }



}
