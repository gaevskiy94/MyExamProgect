package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    WebDriver driver;

    String searchFieldId = "searchInput";
    String searchButtonXpath = "//button[@class='c-search__submit']";

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String searchText){
        WebElement searchField = driver.findElement(By.id(searchFieldId));
        searchField.sendKeys(searchText);

        WebElement searchButton = driver.findElement(By.xpath(searchButtonXpath));
        searchButton.click();
    }
}
