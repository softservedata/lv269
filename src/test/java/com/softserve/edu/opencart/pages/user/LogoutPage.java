package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;

public class LogoutPage extends AColumnRightGuestComponent {
    private WebElement continueButton;

    public LogoutPage() {
        super();
        continueButton = search.cssSelector(".btn.btn-primary");
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    public HomePage gotoHomePage() {
        clickContinueButton();
        return new HomePage();
    }
}