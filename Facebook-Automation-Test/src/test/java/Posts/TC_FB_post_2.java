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

public class TC_FB_post_2 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_post_2(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
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

        driver.findElement(By.xpath("//div[@class='x1i10hfl x1ejq31n xd10rxx x1sy0etr x17r0tee x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x1ypdohk xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8 x1hl2dhg xggy1nq x87ps6o x1lku1pv x1a2a7pz x6s0dn4 xmjcpbm x107yiy2 xv8uw2v x1tfwpuw x2g32xy x78zum5 x1q0g3np x1iyjqo2 x1nhvcw1 x1n2onr6 xt7dq6l x1ba4aug x1y1aw1k xn6708d xwib8y2 x1ye3gou']")).click();
        WebElement post = driver.findElement(By.xpath("//p[@class='xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8']"));
        post.sendKeys("Hi everyone, This is a Test Post 02, -KAVISHKA-");

        Thread.sleep(2000);

        //Upload a photo
        WebElement Photo = driver.findElement(By.xpath("//div[@aria-label='Photo/video']//div//div//img[@class='x1b0d499 xl1xv1r']"));
        Photo.click();
        WebElement Upload = driver.findElement(By.xpath("//div[@class='x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x1iyjqo2 x2lwn1j xl56j7k']"));
        Upload.click();

        String data = "C:\\Users\\Kavishka\\Downloads\\FB post.png";
        StringSelection Selection = new StringSelection(data);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Selection , null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);

        //Location
        WebElement Location = driver.findElement(By.xpath("//div[@aria-label='Check in']//div//div//img[@class='x1b0d499 xl1xv1r']"));
        Location.click();
        WebElement SelectLocation = driver.findElement(By.xpath("//input[@placeholder='Where are you?']"));
        SelectLocation.sendKeys("Kurunegala" + Keys.ENTER);
        Thread.sleep(2500);
        driver.findElement(By.xpath("//li[@id='108407892517483']//div[@class='x78zum5 xdt5ytf xz62fqu x16ldp7u']")).click();


        //Tag friends
        Thread.sleep(2000);
        WebElement Tag = driver.findElement(By.xpath("//div[@aria-label='Tag people']//div//div//img[@class='x1b0d499 xl1xv1r']"));
        Tag.click();
        WebElement SelectTag = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        SelectTag.sendKeys("alan walker");
        Thread.sleep(2000);
        WebElement Tagfriend = driver.findElement(By.xpath("//li[@id='100044403847140']//div[@class='x78zum5 xdt5ytf x16n37ib']"));
        Tagfriend.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click();

        //Feeling
        Thread.sleep(2000);
        WebElement Feeling = driver.findElement(By.xpath("//div[@aria-label='Feeling/activity']//div//div//img[@class='x1b0d499 xl1xv1r']"));
        Feeling.click();
        WebElement Activities = driver.findElement(By.xpath("//div[@class='html-div xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x18d9i69 x6s0dn4 x9f619 x78zum5 x2lah0s x1hshjfz x1n2onr6 xng8ra x1pi30zi x1swvt13']//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x xudqn12 x3x7a5m x6prxxf xvq8zen x1s688f xi81zsa'][normalize-space()='Activities']"));
        Activities.click();
        WebElement Listning = driver.findElement(By.xpath("//li[@id='dGFnZ2FibGVfYWN0aXZpdHk6MzgzNjM0ODY4MzM5NDc2']//div[@class='x9f619 x1ja2u2z x78zum5 x1n2onr6 x1r8uery x1iyjqo2 xs83m0k xeuugli x1qughib x6s0dn4 xozqiw3 x1q0g3np xykv574 xbmpl8g x4cne27 xifccgj']"));
        Listning.click();
        WebElement Youtube = driver.findElement(By.xpath("//li[@id='491213680985174']//div[@class='x9f619 x1ja2u2z x78zum5 x1n2onr6 x1r8uery x1iyjqo2 xs83m0k xeuugli x1qughib x6s0dn4 xozqiw3 x1q0g3np xykv574 xbmpl8g x4cne27 xifccgj']"));
        Youtube.click();
        Thread.sleep(2000);

        //Publish
        WebElement Post = driver.findElement(By.xpath("//div[@aria-label='Post']//div[@class='x6s0dn4 x78zum5 xl56j7k x1608yet xljgi0e x1e0frkt']"));
        Post.click();
        Thread.sleep(4000);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight / 35)");
    }
}
