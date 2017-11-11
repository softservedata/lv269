package com.softserve.edu.opencart.testng;


import com.softserve.edu.opencart.testng.constants.Credentials;
import com.softserve.edu.opencart.testng.constants.Messages;
import org.testng.Assert;
import org.testng.annotations.*;
import com.softserve.edu.opencart.testng.pages.admin.MainAdmPg;
import com.softserve.edu.opencart.testng.pages.user.MainPg;

/**
 * This class checks login (using buttons and Enter) and logout
 * process on Chrome.
 */
public class ChromeLoginLogoutAdminTest {

    public WebDriverManager webDriverManager;

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
        webDriverManager.setWebdriverChrome();
    }

    @BeforeMethod
    public void setMainPage() {
        new MainPg(webDriverManager).setMainPage();
    }

    @Test(dataProvider = "TypeOfEntrance")
    public void LoginChromeTest(String typeOfEntrance) {
        new MainPg(webDriverManager).loginIfOpened(typeOfEntrance);
        Assert.assertTrue(new MainAdmPg(webDriverManager).isOpened(),
                Messages.FAIL_LOGIN_ADMIN_CHROME_CLICK.getMessage());
        new MainAdmPg(webDriverManager).logout();
        Assert.assertTrue(new MainPg(webDriverManager).isOpened(),
                Messages.FAIL_LOGOUT_ADMIN_CHROME_CLICK.getMessage());
    }

    @AfterClass
    public void driverQuit() {
        webDriverManager.quitDriver();
    }

}