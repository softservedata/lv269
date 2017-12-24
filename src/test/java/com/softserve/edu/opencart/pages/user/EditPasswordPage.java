package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.data.users.IUser;
import org.openqa.selenium.WebElement;

public class EditPasswordPage extends AColumnRightPartitionalComponent{

    // fields
    private WebElement fieldPassword;
    private WebElement fieldConfirmPassword;
    private WebElement continueButton;
    private WebElement backButton;

    public EditPasswordPage(){
        super();
        fieldPassword = search.id("input-password");
        fieldConfirmPassword = search.id("input-confirm");
        continueButton = search.cssSelector(".btn.btn-primary");
        backButton = search.xpath(".//a[contains( text(),'Back')]");
    }
    // get Data
    public WebElement getFieldPassword() {
        return fieldPassword;
    }

    public WebElement getFieldConfirmPassword() {
        return fieldConfirmPassword;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public void clickFieldPassword() {
        getFieldPassword().click();
    }

    public void clickFieldConfirmPassword() {
        getFieldConfirmPassword().click();
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    public void clickBackButton() {
        getBackButton().click();
    }

    public void clearFieldPassword() {
        getFieldPassword().clear();
    }

    public void clearFieldConfirmPassword() {
        getFieldConfirmPassword().clear();
    }

    public void setFieldPassword(String text){
        clickFieldPassword();
        clearFieldPassword();
        getFieldPassword().sendKeys(text);

    }

    public void setFieldConfirmPassword(String text){
        clickFieldConfirmPassword();
        clearFieldConfirmPassword();
        getFieldConfirmPassword().sendKeys(text);
    }

    //----------Bussiness logic
    public MyAccountPage saveChangesPassword() {
        clickContinueButton();
        return new MyAccountPage();
    }
    public MyAccountPage backWithoutChangesPassword() {
        clickBackButton();
        return new MyAccountPage();
    }
    public void changeFieldPassword(IUser user) {
        setFieldPassword(user.getPassword());
        setFieldConfirmPassword(user.getPassword());
    }
}
