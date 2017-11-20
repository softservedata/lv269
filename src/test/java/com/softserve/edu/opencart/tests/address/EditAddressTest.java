package com.softserve.edu.opencart.tests.address;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.AddressBookPage;
import com.softserve.edu.opencart.pages.user.EditAddressPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class EditAddressTest {
    @BeforeClass
    public void beforClass(){
        Application.get(ApplicationSourceRepository.get().chromeServer7());
    }

    @AfterClass
    public void afterClass() {
        Application.remove();
    }
    @DataProvider(name = "editAddress")
    public Object[][] userData() {
        return new Object[][] {
                {UserRepository.get().userZvarych(), "input-firstname", "First Name must be between 1 and 32 characters!"},
                {UserRepository.get().userZvarych(), "input-lastname", "Last Name must be between 1 and 32 characters!"},
                {UserRepository.get().userZvarych(), "input-address-1", "Address must be between 3 and 128 characters!"},
                {UserRepository.get().userZvarych(), "input-city", "City must be between 2 and 128 characters!"}
        };

    }

    @BeforeMethod
    public void beforMethod(){

    }

    @AfterMethod
    public void afterMethod(){
        Application.get().logout();

    }
    @Test(dataProvider = "editAddress")
    public void checkEmptyField(IUser user, String locator,String expected){
        EditAddressPage editAddressPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount()
                .gotoLoginForLoginPageToMyAccountPage(user)
                .gotoAddressBookPageRightColumn().modifyAddressBookData(user);
        editAddressPage.clearField(editAddressPage.findField(locator));
        editAddressPage.saveChangesAddress();
        String acttual = editAddressPage.getWarningDangerTextforField();
        Assert.assertEquals(acttual, expected);

    }
}
