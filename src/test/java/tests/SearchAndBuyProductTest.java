package tests;

import models.Product;
import models.SearchText;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import static utils.AssertionUtils.*;

public class SearchAndBuyProductTest extends BaseTest{

    @Test
    public static void searchAndBuyProductTest(){
        SearchText searchText = new SearchText("iphone 14");
        SearchPage searchPage = new SearchPage();
        ProductsListPage productsListPage = new ProductsListPage();
        InfoProductPage infoProductPage = new InfoProductPage();
        InfoWindowAfterAddingItemToCartPage infoWindowAfterAddingItemToCartPage =
                new InfoWindowAfterAddingItemToCartPage();
        CartPage cartPage = new CartPage();

        searchPage.search(searchText.getText());

        productsListPage.chooseFirstProduct();

        Product choseProduct = infoProductPage.getCurrentProduct();

        assertContains(choseProduct.getName(), searchText.getText());

        infoProductPage.addCart();

        infoWindowAfterAddingItemToCartPage.buy();

        assertEquals(choseProduct.getPrice(), cartPage.totalCost());

        assertClickable(By.xpath(cartPage.getNextButtonXpath()));
    }
}
