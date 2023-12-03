package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public  void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://kaup24.ee/");
        acceptCookies();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void acceptCookies(){
        WebElement acceptCookiesButton = driver.
                findElement(By.xpath("//button[@class='c-btn--primary h-btn--small cookies_accept-all']"));
        acceptCookiesButton.click();
    }
}
