package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static utils.DriverProvider.getCurrentDriver;
import static utils.WaitUtils.waitVisibilityOfElementLocated;

public class FavoritesPage extends BasePage{
    String nameProductsListXpath = "//p[@class='product-name']";
    String priceProductsListXpath ="//div[@class='product-price']";
    String deleteFavoritesButtonListXpath = "//button[@class='add-to-favorites']";
    String countProductsInFavoritesTextId = "menuCount797027";

    public List<Product> getProductsList(){
        List<Product> productsList = new ArrayList<>();

        List<WebElement> nameProductsList = getCurrentDriver().findElements(By.
                xpath(nameProductsListXpath));
        List<WebElement> priceList = getCurrentDriver().findElements(By.
                xpath(priceProductsListXpath));

        for (int i=0; i<nameProductsList.size(); i++){
            productsList.add(new Product(nameProductsList.get(i).getText(),
                    getPriceDouble(priceList.get(i))));
        }

        return productsList;
    }

    public void deleteAllProductsFromFavorites(){
        WebElement countProductsInFavoritesText = getCurrentDriver().findElement(By.
                id(countProductsInFavoritesTextId));

        int countProducts = Integer.parseInt(countProductsInFavoritesText.getText());

        while (countProducts!=0) {
            WebElement deleteFavoritesButton = getCurrentDriver().findElement(By.
                    xpath(deleteFavoritesButtonListXpath));
            deleteFavoritesButton.click();

            waitVisibilityOfElementLocated(By.id(countProductsInFavoritesTextId));
            countProducts = Integer.parseInt(countProductsInFavoritesText.getText());
        }
    }


}
