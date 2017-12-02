package com.softserve.edu.opencart.tests.admin.products;

import com.softserve.edu.opencart.data.ErrorMessages;
import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.pagination.IPagination;
import com.softserve.edu.opencart.data.pagination.PaginationRepository;
import com.softserve.edu.opencart.data.pathnames.IPathnames;
import com.softserve.edu.opencart.data.pathnames.PathNamesRepository;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.admin.ProductAdminPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class PaginationTest {

    public void browserOpen() {
//        Application.get(ApplicationSourceRepository.get().firefoxVisibleServer7());
        Application.get(ApplicationSourceRepository.get().chromePresentServer7());
    }

    @DataProvider(name = "PaginationItemsPerPage")
    public Object[][] ValidData() {
        return new Object[][]{
                {PathNamesRepository.get().paginationPathnames(), PaginationRepository.get().itemsPerPageOne()},
                {PathNamesRepository.get().paginationPathnames(), PaginationRepository.get().itemsPerPageHalfItemsPlusOne()},
                {PathNamesRepository.get().paginationPathnames(), PaginationRepository.get().itemsPerPageItemsPerPage()},
                {PathNamesRepository.get().paginationPathnames(), PaginationRepository.get().itemsPerPageMoreThanItemsPerPage()}
        };
    }

    @Test(dataProvider = "PaginationItemsPerPage")
    public void paginationPageNumbersTest(IPathnames paginationPathnames,
                                          IPagination paginationData) {
        ProductAdminPage productAdminPage = Application.get().loginAdmin()
                .validEnterAdminProfile(UserRepository.get().admin())
                .openSettingAdminPage(paginationPathnames)
                .openStoreSettingsPageByUrl(paginationPathnames)
                .changeOptionsSet(paginationPathnames, paginationData.getOptionsReplaceValues())
                .openProductAdminPage(paginationPathnames)
                .initLastProductAdminPageNumberAllPages();
        int actualPagesPaginationQuantity = productAdminPage.getPagesPaginationQuantity();
        Integer actualItemsOnAllPagesExceptLast = productAdminPage.getItemsOnAllPagesExceptLast();
        productAdminPage.openSettingAdminPage(paginationPathnames)
                .openStoreSettingsPageByUrl(paginationPathnames)
                .changeOptionsSet(paginationPathnames, paginationData.getOptionsReplaceValues());
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
