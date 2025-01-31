package Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Settings_6 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Settings_6() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Settings_6Test() throws InterruptedException {
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
        WebElement DisplayAccessibility = driver.findElement(By.xpath("//span[normalize-space()='Display & accessibility']"));
        DisplayAccessibility.click();


        WebElement on = driver.findElement(By.xpath("//input[@value='ENABLED']"));
//        on.click();
        WebElement Automatic = driver.findElement(By.xpath("//input[@value='USE_SYSTEM']"));
        WebElement off = driver.findElement(By.xpath("//input[@value='DISABLED']"));

        boolean ison = on.isSelected();
        boolean isAuto = Automatic.isSelected();
        boolean isoff = off.isSelected();


            if (isoff) {
                on.click();
                Thread.sleep(1500);
            }

            if (ison) {
                 off.click();
                 Thread.sleep(1500);
        }


        Automatic.click();
        driver.quit();

        }
    }