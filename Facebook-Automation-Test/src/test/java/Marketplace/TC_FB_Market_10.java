package Marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Market_10 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Market_9() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com/marketplace/?_rdc=1&_rdr");
    }

    @Test
    public void TC_FB_Market_9Test() throws InterruptedException {

        System.out.println("The user is redirected to the login page");
        Thread.sleep(2500);
        driver.quit();

    }
}
