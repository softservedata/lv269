package com.softserve.edu.opencart.tests.smoke;


import com.softserve.edu.opencart.constants.Credentials;
import com.softserve.edu.opencart.pages.MessagesOnPages;
import com.softserve.edu.opencart.pages.PageNames;
import com.softserve.edu.opencart.pages.admin.LoginAdminPage;
import com.softserve.edu.opencart.pages.admin.DashboardAdmin;
import com.softserve.edu.opencart.pages.admin.WrongLoginAdminPage;
import com.softserve.edu.opencart.tools.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



/**
 * This class checks login (using buttons and Enter) and logout
 * process on Chrome.
 */
public class ChromeLoginLogoutAdminTest {

    private WebDriverManager webDriverManager;
    private LoginAdminPage loginAdminPage;

    @DataProvider(name = "ValidData")
    public Object[][] ValidData() {
        return new Object[][]{
                {Credentials.ADMINISTRATOR_LOGIN.toString(), Credentials.ADMINISTRATOR_PASSWORD.toString(),
                        PageNames.DASHBOARD.toString()}};
    }

    @DataProvider(name = "InvalidData")
    public Object[][] InvalidData() {
        return new Object[][]{
                {"aaa", "aaa", MessagesOnPages.ADMIN_LOGIN_ERROR.toString()}};
    }


    @BeforeClass
    public void createDrivers() {
        webDriverManager = new WebDriverManager();
        webDriverManager.setWebdriverChrome();
    }

    @BeforeMethod
    public void setMainPage() {
        webDriverManager.openLoginAdminPage();
        loginAdminPage = new LoginAdminPage(webDriverManager);
    }

    @Test(dataProvider = "ValidData")
    public void LoginValidTest(String login, String password, String expected) {
        DashboardAdmin dashboardAdmin = loginAdminPage.validEnterAdminProfile(login, password);
        Assert.assertEquals(dashboardAdmin.getCurrentPageNameText().toLowerCase(), expected.toLowerCase());
        loginAdminPage = dashboardAdmin.logoutAdminPage();
        Assert.assertTrue(loginAdminPage.isLoginAdminPageOpened());
    }

    @Test(dataProvider = "InvalidData")
    public void LoginInvalidTest(String login, String password, String expected) {
        WrongLoginAdminPage wrongLoginAdminPage = loginAdminPage.invalidEnterAdminProfile(login, password);
        String actual = wrongLoginAdminPage.getWrongLoginMessageText();
        System.out.println(actual);
        Assert.assertEquals(actual, expected);


    }

    @AfterClass
    public void driverQuit() {
        webDriverManager.quitDriver();
    }

}