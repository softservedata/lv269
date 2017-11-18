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

import java.sql.SQLException;

public class BlockLoginTest {
    private final String  UNBLOCK_USER=" UPDATE oc_customer_login SET total = '0' WHERE email  = '%s';";


    @BeforeClass
    public void beforeClass() {
//        Application.get(ApplicationSourceRepository.get().chromeServer7());
        Application.get(ApplicationSourceRepository.get().firefoxServer7());
    }

    @AfterClass
    public void afterClass() throws SQLException {
        Application.remove();
    }


    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {

        return new Object[][]{
                {UserRepository.get().userTestWrongPassword(), UserRepository.get().userTestCorectPassword()}};

    }


    @Test(dataProvider = "Authentication")
    public void checkSuccessfulLogin(IUser userWithWrongPassword, IUser userWithCorectPassword) throws Exception {
        Application.get().unlockUserByQuery(userWithCorectPassword, UNBLOCK_USER);

        String actual;
        String expectedFirstWarning = "Warning: No match for E-Mail Address and/or Password.";
        String expectedSecondWarning = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";

        LoginPage loginPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount();
        for (int i = 0; i < 5; i++) {
            loginPage = loginPage.gotoLoginForLoginPageToWarning(userWithWrongPassword);
            actual = loginPage.getWarningDangerText();

            Assert.assertEquals(actual, expectedFirstWarning);
        }

        loginPage = loginPage.gotoLoginForLoginPageToWarning(userWithWrongPassword);
        actual = loginPage.getWarningDangerText();

        Assert.assertEquals(actual, expectedSecondWarning);

        //check is user reale blocked(check with correct password)
        loginPage = loginPage.gotoLoginForLoginPageToWarning(userWithCorectPassword);
        actual = loginPage.getWarningDangerText();

        Assert.assertEquals(actual, expectedSecondWarning);

        Application.get().unlockUserByQuery(userWithCorectPassword, UNBLOCK_USER);
        Application.closeConnection();
        //unblockInDatabase(userWithWrongPassword.getEmail());

    }
}
