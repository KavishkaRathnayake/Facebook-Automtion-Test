package Posts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class TC_FB_post_3 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_post_3() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_post_2Test() throws InterruptedException, AWTException {
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

        WebElement Yourproiebutton = driver.findElement(By.xpath("//*[name()='g' and contains(@mask,'url(#:R6lm')]//*[name()='image' and contains(@x,'0')]"));
        Yourproiebutton.click();
        WebElement visitProile = driver.findElement(By.xpath("//div[@class='x9f619 x1ja2u2z x78zum5 x2lah0s x1n2onr6 x1qughib x6s0dn4 xozqiw3 x1q0g3np x1sxyh0 xurb0ha xwib8y2 x1y1aw1k xcud41i x139jcc6 x4vbgl9 x1rdy4ex']"));
        visitProile.click();
        Thread.sleep(15000);

        WebElement menu = driver.findElement(By.xpath("(//div[@aria-label='Actions for this post'])[1]"));
        menu.click();
        WebElement Edit = driver.findElement(By.xpath("//span[normalize-space()='Edit post']"));
        Edit.click();
        WebElement Type = driver.findElement(By.xpath("//p[@class='xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8']"));
        Type.sendKeys("Successfully Edited");
        WebElement Save = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));
        Save.click();

        //Publish
        WebElement Post = driver.findElement(By.xpath("//div[@aria-label='Post']//div[@class='x6s0dn4 x78zum5 xl56j7k x1608yet xljgi0e x1e0frkt']"));
        Post.click();
        Thread.sleep(4000);


    }
}
