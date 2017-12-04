package com.softserve.edu.opencart.tests.login;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.MyAccountPage;
import com.softserve.edu.opencart.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SuccessLoginTest extends TestRunner {


    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{{UserRepository.get().userTestLogin()}};

    }

    @Test(dataProvider = "Authentication")
    public void checkSuccessfulLogin(IUser user) throws Exception {
        logger.info(String.format("check Successful Login of User: %s", user.getEmail()));
        reporter.info(String.format("check Successful Login of User: %s", user.getEmail()));

        MyAccountPage myAccountPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount()
                .gotoLoginForLoginPageToMyAccountPage(user);
        Assert.assertEquals(myAccountPage.gotoEditAccountPageFromRightColumn().getEmailText(), user.getEmail());
        Application.get().logout();
    }
}