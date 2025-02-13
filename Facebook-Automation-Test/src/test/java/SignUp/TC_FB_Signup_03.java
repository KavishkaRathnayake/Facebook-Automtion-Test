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

public class TC_FB_Signup_03 {

    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Signup_03(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com/");
    }

    @Test
    @Parameters({"Firstname","Lastname","Username","Password"})
    public void TC_FB_Signup_03Test(String first, String Last, String User, String Pass) throws InterruptedException {
        //visit signup page
        WebElement SignupButton = driver.findElement(By.xpath("(//a[normalize-space()='Create new account'])[1]"));
        SignupButton.click();

        //Enter valid name
        WebElement FirstName = driver.findElement(By.name("firstname"));
        FirstName.sendKeys(first);

        WebElement SurName = driver.findElement(By.name("lastname"));
        SurName.sendKeys(Last);

        //Enter an invalid Birthdate
        WebElement Date = driver.findElement(By.name("birthday_day"));
        Select selectDate = new Select(Date);
        selectDate.selectByVisibleText("1");

        WebElement Month = driver.findElement(By.name("birthday_month"));
        Select selectMonth = new Select(Month);
        selectMonth.selectByVisibleText("Apr");

        WebElement Year = driver.findElement(By.name("birthday_year"));
        Select selectYear = new Select(Year);
        selectYear.selectByVisibleText("2024");

        //Check whether Gender is selected and select the gender as custom
        WebElement SeletedGender1 = driver.findElement(By.xpath("(//input[@id='sex'])[1]"));
        Boolean GenderFemale = SeletedGender1.isSelected();

        WebElement SeletedGender2 = driver.findElement(By.xpath("(//input[@id='sex'])[2]"));
        Boolean GenderMale = SeletedGender2.isSelected();

        WebElement SeletedGender3 = driver.findElement(By.xpath("(//input[@id='sex'])[3]"));
        Boolean Gendercustom = SeletedGender3.isSelected();

        if(!(GenderFemale)){
            WebElement Female = driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[1]"));
            Female.click();
            Thread.sleep(500);

            }
        if(!(GenderFemale)) {
            WebElement Male = driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[2]"));
            Male.click();
            Thread.sleep(500);
        }
        if(!(GenderFemale)) {
            WebElement Custom = driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[3]"));
            Custom.click();
            String SelectedGender = Custom.getText();
            System.out.println("Seleted Gender is: " + SelectedGender);

            WebElement Pronoun = driver.findElement(By.name("preferred_pronoun"));
            Select selectPronoun = new Select(Pronoun);
            selectPronoun.selectByValue("6");

            //Enter a valid email
            WebElement Email = driver.findElement(By.name("reg_email__"));
            Email.sendKeys(User);

            //Enter a valid password
            WebElement Password = driver.findElement(By.name("reg_passwd__"));
            Password.sendKeys(Pass);

            WebElement SubmitButton2= driver.findElement(By.name("websubmit"));
            SubmitButton2.click();
            Thread.sleep(5000);

            //Error Message
            WebElement PopupBox = driver.findElement(By.xpath("(//div[@class='uiContextualLayer uiContextualLayerLeft'])[1]"));
            String ErrorMessage =  PopupBox.getText();
            System.out.println("Error Message: " + ErrorMessage);


        }

    }
    @AfterMethod
    public void after(){
        driver.quit();
    }

}
