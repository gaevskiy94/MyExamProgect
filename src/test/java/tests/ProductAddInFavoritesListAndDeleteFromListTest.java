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
        HeaderPage headerPage = new HeaderPage();
        UserProfileMenuPage userProfileMenuPage = new UserProfileMenuPage();
        AuthorizationPage authorizationPage = new AuthorizationPage();
        SearchPage searchPage = new SearchPage();
        ProductsListPage productsListPage = new ProductsListPage();
        FavoritesPage favoritesPage = new FavoritesPage();

        headerPage.openUserProfileDDMenu();

        userProfileMenuPage.openLoginPage();

        authorizationPage.login(user.getEmail(), user.getPassword());

        headerPage.openUserProfileDDMenu();

        assertIsDisplay(By.xpath(userProfileMenuPage.getLogoutButtonXpath()));

        searchPage.search(searchText.getText());

        List<Product> threeProductsAddedInFavoritesList = productsListPage
                .threeFirstProductsAddInFavoriteAndGetListTheseProducts();

        headerPage.openFavoritesList();

        List<Product> productListFromFavorites = favoritesPage.getProductsList();

        assertEqualsProductsLists(threeProductsAddedInFavoritesList, productListFromFavorites);

        favoritesPage.deleteAllProductsFromFavorites();

        assertEmptyList(favoritesPage.getProductsList());
    }
}
