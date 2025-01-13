package Groups;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Groups_2 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Groups_2(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_Groups_2Test() throws InterruptedException {
        //Login to facebook
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("jegoh94617@konican.com");

        WebElement Password = driver.findElement(By.id("pass"));
        Password.sendKeys("celkon");

        WebElement LoginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        LoginButton.click();

        //Search
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search Facebook']"));
        search.sendKeys("Aliexpress coupon ඉක්මන්ට ගනිමු" + Keys.ENTER);
        //Visit Group
        WebElement Group = driver.findElement(By.xpath("//a[contains(text(),'Aliexpress coupon ඉක්මන්ට ගනිමු')]"));
        Group.click();
        //Join Group
        WebElement join = driver.findElement(By.xpath("//div[@class='x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x2lah0s x193iq5w xeuugli x150jy0e x1e558r4 xjkvuk6 x1iorvi4']//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft'][normalize-space()='Join Group']"));
        String joinButton = join.getText();
        System.out.println("The button text before join the group: " + joinButton);
        join.click();

        Thread.sleep(3000);

        //Verify joined button
        WebElement joined = driver.findElement(By.xpath("//div[@class='x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x2lah0s x193iq5w xeuugli x150jy0e x1e558r4 xjkvuk6 x1iorvi4']//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft'][normalize-space()='Joined']"));
        String isjoined = joined.getText();
        System.out.println("After Joined to the group the join button changed as: " + isjoined);

        Thread.sleep(2000);
        System.out.println("Yes, The 'Join Group' button changes to reflect the new membership status");
        driver.quit();
    }

}
