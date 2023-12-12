package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class CartPage extends BasePage{
    String totalCostTextXpath = "//strong[@class='notranslate float_right c-price h-price--large']";
    String nextButtonXpath = "//button[@class='c-btn--primary h-btn-intent--atc h-btn--full-width  ']";

    public double totalCost(){
        WebElement totalCostText = getCurrentDriver().findElement(By.xpath(totalCostTextXpath));
        return getPriceDouble(totalCostText);
    }

    public String getNextButtonXpath() {
        return nextButtonXpath;
    }
}
