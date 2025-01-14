package Groups;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Groups_5 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Groups_5(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Groups_5Test(){
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("jegoh94617@konican.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //Search
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search Facebook']"));
        search.sendKeys("Aliexpress coupon ඉක්මන්ට ගනිමු" + Keys.ENTER);
        //Visit Group
        WebElement Group = driver.findElement(By.xpath("//a[contains(text(),'Aliexpress coupon ඉක්මන්ට ගනිමු')]"));
        Group.click();

        //Comment post
        WebElement comment = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[13]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/span[1]/span[1]"));
        comment.click();
        WebElement writeComment = driver.findElement(By.className("xdj266r x11i5rnm xat24cr x1mh8g0r"));
        writeComment.sendKeys("This is a test comment by -KAVISHKA-" + Keys.ENTER);

    }
}
