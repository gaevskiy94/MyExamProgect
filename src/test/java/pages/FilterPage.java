package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;
import static utils.WaitUtils.waitElementToBeClickable;

public class FilterPage extends BasePage{
    String minPriceFieldXpath = "//input[@class='price-from']";
    String maxPriceFieldXpath = "//input[@class='price-to']";
    String sliderMaxPriceXpath = "//div[@class='noUi-handle noUi-handle-upper']";
    String cleanFilterButtonXpath = "//div[@class='dtc clear-filters']";

    public void setPriceRange(String minPrice, String maxPrice){
        WebElement minPriceField = getCurrentDriver().findElement(By.xpath(minPriceFieldXpath));
        minPriceField.sendKeys(Keys.CONTROL + "a");
        minPriceField.sendKeys(minPrice);
        minPriceField.sendKeys(Keys.ENTER);

        WebElement maxPriceField = getCurrentDriver().findElement(By.xpath(maxPriceFieldXpath));
        maxPriceField.sendKeys(Keys.CONTROL + "a");
        maxPriceField.sendKeys(maxPrice);
        maxPriceField.sendKeys(Keys.ENTER);

        waitElementToBeClickable(By.xpath(cleanFilterButtonXpath));

        WebElement sliderMaxPrice = getCurrentDriver().findElement(By.xpath(sliderMaxPriceXpath));
        sliderMaxPrice.click();

        waitElementToBeClickable(By.xpath(cleanFilterButtonXpath));
    }
}
