package Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class TC_FB_Settings_2 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Settings_2(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.facebook.com/");

    }
    @Test
    public void TC_FB_Settings_2Test(){
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("jegoh94617@konican.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //settings
        WebElement ProfileIcon = driver.findElement(By.xpath("//*[name()='g' and contains(@mask,'url(#:R1ld')]//*[name()='image' and contains(@x,'0')]"));
        ProfileIcon.click();
        WebElement PrivacyAndSettings = driver.findElement(By.xpath("//span[normalize-space()='Settings & privacy']"));
        PrivacyAndSettings.click();
        WebElement Language = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(Language).perform();
    }
}
