package tests;

import models.RangePrice;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.FilterPage;
import pages.HomePage;
import pages.ProductsListPage;

import static utils.AssertionUtils.assertPriceRange;


public class FilterPriceRangeTest extends BaseTest {

    @Test
    public void priceRangeTest() {
        RangePrice rangePrice = new RangePrice("800", "1000");
        HomePage homePage = new HomePage();
        CatalogPage catalogPage = new CatalogPage();
        FilterPage filterPage = new FilterPage();
        ProductsListPage productsListPage = new ProductsListPage();

        homePage.openCatalog();

        catalogPage.openCategoryTelerid();

        filterPage.setPriceRange(rangePrice.getMinPrice(), rangePrice.getMaxPrice());

        assertPriceRange(rangePrice.getMinPrice(), rangePrice.getMaxPrice(), productsListPage.getPriceProductsList());

    }
}
