package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class SearchPage {
    String searchFieldId = "searchInput";
    String searchButtonXpath = "//button[@class='c-search__submit']";

    public void search(String searchText){
        WebElement searchField = getCurrentDriver().findElement(By.id(searchFieldId));
        searchField.sendKeys(searchText);

        WebElement searchButton = getCurrentDriver().findElement(By.xpath(searchButtonXpath));
        searchButton.click();
    }
}
