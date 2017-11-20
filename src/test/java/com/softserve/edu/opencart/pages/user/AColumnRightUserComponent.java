package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AColumnRightUserComponent extends AColumnRightPartitionalComponent {


    // Fields
    private WebElement editAccount;
    private WebElement password;
    private WebElement logout;


    public AColumnRightUserComponent(WebDriver driver) {
        super(driver);
        logout = driver.findElement(By.cssSelector("a.list-group-item[href*='logout']"));
        password = driver.findElement(By.cssSelector("a.list-group-item[href*='password']"));
        editAccount = driver.findElement(By.cssSelector("a.list-group-item[href*='edit']"));
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
    	return new LogoutPage(driver);
    }

}