package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends AColumnRightGuestComponent{

    private WebElement fieldEmailAddress;
    private WebElement continueButton;
    private WebElement backButton;

    public ForgotPasswordPage(){
        super();
        fieldEmailAddress = search.id("input-email");
        continueButton = search.cssSelector(".btn.btn-primary");
        backButton = search.xpath(".//a[contains( text(),'Back')]");
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public WebElement getFieldEmailAddress(){
        return fieldEmailAddress;
    }
    public void clickContinueButton() {
        getContinueButton().click();
    }
    public void clickBackButton(){getBackButton().click();}
    public void clickFieldEmailAddress(){
        getFieldEmailAddress().click();
    }

    public void clearFieldEmailAddress(){
        getFieldEmailAddress().clear();
    }

    public void setFieldEmailAddress(String text){
        clearFieldEmailAddress();
        clearFieldEmailAddress();
        getFieldEmailAddress().sendKeys(text);
    }

    public LoginPage sendEmailWithUrl(String text){
        setFieldEmailAddress(text);
        clickContinueButton();
        return new LoginPage();
    }
   // public
}
