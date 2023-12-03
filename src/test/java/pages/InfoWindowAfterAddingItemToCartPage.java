package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InfoWindowAfterAddingItemToCartPage {
    WebDriver driver;
    WebDriverWait wait;

    String buyButtonId = "buy";

    public InfoWindowAfterAddingItemToCartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void buy(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id(buyButtonId)));

        WebElement buyButton = driver.findElement(By.id(buyButtonId));
        buyButton.click();
    }
}
