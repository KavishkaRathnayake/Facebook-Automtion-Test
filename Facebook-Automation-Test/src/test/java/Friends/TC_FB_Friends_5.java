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

public class TC_FB_Friends_5 {
    WebDriver driver;
    @BeforeMethod
    public void TC_FB_Friends_5(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    @Parameters({"Username", "Password"})
    public void TC_FB_Friends_5Test(String user, String Pass) throws InterruptedException {
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys(user);

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys(Pass);

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //Unfriend User
        WebElement VisitToFriends = driver.findElement(By.xpath("//span[contains(text(),'Friends')]"));
        VisitToFriends.click();
        WebElement AllFriends = driver.findElement(By.xpath("//span[contains(text(),'All friends')]"));
        AllFriends.click();
        WebElement More = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[5]/a[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]"));
        More.click();
        Thread.sleep(2500);

        WebElement Unfriend = driver.findElement(By.xpath("//span[normalize-space()='Unfriend Kavishka']"));
        Unfriend.click();
        WebElement Confirmation = driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
        Confirmation.click();

        //Verify
        WebElement Verify = driver.findElement(By.xpath("//span[contains(text(),'Add friend')]"));
        String AddFriendButton = Verify.getText();
        System.out.println("Button Text Changes as: " + AddFriendButton);

    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
