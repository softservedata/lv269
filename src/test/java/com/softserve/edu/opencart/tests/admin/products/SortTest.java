package com.softserve.edu.opencart.tests.admin.products;

import com.softserve.edu.opencart.data.ErrorMessages;
import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.pathnames.PathNamesRepository;
import com.softserve.edu.opencart.data.pathnames.StoreSettingOptionSet;
import com.softserve.edu.opencart.data.sort.AdminProductSortRepository;
import com.softserve.edu.opencart.data.sort.IAdminProductSort;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.ProductPageUtils;
import com.softserve.edu.opencart.pages.admin.ProductAdminPage;
import com.softserve.edu.opencart.tests.TestContextAttributes;
import com.softserve.edu.opencart.tests.TestRunnerPresent;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class SortTest extends TestRunnerPresent {

    @BeforeMethod
    public void setTestContextNull(ITestContext context) {
        context.setAttribute(TestContextAttributes.TOKEN.toString(), null);
        context.setAttribute(TestContextAttributes.DEFAULT_SETTING_OPTIONS_LIST.toString(), null);
        context.setAttribute(TestContextAttributes.PRODUCT_ADMIN_PAGE.toString(), null);
        context.setAttribute(TestContextAttributes.PATHNAMES.toString(), PathNamesRepository.get().sortPathnames()
                .clone());
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
        logger.info(String.format("Sort ProductsAdminPage by %s in %s order", adminProductSort.getColumnName(),
                adminProductSort.getSortOrder()));
        reporter.info(String.format("Sort ProductsAdminPage by %s in %s order", adminProductSort.getColumnName(),
                adminProductSort.getSortOrder()));
        ProductAdminPage productAdminPage = Application.get().loginAdmin()
                .validEnterAdminProfile(context, UserRepository.get().admin())
                .openSettingAdminPage(context)
                .openStoreSettingsPageByStoreUrl(context)
                .changeOptionsSet(context, adminProductSort.getOptionsReplaceValues())
                .openProductAdminPage(context)
                .sortByColumnName(adminProductSort)
                .initCurrentDisplayedProductList();
        context.setAttribute(TestContextAttributes.PRODUCT_ADMIN_PAGE.toString(), productAdminPage);
        boolean isListsEqual = new ProductPageUtils()
                .sortByColumnNameAndCompare(adminProductSort, productAdminPage.getProductShortListAllPages());
        Assert.assertTrue(isListsEqual, ErrorMessages.WRONG_SORTED_LIST.toString());
    }

    @AfterMethod
    public void setDefaultOptionsAndLogout(ITestContext context) {
        if ((String) context.getAttribute(TestContextAttributes.TOKEN.toString()) != null) {
            if ((StoreSettingOptionSet) context.getAttribute(TestContextAttributes.DEFAULT_SETTING_OPTIONS_LIST
                    .toString()) != null) {
                ((ProductAdminPage) context.getAttribute(TestContextAttributes.PRODUCT_ADMIN_PAGE.toString()))
                        .openSettingAdminPage(context)
                        .openStoreSettingsPageByStoreUrl(context)
                        .changeOptionsSet(context);
            }
            Application.get().logoutAdmin(context);
        }
    }
}
