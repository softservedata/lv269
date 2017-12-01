package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;

public class EditAccountPage extends AColumnRightUserComponent {

    // fields

    private WebElement email;

    public EditAccountPage() {
        super();
        email = search.name("email");

    }

    public WebElement getEmail() {
        return email;
    }

    public String getEmailText() {
        return getEmail().getAttribute("value");
    }

//----------Bussiness logic


}