package Friends;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;


public class TC_FB_Friends_6 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Friends_6(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @Test
    @Parameters({"Username","Password"})
    public void TC_FB_Friends_6Test(String user, String pass) throws InterruptedException {
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys(user);

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys(pass);

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //View Suggestions
        WebElement VisitToFriends = driver.findElement(By.xpath("//span[contains(text(),'Friends')]"));
        VisitToFriends.click();
        WebElement Suggestions = driver.findElement(By.xpath("//span[contains(text(),'Suggestions')]"));
        Suggestions.click();
        Thread.sleep(2500);

        System.out.println("Yes, A list of friend suggestions appear, showing people the user might know.");

    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
