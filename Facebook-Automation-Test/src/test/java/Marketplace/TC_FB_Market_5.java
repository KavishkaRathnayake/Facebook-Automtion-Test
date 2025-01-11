package Marketplace;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class TC_FB_Market_5 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Market_5(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Market_2Test() throws InterruptedException, AWTException {
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("patali9600@gmail.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //Access Marketplace
        WebElement Marketplace = driver.findElement(By.xpath("//span[contains(text(),'Marketplace')]"));
        Marketplace.click();

        //Post New Item
        WebElement listing = driver.findElement(By.xpath("//span[contains(text(),'Create new listing')]"));
        listing.click();
        WebElement ChooseType = driver.findElement(By.xpath("//span[contains(text(),'Item for sale')]"));
        ChooseType.click();

        WebElement Photo = driver.findElement(By.xpath("//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x xudqn12 x676frb x1lkfr7t x1lbecb7 x1s688f xzsf02u x2b8uid']"));
        Photo.click();

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


        WebElement Title = driver.findElement(By.xpath("//label[@aria-label='Title']"));
        Title.sendKeys("This is a test listing by KAVISHKA");

        WebElement Price = driver.findElement(By.xpath("//label[@aria-label='Price']"));
        Price.sendKeys("1000");

        WebElement Category = driver.findElement(By.xpath("//label[@aria-label='Category']//i[@class='x1b0d499 xep6ejk']"));
        Category.click();
        WebElement SelectTools = driver.findElement(By.xpath("//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x6prxxf xvq8zen xo1l8bm xzsf02u'][normalize-space()='Tools']"));
        SelectTools.click();

        WebElement Condition = driver.findElement(By.xpath("//label[@aria-label='Condition']"));
        Condition.click();
        WebElement SelectNew = driver.findElement(By.xpath("//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x xudqn12 x3x7a5m x6prxxf xvq8zen xk50ysn xzsf02u x1yc453h'][normalize-space()='New']"));
        SelectNew.click();

        WebElement Brand = driver.findElement(By.xpath("//label[@aria-label='Brand']"));
        Brand.sendKeys("This is a test listing by KAVISHKA");

        WebElement Discription = driver.findElement(By.xpath("//label[@aria-label='Description']"));
        Discription.sendKeys("This is a test listing by KAVISHKA");

        WebElement Tags = driver.findElement(By.xpath("//label[@aria-label='Product tags']"));
        Tags.sendKeys("This is a test listing by KAVISHKA");

        WebElement SKU = driver.findElement(By.xpath("//label[@aria-label='SKU']"));
        SKU.sendKeys("This is a test listing by KAVISHKA");

        WebElement Location = driver.findElement(By.xpath("//label[@aria-label='Location']"));
        Location.sendKeys("Colombo, Sri Lanka");
        WebElement SelectLocation = driver.findElement(By.xpath("//span[normalize-space()='City']"));
        SelectLocation.click();

        WebElement Next = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
        Next.click();
        WebElement Publish = driver.findElement(By.xpath("//span[contains(text(),'Publish')]"));
        Publish.click();

    }
}
