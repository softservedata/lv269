package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import org.testng.annotations.*;

/**
 * Created by Serhiienko.
 */
public class LoginForTest {

    @BeforeMethod
    public static void precondition() {
        Application.get().login().gotoLoginForLoginPageToMyAccountPage(UserRepository.get().valid());
    }

    @AfterMethod
    public static void logOut() {
        Application.get().getApplicationSources().getUserLogoutUrl();
        Application.remove();
    }

}
