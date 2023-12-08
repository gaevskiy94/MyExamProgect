package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static utils.DriverProvider.getCurrentDriver;

public class ProductsListPage {
    String imagesProductsListXpath = "//a[@class='product-image-container']";
    String priceProductsListXpath = "//span[@class='price notranslate ']";
    String discountedPriceProductsListXpath = "//span[@class='price notranslate discount-price']";

    public void chooseFirstProduct(){
        List<WebElement> productsList = getCurrentDriver().findElements(By.xpath(imagesProductsListXpath));
        productsList.get(0).click();
    }

    public List<Product> getPriceProductsList(){
        List<Product> priceProductsList = new ArrayList<>();


        List<WebElement> pricesList = getCurrentDriver().findElements(By.xpath(priceProductsListXpath));
        for(WebElement element: pricesList){
            priceProductsList.add(new Product(getPriceDouble(element)));
        }

        List<WebElement> discountedPriceProductsList = getCurrentDriver().findElements(By.
                xpath(discountedPriceProductsListXpath));
        for(WebElement element: discountedPriceProductsList){
           priceProductsList.add(new Product(getPriceDouble(element)));
        }
        return priceProductsList;
    }

    public double getPriceDouble(WebElement element){
        String str= element.getText().replaceAll(" ","");
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(sb.length()-1);
        sb.insert(sb.length() - 2, ".");
        return Double.parseDouble(sb.toString());
    }

}
