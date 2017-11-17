package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.constants.Credentials;
import com.softserve.edu.opencart.constants.URLs;
import com.softserve.edu.opencart.pages.PageNames;
import com.softserve.edu.opencart.pages.admin.DashboardAdmin;
import com.softserve.edu.opencart.pages.admin.LoginAdminPage;
import com.softserve.edu.opencart.pages.admin.ProductAdminPage;
import com.softserve.edu.opencart.tools.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PaginationTest {

    private WebDriverManager webDriverManager;
    private ProductAdminPage productAdminPage;


    @BeforeClass
    public void createDrivers() {
        webDriverManager = new WebDriverManager();
        webDriverManager.setWebdriverChrome();
        productAdminPage = webDriverManager.openLoginAdminPage()
                .validEnterAdminProfile(Credentials.ADMINISTRATOR_LOGIN.toString(),
                        Credentials.ADMINISTRATOR_PASSWORD.toString())
                .openSettingAdminPage()
                .openStoreSettingsPageByUrl(URLs.URL_SERVER.toString())
                .changeOptionByTabNameAndOptionName ("Option", "Default Items Per Page (Admin)", "20")
                .openProductAdminPage();
    }

    @Test
    public void openProductAdminPage() {
        Assert.assertEquals(productAdminPage.getCurrentPageNameText().toLowerCase(),
                PageNames.PRODUCTS_ADMIN.toString().toLowerCase());
    }

    @AfterClass
    public void quitWebDriver() {
        webDriverManager.quitDriver();
    }
}
