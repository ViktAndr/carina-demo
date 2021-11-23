package com.qaprosoft.carina.demo.mytest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.mytest.page.HomePage;
import com.qaprosoft.carina.demo.mytest.page.LoginPage;
import com.qaprosoft.carina.demo.mytest.service.UserService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginMenu extends AbstractUIObject {

    @FindBy(id = "login-popup2")
    private ExtendedWebElement loginMenu;

    @FindBy(id = "email")
    private ExtendedWebElement enterEmail;

    @FindBy(id = "upass")
    private ExtendedWebElement enterPass;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement submitButton;

    LoginMenu(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginMenuPresent() {
        return loginMenu.isElementPresent();
    }

    public HomePage login(UserService user) {
        enterEmail.type(user.getUser().getEmail());
        enterPass.type(user.getUser().getPassword());
        return submitButton();
    }

    public LoginPage loginWithInvalidEmail(UserService user) {
        enterEmail.type(user.getUserWithInvalidEmail().getEmail());
        enterPass.type(user.getUserWithInvalidEmail().getPassword());
        submitButton.click();
        return new LoginPage(getDriver());
    }

    public LoginPage loginWithInvalidPass (UserService user) {
        enterEmail.type(user.getUserWithInvalidPassword().getEmail());
        enterPass.type(user.getUserWithInvalidPassword().getPassword());
        submitButton.click();
        return new LoginPage(getDriver());
    }

    private HomePage submitButton() {
        submitButton.click();
        return new HomePage(getDriver());
    }

}
