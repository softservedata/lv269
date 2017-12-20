package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.search.ISearch;

public class StartElm {

    protected final ISearch search;

    public StartElm() {
        this.search = Application.get().search();
        checkWebElements();
    }

    private void checkWebElements() {
        getCurrency();
        getMyAccount();
        getWishList();
        getShoppingCart();
        getCheckout();
        getLogo();
        getSearchProductField();
        getSearchProductButton();
        getCart();
    }

    // TODO delete
    public ISearch getSearch() {
        return Application.get().search();
    }
    
    public WebElement getCurrency() {
        return search.cssSelector(".btn.btn-link.dropdown-toggle");
    }

    public WebElement getMyAccount() {
        return search.cssSelector(".list-inline > li > a.dropdown-toggle");
    }

    public WebElement getWishList() {
        return search.id("wishlist-total");
    }

    public WebElement getShoppingCart() {
        return search.cssSelector("a[title='Shopping Cart']");
    }

    public WebElement getCheckout() {
        return search.cssSelector("a[title='Checkout']");
    }

    public WebElement getLogo() {
        return search.cssSelector("#logo > a");
    }

    public WebElement getSearchProductField() {
        //System.out.println("----------------------------------");
        //return search.name("search");
        return getSearch().name("search");
    }

    public WebElement getSearchProductButton() {
        //return search.cssSelector(".btn.btn-default.btn-lg");
        return getSearch().cssSelector(".btn.btn-default.btn-lg");
    }

    public WebElement getCart() {
        return search.cssSelector("#cart > button");
    }

}
