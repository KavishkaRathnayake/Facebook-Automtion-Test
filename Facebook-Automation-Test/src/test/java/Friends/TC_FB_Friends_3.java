package Friends;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Friends_3 {
    WebDriver driver;

    public void TC_FB_Friends_3(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test(priority = 1)
    public void TC_FB_Friends_3Test() {

        //User A
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("patali9600@gmail.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

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
    public void TC_FB_Friends_3Test1() {

        //User B
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("jegoh94617@konican.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //Delete request
        WebElement FriendSection = driver.findElement(By.xpath("//span[contains(text(),'Find friends')]"));
        FriendSection.click();
        WebElement FriendRequests = driver.findElement(By.xpath("//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lkfr7t x1lbecb7 xk50ysn xzsf02u'][normalize-space()='Friend Requests']"));
        FriendRequests.click();
        WebElement Delete = driver.findElement(By.xpath("//div[@class='x135pmgq']//div//div//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x xudqn12 x3x7a5m x6prxxf xvq8zen x1s688f x1dem4cn']//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft'][normalize-space()='Delete']"));
        Delete.click();

        //Verify
        WebElement verify = driver.findElement(By.xpath("//div[@class='x1huwwth x16suv20']"));
        String Request = verify.getText();
        System.out.println("Button Shows: " + Request);
        System.out.println("Yes, Successfully Removed Friend List");

        driver.quit();

    }
}
