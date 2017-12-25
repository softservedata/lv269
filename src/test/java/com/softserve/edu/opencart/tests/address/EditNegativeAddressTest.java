package com.softserve.edu.opencart.tests.address;


import com.softserve.edu.opencart.data.field.ListOfFieldsRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.EditAddressPage;
import com.softserve.edu.opencart.tests.TestRunnerFireFox;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.List;

public class EditNegativeAddressTest extends TestRunnerFireFox {


    @AfterMethod
    public void afterMethod() {
        Application.get().logout();
    }

    @DataProvider(name = "editAddress")
    public Iterator<Object[]> userData() {
        List<Object[]> data = ListOfFieldsRepository.get().nehgativeFields().getData();
        return data.iterator();
    }


    @Test(dataProvider = "editAddress")
    public void checkEmptyField(IUser user, IUser wrongField, String expected) {
        logger.info(String.format("check Empty Field:  of User: %s",wrongField.getEmail()));
        reporter.info(String.format("check Empty Address:  of User: %s", wrongField.getEmail()));

        EditAddressPage editAddressPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount()
                .gotoLoginForLoginPageToMyAccountPage(user)
                .gotoAddressBookPageRightColumn().modifyAddressBookData(user);

        editAddressPage.changeFieldAddress(wrongField);
        editAddressPage.saveChangesAddress();
        String actual = editAddressPage.getWarningDangerTextforField();

        flexAssert.assertEquals(actual, expected);
    }

}
