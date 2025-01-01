package Messages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class TC_FB_Msg_4 {
    WebDriver driver;

    @BeforeMethod
     public void  TC_FB_Msg_4(){
         ChromeOptions chromeOptions = new ChromeOptions();
         chromeOptions.setBrowserVersion("121");
         driver = new ChromeDriver(chromeOptions);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         driver.manage().window().maximize();
         driver.get("https://www.facebook.com/");
     }

     @Test
    public void TC_FB_Msg_4Test() throws InterruptedException, AWTException {
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


        //photo

        WebElement PhotoButton = driver.findElement(By.xpath("//div[@aria-label='Attach a file']//*[name()='svg']"));
        PhotoButton.click();

        String data = "C:\\Users\\Kavishka\\Downloads\\FB post.png";
        StringSelection selection = new StringSelection(data);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);

        //Text message
        WebElement typetextmessage = driver.findElement(By.xpath("//p[@class='xat24cr xdj266r']"));
        typetextmessage.sendKeys("This is a test message from KAVISHKA");
        WebElement Send = driver.findElement(By.xpath("//div[@aria-label='Press Enter to send']//*[name()='svg']"));
        Send.click();
        Thread.sleep(2000);

        //Emoji
        WebElement ChooseEmoji = driver.findElement(By.xpath("//div[@class='x9f619 x1n2onr6 x1ja2u2z __fb-light-mode']//div[@aria-label='Choose an emoji']//*[name()='svg']"));
        ChooseEmoji.click();
        Thread.sleep(5000);
        WebElement Emoji1 = driver.findElement(By.xpath("//img[@alt='\uD83D\uDE03']"));
        Emoji1.click();
        WebElement Emoji2 = driver.findElement(By.xpath("//img[@alt='\uD83E\uDDD0']"));
        Emoji2.click();
        WebElement Emoji3 = driver.findElement(By.xpath("//img[@alt='\uD83E\uDD29']"));
        Emoji3.click();
        WebElement Emoji4 = driver.findElement(By.xpath("//img[@alt='\uD83D\uDE0E']"));
        Emoji4.click();
        WebElement Send2 = driver.findElement(By.xpath("//div[@aria-label='Press Enter to send']//*[name()='svg']"));
        Send2.click();


    }
}
