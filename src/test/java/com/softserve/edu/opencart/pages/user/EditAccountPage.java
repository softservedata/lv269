package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAccountPage extends AColumnRightUserComponent {

    // fields

    private WebElement email;

    public EditAccountPage(WebDriver driver) {
        super(driver);
        email = driver.findElement(By.name("email"));

    }

    public WebElement getEmail() {
        return email;
    }

    public String getEmailText() {
        return getEmail().getAttribute("value");
    }

//----------Bussiness logic


}