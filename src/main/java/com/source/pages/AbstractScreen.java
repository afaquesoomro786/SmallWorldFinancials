package com.source.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractScreen {
    protected WebDriver driver;

    public AbstractScreen(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Navigate back to previous screen
     */
    public void goBack() {
        driver.navigate().back();
    }

    public boolean navigateToURL(String url) {
        driver.navigate().to(url);
        return true;
    }

}