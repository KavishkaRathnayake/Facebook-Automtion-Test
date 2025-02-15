package Settings;

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

public class TC_FB_Settings_5 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Settings_5(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.facebook.com/");
    }

    @Test
    @Parameters({"Username","Password"})
    public void TC_FB_Settings_5Test(String user, String Pass) throws InterruptedException {
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys(user);

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys(Pass);


        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //settings
        WebElement ProfileIcon = driver.findElement(By.xpath("//*[name()='g' and contains(@mask,'url(#:R1ld')]//*[name()='image' and contains(@x,'0')]"));
        ProfileIcon.click();
        WebElement PrivacyAndSettings = driver.findElement(By.xpath("//span[normalize-space()='Settings & privacy']"));
        PrivacyAndSettings.click();
        WebElement ActivityLog = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/a[1]/div[1]/div[2]"));
        ActivityLog.click();


    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
}
