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

    @DataProvider(name = "editAddress")
    public Iterator<Object[]> userData() {
        List<Object[]> data = ListOfFieldsRepository.get().nehgativeFields().getData();
        return data.iterator();
    }
    @Test(dataProvider = "editAddress")
   // public void checkEmptyField(IUser user, IUser wrongField, String expected) {
        public void checkEmptyField( IUser wrongField, String expected) throws InterruptedException {
        logger.info(String.format("check Empty Field:  of User: %s", wrongField.getClass().getName()));
        reporter.info(String.format("check Empty Address:  of User: %s", wrongField.getClass().getName()));

        RegisterPage registerPage = Application.get().loadHomePage().gotoRegistePageFromMyAccount();

        registerPage.changeFieldRegister(wrongField);
        registerPage.gotoRegisterSuccessPage();
        //Thread.sleep(10000);

        String actual = registerPage.getWarningDangerTextforField();
        Assert.assertEquals(actual, expected);

    }
}
