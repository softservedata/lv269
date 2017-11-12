package com.softserve.edu.opencart.tests.smoke;


import com.softserve.edu.opencart.constants.Credentials;
import com.softserve.edu.opencart.pages.admin.LoginAdminPage;
import com.softserve.edu.opencart.pages.admin.MainAdminPage;
import com.softserve.edu.opencart.pages.admin.WrongLoginAdminPage;
import com.softserve.edu.opencart.tools.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * This class checks login (using buttons and Enter) and logout
 * process on Chrome.
 */
public class ChromeLoginLogoutAdminTest {

    private WebDriverManager webDriverManager;
    private LoginAdminPage loginAdminPage;

    @DataProvider (name = "ValidData")
    public Object[][] ValidData() {
        return new Object[][]{
                {Credentials.ADMINISTRATOR_LOGIN.toString(), Credentials.ADMINISTRATOR_PASSWORD.toString()}};
    }
    @DataProvider (name = "InvalidData")
    public Object[][] InvalidData() {
        return new Object[][]{
                {"aaa", "aaa"}};
    }


    @BeforeClass
    public void createDrivers() {
        webDriverManager = new WebDriverManager();
        webDriverManager.setWebdriverChrome();
    }

    @BeforeMethod
    public void setMainPage() {
        webDriverManager.openAddress("http://server7.pp.ua/admin/");
        loginAdminPage = new LoginAdminPage(webDriverManager);
    }

    @Test(dataProvider = "ValidData")
    public void LoginValidTest(String login, String password) {
        MainAdminPage mainAdminPage = loginAdminPage.validEnterAdminProfile(login, password);
        Assert.assertEquals(mainAdminPage.getPathnamePageNameLast(), "Dashboard");
        loginAdminPage = mainAdminPage.logoutAdminPage();
        Assert.assertTrue(loginAdminPage.isLoginAdminPageOpened());
    }

    @Test(dataProvider = "InvalidData")
    public void LoginInvalidTest(String login, String password) {
        WrongLoginAdminPage wrongLoginAdminPage = loginAdminPage.invalidEnterAdminProfile(login, password);
        String actual = wrongLoginAdminPage.getWrongLoginMessageText();
        System.out.println(actual);
        String expected = "No match for Username and/or Password.";
        Assert.assertEquals(actual, expected);


    }

    @AfterClass
    public void driverQuit() {
        webDriverManager.quitDriver();
    }

}