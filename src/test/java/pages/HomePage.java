package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;
public class HomePage {
    String catalogLinkId = "menuBurger";

    public void openCatalog(){
        WebElement catalogLink = getCurrentDriver().findElement(By.id(catalogLinkId));
        catalogLink.click();
    }

}
