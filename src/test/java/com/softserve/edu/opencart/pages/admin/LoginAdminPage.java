package com.softserve.edu.opencart.pages.admin;//package server7.testng;

import com.softserve.edu.opencart.constants.URLs;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.tools.SearchManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginAdminPage {

 //Field
    private SearchManager searchManager;
    private WebElement logo;
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement loginBtn;
    private WebElement forgotPasswordBtn;

    public LoginAdminPage(SearchManager searchManager) {
        this.searchManager = searchManager;
        logo = searchManager.findElement(By.cssSelector(".navbar-header > a"));
        loginField = searchManager.findElement(By.id("input-username"));
        passwordField = searchManager.findElement(By.id("input-password"));
        loginBtn = searchManager.findElement(By.tagName("button"));
        forgotPasswordBtn = searchManager.findElement(By.cssSelector(".help-block > a"));

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

    public WebElement getForgotPasswordBtn() {
        return forgotPasswordBtn;
    }

    // toString Functional

    // SetData


    public void clickLogo() {
        searchManager.clickElement(getLogo());
    }

    public void clickLoginBtn () {
        searchManager.clickElement(getLoginBtn());
    }

    public void setLoginField(String loginText) {
        searchManager.fillInputField(getLoginField(), loginText);
    }

    public void setPasswordField(String passwordText) {
        searchManager.fillInputField(getPasswordField(), passwordText);
    }

    public void clickForgotPassworBtn () {
        searchManager.clickElement(forgotPasswordBtn);
    }

    // set Functional

    public void setCredentials (String login, String password) {
        setLoginField(login);
        setPasswordField(password);
        clickLoginBtn();
    }

    // Business Logic
    public  void openLoginAdmPage () {
        searchManager.openAddress(URLs.URL_SERVER.toString() + URLs.URL_ADMIN_PAGE.toString());
    }

    public DashboardAdmin validEnterAdminProfile (IUser user){
//        setCredentials (user.getEmail(), user.getPassword());
        setCredentials ("admin", "269lv269lv");
        //TODO ********************************** Change back
        return new DashboardAdmin(searchManager);
    }

    public WrongLoginAdminPage invalidEnterAdminProfile (String login, String password) {
        setCredentials (login, password);
        return new WrongLoginAdminPage(searchManager);
    }

    public boolean isLoginAdminPageOpened () {
        return (searchManager.isElementDisplayed(getLoginBtn()));
    }


}
