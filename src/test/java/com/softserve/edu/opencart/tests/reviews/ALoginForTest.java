package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tests.TestRunnerPhantomJS;
import org.testng.annotations.*;

/**
 * Created by Serhiienko.
 */
public abstract class ALoginForTest extends TestRunnerPhantomJS {

    @BeforeTest
    public void precondition() {
        Application.get().login().gotoLoginForLoginPageToMyAccountPage(UserRepository.get().valid());
    }

    @AfterTest
    public void logOut() {
        Application.get().logout();
    }

}
