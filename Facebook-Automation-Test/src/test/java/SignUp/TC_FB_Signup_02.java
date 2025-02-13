package SignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Signup_02 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Signup_02(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com/");
    }
    @Test
    @Parameters({"Firstname","Lastname","Username","Password"})
    public void TC_FB_Signup_02Test(String first, String Last, String User, String Pass) throws InterruptedException {
        //visit signup page
        WebElement SignupButton = driver.findElement(By.xpath("(//a[normalize-space()='Create new account'])[1]"));
        SignupButton.click();

        //Enter valid name
        WebElement FirstName = driver.findElement(By.name("firstname"));
        FirstName.sendKeys(first);

        WebElement SurName = driver.findElement(By.name("lastname"));
        SurName.sendKeys(Last);

        //Enter a valid Birthdate
        WebElement Date = driver.findElement(By.name("birthday_day"));
        Select selectDate = new Select(Date);
        selectDate.selectByIndex(26);

        WebElement Month = driver.findElement(By.name("birthday_month"));
        Select selectMonth = new Select(Month);
        selectMonth.selectByVisibleText("Jan");

        WebElement Year = driver.findElement(By.name("birthday_year"));
        Select selectYear = new Select(Year);
        selectYear.selectByVisibleText("2001");

        //Check whether Gender is selected and select the gender as male
        WebElement SeletedGender1 = driver.findElement(By.xpath("//span[@data-type='radio']//span[1]"));
        Boolean GenderFemale = SeletedGender1.isSelected();

        WebElement SeletedGender2 = driver.findElement(By.xpath("//span[@data-type='radio']//span[2]"));
        Boolean Gendermale = SeletedGender2.isSelected();

        WebElement SeletedGender3 = driver.findElement(By.xpath("//span[@data-type='radio']//span[3]"));
        Boolean GenderCustom = SeletedGender3.isSelected();

        if (!(GenderFemale)) {
            WebElement Female = driver.findElement(By.xpath("//span[@data-type='radio']//span[1]"));
            Female.click();
        }
        Thread.sleep(500);

        if (!(GenderCustom)) {
            WebElement Custom = driver.findElement(By.xpath("//span[@data-type='radio']//span[3]"));
            Custom.click();
        }
        Thread.sleep(500);

        if (!(Gendermale)) {
            WebElement Male = driver.findElement(By.xpath("//span[@data-type='radio']//span[2]"));
            Male.click();
            String SeletedGender = Male.getText();
            System.out.println("Selected Gender is: " + SeletedGender);
        }

        //Enter a valid email
        WebElement Email = driver.findElement(By.name("reg_email__"));
        Email.sendKeys(User);

        //Enter a valid password
        WebElement Password = driver.findElement(By.name("reg_passwd__"));
        Password.sendKeys(Pass);

        //Click on Signup Button
        WebElement SignupButton2 = driver.findElement(By.name("websubmit"));
        SignupButton2.click();

        Thread.sleep(10000);
        WebElement PopupBox = driver.findElement(By.xpath("//div[@id='reg_error_inner']"));
        String ErrorMessage = PopupBox.getText();
        System.out.println("Error Message: " + ErrorMessage);


    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
}
