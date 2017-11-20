package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AColumnRightGuestComponent extends AColumnRightPartitionalComponent {


    // Fields
    private WebElement login;
    private WebElement register;
    private WebElement forgotttenPassword;


    public AColumnRightGuestComponent(WebDriver driver) {
        super(driver);

        login = driver.findElement(By.cssSelector("a.list-group-item[href*='login']"));
        register = driver.findElement(By.cssSelector("a.list-group-item[href*='register']"));
        forgotttenPassword = driver.findElement(By.cssSelector("a.list-group-item[href*='forgotten']"));

    }

    // PageObject

    // get Data

    public WebElement getLogin() {
        return login;
    }

    public WebElement getRegister() {
        return register;
    }


    public WebElement getForgotttenPassword() {
        return forgotttenPassword;
    }

    // get Functional

    // set Data

    public void clickLoginRightColumn() {
        getLogin().click();
    }

    public void clickRegisterRightColumn() {
        getRegister().click();
    }

    public void clickForgotttenPasswordRightColumn() {
        getForgotttenPassword().click();
    }


    // set Functional

    // Business Logic
    public LoginPage gotoLoginPageRightColumn() {
        clickLoginRightColumn();
        return new LoginPage(driver);
    }
    //    public RegisterPage gotoRegisterPageRightColumn() {
//        clickRegisterRightColumn();
//        return new RegisterPage(driver);
//    }

//    public ForgotPasswordPage gotoAdressBookPageRightColumn() {
//        clickForgotttenPasswordRightColumn();
//        return new ForgotPasswordPage(driver);
//    }

    public LoginPage gotoMyAccountPageRightColumn() {
        clickMyAccountRigthPanel();
        return new LoginPage(driver);
    }

    public LoginPage gotoAdressBookPageRightColumn() {
        clickAddressBook();
        return new LoginPage(driver);
    }

    //    public LoginPage gotoWishListPageRightColumn() {
//        clickRigthPanelWishList();
//        return new LoginPage(driver);
//    }
    public LoginPage gotoOrderHistoryRightColumn() {
        clickOrderHistory();
        return new LoginPage(driver);
    }
    public LoginPage gotoDownloadsPageRightColumn() {
        clickDownloads();
        return new LoginPage(driver);
    }

    public LoginPage gotoRecurringPaymentsPageRightColumn() {
        clickRecurringPayments();
        return new LoginPage(driver);
    }
    public LoginPage gotoRewardPointsPageRightColumn() {
        clickRewardPoints();
        return new LoginPage(driver);
    }
    public LoginPage gotoReturnsPageRightColumn() {
        clickReturns();
        return new LoginPage(driver);
    }
    public LoginPage gotoTransactionsPageRightColumn() {
        clickTransactions();
        return new LoginPage(driver);
    }
    public LoginPage gotoNewsletterPageRightColumn() {
        clickNewsletter();
        return new LoginPage(driver);
    }


}
