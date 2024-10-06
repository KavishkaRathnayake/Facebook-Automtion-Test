import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openLoginTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void FBLoginTest(){
       //01) Check Login giving Correct Credentials
//        driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("jigiwi7156@jofuso.com");
//        driver.findElement(By.xpath("(//input[@id='pass'])[1]")).sendKeys("Celkon");
//        driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]")).click();
//
        //02) Check Login giving InCorrect Credentials
        //02.1) Check Login giving Incorrect email
        driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("xyz@gmail.com");
        driver.findElement(By.xpath("(//input[@id='pass'])[1]")).sendKeys("Celkon");
        WebElement Loginbutton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        Loginbutton.click();

        IncorrectCredentials();

       driver.navigate().back();

        //02.2)Check Login giving Incorrect Password
        driver.findElement(By.xpath("(//input[@id='email'])[1]")).clear();
        driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("jigiwi7156@jofuso.com");
        driver.findElement(By.xpath("(//input[@id='pass'])[1]")).sendKeys("xyzhijk");
        WebElement Loginbutton2 = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        Loginbutton2.click();

        IncorrectCredentials();

//        03)Forgotten Password
        driver.navigate().back();
        WebElement ForgottenPassword = driver.findElement(By.xpath("(//a[normalize-space()='Forgotten password?'])[1]"));
        String Text =  ForgottenPassword.getText();
        System.out.println("Text of the link is: " + Text);

        //03.1.1) Give password & Try to login
        ForgottenPassword.click();
        driver.findElement(By.xpath("(//input[@id='pass'])[1]")).sendKeys("abefg");
        driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]")).click();
        driver.navigate().back();

        //03.1.2) Try Another way button
        WebElement TryAnotherwaybutton =  driver.findElement(By.xpath("//a[normalize-space()='Try another way']"));
        String TryAnotherwaybuttonTXT = TryAnotherwaybutton.getText();
        System.out.println("Button text is: " +TryAnotherwaybuttonTXT);
        TryAnotherwaybutton.click();

        //03.1.3)Try Another way button page
        String pagetittle = driver.getTitle();
        System.out.println("Page Tittle is: " +pagetittle);

        WebElement FbButtononNavigationBar = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[2]/div"));
        FbButtononNavigationBar.click();
        driver.findElement(By.xpath("(//div[@aria-label='Close'])[1]")).click();

        //03.2) Reset Password options

        //03.2.1) Send code via email
        WebElement Sendcodeviaemail = driver.findElement(By.xpath("//input[@id='send_email']"));
        Sendcodeviaemail.click();
        WebElement ContinueButton = driver.findElement(By.xpath("(//button[normalize-space()='Continue'])[1]"));
        ContinueButton.click();



    }
    public void IncorrectCredentials() {
        WebElement IncorrectCredentials = driver.findElement(By.xpath("(//div[@class='_9ay7'])[1]"));
        String IncorrectPassword = IncorrectCredentials.getText();
        System.out.println("It Says: " + IncorrectPassword);
    }


}
