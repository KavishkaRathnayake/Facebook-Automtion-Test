package Messages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Msg_1 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Msg_1(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void TC_FB_Msg_1Test(){
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("patali9600@gmail.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

//        //Sometimes while Anonymous Login it is requiring the password again, for that;
//        WebElement AnonymousLoginPassword = driver.findElement(By.id("pass"));
//        AnonymousLoginPassword.sendKeys("celkon");

//        WebElement AnonymousLoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
//        AnonymousLoginButton.click();
//
//        WebElement pass = driver.findElement(By.name("pass"));
//        pass.sendKeys("Celkon");
//        driver.findElement(By.name("login")).click();

        //Messages
        WebElement MessageButton = driver.findElement(By.xpath("(//div[@aria-label='Messenger'])[1]"));
        MessageButton.click();
        WebElement Recipient = driver.findElement(By.xpath("//span[contains(text(),'Virat Kohli')]"));
        Recipient.click();
        WebElement typemessage = driver.findElement(By.xpath("//p[@class='xat24cr xdj266r']"));
        typemessage.sendKeys("This is a test message from KAVISHKA");
        WebElement Send = driver.findElement(By.xpath("//div[@aria-label='Press Enter to send']//*[name()='svg']"));
        Send.click();
    }
}
