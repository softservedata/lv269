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

    @BeforeClass
    public void fileWriter() {
        Application.get(ApplicationSourceRepository.get().chromeServer7());
    }

    @DataProvider(name = "PaginationItemsPerPage")
    public Object[][] ValidData() {
        return new Object[][]{
                {PathNamesRepository.get().pagination(), PaginationRepository.get().itemsPerPageOne()},
                {PathNamesRepository.get().pagination(), PaginationRepository.get().itemsPerPageHalfItemsPlusOne()},
                {PathNamesRepository.get().pagination(), PaginationRepository.get().itemsPerPageItemsPerPage()},
                {PathNamesRepository.get().pagination(), PaginationRepository.get().itemsPerPageMoreThanItemsPerPage()}
        };
    }

    @Test(dataProvider = "PaginationItemsPerPage")
    public void paginationPageNumbersTest(IPathnames paginationPathnames,
                                          IPagination paginationData) {
        ProductAdminPage productAdminPage = Application.get().loginAdmin()
                .validEnterAdminProfile(UserRepository.get().admin())
                .openSettingAdminPage(paginationPathnames)
                .openStoreSettingsPageByUrl(paginationPathnames)
                .changeOptionsSet(paginationPathnames, paginationData)
                .openProductAdminPage(paginationPathnames)
                .initLastProductAdminPageNumberAllPages();
        int actual = productAdminPage.getLastProductAdminPageAllPagesNumber();
        productAdminPage.openSettingAdminPage(paginationPathnames)
                .openStoreSettingsPageByUrl(paginationPathnames)
                .changeOptionsSet(paginationPathnames, paginationData);
        Assert.assertEquals(actual, (paginationData.getItemsNumber() + paginationData.getItemsNumber() - 1)
                        / paginationData.getItemsNumber(),
                String.format(ErrorMessages.WRONG_NUMBER_PAGES_PAGINATION.toString(), paginationData.getItemsNumber(),
                       paginationData.getItemsPerPageNumber()));
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
