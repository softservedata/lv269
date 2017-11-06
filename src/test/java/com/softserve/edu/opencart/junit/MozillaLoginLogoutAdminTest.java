package com.softserve.edu.opencart.junit;

import org.junit.*;

public class MozillaLoginLogoutAdminTest {

    private static final String ENTER = "enter";
    private static final String BUTTON = "button";

    static WebDriverCreator webDriverCreator;
    static LoginLogoutAdmin loginLogoutAdmin;

    @BeforeClass
    public static void createDrivers() {
        webDriverCreator = new WebDriverCreator();
        webDriverCreator.setWebdriverFirefox();
        loginLogoutAdmin = new LoginLogoutAdmin(webDriverCreator);
    }

    @Before
    public void setMainPage () {
        loginLogoutAdmin.setMainPage();
    }

    @Test
    public void LoginMozillaClickTest() {
        loginLogoutAdmin.login(BUTTON);
        Assert.assertTrue(Messages.FAIL_LOGIN_ADMIN_FIREFOX_CLICK.getMessage(),
                loginLogoutAdmin.isLogined());
        loginLogoutAdmin.logout();
        Assert.assertTrue(Messages.FAIL_LOGOUT_ADMIN_FIREFOX_CLICK.getMessage(),
                loginLogoutAdmin.isLogouted());
    }

    @Test
    public void testLoginMozillaEnter() {
        loginLogoutAdmin.login(ENTER);
        Assert.assertTrue(Messages.FAIL_LOGIN_ADMIN_FIREFOX_ENTER.getMessage(),
                loginLogoutAdmin.isLogined());
        loginLogoutAdmin.logout();
        Assert.assertTrue(Messages.FAIL_LOGOUT_ADMIN_FIREFOX_ENTER.getMessage(),
                loginLogoutAdmin.isLogouted());
    }

    @AfterClass
    public static void driverQuit() {
        webDriverCreator.quitDriver();
    }

}