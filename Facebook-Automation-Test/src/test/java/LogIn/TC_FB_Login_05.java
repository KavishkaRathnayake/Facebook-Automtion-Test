package LogIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Login_05 {
    WebDriver driver;

    @BeforeMethod
    public void openLoginTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void TC_FB_Login_05(){
        //     Don't Enter a username & password
        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        invalidCredentials2();



    }
    //Error message when entering wrong credentials. (But that error message is Showing sometimes only )
    public void invalidCredentials2() {
        WebElement invalidCredentials2 = driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String errormessage = invalidCredentials2.getText();
        System.out.println("Showing an error as: " + errormessage);

    }
    @AfterMethod
    public void after(){
        driver.quit();
    }

}
