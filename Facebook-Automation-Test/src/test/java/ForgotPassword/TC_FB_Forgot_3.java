package ForgotPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Forgot_3 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Forgot_1(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://web.facebook.com/?");
    }

    @Test
    public void TC_FB_Forgot_1Test(){
        //visit to the password reset page
        driver.findElement(By.xpath("(//a[normalize-space()='Forgotten password?'])[1]")).click();

        //Enter a Valid Email
        WebElement EnterEmail = driver.findElement(By.name("email"));
        EnterEmail.sendKeys("0773681755");

        WebElement SearchButton = driver.findElement(By.xpath("//button[@id='did_submit']"));
        SearchButton.click();

        WebElement ContinueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        ContinueButton.click();
//
//        Boolean EmailButton = driver.findElement(By.name("send_email")).isSelected();
//        WebElement  PasswordButton = driver.findElement(By.name("recover_method"));
//        PasswordButton.isSelected();
//
//        if((EmailButton)){
//            WebElement selectEmailButton = driver.findElement(By.name("send_email"));
//            selectEmailButton.click();
//        }



    }
}
