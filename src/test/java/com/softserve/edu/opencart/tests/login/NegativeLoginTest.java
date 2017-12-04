package com.softserve.edu.opencart.tests.login;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.LoginPage;
import com.softserve.edu.opencart.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class NegativeLoginTest extends TestRunner {

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{{UserRepository.get().userUnknown()}};

    }

    @Test(dataProvider = "Authentication")
    public void checkNegativeLogin(IUser user) {
        logger.info(String.format("check Negative Logining of User: %s", user.getEmail()));
        reporter.info(String.format("check Negative Logining of User: %s", user.getEmail()));

        LoginPage loginPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount();
        loginPage = loginPage.gotoLoginForLoginPageToWarning(user);
        String actual = loginPage.getWarningDangerText();

        Assert.assertEquals(actual, LoginPage.EXPECTED_FIRST_WARNING);
    }
}