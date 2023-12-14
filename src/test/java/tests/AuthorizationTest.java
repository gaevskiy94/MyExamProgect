package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.HomePage;

import static utils.AssertionUtils.*;

public class AuthorizationTest extends BaseTest{
    @Test
    public void authorizationTest(){
        User user = new User("gaevskiy.alexandr3@gmail.com", "12345qwerTY!");
        HomePage homePage = new HomePage();
        AuthorizationPage authorizationPage = new AuthorizationPage();

        homePage.openAuthorizationPage();

        authorizationPage.login(user.getEmail(), user.getPassword());

        assertIsDisplay(By.xpath(homePage.getLogoutButtonXpath()));

        homePage.logout();

        assertIsNotDisplay(By.xpath(homePage.getLogoutButtonXpath()));
    }
}
