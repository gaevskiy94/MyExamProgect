package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;
import static utils.WaitUtils.waitElementToBeClickable;

public class InfoWindowAfterAddingProductToCartPage {
    String buyButtonId = "buy";

    public void buy(){
        waitElementToBeClickable(By.id(buyButtonId));

        WebElement buyButton = getCurrentDriver().findElement(By.id(buyButtonId));
        buyButton.click();
    }
}
