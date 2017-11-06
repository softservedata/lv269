package com.softserve.edu.opencart.pages.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class AHeaderComponent {

    // Fields
    
    private WebDriver driver;
    //
    private WebElement currency;
    private WebElement myAccount;
    private WebElement wishList;
    private WebElement shoppingCart;
    private WebElement checkout;
    private WebElement logo;
    private WebElement searchText;
    private WebElement searchButton;
    private WebElement cart;
    private List<WebElement> menuTop;
    
    protected AHeaderComponent(WebDriver driver) {
        this.driver=driver;
        currency=driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        myAccount=driver.findElement(By.cssSelector(".list-inline > li > a.dropdown-toggle"));
        wishList=driver.findElement(By.cssSelector("12"));
        shoppingCart=driver.findElement(By.cssSelector("12"));
        checkout=driver.findElement(By.cssSelector("12"));
        logo=driver.findElement(By.cssSelector("12"));
        searchText=driver.findElement(By.cssSelector("12"));
        searchButton=driver.findElement(By.cssSelector("12"));
        cart=driver.findElement(By.cssSelector("12"));
        menuTop=driver.findElements(By.cssSelector("12"));
    }

    // PageObject

    // get Data

    public WebElement getCurrency() {
        return currency;
    }

    public WebElement getMyAccount() {
        return myAccount;
    }

    public WebElement getWishList() {
        return wishList;
    }

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public WebElement getCheckout() {
        return checkout;
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getSearchText() {
        return searchText;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getCart() {
        return cart;
    }

    public List<WebElement> getMenuTop() {
        return menuTop;
    }

    public WebElement getMenuTopByCategoryPartialName(String categoryName) {
        // TODO
        return null;
    }

    // Functional

    public String getCurrencyText() {
        return getCurrency().getText().substring(0,1);
    }

    public String getMyAccountText() {
        return getMyAccount().getText();
    }

    // set Data

//    public void setLoginInput(String login) {
//        getLoginInput().sendKeys(login);
//    }
//
//    public void clearLoginInput() {
//        getLoginInput().clear();
//    }
//
//    public void clickLoginAccount() {
//        getLoginAccount().click();
//    }
    
    // Business Logic

//    public CommonPage successLogin(IUser user) {
//        setLoginData(user);
//        return new CommonPage();
//    }

}
