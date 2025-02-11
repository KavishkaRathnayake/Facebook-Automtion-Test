package Groups;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Groups_6 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Groups_6(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

    }
    @Test
    @Parameters({"Username","Password"})
    public void TC_FB_Groups_6Test(String Username, String Pass){
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys(Username);

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys(Pass);

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //Search
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search Facebook']"));
        search.sendKeys("Aliexpress coupon ඉක්මන්ට ගනිමු" + Keys.ENTER);
        //Visit Group
        WebElement Group = driver.findElement(By.xpath("//a[contains(text(),'Aliexpress coupon ඉක්මන්ට ගනිමු')]"));
        Group.click();

        //Leave group
        WebElement Leave = driver.findElement(By.xpath("//div[@class='x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x2lah0s x193iq5w xeuugli x150jy0e x1e558r4 xjkvuk6 x1iorvi4']//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft'][normalize-space()='Joined']"));
        Leave.click();
        String Verify = Leave.getText();
        System.out.println("Before leave group the button text shows as: " + Verify);
        WebElement LeaveGroup = driver.findElement(By.xpath(" //span[normalize-space()='Leave group']"));
        LeaveGroup.click();
        WebElement ConfirmLeave = driver.findElement(By.xpath("//span[contains(text(),'Leave Group')]"));
        ConfirmLeave.click();

      driver.quit();

    }

}
