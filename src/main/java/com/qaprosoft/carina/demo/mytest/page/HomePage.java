package com.qaprosoft.carina.demo.mytest.page;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mytest.components.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy (id ="header")
    private HeaderMenu header;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HeaderMenu getHeaderMenu(){
        return header;
    }
}
