package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.DriverProvider.closeDriver;
import static utils.DriverProvider.getCurrentDriver;
import static utils.WaitUtils.waitElementToBeClickable;


public class BaseTest {
    String acceptCookiesButtonXpath = "//button[@class='c-btn--primary h-btn--small cookies_accept-all']";

    @BeforeMethod
    public  void setUp(){
        getCurrentDriver().get("https://kaup24.ee/");
        acceptCookies();
    }

    @AfterMethod
    public void tearDown(){
        closeDriver();
    }

    public void acceptCookies(){
        waitElementToBeClickable(By.xpath(acceptCookiesButtonXpath));

        WebElement acceptCookiesButton = getCurrentDriver().
                findElement(By.xpath(acceptCookiesButtonXpath));
        acceptCookiesButton.click();
    }
}
