package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



import static utils.DriverProvider.getCurrentDriver;

public class CatalogPage extends BasePage{
    String categoryKodumasinadKodutehnikaLinkXpath =
            "//div[@class='c-categories-list__title']//*[contains(text(), 'Kodumasinad, kodutehnika')]";
    String categoryTeleridJaTarvikudLinkXpath =
            "//div[@class='category-list-item-wrap all-categories-visible']//*[contains(text(), 'Telerid ja tarvikud')]";
    String categoryTeleridLinkXpath =
            "//div[@class='category-list-item-wrap all-categories-visible']//*[contains(text(), 'Telerid ')]";

    public void openCategoryTelerid(){
        WebElement categoryKodumasinadKodutehnikaLink = getCurrentDriver().findElement(By.
                xpath(categoryKodumasinadKodutehnikaLinkXpath));
        categoryKodumasinadKodutehnikaLink.click();

        WebElement categoryTeleridJaTarvikudLink = getCurrentDriver().findElement(By.
                xpath(categoryTeleridJaTarvikudLinkXpath));
        categoryTeleridJaTarvikudLink.click();

        WebElement categoryTeleridLink = getCurrentDriver().findElement(By.xpath(categoryTeleridLinkXpath));
        categoryTeleridLink.click();



    }
}
