package Notifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Notify_2 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Notify_2(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Notify_2Test() throws InterruptedException {
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("jegoh94617@konican.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //view notifications
        WebElement view = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M3 9.5a9 9')]"));
        view.click();

        WebElement Unread = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/a[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]"));
        String IsUnread = Unread.getText();

        if(IsUnread.equals("Mark as read")){
            System.out.println("This is an unread message, So, I will read it");
            Unread.click();
        }
        else {
            System.out.println("This is an unread message");
        }

        Thread.sleep(2000);
        System.out.println("The notification should no longer appear highlighted or as unread.");
        driver.quit();
    }
}
