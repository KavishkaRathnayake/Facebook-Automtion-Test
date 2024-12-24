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

public class TC_FB_post_6 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_post_6(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_post_5Test() throws InterruptedException, AWTException {
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

        WebElement pass = driver.findElement(By.name("pass"));
        pass.sendKeys("Celkon");
        driver.findElement(By.name("login")).click();

        //Scroll half of the page
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        Long scrollHeight = (Long) javascriptExecutor.executeScript("return document.body.scrollHeight");
        javascriptExecutor.executeScript("window.scrollBy(0, arguments[0] / 2);", scrollHeight);

//        Comment on Post
        WebElement Comment = driver.findElement(By.xpath("//div[@class='x1hc1fzr x1unhpq9 x6o7n8i']//div//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[13]//div[1]//div[1]//div[4]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//span[1]//span[1]"));
        Comment.click();
        WebElement Write = driver.findElement(By.xpath("//p[@class='xdj266r x11i5rnm xat24cr x1mh8g0r']"));
        Write.sendKeys("This is a test comment, From KAVISHKA" );

        //Insert emoji
        WebElement Emoji = driver.findElement(By.xpath("//div[@id='focused-state-actions-list']//div[@aria-label='Insert an emoji']"));
        Emoji.click();
        driver.findElement(By.xpath("//img[@alt='☺\uFE0F']")).click();
        driver.findElement(By.xpath("//img[@alt='\uD83D\uDE07']")).click();

        //Upload a photo
        WebElement icon = driver.findElement(By.xpath("//div[@id='focused-state-actions-list']//div[@aria-label='Attach a photo or video']"));
        icon.click();

        String data = "C:\\Users\\Kavishka\\Downloads\\FB post.png";
        StringSelection selection = new StringSelection(data);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);

        Write.sendKeys(Keys.ENTER);



    }
}
