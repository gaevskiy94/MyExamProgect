package tests;

import models.Product;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import static utils.AssertionUtils.*;

public class SearchAndBuyProductTest extends BaseTest{

    @Test
    @Parameters({"searchText"})
    public static void searchAndBuyProductTest(String searchText){
        SearchPage searchPage = new SearchPage();
        ProductsListPage productsListPage = new ProductsListPage();
        InfoProductPage infoProductPage = new InfoProductPage();
        InfoWindowAfterAddingItemToCartPage infoWindowAfterAddingItemToCartPage =
                new InfoWindowAfterAddingItemToCartPage();
        CartPage cartPage = new CartPage();

        searchPage.search(searchText);

        productsListPage.chooseFirstProduct();

        Product choseProduct = infoProductPage.CurrentProduct();

        assertContains(choseProduct.getName(), searchText);

        infoProductPage.addCart();

        infoWindowAfterAddingItemToCartPage.buy();

        assertEquals(choseProduct.getPrice(), cartPage.totalCost());

        assertClickable(By.xpath(cartPage.getNextButtonXpath()));
    }
}
