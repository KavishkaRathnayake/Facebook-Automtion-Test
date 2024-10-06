package Interface;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenHomeTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void HomeTest(){
        //01) Login giving Correct Credentials
        driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("jigiwi7156@jofuso.com");
        driver.findElement(By.xpath("(//input[@id='pass'])[1]")).sendKeys("Celkon");
        driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]")).click();

//        Alert new1 =driver.switchTo().alert();
//        new1.accept();
        driver.findElement(By.xpath("//a[@aria-label='Home']")).click();
    }
}
