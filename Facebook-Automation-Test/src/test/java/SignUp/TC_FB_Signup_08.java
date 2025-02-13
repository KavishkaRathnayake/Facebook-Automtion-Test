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

public class TC_FB_Signup_08 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Signup_01(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com/");
    }

    @Test
    @Parameters({"Firstname","Lastname","Username","Password"})
    public void TC_FB_Signup_08Test(String first, String Last, String User, String Pass) throws InterruptedException {
        //visit signup page
        WebElement SignupButton = driver.findElement(By.xpath("(//a[normalize-space()='Create new account'])[1]"));
        SignupButton.click();

        //Enter valid name
        WebElement FirstName = driver.findElement(By.name("firstname"));
        FirstName.sendKeys(first);

        WebElement SurName = driver.findElement(By.name("lastname"));
        SurName.sendKeys(Last);

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
        Email.sendKeys(User);

        //Enter Valid Password
        WebElement Password = driver.findElement(By.name("reg_passwd__"));
        Password.sendKeys(Pass);

        //Click on Signup Button
        WebElement SignupButton2 = driver.findElement(By.name("websubmit"));
        SignupButton2.click();

        //Error Message
        String ErrorMessage = driver.findElement(By.xpath("//div[@class='uiContextualLayerPositioner _572t uiLayer']")).getText();
        System.out.println("Error Message: " + ErrorMessage);


    }
    @AfterMethod
    public void after(){
        driver.quit();
    }

}
