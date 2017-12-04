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
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class OpenProductAdminPageTest {

    @BeforeClass
    public void preparations(ITestContext context) {
        Application.get(ApplicationSourceRepository.get().chromePresentServer7());
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

    @AfterClass
    public void quitWebdriver() {
        Application.get().remove();
    }
}

