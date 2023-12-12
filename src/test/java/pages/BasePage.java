package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.DriverProvider.getCurrentDriver;

public class BasePage {
    String loginLinkXpath = "//a[@href='https://kaup24.ee/et/u/login']";
    String logoutButtonXpath = "//a[@href='https://kaup24.ee/et/users/account/logout']";
    String catalogLinkId = "menuBurger";
    String userProfileDDMenuXpath = "//a[@rel-widget-id='header']";
    String favoritesListLinkXpath = "//li[@class= 'c-user-menu-item']/a[@href='https://kaup24.ee/et/u/wishlist']";
    String searchFieldId = "searchInput";
    String searchButtonXpath = "//button[@class='c-search__submit']";

    public void authorizationPage(){
        openUserProfileDDMenu();

        WebElement loginLink = getCurrentDriver().findElement(By.xpath(loginLinkXpath));
        loginLink.click();
    }

    public void logout(){
        openUserProfileDDMenu();

        WebElement logoutButton = getCurrentDriver().findElement(By.xpath(logoutButtonXpath));
        logoutButton.click();
    }

    public String getLogoutButtonXpath() {
        openUserProfileDDMenu();
        return logoutButtonXpath;
    }

    public void openUserProfileDDMenu(){
        Actions action = new Actions(getCurrentDriver());

        WebElement userProfileDDMenu = getCurrentDriver().findElement(By.xpath(userProfileDDMenuXpath));
        action.moveToElement(userProfileDDMenu).build().perform();
    }

    public void openCatalog(){
        WebElement catalogLink = getCurrentDriver().findElement(By.id(catalogLinkId));
        catalogLink.click();
    }

    public void openFavoritesList() {
        WebElement favoritesListLink = getCurrentDriver().findElement(By.xpath(favoritesListLinkXpath));
        favoritesListLink.click();
    }

    public void search(String searchText){
        WebElement searchField = getCurrentDriver().findElement(By.id(searchFieldId));
        searchField.sendKeys(searchText);

        WebElement searchButton = getCurrentDriver().findElement(By.xpath(searchButtonXpath));
        searchButton.click();
    }

    public double getPriceDouble(WebElement element){
        String priceStr = element.getText().replaceAll(" ", "");

        if (priceStr.contains("kuus") && priceStr.contains("SJH")) {
            priceStr = priceStr.substring(priceStr.indexOf("\n")+1);
            priceStr = priceStr.substring(0, priceStr.indexOf("\u20AC"));
            priceStr = priceStr.replaceAll("\n", "");

        }else if (priceStr.contains("kuus")) {
            priceStr = priceStr.substring(priceStr.indexOf("\n")+1);
            priceStr = priceStr.substring(0, priceStr.indexOf("\u20AC"));
            priceStr = priceStr.replaceAll("\n", "");
        }else {
            priceStr = priceStr.substring(0, priceStr.indexOf("\u20AC"));
            priceStr = priceStr.replaceAll("\n", "");
        }

        StringBuilder sb = new StringBuilder(priceStr);

        return Double.parseDouble(sb.insert(sb.length() - 2, ".").toString());
    }
}
