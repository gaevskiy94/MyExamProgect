package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductsListPage {
    WebDriver driver;

    String productsListXpath = "//a[@class='product-image-container']";

    public ProductsListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void choseFirstProduct(){
        List<WebElement> productsList = driver.findElements(By.xpath(productsListXpath));
        productsList.get(0).click();
    }

}
