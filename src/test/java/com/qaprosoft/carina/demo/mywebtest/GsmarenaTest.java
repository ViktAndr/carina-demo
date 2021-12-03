package com.qaprosoft.carina.demo.mywebtest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mytest.components.HeaderMenu;
import com.qaprosoft.carina.demo.mytest.components.LoginMenu;
import com.qaprosoft.carina.demo.mytest.page.*;
import com.qaprosoft.carina.demo.mytest.service.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qaprosoft.carina.demo.mytest.constants.WebContants.GSM_ARENA_LOGIN_FAILED_EMAIL;
import static com.qaprosoft.carina.demo.mytest.constants.WebContants.GSM_ARENA_LOGIN_FAILED_PASS;

public class GsmarenaTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "andrienko")
    public void verifySuccessLogin() {
        UserService userService = new UserService();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        LoginMenu loginMenu = homePage.getHeaderMenu().openLoginMenu();
        Assert.assertTrue(loginMenu.isLoginMenuPresent(), "Login form is not present");
        loginMenu.login(userService);
        Assert.assertTrue(homePage.getHeaderMenu().isLogOutButtonPresent(), "Button is not present");
    }

    @Test()
    @MethodOwner(owner = "andrienko")
    public void verifyFailedLogin() {
        UserService userService = new UserService();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page  is not opened");
        LoginMenu loginMenu = homePage.getHeaderMenu().openLoginMenu();
        Assert.assertTrue(loginMenu.isLoginMenuPresent(), "Login form is not present");
        LoginPage loginPage = loginMenu.loginWithInvalidEmail(userService);
        Assert.assertEquals(loginPage.loginFailed(), GSM_ARENA_LOGIN_FAILED_EMAIL, "User record not found. Wrong email or password.");
    }

    @Test()
    @MethodOwner(owner = "andrienko")
    public void verifyFailedLoginWithInvalidPassword() {
        UserService userService = new UserService();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page  is not opened");
        LoginMenu loginMenu = homePage.getHeaderMenu().openLoginMenu();
        Assert.assertTrue(loginMenu.isLoginMenuPresent(), "Login form is not present");
        LoginPage loginPage = loginMenu.loginWithInvalidPass(userService);
        Assert.assertEquals(loginPage.loginFailed(), GSM_ARENA_LOGIN_FAILED_PASS, "User record not found. Wrong email or password.");
    }

    @Test()
    @MethodOwner(owner = "andrienko")
    public void verifyHeaderComponents() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isGsmarenaButtonPresent(), "Gsmarena button is not present");
        Assert.assertTrue(headerMenu.isGsmarenaSearchTextPresent(), "Gsmarena search text is not present");
        Assert.assertTrue(headerMenu.isSearchButtonPresent(), "Search button is not present");
        Assert.assertTrue(headerMenu.isTipIconPresent(), "Tip icon is not present");
        Assert.assertTrue(headerMenu.isFacebookIconPresent(), "Facebook icon is not present");
        Assert.assertTrue(headerMenu.isInstagramIconPresent(), "Instagram icon is not present");
        Assert.assertTrue(headerMenu.isTwitterIconPresent(), "Twitter icon is not present");
        Assert.assertTrue(headerMenu.isYoutubeIconPresent(), "Youtube icon is not present");
        Assert.assertTrue(headerMenu.isRssIconPresent(), "Rss icon is not present");
        Assert.assertTrue(headerMenu.isLoginIconPresent(), "Login icon is not present");
        Assert.assertTrue(headerMenu.isSingUpIconPresent(), "SingUp icon is not present");
    }
}
