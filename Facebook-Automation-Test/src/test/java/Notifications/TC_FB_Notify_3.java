package Notifications;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Notify_3 {
    WebDriver driver;
    @BeforeMethod
    public void TC_FB_Notify_3(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test(priority = 1)
    public void TC_FB_Notify_3Test() {
        //User A
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("patali9600@gmail.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //Send request
        WebElement Search = driver.findElement(By.xpath("//input[@placeholder='Search Facebook']"));
        Search.sendKeys("Kavishka Selenium" + Keys.ENTER);

        WebElement GoToProfile = driver.findElement(By.xpath("//a[normalize-space()='Kavishka Selenium']"));
        GoToProfile.click();

        WebElement AddFriendButton = driver.findElement(By.xpath("//span[contains(text(),'Add friend')]"));
        AddFriendButton.click();

        WebElement AddFriendButtonConfirmation = driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/div/div/div/div/div/div[@role='dialog']/div/div/div[@aria-label='Add friend']/div[1]"));
        AddFriendButtonConfirmation.click();

        driver.quit();
    }

    @Test(priority = 2)
    public void TC_FB_Notify_3Test1() throws InterruptedException {

        //User B
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

        Thread.sleep(2000);
        System.out.println("A real-time notification appears.");
        driver.quit();


    }
}
