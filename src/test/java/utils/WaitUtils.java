package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverProvider.getCurrentDriver;

public class WaitUtils {

    public static WebDriverWait getCurrentWait(){
         return new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(20));
    }

    public static void waitVisibilityOfElementLocated(By locator){
        getCurrentWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

    }
    public static void waitElementToBeClickable(By locator){
        getCurrentWait().until(ExpectedConditions.elementToBeClickable(locator));
    }
}
