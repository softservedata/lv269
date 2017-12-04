package com.softserve.edu.opencart.tests.admin.products;

import com.softserve.edu.opencart.data.ErrorMessages;
import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.pathnames.IPathnames;
import com.softserve.edu.opencart.data.pathnames.PathNamesRepository;
import com.softserve.edu.opencart.data.sort.AdminProductSortRepository;
import com.softserve.edu.opencart.data.sort.IAdminProductSort;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.ProductPageUtils;
import com.softserve.edu.opencart.pages.admin.ProductAdminPage;
import com.softserve.edu.opencart.tests.TestContextAttributes;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class SortTest {

    @BeforeClass
    public void browserOpen(ITestContext context) {
//        Application.get(ApplicationSourceRepository.get().firefoxVisibleServer7());
        Application.get(ApplicationSourceRepository.get().chromePresentServer7());
        context.setAttribute(TestContextAttributes.PATHNAMES.toString(), PathNamesRepository.get().paginationPathnames());
    }

    @DataProvider(name = "SortData")
    public Object[][] ValidData() {
        return new Object[][]{
                {AdminProductSortRepository.get().sortProductNameAsc()},
                {AdminProductSortRepository.get().sortProductNameDesc()},
                {AdminProductSortRepository.get().sortModelAsc()},
                {AdminProductSortRepository.get().sortModelDesc()},
                {AdminProductSortRepository.get().sortPriceAsc()},
                {AdminProductSortRepository.get().sortPriceDesc()},
                {AdminProductSortRepository.get().sortQuantityAsc()},
                {AdminProductSortRepository.get().sortQuantityDesc()},
                {AdminProductSortRepository.get().sortStatusAsc()},
                {AdminProductSortRepository.get().sortStatusDesc()}
        };
    }

    @Test(dataProvider = "SortData")
    public void sortProductAdminTest(ITestContext context,
                                     IAdminProductSort adminProductSort) {
        ProductAdminPage productAdminPage = Application.get().loginAdmin()
                .validEnterAdminProfile(UserRepository.get().admin())
                .openSettingAdminPage(context)
                .openStoreSettingsPageByStoreUrl(context)
                .changeOptionsSet(context, adminProductSort.getOptionsReplaceValues())
                .openProductAdminPage(context)
                .sortByColumnName(adminProductSort)
                .initCurrentDisplayedProductList();
        boolean isListsEqual = new ProductPageUtils()
                .sortByColumnNameAndCompare(adminProductSort, productAdminPage.getProductShortListAllPages());
        productAdminPage.openSettingAdminPage(context)
                .openStoreSettingsPageByStoreUrl(context)
                .changeOptionsSet(context, adminProductSort.getOptionsReplaceValues());
        Assert.assertTrue(isListsEqual, ErrorMessages.WRONG_SORTED_LIST.toString());
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
