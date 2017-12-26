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
import com.softserve.edu.opencart.tests.TestContextAttributes;
import com.softserve.edu.opencart.tests.TestRunnerPresent;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;


/**
 * This class checks login (using buttons and Enter) and logoutAdmin
 * process on Chrome.
 */
public class ChromeLoginLogoutAdminTest extends TestRunnerPresent {

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
    public void LoginValidTest(ITestContext context, IUser validUser, IExpectedStrings dashBoardPageName) {
		        logger.info("Login to the AdminPRofile with valid Data");
        reporter.info("Login to the AdminPRofile with valid Data");
        DashboardAdmin dashboardAdmin = Application.get().loginAdmin()
                .validEnterAdminProfile(context, validUser);
        Assert.assertEquals(dashboardAdmin.getCurrentPageNameText().toLowerCase(),
                dashBoardPageName.getExpectedString().toLowerCase(),
                ErrorMessages.WRONG_LOGIN_ADMIN_VALID.toString());
    }

    @Test(dataProvider = "InvalidAdminData")
    public void LoginInvalidTest(IUser invalidUser, IExpectedStrings wrongLoginAdminMessage) {
		logger.info("Smoke test: Login to the AdminProfile with invalid Data");
        reporter.display("Smoke test: Login to the AdminProfile with invalid Data");
        WrongLoginAdminPage wrongLoginAdminPage = Application.get().loginAdmin()
                .invalidEnterAdminProfile(invalidUser);
        Assert.assertEquals(wrongLoginAdminPage.getWrongLoginMessageText().toLowerCase(),
                wrongLoginAdminMessage.getExpectedString().toLowerCase(),
                ErrorMessages.WRONG_LOGIN_ADMIN_INVALID.toString());
		logger.info("Smoke test: Login to the AdminProfile done");
        reporter.display("Smoke test: Login to the AdminProfile done");
    }

    @AfterMethod
    public void logoutAdminPage (ITestContext context) {
        if ((String)context.getAttribute(TestContextAttributes.TOKEN.toString())!=null) {
            Application.get().logoutAdmin(context);
        }
    }
}