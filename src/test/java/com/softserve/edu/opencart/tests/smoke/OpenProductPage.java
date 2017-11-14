package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.constants.Credentials;
import com.softserve.edu.opencart.pages.MessagesOnPages;
import com.softserve.edu.opencart.pages.PageNames;
import com.softserve.edu.opencart.pages.admin.LoginAdminPage;
import com.softserve.edu.opencart.tools.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class OpenProductPage {

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
}
