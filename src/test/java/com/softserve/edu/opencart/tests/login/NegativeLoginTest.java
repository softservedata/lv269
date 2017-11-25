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



public class NegativeLoginTest {
    @BeforeClass
    public void beforeClass()   {
//        Application.get(ApplicationSourceRepository.get().chromeServer7());
        Application.get(ApplicationSourceRepository.get().firefoxImplicitServer7());
    }

    @AfterClass
    public void afterClass() {
        Application.remove();
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{{UserRepository.get().userUnknown()}};

    }

    @Test(dataProvider = "Authentication")
    public void checkSuccessfulLogin(IUser user)   {

        LoginPage loginPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount();
        loginPage = loginPage.gotoLoginForLoginPageToWarning(user);
        String actual = loginPage.getWarningDangerText();

        Assert.assertEquals(actual, LoginPage.EXPECTED_FIRST_WARNING);
    }
}