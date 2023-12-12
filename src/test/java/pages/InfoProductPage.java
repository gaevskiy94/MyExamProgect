package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;
import static utils.WaitUtils.waitVisibilityOfElementLocated;

public class InfoProductPage extends BasePage{
    String nameProductXpath = "//h1[@class='c-product__name']";
    String priceProductXpath = "//div[@class='c-product__price']";
    String addCartButtonXpath = "//div[@class='c-btn--primary h-btn-intent--atc']";

    public String getNameProduct(){
        waitVisibilityOfElementLocated(By.xpath(nameProductXpath));

        WebElement nameProductText = getCurrentDriver().findElement(By.xpath(nameProductXpath));
        return nameProductText.getText();
    }

    public double getPriceProduct(){
        waitVisibilityOfElementLocated(By.xpath(priceProductXpath));

        WebElement priceProductText = getCurrentDriver().findElement(By.xpath(priceProductXpath));
        return getPriceDouble(priceProductText);
    }

    public Product getCurrentProduct(){
        return new Product(getNameProduct(),getPriceProduct());
    }
    public void addCart(){
        WebElement addCartButton = getCurrentDriver().findElement(By.xpath(addCartButtonXpath));
        addCartButton.click();
    }
}
