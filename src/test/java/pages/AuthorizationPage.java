package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class AuthorizationPage {
    String emailFieldXpath = "//div[@widget-attachpoint='viewLogin']//input[@placeholder='E-post']";
    String passwordFieldXpath = "//div[@widget-attachpoint='viewLogin']//input[@placeholder='Parool']";
    String loginButtonXpath = "//div[@widget-attachpoint='viewLogin']//input[@class='btn btn-primary btn-full-width']";

    public void login(String email, String password){
        WebElement emailField = getCurrentDriver().findElement(By.xpath(emailFieldXpath));
        emailField.sendKeys(email);

        WebElement passwordField = getCurrentDriver().findElement(By.xpath(passwordFieldXpath));
        passwordField.sendKeys(password);

        WebElement loginButton = getCurrentDriver().findElement(By.xpath(loginButtonXpath));
        loginButton.click();
    }
}
