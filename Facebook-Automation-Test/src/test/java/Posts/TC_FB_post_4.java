package Posts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class TC_FB_post_4 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_post_4() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_FB_post_4Test() throws InterruptedException, AWTException {
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

        WebElement pass = driver.findElement(By.name("pass"));
        pass.sendKeys("Celkon");
       driver.findElement(By.name("login")).click();

//       //Scroll half of the page
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        Long scrollHeight = (Long) javascriptExecutor.executeScript("return document.body.scrollHeight");
//        javascriptExecutor.executeScript("window.scrollBy(0, arguments[0] / 2);", scrollHeight);

        //Like React
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Like']//div[@class='x9f619 x1ja2u2z x78zum5 x1n2onr6 x1r8uery x1iyjqo2 xs83m0k xeuugli xl56j7k x6s0dn4 xozqiw3 x1q0g3np xn6708d x1ye3gou xexx8yu xcud41i x139jcc6 x4cne27 xifccgj xn3w4p2 xuxw1ft']"))).perform();
        WebElement Like = driver.findElement(By.xpath("//div[@aria-label='Like']//div//canvas"));
        actions.moveToElement(Like).perform();
        Like.click();
        Thread.sleep(1500);

        //Heart React
        actions.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Like']//div[@class='x9f619 x1ja2u2z x78zum5 x1n2onr6 x1r8uery x1iyjqo2 xs83m0k xeuugli xl56j7k x6s0dn4 xozqiw3 x1q0g3np xn6708d x1ye3gou xexx8yu xcud41i x139jcc6 x4cne27 xifccgj xn3w4p2 xuxw1ft']"))).perform();
        WebElement Heart = driver.findElement(By.xpath("//div[@aria-label='Love']//div//canvas"));
        actions.moveToElement(Heart).perform();
        Heart.click();
        Thread.sleep(1500);

        //Care React
        actions.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Like']//div[@class='x9f619 x1ja2u2z x78zum5 x1n2onr6 x1r8uery x1iyjqo2 xs83m0k xeuugli xl56j7k x6s0dn4 xozqiw3 x1q0g3np xn6708d x1ye3gou xexx8yu xcud41i x139jcc6 x4cne27 xifccgj xn3w4p2 xuxw1ft']"))).perform();
        WebElement Care = driver.findElement(By.xpath("//div[@aria-label='Care']//div//canvas"));
        actions.moveToElement(Care).perform();
        Care.click();
        Thread.sleep(1500);

        //Haha React
        actions.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Like']//div[@class='x9f619 x1ja2u2z x78zum5 x1n2onr6 x1r8uery x1iyjqo2 xs83m0k xeuugli xl56j7k x6s0dn4 xozqiw3 x1q0g3np xn6708d x1ye3gou xexx8yu xcud41i x139jcc6 x4cne27 xifccgj xn3w4p2 xuxw1ft']"))).perform();
        WebElement Haha = driver.findElement(By.xpath("//div[@aria-label='Haha']//div//canvas"));
        actions.moveToElement(Haha).perform();
        Haha.click();
        Thread.sleep(1500);

        //Wow React
        actions.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Like']//div[@class='x9f619 x1ja2u2z x78zum5 x1n2onr6 x1r8uery x1iyjqo2 xs83m0k xeuugli xl56j7k x6s0dn4 xozqiw3 x1q0g3np xn6708d x1ye3gou xexx8yu xcud41i x139jcc6 x4cne27 xifccgj xn3w4p2 xuxw1ft']"))).perform();
        WebElement Wow = driver.findElement(By.xpath("//div[@aria-label='Wow']//div//canvas"));
        actions.moveToElement(Wow).perform();
        Wow.click();
        Thread.sleep(1500);

        //Sad React
        actions.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Like']//div[@class='x9f619 x1ja2u2z x78zum5 x1n2onr6 x1r8uery x1iyjqo2 xs83m0k xeuugli xl56j7k x6s0dn4 xozqiw3 x1q0g3np xn6708d x1ye3gou xexx8yu xcud41i x139jcc6 x4cne27 xifccgj xn3w4p2 xuxw1ft']"))).perform();
        WebElement Sad = driver.findElement(By.xpath("//div[@aria-label='Sad']//div//canvas"));
        actions.moveToElement(Sad).perform();
        Sad.click();
        Thread.sleep(1500);

        //Angry React
        actions.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Like']//div[@class='x9f619 x1ja2u2z x78zum5 x1n2onr6 x1r8uery x1iyjqo2 xs83m0k xeuugli xl56j7k x6s0dn4 xozqiw3 x1q0g3np xn6708d x1ye3gou xexx8yu xcud41i x139jcc6 x4cne27 xifccgj xn3w4p2 xuxw1ft']"))).perform();
        WebElement Angry = driver.findElement(By.xpath("//div[@aria-label='Angry']//div//canvas"));
        actions.moveToElement(Angry).perform();
        Angry.click();

    }
}
