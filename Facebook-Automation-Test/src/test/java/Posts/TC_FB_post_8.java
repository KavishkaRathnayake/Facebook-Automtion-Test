package Posts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_post_8 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_post_8(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_post_8Test(){
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

        WebElement shareButton = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[2]/div[27]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[13]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/span[1]/span[1]"));
        shareButton.click();
        WebElement thoughts = driver.findElement(By.xpath("//p[@class='xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8']"));
        thoughts.sendKeys("This is a test share, By KAVISHKA");
        WebElement ShareNow = driver.findElement(By.xpath("//span[contains(text(),'Share now')]"));
        ShareNow.click();
    }
}
