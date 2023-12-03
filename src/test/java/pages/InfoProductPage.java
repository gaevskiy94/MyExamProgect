package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InfoProductPage {
    WebDriver driver;

    String nameProductXpath = "//h1[@class='c-product__name']";
    String priceProductXpath = "//div[@class='c-price h-price--xx-large h-price']";
    String addCartButtonXpath = "//div[@class='c-btn--primary h-btn-intent--atc']";

    public InfoProductPage(WebDriver driver){
        this.driver = driver;
    }

    public String getNameProduct(){
        WebElement nameProductText = driver.findElement(By.xpath(nameProductXpath));
        return nameProductText.getText();
    }

    public double getPriceProduct(){
        WebElement priceProductText = driver.findElement(By.xpath(priceProductXpath));

        return Double.parseDouble(priceProductText.
                getText().replaceAll("\n",".").replace(" ", "").
                substring(0, priceProductText.getText().length()-3));
    }

    public void addCart(){
        WebElement addCartButton = driver.findElement(By.xpath(addCartButtonXpath));
        addCartButton.click();
    }
}
