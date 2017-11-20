package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddressBookEntries {
    private WebElement entriesLocator;
    private WebElement  editButton;
    private WebElement deleteButton;
    private WebElement addressData;

    public AddressBookEntries(WebElement entriesLocator){
        this.entriesLocator = entriesLocator;
        editButton = entriesLocator.findElement(By.cssSelector(".btn.btn-info"));
        deleteButton = entriesLocator.findElement(By.cssSelector(".btn.btn-danger"));
        addressData = entriesLocator.findElement(By.cssSelector(".text-left"));
    }

    public WebElement getEntriesLocator() {
        return entriesLocator;
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
