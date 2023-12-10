package tests;

import models.User;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.HeaderPage;
import pages.UserProfileMenuPage;

import static utils.AssertionUtils.assertFalse;
import static utils.AssertionUtils.assertTrue;

public class AuthorizationTest extends BaseTest{
    @Test
    public void authorizationTest(){
        User user = new User("gaevskiy.alexandr3@gmail.com", "12345qwerTY!");
        HeaderPage headerPage = new HeaderPage();
        UserProfileMenuPage userProfileMenuPage = new UserProfileMenuPage();
        AuthorizationPage authorizationPage = new AuthorizationPage();

        headerPage.openUserProfileDDMenu();

        userProfileMenuPage.openLoginPage();

        authorizationPage.login(user.getEmail(), user.getPassword());

        headerPage.openUserProfileDDMenu();

        assertTrue(userProfileMenuPage.isDisplayLogoutButton());

        userProfileMenuPage.logout();

        headerPage.openUserProfileDDMenu();

        assertFalse(userProfileMenuPage.isDisplayLogoutButton());

    }
}
