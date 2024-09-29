import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
    WebDriver driver;


    @BeforeMethod
    public void OpenHomePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/?_rdc=1&_rdr");
    }
    @Test
    public void HomePageTest(){
        //FaceBook Logo size
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Facebook']"));
        String height = logo.getCssValue("height");
        String margin = logo.getCssValue("margin");

        System.out.println("Logo height is: " + height);
        System.out.println("Logo margin is: " + margin);

        //The text under FaceBook Logo
        WebElement textunderLogo = driver.findElement(By.xpath("//h2[@class='_8eso']"));
        String Text =textunderLogo.getText();
        System.out.println("Text is: " + Text);

        //Text on the textbox field

        WebElement TxtField = driver.findElement(By.id("email"));
        String Textbox1 = TxtField.getAttribute("aria-label");
        System.out.println("Text on the Textbox 01: " + Textbox1);

        WebElement passwordField = driver.findElement(By.id("passContainer"));
        String Textbox2 = passwordField.getAttribute("aria-label");
        System.out.println("Text on the Textbox 02: " + Textbox2);



        //Loggin Button
        WebElement LogginButton = driver.findElement(By.name("login"));
        String color = LogginButton.getCssValue("background-color");
        System.out.println("Loggin button color is: " + color);

        String buttontext = LogginButton.getText();
        System.out.println("Button Text is: " + buttontext);

        String ButtonTextcolor = LogginButton.getCssValue("color");
        System.out.println("Loggin button color is: " + ButtonTextcolor);

        String ButtonFont = LogginButton.getCssValue("font-family");
        System.out.println("Loggin button font is: " + ButtonFont);

        //Fogotten Password
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[normalize-space()='Forgotten password?']"));
        String linkText = forgotPasswordLink.getText();
        System.out.println("Fogotten Password text is: " + linkText);

        forgotPasswordLink.click();
        driver.navigate().back();

        //Create new account button
        WebElement Createaccountbutton = driver.findElement(By.xpath("//a[normalize-space()='Create new account']"));
        String buttonText02 = Createaccountbutton.getText();
        System.out.println("Button Text is: " + buttonText02);

        String Buttoncolor =  Createaccountbutton.getCssValue("background-color");
        System.out.println("new account button color is: " + Buttoncolor);

        //Text that bottom of the page
        WebElement bottomtext = driver.findElement(By.xpath("//div[@id='reg_pages_msg']"));
        String textbottomthepage = bottomtext.getText();
        System.out.println("Text bottom of the page is: " + textbottomthepage);


    driver.quit();
    }
}

