package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.tools.SearchManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WrongLoginAdminPage extends LoginAdminPage {

    // Fields
    private WebElement wrongLoginMessage;

    public WrongLoginAdminPage(SearchManager searchManager) {
        super(searchManager);
        wrongLoginMessage = searchManager.findElement(By.className("alert"));
    }



    // PageObject

    // Get data
    public WebElement getWrongLoginMessage() {
        return wrongLoginMessage;
    }

    // Get Functional

    public String getWrongLoginMessageText () {
        return getWrongLoginMessage().getText().split("\n")[0];
    }

    // set data

    // set Functional

    // Business Logic


}
