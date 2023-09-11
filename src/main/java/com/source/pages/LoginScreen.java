package com.source.pages;


import com.source.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends AbstractScreen {

    @FindBy(id = "loginn")
    private By login;

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    public boolean performLogin(String username, String password) {
        if (enterUsername(username)) {
            enterPassword(password);
            if (submitLogin()) {
                return true;
            }
        }
        return false;
    }

    public boolean enterUsername(String username) {
        if (Utility.waitForWebElement(driver, usernameField, 5)) {
            usernameField.sendKeys(username);
            return true;
        }
        return false;
    }

    public boolean enterPassword(String password) {
        if (Utility.waitForWebElement(driver, passwordField, 5)) {
            passwordField.sendKeys(password);
            return true;
        }
        return false;
    }

    public boolean submitLogin() {
        if (Utility.waitForWebElementClickable(driver, loginButton, 5)) {
            loginButton.click();
            return true;
        }
        return false;
    }


}
