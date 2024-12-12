package SignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_FB_Signup_05 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Signup_05(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com/");
    }

    @Test
    public void TC_FB_Signup_05Test() throws InterruptedException {
        //visit signup page
        WebElement SignupButton = driver.findElement(By.xpath("(//a[normalize-space()='Create new account'])[1]"));
        SignupButton.click();

        //Enter valid name
        WebElement FirstName = driver.findElement(By.name("firstname"));
        FirstName.sendKeys("Kaveesha");

        WebElement SurName = driver.findElement(By.name("lastname"));
        SurName.sendKeys("Rathnayaka");

        //Enter valid Birthdate
        WebElement Date = driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDate = new Select(Date);
        selectDate.selectByIndex(26);

        WebElement Month = driver.findElement(By.xpath("//select[@id='month']"));
        Select selectMonth = new Select(Month);
        selectMonth.selectByVisibleText("Jan");

        WebElement Year = driver.findElement(By.xpath("//select[@id='year']"));
        Select selectYear = new Select(Year);
        selectYear.selectByVisibleText("2001");

        //Check whether Gender is selected and select the gender
        WebElement SeletedGender1 = driver.findElement(By.xpath("(//input[@id='sex'])[1]"));
        boolean GenderFemale = SeletedGender1.isSelected();

        WebElement SeletedGender2 = driver.findElement(By.xpath("(//input[@id='sex'])[2]"));
        boolean Gendermale = SeletedGender2.isSelected();

        WebElement SeletedGender3 = driver.findElement(By.xpath("(//input[@id='sex'])[2]"));
        boolean GenderCustom = SeletedGender3.isSelected();

        if (!(GenderFemale)){
            WebElement Female = driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[1]"));
            Female.click();
            String SeletedGender = Female.getText();
            System.out.println("Seleted Gender is: " + SeletedGender);
        }

        //Enter valid Email
        WebElement Email =  driver.findElement(By.name("reg_email__"));
        Email.sendKeys("fefah24039@eoilup.com");

        //Enter Valid Password
        WebElement Password = driver.findElement(By.name("reg_passwd__"));
        Password.sendKeys("xxxx");

        //Click on Signup Button
        WebElement SignupButton2 = driver.findElement(By.name("websubmit"));
        SignupButton2.click();
        Thread.sleep(20000);

        //Error Message
        String ErrorMessage = driver.findElement(By.xpath("(//div[@id='reg_error'])[1]")).getText();
        System.out.println("Error Message: " + ErrorMessage);

        driver.quit();

    }

}
