package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.FilterPage;
import pages.HomePage;
import pages.ProductsListPage;

import static utils.AssertionUtils.assertPriceRange;


public class FilterPriceRangeTest extends BaseTest {

    @Test
    @Parameters({"minPrice", "maxPrice"})
    public void priceRangeTest(String minPrice, String maxPrice) {
        HomePage homePage = new HomePage();
        CatalogPage catalogPage = new CatalogPage();
        FilterPage filterPage = new FilterPage();
        ProductsListPage productsListPage = new ProductsListPage();

        homePage.openCatalog();

        catalogPage.openCategoryTelerid();

        filterPage.setPriceRange(minPrice, maxPrice);

        assertPriceRange(minPrice,maxPrice, productsListPage.getPriceProductsList());

    }
}
