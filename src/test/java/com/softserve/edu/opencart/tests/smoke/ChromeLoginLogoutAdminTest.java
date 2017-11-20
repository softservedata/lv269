//package com.softserve.edu.opencart.tests.smoke;
//
//
//import com.softserve.edu.opencart.data.users.IUser;
//import com.softserve.edu.opencart.data.users.UserRepository;
//import com.softserve.edu.opencart.pages.admin.LoginAdminPage;
//import com.softserve.edu.opencart.pages.admin.DashboardAdmin;
//import com.softserve.edu.opencart.pages.admin.WrongLoginAdminPage;
//import com.softserve.edu.opencart.tools.SearchManager;
//import org.testng.Assert;
//import org.testng.annotations.*;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//
//
///**
// * This class checks login (using buttons and Enter) and logout
// * process on Chrome.
// */
//public class ChromeLoginLogoutAdminTest {
//
//    private SearchManager searchManager;
//    private LoginAdminPage loginAdminPage;
//
//    @DataProvider(name = "ValidData")
//    public Object[][] ValidData() {
//        return new Object[][]{
//                {UserRepository.get().admin()}};
//    }
//
//    @DataProvider(name = "InvalidData")
//    public Object[][] InvalidData() {
//        return new Object[][]{
//                {UserRepository.get().admin()}};
//    }
//
//
//    @BeforeClass
//    public void createDrivers() {
////        searchManager = new SearchManager();
////        searchManager.setWebdriverChrome();
//    }
//
//    @BeforeMethod
//    public void setMainPage() {
//        searchManager.openLoginAdminPage();
//        loginAdminPage = new LoginAdminPage(searchManager);
//    }
//
//    @Test(dataProvider = "ValidData")
//    public void LoginValidTest(IUser validUser) {
//        DashboardAdmin dashboardAdmin = loginAdminPage.validEnterAdminProfile(validUser);
////        Assert.assertEquals(dashboardAdmin.getCurrentPageNameText().toLowerCase(), expected.toLowerCase());
//        loginAdminPage = dashboardAdmin.logoutAdminPage();
//        Assert.assertTrue(loginAdminPage.isLoginAdminPageOpened());
//    }
//
//    @Test(dataProvider = "InvalidData")
//    public void LoginInvalidTest(String login, String password, String expected) {
//        WrongLoginAdminPage wrongLoginAdminPage = loginAdminPage.invalidEnterAdminProfile(login, password);
//        String actual = wrongLoginAdminPage.getWrongLoginMessageText();
//        System.out.println(actual);
//        Assert.assertEquals(actual, expected);
//
//
//    }
//
//    @AfterClass
//    public void driverQuit() {
//        searchManager.quitDriver();
//    }
//
//}