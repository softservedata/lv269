package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class AddressBookPage extends MyAccountPage {

    private List<AddressBookEntries> addressBookEntries;
    private WebElement newAddressBook;
    private WebElement backButton;

    public AddressBookPage(WebDriver driver){
        super(driver);
        newAddressBook = driver.findElement(By.cssSelector(".btn.btn-primary"));
        backButton = driver.findElement(By.xpath(".//a[contains( text(),'Back')]"));
        initAddressBookEntries(By.cssSelector("table.table.table-bordered.table-hover>tbody>tr"));
    }
    protected void initAddressBookEntries(By searchLocator) {
        addressBookEntries = new ArrayList<>();
        List<WebElement> addressWebElements = driver.findElements(searchLocator);
        for (WebElement current : addressWebElements) {
            addressBookEntries.add(new AddressBookEntries(current));
        }
    }
    // PageObject

    // get Data

    public WebElement getNewAddressBook() {
        return newAddressBook;
    }

    public WebElement getBackButton() {
        return backButton;
    }
    // get Functional

    // set Data




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
    public EditAddressPage createAddress(){
        clickNewAddress();
        return new EditAddressPage(driver);
    }


}
