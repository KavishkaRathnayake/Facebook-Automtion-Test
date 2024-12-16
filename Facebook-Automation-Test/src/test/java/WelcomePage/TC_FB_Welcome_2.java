package WelcomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Welcome_2 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Welcome_2(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com/?");
    }

    @Test
    public void TC_FB_Welcome_2Test() throws InterruptedException {
        //Username
        WebElement Username = driver.findElement(By.name("email"));
        String UsernameText = Username.getAttribute("placeholder");
        String UsernameInputtype = Username.getAttribute("type");
        System.out.println("Username input type is: " + UsernameInputtype);
        System.out.println("Username Text is: " + UsernameText);

        Username.sendKeys("jigiwi7156@jofuso.com");


      //Password
        WebElement Password = driver.findElement(By.name("pass"));
        String Passwordtype = Password.getAttribute("type");
        String Passwordtext = Password.getAttribute("placeholder");

        System.out.println("Passowrd Input type is: " + Passwordtype);
        System.out.println("Password text is: " + Passwordtext);

        Password.sendKeys("Celkon");

        //Login Button
        System.out.println("<<<<<<<<<<Login Button>>>>>>>>>>");
        WebElement LoginButton = driver.findElement(By.name("login"));
        String LoginButtonText = LoginButton.getText();
        System.out.println("Loggin Button Text is: " + LoginButtonText);

        String BackgroundColour = LoginButton.getCssValue("background-color");
        String Fontsize =  LoginButton.getCssValue("font-size");
        String Textcolour = LoginButton.getCssValue("color");
        String TextFont = LoginButton.getCssValue("font-family");
        System.out.println("Loggin button Font size: " + Fontsize);
        System.out.println("Loggin button Background Colour: " + BackgroundColour);
        System.out.println("Loggin button Text Colour: " + Textcolour);
        System.out.println("Loggin button Text Font: " + TextFont);



        //signup button
        System.out.println("<<<<<<<<<Signup Button>>>>>>>>>>");
        WebElement SignupButton = driver.findElement(By.xpath("(//a[normalize-space()='Create new account'])[1]"));
        String SignupButtonText = SignupButton.getText();
        System.out.println("Loggin Button Text is: " + SignupButtonText);

        String BackgroundColour2 = SignupButton.getCssValue("background-color");
        String Fontsize2 =  SignupButton.getCssValue("font-size");
        String Textcolour2 = SignupButton.getCssValue("color");
        String TextFont2 = SignupButton.getCssValue("font-family");
        String SignupButtonLink = SignupButton.getAttribute("href");

        System.out.println("Signup Button Font size: " + Fontsize2);
        System.out.println("Signup Button Background Colour: " + BackgroundColour2);
        System.out.println("Signup Button Text Colour: " + Textcolour2);
        System.out.println("Signup Button Text Font: " + TextFont2);
        System.out.println("Signup Button Page Link: " + SignupButtonLink);
        SignupButton.click();

        driver.navigate().back();

        //Forgooten Password
        WebElement ForgottenPasworrd = driver.findElement(By.xpath("//a[normalize-space()='Forgotten password?']"));
        String ForgottenPaswordtext = ForgottenPasworrd.getText();
        String ForgottenPasswordLink = ForgottenPasworrd.getAttribute("href");
        System.out.println("Forgotten Password Text is: " + ForgottenPaswordtext);
        System.out.println("Forgotten Password Link is: " + ForgottenPasswordLink);


        Thread.sleep(500);
        driver.quit();
    }
}
