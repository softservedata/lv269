package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.pathnames.IPathnames;
import com.softserve.edu.opencart.data.pathnames.PathNamesRepository;
import com.softserve.edu.opencart.data.texts.ExpectedStringsRepository;
import com.softserve.edu.opencart.data.texts.IExpectedStrings;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.admin.ProductAdminPage;
import com.softserve.edu.opencart.tests.TestContextAttributes;
import com.softserve.edu.opencart.tests.TestRunnerPresent;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class OpenProductAdminPageTest extends TestRunnerPresent {

    @BeforeClass
    public void preparations(ITestContext context) {
        context.setAttribute(TestContextAttributes.PATHNAMES.toString(), PathNamesRepository.get()
                .openProductAdminPagePathnames());
    }

    @BeforeMethod
    public void setTokenEmpty (ITestContext context) {
        context.setAttribute(TestContextAttributes.TOKEN.toString(), null);
    }

    @DataProvider(name = "OpenProductPageData")
    public Object[][] ValidData() {
        return new Object[][]{
                {ExpectedStringsRepository.get().productsPageName()}
        };
    }

    @Test(dataProvider = "OpenProductPageData")
    public void openProductAdminPageTest(ITestContext context,
                                         IExpectedStrings adminProductPageName) {
        logger.info("Smoke test: open ProductAdminPage");
        reporter.info("Smoke test: open ProductAdminPage");
        ProductAdminPage productAdminPage = Application.get()
                .loginAdmin()
                .validEnterAdminProfile(context, UserRepository.get().admin())
                .openProductAdminPage(context);
        Assert.assertEquals(productAdminPage.getCurrentPageNameText().toLowerCase(),
                adminProductPageName.getExpectedString().toLowerCase());
    }

    @AfterMethod
    public void logoutAdminPage(ITestContext context) {
        if ((String) context.getAttribute(TestContextAttributes.TOKEN.toString()) != null) {
            Application.get().logoutAdmin(context);
        }
    }
}

