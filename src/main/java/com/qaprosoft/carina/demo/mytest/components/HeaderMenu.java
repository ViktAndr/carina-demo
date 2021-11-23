package com.qaprosoft.carina.demo.mytest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//i[contains(@class, 'head-icon icon-user')]")
    private ExtendedWebElement logOutButton;

    @FindBy(id = "login-active")
    private ExtendedWebElement loginIcon;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginMenu openLoginMenu() {
        loginIcon.click();
        return new LoginMenu(driver);
    }

    public boolean isLogOutButtonPresent() {
        return logOutButton.isPresent();
    }
}
