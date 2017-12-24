package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.Operations;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class EditAddressPage extends AddressBookPage {
    private AddressComponent addressComponent;
    private WebElement fieldFirstName;
    private WebElement fieldLastName;
    private WebElement continueButton;
    private WebElement backButton;

    public EditAddressPage() {
        super();
        this.addressComponent = new AddressComponent();
        this.fieldFirstName = search.id("input-firstname");
        this.fieldLastName = search.id("input-lastname");
        this.continueButton = search.cssSelector(".btn.btn-primary");
        this.backButton = search.xpath(".//a[contains( text(),'Back')]");
    }
    // PageObject
    // get Data

    public WebElement getFieldFirstName() {
        return fieldFirstName;
    }

    public WebElement getFieldLastName() {
        return fieldLastName;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getBackButton() {
        return backButton;
    }

    // get Functional
    public String getWarningDeleteAddressText() {
        return getAlertWarningText();

    }

    public String getWarningDangerTextforField() {
        return getAlertTextDangerText();

    }
    // set Data

    public void clickFieldFirstName() {
        getFieldFirstName().click();
    }

    public void clickFieldLastName() {
        getFieldLastName().click();
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    public void clickBackButton() {
        getBackButton().click();
    }


    public void clearFieldFirstName() {
        getFieldFirstName().clear();
    }

    public void clearFieldLastName() {
        getFieldLastName().clear();
    }

    //-----------------------------------------

    public void setFieldFirstName(String text) {
        clickFieldFirstName();
        clearFieldFirstName();
        getFieldFirstName().sendKeys(text);
    }

    public void setFieldLastName(String text) {
        clickFieldLastName();
        clearFieldLastName();
        getFieldLastName().sendKeys(text);
    }


    //* Business Logic

    public AddressBookPage saveChangesAddress() {
        clickContinueButton();
        return new AddressBookPage();
    }

    public AddressBookPage backWithoutChangesAddress() {
        clickBackButton();
        return new AddressBookPage();
    }

    public void changeFieldAddress(IUser user) {
        setFieldFirstName(user.getFirstname());
        setFieldLastName(user.getLastname());
        addressComponent.setFieldFirstAddress(user.getAddressFirst());
        addressComponent.setFieldCity(user.getCity());
        addressComponent.selectFieldCountry(user.getCountry());
        addressComponent.selectFieldRegion(user.getRegion());

    }

}


