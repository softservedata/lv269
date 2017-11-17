package com.softserve.edu.opencart.pages.admin;//package server7.testng;

import com.softserve.edu.opencart.constants.URLs;
import com.softserve.edu.opencart.tools.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginAdminPage {

 //Field
    private WebDriverManager webDriverManager;
    private WebElement logo;
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement loginBtn;

    public LoginAdminPage(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        logo = webDriverManager.findElement(By.cssSelector(".navbar-header > a"));
        loginField = webDriverManager.findElement(By.id("input-username"));
        passwordField = webDriverManager.findElement(By.id("input-password"));
        loginBtn = webDriverManager.findElement(By.tagName("button"));
    }

    //Get data
    public WebElement getLogo() {
        return logo;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    // toString Functional

    // SetData


    public void clickLogo() {
        webDriverManager.clickElement(getLogo());
    }

    public void clickLoginBtn () {
        webDriverManager.clickElement(getLoginBtn());
    }

    public void setLoginField(String loginText) {
        webDriverManager.fillInputField(getLoginField(), loginText);
    }

    public void setPasswordField(String passwordText) {
        webDriverManager.fillInputField(getPasswordField(), passwordText);
    }

    // set Functional

    public void setCredentials (String login, String password) {
        setLoginField(login);
        setPasswordField(password);
        clickLoginBtn();
    }

    // Business Logic
    public  void openLoginAdmPage () {
        webDriverManager.openAddress(URLs.URL_SERVER.toString() + URLs.URL_ADMIN_PAGE.toString());
    }

    public DashboardAdmin validEnterAdminProfile (String login, String password){
        setCredentials (login, password);
        return new DashboardAdmin(webDriverManager);
    }

    public WrongLoginAdminPage invalidEnterAdminProfile (String login, String password) {
        setCredentials (login, password);
        return new WrongLoginAdminPage(webDriverManager);
    }

    public boolean isLoginAdminPageOpened () {
        return (webDriverManager.isElementDisplayed(getLoginBtn()));
    }


}
