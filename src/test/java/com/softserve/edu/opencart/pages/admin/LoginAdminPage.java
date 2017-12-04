package com.softserve.edu.opencart.pages.admin;//package server7.testng;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tests.TestContextAttributes;
import com.softserve.edu.opencart.tools.BrowserWrapper;
import com.softserve.edu.opencart.tools.Operations;
import com.softserve.edu.opencart.tools.TextUtils;
import com.softserve.edu.opencart.tools.search.ISearch;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

public class LoginAdminPage {

    private final String AMPERSAND = "&";
    //Field
    protected ISearch search;
    protected BrowserWrapper browser;
    protected Operations operations;
    private WebElement logo;
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement loginBtn;
    private WebElement forgotPasswordBtn;

    public LoginAdminPage() {
        this.search = Application.get().search();
        this.browser = Application.get().browser();
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

    public void clickLoginBtn() {
        getLoginBtn().click();
    }

    public void setLoginField(String loginText) {
        operations.fillInputField(getLoginField(), loginText);
    }

    public void setPasswordField(String passwordText) {
        operations.fillInputField(getPasswordField(), passwordText);
    }

    public void clickForgotPassworBtn() {
        operations.clickElement(getLoginBtn());
    }

    // set Functional
    private String extractToken() {
        return AMPERSAND + TextUtils.splitToList(browser.getUrlPage(), AMPERSAND).get(1);
    }


    public void setCredentials(String login, String password) {
        setLoginField(login);
        setPasswordField(password);
        clickLoginBtn();
    }

    public DashboardAdmin validEnterAdminProfile(ITestContext context, IUser validUser) {
        setCredentials(validUser.getEmail(), validUser.getPassword());
        context.setAttribute(TestContextAttributes.TOKEN.toString(), extractToken());
        return new DashboardAdmin();
    }

    public WrongLoginAdminPage invalidEnterAdminProfile(IUser invalidUser) {
        setCredentials(invalidUser.getEmail(), invalidUser.getPassword());
        return new WrongLoginAdminPage();
    }

    public boolean isLoginAdminPageOpened() {
        return (operations.isElementDisplayed(getLoginBtn()));
    }


}
