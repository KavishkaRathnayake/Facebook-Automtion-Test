package LogIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openLoginTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Login_01() {
//      Enter a valid username & valid password

        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("jigiwi7156@jofuso.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("Celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

//            //Sometimes while Anonymous Login it is requiring the password again, for that;
//        WebElement AnonymousLoginPassword = driver.findElement(By.id("pass"));
//        AnonymousLoginPassword.sendKeys("Celkon");
//
//        WebElement AnonymousLoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
//        AnonymousLoginButton.click();


    }

    @Test
    public void TC_FB_Login_02() {
//        Enter a valid username & invalid password

        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("jigiwi7156@jofuso.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("xxxx");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        invalidCredentials();

        driver.quit();


    }

    @Test
    public void TC_FB_Login_03() {
//        Enter a invalid username & valid password

        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("fefah24039@eoilup.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("Celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        invalidCredentials2();

        driver.quit();


    }

    @Test
    public void TC_FB_Login_04() {
        //        Enter a invalid username & invalid password

        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("fefah24039@eoilup.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("Micromax");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        invalidCredentials2();

    }

    @Test
    public void TC_FB_Login_05(){
        //     Don't Enter a username & password
        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        invalidCredentials2();

        driver.quit();

    }

    //Error message when entering wrong credentials. (But that error message is Showing sometimes only )
    public void invalidCredentials() {
        WebElement invalidCredentials = driver.findElement(By.xpath("(//div[@class='_9ay7'])[1]"));
        String errormessage = invalidCredentials.getText();
        System.out.println("Showing an error as: " + errormessage);
    }

    //Error message when entering wrong credentials. (But that error message is Showing sometimes only )
    public void invalidCredentials2() {
        WebElement invalidCredentials2 = driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String errormessage = invalidCredentials2.getText();
        System.out.println("Showing an error as: " + errormessage);

    }


}

