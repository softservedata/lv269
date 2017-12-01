package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;

abstract class AColumnRightPartitionalComponent extends ANavigatePanelComponent {


    // Fields
//#column-right > div > a:nth-child(4)
    private WebElement myAccountRigthPanel;
    private WebElement addressBook;
    private WebElement wishListRigthPanel;
    private WebElement orderHistory;
    private WebElement downloads;
    private WebElement recurringPayments;
    private WebElement rewardPoints;
    private WebElement returns;
    private WebElement transactions;
    private WebElement newsletter;

    private WebElement listGroup;

    protected AColumnRightPartitionalComponent() {
        super();

        myAccountRigthPanel = search.cssSelector("a.list-group-item[href*='account/account']");
        addressBook = search.cssSelector("a.list-group-item[href*='address']");
        wishListRigthPanel = search.cssSelector("a.list-group-item[href*='wishlist']");
        orderHistory = search.cssSelector("a.list-group-item[href*='order']");
        downloads = search.cssSelector("a.list-group-item[href*='download']");
        recurringPayments = search.cssSelector("a.list-group-item[href*='recurring']");
        rewardPoints = search.cssSelector("a.list-group-item[href*='reward']");
        returns = search.cssSelector("a.list-group-item[href*='return']");
        transactions = search.cssSelector("a.list-group-item[href*='transaction']");
        newsletter = search.cssSelector("a.list-group-item[href*='newsletter']");


    }


    // PageObject

    // get Data

    public WebElement getAddressBook() {
        return addressBook;
    }

    public WebElement getMyAccountRigthPanel() {
        return myAccountRigthPanel;
    }

    public WebElement getWishListRigthPanel() {
        return wishListRigthPanel;
    }

    public WebElement getOrderHistory() {
        return orderHistory;
    }

    public WebElement getDownloads() {
        return downloads;
    }

    public WebElement getRecurringPayments() {
        return recurringPayments;
    }

    public WebElement getRewardPoints() {
        return rewardPoints;
    }

    public WebElement getReturns() {
        return returns;
    }

    public WebElement getTransactions() {
        return transactions;
    }

    public WebElement getNewsletter() {
        return newsletter;
    }


    // get Functional

    // set Data

    public void clickMyAccountRigthPanel() {
        getMyAccountRigthPanel().click();
    }

    public void clickAddressBook() {
        getAddressBook().click();
    }


    public void clickRigthPanelWishList() {
        getWishListRigthPanel().click();
    }

    public void clickOrderHistory() {
        getOrderHistory().click();
    }

    public void clickDownloads() {
        getDownloads().click();
    }

    public void clickRecurringPayments() {
        getRecurringPayments().click();
    }

    public void clickRewardPoints() {
        getRewardPoints().click();
    }

    public void clickReturns() {
        getReturns().click();
    }

    public void clickTransactions() {
        getTransactions().click();
    }

    public void clickNewsletter() {
        getNewsletter().click();
    }

    // set Functional

    // Business Logic

    public WishListPage gotoWishListPageRightColumn() {
        clickRigthPanelWishList();
        return new WishListPage();
    }
    public AddressBookPage gotoAddressBookPageRightColumn() {
        clickAddressBook();
        return new AddressBookPage(driver);
    }


}
