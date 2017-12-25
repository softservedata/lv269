package com.softserve.edu.opencart.tests.address;


import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.AlertsText;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.AddressBookPage;
import com.softserve.edu.opencart.tests.TestRunner;
import com.softserve.edu.opencart.tests.TestRunnerFireFox;
import org.testng.Assert;
import org.testng.annotations.*;

public class DefaultAddressBookTest extends TestRunnerFireFox {

    @DataProvider(name = "addressPage")
    public Object[][] defaultUser() {
        return new Object[][]{
                {UserRepository.get().userZvarych(), AlertsText.CAN_NOT_DELETE_ADDRESS.toString()}
        };
    }

    @Test(dataProvider = "addressPage")
    public void checkDeleteDefaultAddress(IUser user, String expected) {
        logger.info(String.format("check Delete Address:  of User: %s", user.getEmail()));
        reporter.info(String.format("check Delete Address:  of User: %s", user.getEmail()));

        AddressBookPage addressBookPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount()
                .gotoLoginForLoginPageToMyAccountPage(user)
                .gotoAddressBookPageRightColumn();
        addressBookPage.deleteAddressBookEntries(user);

        String actual = addressBookPage.getWarningDeleteAddressText();
        flexAssert.assertEquals(actual, expected);
    }

}
