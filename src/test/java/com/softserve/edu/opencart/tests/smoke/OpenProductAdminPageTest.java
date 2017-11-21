package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.pathnames.IPathnames;
import com.softserve.edu.opencart.data.pathnames.PathNamesRepository;
import com.softserve.edu.opencart.data.texts.ExpectedStringsRepository;
import com.softserve.edu.opencart.data.texts.IExpectedStrings;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.admin.ProductAdminPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class OpenProductAdminPageTest {

    @BeforeClass
    public void fileWriter() {
        Application.get(ApplicationSourceRepository.get().chromeServer7());
    }

    @DataProvider(name = "OpenProductPageData")
    public Object[][] ValidData() {
        return new Object[][]{
                {PathNamesRepository.get().openProductAdminPage(),
                        ExpectedStringsRepository.get().productsPageName()}
        };
    }

    @Test (dataProvider = "OpenProductPageData" )
    public void openProductAdminPageTest(IPathnames openProductPathnames,
                                     IExpectedStrings adminProductPageName) {
        ProductAdminPage productAdminPage = Application.get()
                .loginAdmin()
                .validEnterAdminProfile(UserRepository.get().admin())
                .openProductAdminPage(openProductPathnames);
        Assert.assertEquals(productAdminPage.getCurrentPageNameText().toLowerCase(),
                adminProductPageName.getExpectedString().toLowerCase());
    }

    @AfterMethod
    public void logoutAdminPage() {
        Application.get().logoutAdmin();
    }

    @AfterClass
    public void quitWebdriver() {
        Application.get().remove();
    }
}

