package com.softserve.edu.opencart.tests.address;


import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.AlertsText;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.EditAddressPage;
import com.softserve.edu.opencart.tests.TestRunner;
import com.softserve.edu.opencart.tests.TestRunnerFireFox;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class EditPositiveAddressTest extends TestRunnerFireFox {

    @AfterMethod
    public void afterMethod() {
        Application.get().logout();
    }
    @DataProvider(name = "editAddress")
    public static Object[][] positiveValues() {
        return new Object[][]{{UserRepository.get().userZvarych(), AlertsText.SUCCESS_ADDRESS_TEXT.toString()}};

    }


    @Test(dataProvider = "editAddress")
    public void checkPositiveValueField(IUser user,String expected) {
        logger.info(String.format("check Positive value fields Address :  of User: %s",user.getEmail()));
        reporter.info(String.format("check Positive value fields Address:  of User: %s", user.getEmail()));

        EditAddressPage editAddressPage = Application.get()
                .loadHomePage()
                .gotoLoginPageFromMyAccount()
                .gotoLoginForLoginPageToMyAccountPage(user)
                .gotoAddressBookPageRightColumn()
                .modifyAddressBookData(user);

        editAddressPage.changeFieldAddress(user);
        String actual = editAddressPage
                .saveChangesAddress()
                .getSuccessText();

        Assert.assertEquals(actual, expected);
    }

}

