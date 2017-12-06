package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import org.testng.annotations.*;

/**
 * Created by Serhiienko.
 */
public abstract class ALoginForTest {

    @BeforeTest
    public static void precondition() {
        Application.get().login().gotoLoginForLoginPageToMyAccountPage(UserRepository.get().valid());
    }

    @AfterTest
    public static void logOut() {
        Application.get().logout();
        Application.remove();
    }

}
