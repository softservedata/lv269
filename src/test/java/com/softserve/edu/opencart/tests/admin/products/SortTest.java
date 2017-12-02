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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortTest {

    public void browserOpen() {
//        Application.get(ApplicationSourceRepository.get().firefoxVisibleServer7());
        Application.get(ApplicationSourceRepository.get().chromePresentServer7());
    }

    @DataProvider(name = "SortData")
    public Object[][] ValidData() {
        return new Object[][]{
                {PathNamesRepository.get().sortPathnames(), AdminProductSortRepository.get().sortProductNameAsc()},
                {PathNamesRepository.get().sortPathnames(), AdminProductSortRepository.get().sortProductNameDesc()},
                {PathNamesRepository.get().sortPathnames(), AdminProductSortRepository.get().sortModelAsc()},
                {PathNamesRepository.get().sortPathnames(), AdminProductSortRepository.get().sortModelDesc()},
                {PathNamesRepository.get().sortPathnames(), AdminProductSortRepository.get().sortPriceAsc()},
                {PathNamesRepository.get() .sortPathnames(), AdminProductSortRepository.get().sortPriceDesc()},
                {PathNamesRepository.get().sortPathnames(), AdminProductSortRepository.get().sortQuantityAsc()},
                {PathNamesRepository.get().sortPathnames(), AdminProductSortRepository.get().sortQuantityDesc()},
                {PathNamesRepository.get().sortPathnames(), AdminProductSortRepository.get().sortStatusAsc()},
                {PathNamesRepository.get().sortPathnames(), AdminProductSortRepository.get().sortStatusDesc()}
        };
    }

    @Test(dataProvider = "SortData")
    public void sortProductAdminTest(IPathnames sortPathnames,
                                          IAdminProductSort adminProductSort) {
        ProductAdminPage productAdminPage = Application.get().loginAdmin()
                .validEnterAdminProfile(UserRepository.get().admin())
                .openSettingAdminPage(sortPathnames)
                .openStoreSettingsPageByUrl(sortPathnames)
                .changeOptionsSet(sortPathnames, adminProductSort.getOptionsReplaceValues())
                .openProductAdminPage(sortPathnames)
                .sortByColumnName(adminProductSort)
                .initCurrentDisplayedProductList();
        boolean isListsEqual = new ProductPageUtils()
                .sortByColumnNameAndCompare(adminProductSort, productAdminPage.getProductShortListAllPages());
        productAdminPage.openSettingAdminPage(sortPathnames)
                .openStoreSettingsPageByUrl(sortPathnames)
                .changeOptionsSet(sortPathnames, adminProductSort.getOptionsReplaceValues());
        Assert.assertTrue (isListsEqual, ErrorMessages.WRONG_SORTED_LIST.toString());
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
