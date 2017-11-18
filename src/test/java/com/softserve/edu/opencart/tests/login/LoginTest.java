package com.softserve.edu.opencart.tests.login;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    @BeforeClass
    public void beforeClass() {
//        Application.get(ApplicationSourceRepository.get().chromeServer7());
        Application.get(ApplicationSourceRepository.get().firefoxServer7());
    }
    @AfterClass
    public void afterClass()  {
        Application.remove();
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{{UserRepository.get().userTestLogin()}};

    }

    @Test(dataProvider = "Authentication")
    public void checkSuccessfulLogin(IUser user) throws Exception {

        Application.get().loadHomePage().gotoLoginPageFromMyAccount()
                .gotoLoginForLoginPageToMyAccountPage(user)
                .gotoLogoutPage()
                .gotoHomePage();
    }
}