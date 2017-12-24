package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.tools.exceptions.ErrorUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class AddressBookPage extends AColumnRightPartitionalComponent {

    private List<AddressBookEntries> addressBookEntries;
    private WebElement newAddressBook;
    private WebElement backButton;
    private final String STREET_NOT_FOUND_MESSAGE = "Street %s not found ";

    public AddressBookPage() {
        super();
        newAddressBook = search.cssSelector(".btn.btn-primary");
        backButton = search.xpath(".//a[contains( text(),'Back')]");
        initAddressBookEntries(By.cssSelector("table.table.table-bordered.table-hover>tbody>tr"));
    }

    protected void initAddressBookEntries(By searchLocator) {
        addressBookEntries = new ArrayList<>();
        List<WebElement> addressWebElements = search.getWebElements(searchLocator);
        for (WebElement current : addressWebElements) {
            addressBookEntries.add(new AddressBookEntries(current));
        }
    }
    // PageObject

    // get Data

    public List<AddressBookEntries> getAddressBookEntries() {
        return addressBookEntries;
    }

    public WebElement getNewAddressBook() {
        return newAddressBook;
    }

    public WebElement getBackButton() {
        return backButton;
    }
    // get Functional

    // set Data

    public void clickNewAddress() {
        getNewAddressBook().click();
    }

    public void clickBackButton() {
        getBackButton().click();
    }
    // set Functional

    public void deleteAddressBookEntries(IUser user) {
        getAddressBookEntriesByStreetName(user.getAddressFirst()).clickDeleteButton();

    }

    public AddressBookEntries getAddressBookEntriesByStreetName(String streetName) {
        AddressBookEntries result = null;
        for (AddressBookEntries current : getAddressBookEntries()) {
            if (current.getAddressDataText().toLowerCase().contains(streetName.toLowerCase())) {
                result = current;
                break;
            }
        }
        ErrorUtils.createCustomException((result == null),
                String.format(STREET_NOT_FOUND_MESSAGE, streetName));
        return result;
    }

    // Business Logic
    public EditAddressPage modifyAddressBookData(IUser user) {
        getAddressBookEntriesByStreetName(user.getAddressSecond()).clickEditButton();
        return new EditAddressPage();
    }

    public MyAccountPage gotoMyAccountPage() {
        clickBackButton();
        return new MyAccountPage();
    }

    public EditAddressPage createAddress() {
        clickNewAddress();
        return new EditAddressPage();
    }

    public String getWarningDeleteAddressText() {
        return getAlertWarningText();
    }

    public String getSuccessText() {
        return getAlertSuccessText();
    }


}
