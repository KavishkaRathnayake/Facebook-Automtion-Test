package Groups;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Groups_4 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Groups_4(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    @Parameters({"Username","Password"})
    public void TC_FB_Groups_4Test(String Username,String pass) throws InterruptedException {
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys(Username);

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys(pass);

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //Search
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search Facebook']"));
        search.sendKeys("Aliexpress coupon ඉක්මන්ට ගනිමු" + Keys.ENTER);
        //Visit Group
        WebElement Group = driver.findElement(By.xpath("//a[contains(text(),'Aliexpress coupon ඉක්මන්ට ගනිමු')]"));
        Group.click();

        //React post
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight / 2)");
        //Like
        Actions reactAction = new Actions(driver);
        WebElement Recactbutton1 = driver.findElement(By.xpath("(//span[@data-ad-rendering-role='like_button'][normalize-space()='Like'])[1]"));
        reactAction.moveToElement(Recactbutton1);
        Thread.sleep(1500);
        WebElement Like = driver.findElement(By.xpath("//div[@aria-label='Like']//div//canvas"));
        reactAction.moveToElement(Like);
        Thread.sleep(1500);
        Like.click();

        //Love
        WebElement Recactbutton2 = driver.findElement(By.xpath("//span[@class='x2mfxb x1au9nqc x3nfvp2']//i[@class='x1b0d499 x1d69dk1']"));
        reactAction.moveToElement(Recactbutton2);
        Thread.sleep(1500);
        WebElement Love = driver.findElement(By.xpath("//div[@aria-label='Love']//div//canvas"));
        reactAction.moveToElement(Love);
        Thread.sleep(1500);
        Love.click();

        //Care
        WebElement Recactbutton3 = driver.findElement(By.xpath("//span[@class='x2mfxb x1au9nqc x3nfvp2']//i[@class='x1b0d499 x1d69dk1']"));
        reactAction.moveToElement(Recactbutton3);
        Thread.sleep(1500);
        WebElement Care = driver.findElement(By.xpath("//div[@aria-label='Care']//div//canvas"));
        reactAction.moveToElement(Care);
        Thread.sleep(1500);
        Care.click();

        //Haha
        WebElement Recactbutton4 = driver.findElement(By.xpath("//span[@class='x2mfxb x1au9nqc x3nfvp2']//i[@class='x1b0d499 x1d69dk1']"));
        reactAction.moveToElement(Recactbutton4);
        Thread.sleep(1500);
        WebElement Haha = driver.findElement(By.xpath("//div[@aria-label='Haha']//div//canvas"));
        reactAction.moveToElement(Haha);
        Thread.sleep(1500);
        Haha.click();

        //Wow
        WebElement Recactbutton5 = driver.findElement(By.xpath("//span[@class='x2mfxb x1au9nqc x3nfvp2']//i[@class='x1b0d499 x1d69dk1']"));
        reactAction.moveToElement(Recactbutton5);
        Thread.sleep(1500);
        WebElement Wow = driver.findElement(By.xpath("//div[@aria-label='Wow']//div//canvas"));
        reactAction.moveToElement(Wow);
        Thread.sleep(1500);
        Wow.click();

        //Sad
        WebElement Recactbutton6 = driver.findElement(By.xpath("//span[@class='x2mfxb x1au9nqc x3nfvp2']//i[@class='x1b0d499 x1d69dk1']"));
        reactAction.moveToElement(Recactbutton6);
        Thread.sleep(1500);
        WebElement Sad = driver.findElement(By.xpath("//div[@aria-label='Sad']//div//canvas"));
        reactAction.moveToElement(Sad);
        Thread.sleep(1500);
        Sad.click();

        //Angry
        WebElement Recactbutton7 = driver.findElement(By.xpath("//span[@class='x2mfxb x1au9nqc x3nfvp2']//i[@class='x1b0d499 x1d69dk1']"));
        reactAction.moveToElement(Recactbutton7);
        Thread.sleep(1500);
        WebElement Angry = driver.findElement(By.xpath("//div[@aria-label='Angry']//div//canvas"));
        reactAction.moveToElement(Angry);
        Thread.sleep(1500);
        Angry.click();

    }
}
