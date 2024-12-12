package SignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_FB_Signup_04 {
    WebDriver driver;

    @BeforeMethod
    public void TC_FB_Signup_04(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com/");
    }
    @Test
    public void TC_FB_Signup_04Test() throws InterruptedException {
        //visit signup page
        driver.findElement(By.xpath("(//a[normalize-space()='Create new account'])[1]")).click();


        //Enter a valid name
        WebElement FirstName  = driver.findElement(By.name("firstname"));
        FirstName.sendKeys("Kavishka");

        WebElement Suraneme = driver.findElement(By.name("lastname"));
        Suraneme.sendKeys("Rathnayaka");

        //Enter an valid Birthdate
        WebElement Date = driver.findElement(By.name("birthday_day"));
        Select selectDate = new Select(Date);
        selectDate.selectByIndex(26);

        WebElement Month = driver.findElement(By.name("birthday_month"));
        Select selectMonth = new Select(Month);
        selectMonth.selectByVisibleText("Jan");

        WebElement Year = driver.findElement(By.name("birthday_year"));
        Select selectYear = new Select(Year);
        selectYear.selectByValue("2001");

        //Check whether Gender is selected and select the gender as custom
        boolean FemaleisSelected=  driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[1]")).isSelected();
        boolean MaleisSelected=  driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[2]")).isSelected();
        boolean CustomisSelected=  driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[3]")).isSelected();

        if(!(FemaleisSelected)){
            WebElement SelectFemale = driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[1]"));
            SelectFemale.click();
            Thread.sleep(1000);
//
            }
        if(!(CustomisSelected)){
            WebElement SelectCustom = driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[3]"));
            SelectCustom.click();
            Thread.sleep(1000);
        }
        if(!(MaleisSelected)){
            WebElement SelectMale = driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[2]"));
            SelectMale.click();
            String Male = SelectMale.getText();
            System.out.println("Selected Gender is: " + Male);
        }

        //Enter a invalid email
        WebElement Email = driver.findElement(By.name("reg_email__"));
        Email.sendKeys("hovihama.lk");

//        WebElement Mobilenumber = driver.findElement(By.name("reg_email__"));
//        Mobilenumber.sendKeys("-*6464665%$");

        WebElement Password = driver.findElement(By.name("reg_passwd__"));
        Password.sendKeys("Celkon");

        //Click on Signup Button
        driver.findElement(By.name("websubmit")).click();

        Thread.sleep(3000);

        //Error Message
        String ErrorMessage = driver.findElement(By.xpath("//div[@class='uiContextualLayer uiContextualLayerLeft']")).getText();
        System.out.println("Error Message: " + ErrorMessage);

        driver.quit();
    }
}
