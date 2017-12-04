package com.softserve.edu.opencart.tests.admin.products;

import com.softserve.edu.opencart.data.ErrorMessages;
import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.pagination.IPagination;
import com.softserve.edu.opencart.data.pagination.PaginationRepository;
import com.softserve.edu.opencart.data.pathnames.PathNamesRepository;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.admin.ProductAdminPage;
import com.softserve.edu.opencart.tests.TestContextAttributes;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class PaginationTest {

    @BeforeClass
    public void browserOpen(ITestContext context) {
//        Application.get(ApplicationSourceRepository.get().firefoxPresentServer7());
//        Application.get(ApplicationSourceRepository.get().firefoxImplicitServer7());
        Application.get(ApplicationSourceRepository.get().chromePresentServer7());
        Application.get(ApplicationSourceRepository.get().chromePresentServer7());
        context.setAttribute(TestContextAttributes.PATHNAMES.toString(), PathNamesRepository.get().paginationPathnames());
    }

    @DataProvider(name = "PaginationItemsPerPage")
    public Object[][] ValidData() {
        return new Object[][]{
                {PaginationRepository.get().itemsPerPageOne()},
                {PaginationRepository.get().itemsPerPageHalfItemsPlusOne()},
                {PaginationRepository.get().itemsPerPageItemsPerPage()},
                {PaginationRepository.get().itemsPerPageMoreThanItemsPerPage()}
        };
    }

    @Test(dataProvider = "PaginationItemsPerPage")
    public void paginationPageNumbersTest(ITestContext context,
                                          IPagination paginationData) {
        ProductAdminPage productAdminPage = Application.get().loginAdmin()
                .validEnterAdminProfile(UserRepository.get().admin())
                .openSettingAdminPage(context)
                .openStoreSettingsPageByStoreUrl(context)
                .changeOptionsSet(context, paginationData.getOptionsReplaceValues())
                .openProductAdminPage(context)
                .initLastProductAdminPageNumberAllPages();
        int actualPagesPaginationQuantity = productAdminPage.getPagesPaginationQuantity();
        Integer actualItemsOnAllPagesExceptLast = productAdminPage.getItemsOnAllPagesExceptLast();
        productAdminPage.openSettingAdminPage(context)
                .openStoreSettingsPageByStoreUrl(context)
                .changeOptionsSet(context, paginationData.getOptionsReplaceValues());
        Assert.assertEquals(actualPagesPaginationQuantity,
                (paginationData.getItemsNumber() + paginationData.getItemsPerPageNumber() - 1) / paginationData
                        .getItemsPerPageNumber(),
                String.format(ErrorMessages.WRONG_NUMBER_PAGES_PAGINATION.toString(), paginationData.getItemsNumber(),
                        paginationData.getItemsPerPageNumber()));
        Assert.assertTrue((actualItemsOnAllPagesExceptLast != null) && (actualItemsOnAllPagesExceptLast
                        == Integer.min(paginationData.getItemsNumber(), paginationData.getItemsPerPageNumber())),
                ErrorMessages.WRONG_NUMBER_ITEMS_PER_PAGES.toString());
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
