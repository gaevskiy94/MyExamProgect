package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.DriverProvider.getCurrentDriver;

public class HeaderPage {
    String catalogLinkId = "menuBurger";
    String userProfileDDMenuXpath = "//a[@rel-widget-id='header']";
    String favoritesListLinkXpath = "//li[@class= 'c-user-menu-item']/a[@href='https://kaup24.ee/et/u/wishlist']";

    public void openCatalog(){
        WebElement catalogLink = getCurrentDriver().findElement(By.id(catalogLinkId));
        catalogLink.click();
    }

    public void openUserProfileDDMenu(){
        Actions action = new Actions(getCurrentDriver());

        WebElement userProfileDDMenu = getCurrentDriver().findElement(By.xpath(userProfileDDMenuXpath));
        action.moveToElement(userProfileDDMenu).build().perform();
    }

    public void openFavoritesList(){
        WebElement favoritesListLink = getCurrentDriver().findElement(By.xpath(favoritesListLinkXpath));
        favoritesListLink.click();
    }

}
