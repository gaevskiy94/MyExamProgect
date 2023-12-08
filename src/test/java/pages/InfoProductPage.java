package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;
import static utils.WaitUtils.waitVisibilityOfElementLocated;

public class InfoProductPage {
    String nameProductXpath = "//h1[@class='c-product__name']";
    String priceProductXpath = "//div[@class='c-price h-price--xx-large h-price']";
    String discountedPriceProductXpath = "//div[@class='c-price h-price--xx-large h-price--new']";
    String addCartButtonXpath = "//div[@class='c-btn--primary h-btn-intent--atc']";

    public String getNameProduct(){
        waitVisibilityOfElementLocated(By.xpath(nameProductXpath));

        WebElement nameProductText = getCurrentDriver().findElement(By.xpath(nameProductXpath));
        return nameProductText.getText();
    }

    public double getPriceProduct(){
        waitVisibilityOfElementLocated(By.xpath(priceProductXpath));

        try {
            WebElement priceProductText = getCurrentDriver().findElement(By.xpath(priceProductXpath));

            return Double.parseDouble(priceProductText.
                    getText().replaceAll("\n", ".").replace(" ", "").
                    substring(0, priceProductText.getText().length() - 3));

        }catch(Exception e){
            WebElement discountedPriceProduct = getCurrentDriver().findElement(By.xpath(discountedPriceProductXpath));

            return Double.parseDouble(discountedPriceProduct.
                    getText().replaceAll("\n", ".").replace(" ", "").
                    substring(0, discountedPriceProduct.getText().length() - 3));
        }
    }

    public Product CurrentProduct(){
        return new Product(getNameProduct(),getPriceProduct());
    }
    public void addCart(){
        WebElement addCartButton = getCurrentDriver().findElement(By.xpath(addCartButtonXpath));
        addCartButton.click();
    }
}
