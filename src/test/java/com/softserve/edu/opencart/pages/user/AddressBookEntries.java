package com.softserve.edu.opencart.pages.user;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddressBookEntries extends AColumnRightUserComponent {


    private WebElement  editButton;
    private WebElement deleteButton;
    private WebElement addressData;

    public AddressBookEntries(WebElement entriesLocator){
        editButton = search.cssSelector(".btn.btn-info",entriesLocator);
        deleteButton = search.cssSelector(".btn.btn-danger",entriesLocator);
        addressData = search.cssSelector(".text-left",entriesLocator);

    }

    public WebElement getEditButton() {
        return editButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getAddressData() {
        return addressData;
    }

    public void clickEditButton(){
        getEditButton().click();
    }

    public void clickDeleteButton(){
        getDeleteButton().click();
    }

    public String getAddressDataText(){
        return getAddressData().getText();
    }




}
