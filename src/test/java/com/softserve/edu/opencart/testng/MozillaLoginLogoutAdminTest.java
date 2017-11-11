package com.softserve.edu.opencart.testng;


import com.softserve.edu.opencart.testng.constants.Credentials;
import com.softserve.edu.opencart.testng.constants.Messages;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * This class checks login (using buttons and Enter) and logout
 * process on Chrome.
 */
public class MozillaLoginLogoutAdminTest {

    public WebDriverManager webDriverManager;
    public LoginLogoutAdmin loginLogoutAdmin;

    @DataProvider
    public Object[][] TypeOfEntrance () {
        return new Object[][] {
                {Credentials.BUTTON.get()},
                {Credentials.BUTTON.get()},
        };
    }

    @BeforeClass
    public void createDrivers() {
        webDriverManager = new WebDriverManager();
        webDriverManager.setWebdriverFirefox();
        loginLogoutAdmin = new LoginLogoutAdmin(webDriverManager);
    }

    @BeforeMethod
    public void setMainPage() {
        loginLogoutAdmin.setMainPage();
    }

    @Test(dataProvider = "TypeOfEntrance")
    public void LoginChromeTest(String typeOfEntrance) {
        loginLogoutAdmin.login(typeOfEntrance);
        Assert.assertTrue(loginLogoutAdmin.isLogined(),
                Messages.FAIL_LOGIN_ADMIN_CHROME_CLICK.getMessage());
        loginLogoutAdmin.logout();
        Assert.assertTrue(loginLogoutAdmin.isLogouted(),
                Messages.FAIL_LOGOUT_ADMIN_CHROME_CLICK.getMessage());
    }

    @AfterClass
    public void driverQuit() {
        webDriverManager.quitDriver();
    }

}