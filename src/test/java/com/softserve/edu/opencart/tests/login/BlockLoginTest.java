package com.softserve.edu.opencart.tests.login;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.LoginPage;
import com.softserve.edu.opencart.tests.TestRunner;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BlockLoginTest extends TestRunner {

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {

        return new Object[][]{
                {UserRepository.get().userTestWrongPassword(), UserRepository.get().userTestCorectPassword()}};

    }

    @AfterMethod
    public void closeDB(ITestResult result) {
        Application.get().unlockUserByQuery((IUser) result.getParameters()[0]);
        logger.debug(String.format("unBlocking of User: %s, after test", ((IUser) result.getParameters()[0]).getEmail()));
        reporter.debug(String.format("unBlocking of User: %s, after test", ((IUser) result.getParameters()[0]).getEmail()));
        Application.closeDB();
    }

    @Test(dataProvider = "Authentication")
    public void checkBlockUser(IUser userWithWrongPassword, IUser userWithCorectPassword) {
        logger.info(String.format("check Blocking of User: %s", userWithCorectPassword.getEmail()));
        reporter.info(String.format("check Blocking of User: %s", userWithCorectPassword.getEmail()));

        String actual;
        LoginPage loginPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount();
        for (int i = 0; i < 5; i++) {
            loginPage = loginPage.gotoLoginForLoginPageToWarning(userWithWrongPassword);
            actual = loginPage.getWarningDangerText();

            logger.debug(String.format("check Blocking of User: %s, iteration number: %d", userWithCorectPassword.getEmail(), i));
            reporter.debug(String.format("check Blocking of User: %s, iteration number: %d", userWithCorectPassword.getEmail(), i));

            Assert.assertEquals(actual, LoginPage.EXPECTED_FIRST_WARNING);
        }

        logger.debug(String.format("check Blocking of User: %s, after iterations", userWithCorectPassword.getEmail()));
        reporter.debug(String.format("check Blocking of User: %s, after iterations", userWithCorectPassword.getEmail()));
        loginPage = loginPage.gotoLoginForLoginPageToWarning(userWithWrongPassword);
        actual = loginPage.getWarningDangerText();

        Assert.assertEquals(actual, LoginPage.EXPECTED_SECOND_WARNING);

        logger.debug(String.format("check Blocking of User: %s, with correct password", userWithCorectPassword.getEmail()));
        reporter.debug(String.format("check Blocking of User: %s, with correct password", userWithCorectPassword.getEmail()));
        loginPage = loginPage.gotoLoginForLoginPageToWarning(userWithCorectPassword);
        actual = loginPage.getWarningDangerText();

        Assert.assertEquals(actual, LoginPage.EXPECTED_SECOND_WARNING);

    }
}
