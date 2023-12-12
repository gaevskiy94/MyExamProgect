package tests;

import models.Product;
import models.SearchText;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.*;

import static utils.AssertionUtils.*;

public class SearchAndBuyProductTest extends BaseTest{
    @Test
    public static void searchAndBuyProductTest(){
        SearchText searchText = new SearchText("iphone 14");
        HomePage homePage = new HomePage();
        ProductsListPage productsListPage = new ProductsListPage();
        InfoProductPage infoProductPage = new InfoProductPage();
        InfoWindowAfterAddingProductToCartPage infoWindowAfterAddingProductToCartPage =
                new InfoWindowAfterAddingProductToCartPage();
        CartPage cartPage = new CartPage();

        homePage.search(searchText.getText());

        productsListPage.chooseFirstProduct();

        Product choseProduct = infoProductPage.getCurrentProduct();

        assertContains(choseProduct.getName(), searchText.getText());

        infoProductPage.addCart();

        infoWindowAfterAddingProductToCartPage.buy();

        assertEquals(choseProduct.getPrice(), cartPage.totalCost());

        assertClickable(By.xpath(cartPage.getNextButtonXpath()));
    }
}
