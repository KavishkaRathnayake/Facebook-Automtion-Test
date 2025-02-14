package Messages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class TC_FB_Msg_5 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Msg_5(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        chromeOptions.addArguments("--use-fake-ui-for-media-stream"); //Auto allow microphone access

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }


    @Test
    @Parameters({"Username","Password"})
    public void TC_FB_Msg_5Test(String user, String Pass) throws InterruptedException {
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys(user);

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys(Pass);

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


        //Text message
        WebElement typetextmessage = driver.findElement(By.xpath("//p[@class='xat24cr xdj266r']"));
        typetextmessage.sendKeys("This is a test message from KAVISHKA" + Keys.ENTER);

        Thread.sleep(2000);

        //Audio
        WebElement AudioButton = driver.findElement(By.xpath("//div[@aria-label='Send a voice clip']//*[name()='svg']"));
        AudioButton.click();
        Thread.sleep(8000);

        WebElement SendAudio = driver.findElement(By.xpath("//div[@aria-label='Press Enter to send']"));
        SendAudio.click();

    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
}
