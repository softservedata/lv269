package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.data.users.IUser;
import org.openqa.selenium.WebElement;

public class EditAccountPage extends AColumnRightUserComponent {

    // fields
    private PersonalDetailsComponent personalDetailsComponent;
    private WebElement continueButton;
    private WebElement backButton;

    public EditAccountPage() {
        super();
        this.personalDetailsComponent = new PersonalDetailsComponent();
        continueButton = search.cssSelector(".btn.btn-primary");
        backButton = search.xpath(".//a[contains( text(),'Back')]");
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getBackButton() {
        return backButton;
    }

    //Set fields

    public void clickContinueButton() {
        getContinueButton().click();
    }
    public void clickBackButton(){getBackButton().click();}

    public String getEmailText() {
        return personalDetailsComponent.getFieldEmail().getAttribute("value");
    }

    //----------Bussiness logic
    public MyAccountPage saveChangesAccount() {
        clickContinueButton();
        return new MyAccountPage();
    }

    public MyAccountPage backWithoutChangesAccount() {
        clickBackButton();
        return new MyAccountPage();
    }


    public void changeFieldAccount(IUser user) {
        personalDetailsComponent.setFieldFirstName(user.getFirstname());
        personalDetailsComponent.setFieldLastName(user.getLastname());
        personalDetailsComponent.setFieldEmail(user.getEmail());
        personalDetailsComponent.setFieldTelephone(user.getPhoneNumber());
        personalDetailsComponent.setFieldFax(user.getFax());
    }
}