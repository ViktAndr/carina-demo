package com.qaprosoft.carina.demo.mytest.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//button[contains(@type, 'button')]")
    private ExtendedWebElement headerNavigation;

    @FindBy(xpath = "//button[contains(@class,'lines-button minus')]")
    private ExtendedWebElement gsmarena;

    @FindBy(id = "topsearch-text")
    private ExtendedWebElement gsmarenaSearchText;

    @FindBy(id = "quick-search-button")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//i[contains(@class,'head-icon icon-tip-us icomoon-liga')]")
    private ExtendedWebElement tipIcon;

    @FindBy(xpath = "//i[contains(@class,'head-icon icon-soc-fb2 icomoon-liga')]")
    private ExtendedWebElement facebookIcon;

    @FindBy(xpath = "//i[contains(@class,'head-icon icon-soc-twitter2 icomoon-liga')]")
    private ExtendedWebElement twitterIcon;

    @FindBy(xpath = "//i[contains(@class,'head-icon icon-instagram icomoon-liga')]")
    private ExtendedWebElement instagramIcon;

    @FindBy(xpath = "//i[contains(@class,'head-icon icon-soc-youtube icomoon-liga')]")
    private ExtendedWebElement youtubeIcon;

    @FindBy(xpath = "//i[contains(@class,'head-icon icon-soc-rss2 icomoon-liga')]")
    private ExtendedWebElement rssIcon;

    @FindBy(xpath = "//i[contains(@class,'head-icon icon-user-plus')]")
    private ExtendedWebElement singUpIcon;

    @FindBy(id = "login-active")
    private ExtendedWebElement loginIcon;


    @FindBy(xpath = "//i[contains(@class, 'head-icon icon-user')]")
    private ExtendedWebElement logOutButton;


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

    public boolean isGsmarenaButtonPresent() {
        return gsmarena.isPresent();
    }

    public boolean isGsmarenaSearchTextPresent() {
        return gsmarenaSearchText.isPresent();
    }

    public boolean isSearchButtonPresent() {
        return searchButton.isPresent();
    }

    public boolean isTipIconPresent() {
        return tipIcon.isPresent();
    }

    public boolean isFacebookIconPresent() {
        return facebookIcon.isPresent();
    }

    public boolean isTwitterIconPresent() {
        return twitterIcon.isPresent();
    }

    public boolean isInstagramIconPresent() {
        return instagramIcon.isPresent();
    }

    public boolean isYoutubeIconPresent() {
        return youtubeIcon.isPresent();
    }

    public boolean isRssIconPresent() {
        return rssIcon.isPresent();
    }

    public boolean isSingUpIconPresent() {
        return singUpIcon.isPresent();
    }

    public boolean isLoginIconPresent() {
        return loginIcon.isPresent();
    }
}
