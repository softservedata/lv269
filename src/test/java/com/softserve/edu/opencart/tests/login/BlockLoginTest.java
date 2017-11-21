package com.softserve.edu.opencart.tests.login;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class BlockLoginTest {


    @BeforeClass
    public void beforeClass()   {
//        Application.get(ApplicationSourceRepository.get().chromeServer7());
        Application.get(ApplicationSourceRepository.get().firefoxServer7());
    }

    @AfterClass
    public void afterClass()   {
        Application.remove();
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {

        return new Object[][]{
                {UserRepository.get().userTestWrongPassword(), UserRepository.get().userTestCorectPassword()}};

    }

    @Test(dataProvider = "Authentication")
    public void checkBlockUser(IUser userWithWrongPassword, IUser userWithCorectPassword)   {

        Application.get().unlockUserByQuery(userWithCorectPassword);

        String actual;
        LoginPage loginPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount();
        for (int i = 0; i < 5; i++) {
            loginPage = loginPage.gotoLoginForLoginPageToWarning(userWithWrongPassword);
            actual = loginPage.getWarningDangerText();

            Assert.assertEquals(actual, LoginPage.EXPECTED_FIRST_WARNING);
        }

        loginPage = loginPage.gotoLoginForLoginPageToWarning(userWithWrongPassword);
        actual = loginPage.getWarningDangerText();

        Assert.assertEquals(actual, LoginPage.EXPECTED_SECOND_WARNING);

        //check is user realy blocked(check with correct password)
        loginPage = loginPage.gotoLoginForLoginPageToWarning(userWithCorectPassword);
        actual = loginPage.getWarningDangerText();

        Assert.assertEquals(actual, LoginPage.EXPECTED_SECOND_WARNING);


        Application.get().unlockUserByQuery(userWithCorectPassword);
        Application.closeDB();

    }
}
