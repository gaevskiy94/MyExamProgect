package tests;

import models.Product;
import models.SearchText;
import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

import static utils.AssertionUtils.*;

public class ProductAddInFavoritesListAndDeleteFromListTest extends BaseTest {
    @Test
    public void threeProductsAddInFavoritesListAndDeleteFromListTest(){
        User user = new User("gaevskiy.alexandr3@gmail.com", "12345qwerTY!");
        SearchText searchText = new SearchText("samsung galaxy s23");
        HomePage homePage = new HomePage();
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsListPage productsListPage = new ProductsListPage();
        FavoritesPage favoritesPage = new FavoritesPage();

        homePage.openAuthorizationPage();

        authorizationPage.login(user.getEmail(), user.getPassword());

        assertIsDisplay(By.xpath(homePage.getLogoutButtonXpath()));

        homePage.search(searchText.getText());

        List<Product> threeProductsAddedInFavoritesList = productsListPage
                .threeFirstProductsAddInFavoriteAndGetListTheseProducts();

        productsListPage.openFavoritesList();

        List<Product> productListFromFavorites = favoritesPage.getProductsList();

        assertEqualsProductsLists(threeProductsAddedInFavoritesList, productListFromFavorites);

        favoritesPage.deleteAllProductsFromFavorites();

        assertEmptyList(favoritesPage.getProductsList());
    }
}
