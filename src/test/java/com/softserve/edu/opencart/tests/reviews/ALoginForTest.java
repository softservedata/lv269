package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;

import com.softserve.edu.opencart.tests.TestRunnerChromeWithoutUI;
import org.testng.annotations.*;

/**
 * Created by Serhiienko.
 */
public abstract class ALoginForTest extends TestRunnerChromeWithoutUI {

    @BeforeClass
    public void precondition() {
        Application.get().login().gotoLoginForLoginPageToMyAccountPage(UserRepository.get().valid());
    }

    @AfterClass
    public void logOut() {
        Application.get().logout();
    }

}