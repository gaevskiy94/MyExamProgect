package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static utils.DriverProvider.getCurrentDriver;

public class ProductsListPage extends BasePage{
    String imagesProductsListXpath = "//a[@class='product-image-container']";
    String nameProductsListXpath = "//div[@class='blur']//p[@class='product-name']";
    String priceProductsListXpath ="//div[@class='blur']//div[@class='product-price h-use-ui-lib']";
    String addFavoritesButtonListXpath = "//button[@class='add-to-favorites h-use-ui-lib']";

    public void chooseFirstProduct(){
        List<WebElement> productsList = getCurrentDriver().findElements(By.xpath(imagesProductsListXpath));
        productsList.get(0).click();
    }

    public List<Product> getPriceProductsList(){
        List<Product> productsList = new ArrayList<>();

        List<WebElement> priceList = getCurrentDriver().findElements(By.
                xpath(priceProductsListXpath));
        for(WebElement element: priceList){
            productsList.add(new Product(getPriceDouble(element)));
        }

        return productsList;
    }

    public List<Product> threeFirstProductsAddInFavoriteAndGetListTheseProducts(){
        List<Product> productsList = new ArrayList<>();

        try {

            List<WebElement> addFavoritesButtonList = getCurrentDriver().findElements(By.
                    xpath(addFavoritesButtonListXpath));
            List<WebElement> nameProductsList = getCurrentDriver().findElements(By.
                    xpath(nameProductsListXpath));
            List<WebElement> priceList = getCurrentDriver().findElements(By.
                    xpath(priceProductsListXpath));

            for (int i = 0; i < 3; i++) {
                addFavoritesButtonList.get(i).click();
                productsList.add(new Product(nameProductsList.get(i).getText(), getPriceDouble(priceList.get(i))));
            }
        }catch (Exception e){}

        return productsList;
    }
}