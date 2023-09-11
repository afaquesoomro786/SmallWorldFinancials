package com.source.core;

import com.source.pages.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private LoginScreen loginScreen;
    private HomeScreen homeScreen;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginScreen getLoginScreen(){
        return (loginScreen == null) ? loginScreen = new LoginScreen(driver) : loginScreen;
    }


    public HomeScreen getHomeScreen(){
        return (homeScreen == null) ? homeScreen = new HomeScreen(driver) : homeScreen;
    }
}
