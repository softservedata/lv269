package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;


public class AColumnRightUserComponent extends AColumnRightPartitionalComponent {


    // Fields
    private WebElement editAccount;
    private WebElement password;
    private WebElement logout;


    public AColumnRightUserComponent() {
        super();
        logout = search.cssSelector("a.list-group-item[href*='logout']");
        password = search.cssSelector("a.list-group-item[href*='password']");
        editAccount = search.cssSelector("a.list-group-item[href*='edit']");
    }

    // PageObject

    // get Data

    public WebElement getEditAccount() {
        return editAccount;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogout() {
        return logout;
    }


    // get Functional

    // set Data
    public void clickEditAccount() {
        getEditAccount().click();
    }

    public void clickPassword() {
        getPassword().click();
    }

    public void clickLogoutRightColumn() {
        getLogout().click();
    }


    // set Functional

    // Business Logic

    public LogoutPage gotoLogoutPageRightColumn() {
        clickLogoutRightColumn();
        return new LogoutPage();
    }

}
