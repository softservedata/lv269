package com.softserve.edu.opencart.pages.admin;//package server7.testng;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.Operations;
import com.softserve.edu.opencart.tools.search.ISearch;

import org.openqa.selenium.WebElement;

public class LoginAdminPage {

 //Field
    protected ISearch search;
    protected Operations operations;
    private WebElement logo;
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement loginBtn;
    private WebElement forgotPasswordBtn;

    public LoginAdminPage() {
        this.search = Application.get().search();
        this.operations = Application.get().operations();
        logo = search.cssSelector(".navbar-header > a");
        loginField = search.id("input-username");
        passwordField = search.id("input-password");
        loginBtn = search.tagName("button");
        forgotPasswordBtn = search.cssSelector(".help-block > a");

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
        getLogo().click();
    }

    public void clickLoginBtn () {
        getLoginBtn().click();
    }

    public void setLoginField(String loginText) {
        operations.fillInputField(getLoginField(), loginText);
    }

    public void setPasswordField(String passwordText) {
        operations.fillInputField(getPasswordField(), passwordText);
    }

    public void clickForgotPassworBtn () {
        operations.clickElement(getLoginBtn());
    }

    // set Functional

    public void setCredentials (String login, String password) {
        setLoginField(login);
        setPasswordField(password);
        clickLoginBtn();
    }

    public DashboardAdmin validEnterAdminProfile (IUser validUser){
        setCredentials (validUser.getEmail(), validUser.getPassword());
        Application.get().setToken();
        return new DashboardAdmin();
    }

    public WrongLoginAdminPage invalidEnterAdminProfile (IUser invalidUser) {
        setCredentials (invalidUser.getEmail(), invalidUser.getPassword());
        return new WrongLoginAdminPage();
    }

    public boolean isLoginAdminPageOpened () {
        return (operations.isElementDisplayed(getLoginBtn()));
    }


}
