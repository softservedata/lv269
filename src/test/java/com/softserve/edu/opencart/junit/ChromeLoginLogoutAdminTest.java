package com.softserve.edu.opencart.junit;

import org.junit.*;

/**
 * This class checks login (using buttons and Enter) and logout
 * process on Chrome.
 */
public class ChromeLoginLogoutAdminTest {

    static WebDriverCreator webDriverCreator;
    static LoginLogoutAdmin loginLogoutAdmin;

    @BeforeClass
    public static void createDrivers() {
        webDriverCreator = new WebDriverCreator();
        webDriverCreator.setWebdriverChrome();
        loginLogoutAdmin = new LoginLogoutAdmin(webDriverCreator);
    }

    @Before
    public void setMainPage () {
        loginLogoutAdmin.setMainPage();
    }

    @Test
    public void LoginChromeClickTest() {
        loginLogoutAdmin.login(Credentials.BUTTON.getChosenConstant());
        Assert.assertTrue(Messages.FAIL_LOGIN_ADMIN_CHROME_CLICK.getMessage(),
                loginLogoutAdmin.isLogined());
        loginLogoutAdmin.logout();
        Assert.assertTrue(Messages.FAIL_LOGOUT_ADMIN_CHROME_CLICK.getMessage(),
                loginLogoutAdmin.isLogouted());
    }

    @Test
    public void testLoginChromeEnter(){
        loginLogoutAdmin.login(Credentials.ENTER.getChosenConstant());
        Assert.assertTrue(Messages.FAIL_LOGIN_ADMIN_CHROME_ENTER.getMessage(),
                loginLogoutAdmin.isLogined());
        loginLogoutAdmin.logout();
        Assert.assertTrue(Messages.FAIL_LOGOUT_ADMIN_CHROME_ENTER.getMessage(),
                loginLogoutAdmin.isLogouted());
    }

    @AfterClass
    public static void driverQuit() {
        webDriverCreator.quitDriver();
    }

}