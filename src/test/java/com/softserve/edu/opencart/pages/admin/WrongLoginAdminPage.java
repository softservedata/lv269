package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.WebElement;

public class WrongLoginAdminPage extends LoginAdminPage {

    // Fields
    private WebElement wrongLoginMessage;

    public WrongLoginAdminPage() {
        wrongLoginMessage = search.className("alert");
    }



    // PageObject

    // Get data
    public WebElement getWrongLoginMessage() {
        return wrongLoginMessage;
    }

    // Get Functional

    public String getWrongLoginMessageText () {
        return operations.getText(getWrongLoginMessage()).split("\n")[0];
    }

    // set data

    // set Functional

    // Business Logic


}
