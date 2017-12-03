package com.softserve.edu.opencart.tests.smoke;


import com.softserve.edu.opencart.data.ErrorMessages;
import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.texts.ExpectedStringsRepository;
import com.softserve.edu.opencart.data.texts.IExpectedStrings;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.admin.DashboardAdmin;
import com.softserve.edu.opencart.pages.admin.WrongLoginAdminPage;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * This class checks login (using buttons and Enter) and logoutAdmin
 * process on Chrome.
 */
public class ChromeLoginLogoutAdminTest {

    @BeforeClass
    public void fileWriter() {
        Application.get(ApplicationSourceRepository.get().chromePresentServer7());
    }

    @DataProvider(name = "ValidAdminData")
    public Object[][] ValidData() {
        return new Object[][]{
                {UserRepository.get().admin(), ExpectedStringsRepository.get().dashboardAdminPageName()}};
    }

    @DataProvider(name = "InvalidAdminData")
    public Object[][] InvalidData() {
        return new Object[][]{
                {UserRepository.get().validUser(), ExpectedStringsRepository.get().wrongLoginMessage()}};
    }


    @Test(dataProvider = "ValidAdminData")
    public void LoginValidTest(IUser validUser, IExpectedStrings dashBoardPageName) {
        DashboardAdmin dashboardAdmin = Application.get().loginAdmin()
                .validEnterAdminProfile(validUser);
        Assert.assertEquals(dashboardAdmin.getCurrentPageNameText().toLowerCase(),
                dashBoardPageName.getExpectedString().toLowerCase(),
                ErrorMessages.WRONG_LOGIN_ADMIN_VALID.toString());
    }

    @Test(dataProvider = "InvalidAdminData")
    public void LoginInvalidTest(IUser invalidUser, IExpectedStrings wrongLoginAdminMessage) {
        WrongLoginAdminPage wrongLoginAdminPage = Application.get().loginAdmin()
                .invalidEnterAdminProfile(invalidUser);
        Assert.assertEquals(wrongLoginAdminPage.getWrongLoginMessageText().toLowerCase(),
                wrongLoginAdminMessage.getExpectedString().toLowerCase(),
                ErrorMessages.WRONG_LOGIN_ADMIN_INVALID.toString());
    }

    @AfterMethod
    public void logoutAdminPage () {
        Application.get().logoutAdmin();
    }

    @AfterClass
    public void quitWebdriver() {
        Application.get().remove();
    }

}