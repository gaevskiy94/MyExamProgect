package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class UserProfileMenuPage {
    String loginLinkXpath = "//a[@href='https://kaup24.ee/et/u/login']";
    String logoutButtonXpath = "//a[@href='https://kaup24.ee/et/users/account/logout']";

    public void openLoginPage(){
        WebElement loginLink = getCurrentDriver().findElement(By.xpath(loginLinkXpath));
        loginLink.click();
    }

    public void logout(){
        WebElement logoutButton = getCurrentDriver().findElement(By.xpath(logoutButtonXpath));
        logoutButton.click();
    }

    public String getLogoutButtonXpath() {
        return logoutButtonXpath;
    }
}
