package Friends;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Friends_1 {
    WebDriver driver;

////    @BeforeMethod
////    public void TC_FB_Friends_1(){
//
//
//    }

    @Test(priority = 1)
    public void TC_FB_Friends_1Test() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

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

        WebElement verify = driver.findElement(By.xpath("//span[contains(text(),'Cancel request')]"));
        String Request = verify.getText();
        System.out.println("Button Text Changes as: " + Request);

        driver.quit();
    }


}
