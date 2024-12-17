package ForgotPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Forgot_2 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Forgot_2(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://web.facebook.com/?");
    }
    @Test
    public void TC_FB_Forgot_2Test(){
        //Visit to password reset page
        driver.findElement(By.xpath("//a[normalize-space()='Forgotten password?']")).click();

        //Enter an invalid email
        WebElement EnterEmail = driver.findElement(By.name("email"));
        EnterEmail.sendKeys("hovihama.lk");

        WebElement SearchButton = driver.findElement(By.xpath("//button[@id='did_submit']"));
        SearchButton.click();

        WebElement PopupBox = driver.findElement(By.xpath("//div[@class='pam uiBoxRed']"));
        String ErrorMessage = PopupBox.getText();
        System.out.println(ErrorMessage);


        driver.quit();
    }
}
