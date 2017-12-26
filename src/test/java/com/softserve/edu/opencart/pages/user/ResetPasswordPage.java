package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.CheckingMails;
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

    public LoginPage saveChangesAccount(IUser user) {
        passwordComponent.setFieldPassword(user.getPhoneNumber());
        passwordComponent.setFieldConfirmPassword(user.getPhoneNumber());
        clickContinueButton();
        return new LoginPage();
    }
    public ResetPasswordPage changePass(IUser user){
        Application.get().browser()
                .openUrl(CheckingMails
                        .getMessageUrlFromMail(user.getPostCode(),
                                user.getFax(),
                                user.getEmail(),
                                user.getPassword()));
        return new ResetPasswordPage();

    }
}
