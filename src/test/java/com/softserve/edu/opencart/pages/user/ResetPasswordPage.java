package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;

public class ResetPasswordPage extends AColumnRightGuestComponent {

    private PasswordComponent passwordComponent;
    private WebElement continueButton;
    private WebElement backButton;

    public ResetPasswordPage(){
        super();
        passwordComponent = new PasswordComponent();
        continueButton = search.cssSelector(".btn.btn-primary");
        backButton = search.xpath(".//a[contains( text(),'Back')]");
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }
    public void clickBackButton(){getBackButton().click();}

    public LoginPage saveChangesAccount(String text) {
        passwordComponent.setFieldPassword(text);
        passwordComponent.setFieldConfirmPassword(text);
        clickBackButton();
        return new LoginPage();
    }
}
