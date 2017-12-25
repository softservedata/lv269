package com.softserve.edu.opencart.tests.address;

import com.softserve.edu.opencart.data.field.ListOfFieldsRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.EditAddressPage;
import com.softserve.edu.opencart.pages.user.RegisterPage;
import com.softserve.edu.opencart.tests.TestRunnerFireFox;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class CheckEmptyFieldsRegisterPageTest extends TestRunnerFireFox {

    @DataProvider(name = "notValidRegistration")
    public Iterator<Object[]> userData() {
        List<Object[]> data = ListOfFieldsRepository.get().nehgativeFieldsForRegistration().getData();
        return data.iterator();
    }
    @Test(dataProvider = "notValidRegistration")
        public void checkEmptyField( IUser wrongField, String expected){
        logger.info(String.format("check Empty Fields:  of User: %s", wrongField.getClass().getName()));
        reporter.info(String.format("check Empty Fields:  of User: %s", wrongField.getClass().getName()));

        RegisterPage registerPage = Application.get().loadHomePage().gotoRegistePageFromMyAccount();

        registerPage.changeFieldRegister(wrongField);
        registerPage.gotoRegisterSuccessPage();

        String actual = registerPage.getWarningDangerTextforField();
        flexAssert.assertEquals(actual, expected);

    }
}
