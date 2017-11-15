package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ${Mirek} .
 */
public class AddressBookPage extends MyAccountPage {
    private WebElement editButton;
    private WebElement deleteButton;
    private WebElement newAddressBook;
    private WebElement backButton;

    public AddressBookPage(WebDriver driver){
        super(driver);
        editButton = driver.findElement(By.cssSelector(".btn.btn-info"));
        deleteButton = driver.findElement(By.cssSelector(".btn.btn-danger"));
        newAddressBook = driver.findElement(By.cssSelector(".btn.btn-primary"));
        backButton = driver.findElement(By.xpath(".//a[contains( text(),'Back')]"));
    }
    // PageObject

    // get Data

    public WebElement getEditButton() {
        return editButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getNewAddressBook() {
        return newAddressBook;
    }

    public WebElement getBackButton() {
        return backButton;
    }
    // get Functional

    // set Data
    public void clickEditButton(){
        getEditButton().click();
    }

    public void clickDeleteButton(){
        getDeleteButton().click();
    }

    public void clickNewAddress(){
        getNewAddressBook().click();
    }

    public void clickBackButton(){
        getBackButton().click();
    }
    // set Functional

    // Business Logic
    public MyAccountPage gotoMyAccountPage(){
        clickBackButton();
        return new MyAccountPage(driver);
    }

    public EditAddressPage gotoEditAddress(){
        clickEditButton();
        return new EditAddressPage(driver);
    }
}
