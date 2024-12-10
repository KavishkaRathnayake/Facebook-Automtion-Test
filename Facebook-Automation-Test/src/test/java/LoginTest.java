import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openLoginTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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

            //Sometimes while Anonymous Login it is requiring the password again, for that;
        WebElement AnonymousLoginPassword = driver.findElement(By.id("pass"));
        AnonymousLoginPassword.sendKeys("Celkon");

        WebElement AnonymousLoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        AnonymousLoginButton.click();
    }

    @Test
    public void TC_FB_Login_02(){
//        Enter a valid username & invalid password

        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("jigiwi7156@jofuso.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("xxxx");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();
    }
}

