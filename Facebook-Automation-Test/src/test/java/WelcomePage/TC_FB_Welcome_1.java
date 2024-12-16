package WelcomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Welcome_1 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Logo_1(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com/");
    }

    @Test
    public void TC_FB_Logo_1Test(){
        WebElement LogoSize = driver.findElement(By.xpath("(//img[@alt='Facebook'])[1]"));
        String margin =  LogoSize.getCssValue("margin");
        String height =  LogoSize.getCssValue("height");
        System.out.println("Logo height is: " + height);
        System.out.println("Logo margin is: " + margin);
        System.out.println("");

        //Text under the Facebook Logo
        System.out.println("<<<<<<<<<<<The Text Under the Facebook logo>>>>>>>>>>");
        WebElement UnderLogoText = driver.findElement(By.xpath("//h2[@class='_8eso']"));
        String Text = UnderLogoText.getText();
        System.out.println("The Text Under the Facebook logo is: " + Text);

        String Textfontfamily = UnderLogoText.getCssValue("font-family");
        String Textfontsize = UnderLogoText.getCssValue("font-size");
        String Textfontweight = UnderLogoText.getCssValue("font-weight");
        String Textlineheight = UnderLogoText.getCssValue("line-height");
        String TextWidth = UnderLogoText.getCssValue("width");

        System.out.println("Text font size is: " + Textfontsize);
        System.out.println("Text font family is: " + Textfontfamily);
        System.out.println("Text font weight is: " + Textfontweight);
        System.out.println("Text line height is: " + Textlineheight);
        System.out.println("Text Width is: " + TextWidth);

        driver.quit();


    }

}
