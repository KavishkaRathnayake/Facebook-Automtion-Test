package NavigationBar;

import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Nav_1 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Nav_1(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    @Parameters({"Username","Password"})
    public void TC_FB_Nav_1Test(String user, String Pass) throws InterruptedException {
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys(user);

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys(Pass);

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();
//
//                    //Sometimes while Anonymous Login it is requiring the password again, for that;
//        WebElement AnonymousLoginPassword = driver.findElement(By.id("pass"));
//        AnonymousLoginPassword.sendKeys("Celkon");
//
//        WebElement AnonymousLoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
//        AnonymousLoginButton.click();


        Thread.sleep(5000);

        //    Visit to facebook logo
        driver.findElement(By.xpath("//a[@aria-label='Facebook']//*[name()='svg']")).click();
        Thread.sleep(3000);

//        Click on facebook search
        WebElement SearchBox = driver.findElement(By.xpath("//input[@placeholder='Search Facebook']"));
        SearchBox.sendKeys("Rajarata Uni Lovers" + Keys.ENTER);
        Thread.sleep(2000);

//        Click on facebook Home
        WebElement Home = driver.findElement(By.xpath("//a[@aria-label='Home']"));
        Home.click();
        Thread.sleep(1500);

////        Click on facebook Friends
//        WebElement Friends = driver.findElement(By.xpath("//a[@aria-label='Friends']"));
//        Friends.click();
//        Thread.sleep(2000);

//        Click on facebook Groups
        WebElement Groups = driver.findElement(By.xpath("//a[@aria-label='Groups']"));
        Groups.click();
        Thread.sleep(2000);

//        Click on facebook Messages
        WebElement Messages = driver.findElement(By.xpath("(//div[@aria-label='Messenger'])[1]"));
        Messages.click();
        Thread.sleep(2000);

//        Click on facebook Notifications
        WebElement Notifications = driver.findElement(By.xpath("//a[@aria-label='Notifications']"));
        Notifications.click();
        Thread.sleep(2000);

        driver.quit();


    }


}
