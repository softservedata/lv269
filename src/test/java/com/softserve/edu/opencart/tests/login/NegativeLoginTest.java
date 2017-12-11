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


public class NegativeLoginTest extends TestRunner {

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{{UserRepository.get().userUnknown()}};

    }

    @AfterMethod
    public void closeDB(ITestResult result) {
        Application.get().unlockUserByQuery((IUser) result.getParameters()[0]);
        logger.debug(String.format("unBlocking of User: %s, after test", ((IUser) result.getParameters()[0]).getEmail()));
        reporter.debug(String.format("unBlocking of User: %s, after test", ((IUser) result.getParameters()[0]).getEmail()));
        Application.closeDB();
    }

    @Test(dataProvider = "Authentication")
    public void checkNegativeLogin(IUser user) {
        logger.info(String.format("start check Negative Logining of User: %s", user.getEmail()));
        reporter.info(String.format("start check Negative Logining of User: %s", user.getEmail()));

        LoginPage loginPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount();
        loginPage = loginPage.gotoLoginForLoginPageToWarning(user);
        String actual = loginPage.getWarningDangerText();

        Assert.assertEquals(actual, LoginPage.EXPECTED_FIRST_WARNING);
        logger.info(String.format("finish check Negative Logining of User: %s", user.getEmail()));
        reporter.info(String.format("finish check Negative Logining of User: %s", user.getEmail()));

    }
}