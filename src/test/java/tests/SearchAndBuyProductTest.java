package tests;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;



public class SearchAndBuyProductTest extends BaseTest{

    @Test
    @Parameters({"searchText"})
    public void searchAndBuyProductTest(String searchText){
        SearchPage searchPage = new SearchPage(driver);
        ProductsListPage productsListPage = new ProductsListPage(driver);
        InfoProductPage infoProductPage = new InfoProductPage(driver);
        InfoWindowAfterAddingItemToCartPage infoWindowAfterAddingItemToCartPage =
                new InfoWindowAfterAddingItemToCartPage(driver);
        CartPage cartPage = new CartPage(driver);

        searchPage.search(searchText);

        productsListPage.choseFirstProduct();

        Assert.assertTrue(infoProductPage.getNameProduct().toLowerCase().contains(searchText.toLowerCase()));

        double priceProduct = infoProductPage.getPriceProduct();

        infoProductPage.addCart();

        infoWindowAfterAddingItemToCartPage.buy();

        Assert.assertEquals(priceProduct, cartPage.totalCost());

        Assert.assertTrue(cartPage.isClickableButtonNext());
    }
}
