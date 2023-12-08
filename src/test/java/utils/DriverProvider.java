package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverProvider {
    private static WebDriver driver;

    public static WebDriver getCurrentDriver(){
        if(driver == null){
            init();
        }
        return driver;
    }

    public static void init(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
