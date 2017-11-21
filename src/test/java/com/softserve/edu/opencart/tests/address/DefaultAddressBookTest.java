package com.softserve.edu.opencart.tests.address;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.AlertsText;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.AddressBookPage;
import com.softserve.edu.opencart.pages.user.EditAddressPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class DefaultAddressBookTest {
    @BeforeClass
    public void beforClass(){
        Application.get(ApplicationSourceRepository.get().firefoxServer7());
        //Application.get(ApplicationSourceRepository.get().chromeServer7());
    }

    @AfterClass
    public void afterClass() {
        Application.remove();
    }

    @DataProvider(name = "addressPage")
    public Object[][] defaultUser() {
        return new Object[][] {
                {
                        UserRepository.get().userZvarych(),AlertsText.CAN_NOT_DELETE_ADDRESS.toString()

                }
        };

    }

    @BeforeMethod
    public void beforMethod(){

    }

    @AfterMethod
    public void afterMethod(){
        Application.get().logout();

    }
    @Test(dataProvider = "addressPage")
    public void checkDeleteDefoltAddress(IUser user, String expected){
        AddressBookPage addressBookPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount()
                .gotoLoginForLoginPageToMyAccountPage(user)
                .gotoAddressBookPageRightColumn();
        addressBookPage.deleteAddressBookEntries(user);
        String actual = addressBookPage.getWarningDeleteAddressText();
        Assert.assertEquals(actual,expected);
    }

}
