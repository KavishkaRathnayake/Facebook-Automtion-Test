package LogIn;

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

public class TC_FB_Login_01 {
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
    @Parameters({"Username","Password"})
    public void TC_FB_Login_01(String user, String pass) {
//      Enter a valid username & valid password

        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys(user);

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys(pass);

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

//        //Sometimes while Anonymous Login it is requiring the password again, for that;
//        WebElement AnonymousLoginPassword = driver.findElement(By.id("pass"));
//        AnonymousLoginPassword.sendKeys("Celkon");
//
//        WebElement AnonymousLoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
//        AnonymousLoginButton.click();

    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
}
