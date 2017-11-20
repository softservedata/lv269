//package com.softserve.edu.opencart.tests.smoke;
//
//import com.softserve.edu.opencart.constants.Credentials;
//import com.softserve.edu.opencart.pages.PageNames;
//import com.softserve.edu.opencart.pages.admin.DashboardAdmin;
//import com.softserve.edu.opencart.pages.admin.LoginAdminPage;
//import com.softserve.edu.opencart.pages.admin.ProductAdminPage;
//import com.softserve.edu.opencart.tools.SearchManager;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class OpenProductAdminPageTest {
//
//    private SearchManager searchManager;
//    private DashboardAdmin dashboardAdmin;
//
//
//    @BeforeClass
//    public void createDrivers() {
//        searchManager = new SearchManager();
//        searchManager.setWebdriverChrome();
//        LoginAdminPage loginAdminPage = searchManager.openLoginAdminPage();
//        dashboardAdmin = loginAdminPage.validEnterAdminProfile(
//                Credentials.ADMINISTRATOR_LOGIN.toString(), Credentials.ADMINISTRATOR_PASSWORD.toString());
//    }
//
//    @Test
//    public void openProductAdminPage () {
//        ProductAdminPage productAdminPage = dashboardAdmin.openProductAdminPage();
//        Assert.assertEquals(productAdminPage.getCurrentPageNameText().toLowerCase(),
//                PageNames.PRODUCTS_ADMIN.toString().toLowerCase ());
//    }
//
//    @AfterClass
//    public void quitWebDriver () {
//        searchManager.quitDriver();
//    }
//}
