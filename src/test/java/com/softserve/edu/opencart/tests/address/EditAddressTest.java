package com.softserve.edu.opencart.tests.address;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.AlertsText;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.GeneralLocators;
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
                {UserRepository.get().userZvarych(), GeneralLocators.FIRST_NAME_LOCATOR, AlertsText.FIRST_NAME_MUST_BE_1_TO_32.toString()},
                {UserRepository.get().userZvarych(), GeneralLocators.SECOND_NAME_LOCATOR,AlertsText.SECOND_NAME_MUST_BE_1_TO_32.toString()},
                {UserRepository.get().userZvarych(), GeneralLocators.ADDRESS_LOCATOR, AlertsText.ADDRESS_MUST_BE_3_TO_128.toString()},
                {UserRepository.get().userZvarych(), GeneralLocators.CITY_LOCATOR, AlertsText.CITY_MUST_BE_2_TO_128.toString()}
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
    public void checkEmptyField(IUser user, GeneralLocators locator,String expected){
        EditAddressPage editAddressPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount()
                .gotoLoginForLoginPageToMyAccountPage(user)
                .gotoAddressBookPageRightColumn().modifyAddressBookData(user);
        editAddressPage.clearField(editAddressPage.findField(locator));
        editAddressPage.saveChangesAddress();
        String acttual = editAddressPage.getWarningDangerTextforField();
        Assert.assertEquals(acttual, expected);

    }
}
