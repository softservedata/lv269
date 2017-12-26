package com.softserve.edu.opencart.tests.admin.products;

import com.softserve.edu.opencart.data.ErrorMessages;
import com.softserve.edu.opencart.data.filter.AdminProductFilterListsRepository;
import com.softserve.edu.opencart.data.filter.IAdminProductFilterLists;
import com.softserve.edu.opencart.data.pathnames.PathNamesRepository;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.ProductPageUtils;
import com.softserve.edu.opencart.pages.admin.ProductAdminPage;
import com.softserve.edu.opencart.tests.TestContextAttributes;
import com.softserve.edu.opencart.tests.TestRunnerPresent;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FilterTest extends TestRunnerPresent {

    @BeforeMethod
    public void setTestContextNull(ITestContext context) {
        context.setAttribute(TestContextAttributes.TOKEN.toString(), null);
        context.setAttribute(TestContextAttributes.PRODUCT_ADMIN_PAGE.toString(), null);
        context.setAttribute(TestContextAttributes.PATHNAMES.toString(), PathNamesRepository.get().filterPathnames()
                .clone());
    }

    @DataProvider(name = "FilterData")
    public Object[][] ValidData() {
        return new Object[][]{
                {AdminProductFilterListsRepository.get().filterOnlyExistedProductName()},
                {AdminProductFilterListsRepository.get().filterOnlyNoneExistedProductName()},
                {AdminProductFilterListsRepository.get().filterOnlyProductNameMultipleResult()},
                {AdminProductFilterListsRepository.get().filterOnlyExistedModel()},
                {AdminProductFilterListsRepository.get().filterOnlyNoneExistedModel()},
                {AdminProductFilterListsRepository.get().filterOnlyProductNameFromModelText()},
                {AdminProductFilterListsRepository.get().filterOnlyExistedPriceMultiResult()},
                {AdminProductFilterListsRepository.get().filterOnlyLetterQuantity()},
        };
    }

    @Test(dataProvider = "FilterData")
    public void filterProductAdminTest(ITestContext context,
                                     IAdminProductFilterLists adminProductLists) {
        logger.info(String.format("Filter ProductsAdminPage by template: '%s' / '%s' / '%s' / '%s' / '%s' / '%s' ",
                adminProductLists.getFilterTemplate().getName(), adminProductLists.getFilterTemplate().getModel(),
                adminProductLists.getFilterTemplate().getPrice(), adminProductLists.getFilterTemplate().getQuantity(),
                adminProductLists.getFilterTemplate().getStatusText(), adminProductLists.getFilterTemplate()
                        .getImageText()));
        reporter.info(String.format("Filter ProductsAdminPage by template: '%s' / '%s' / '%s' / '%s' / '%s' / '%s' ",
                adminProductLists.getFilterTemplate().getName(), adminProductLists.getFilterTemplate().getModel(),
                adminProductLists.getFilterTemplate().getPrice(), adminProductLists.getFilterTemplate().getQuantity(),
                adminProductLists.getFilterTemplate().getStatusText(), adminProductLists.getFilterTemplate()
                        .getImageText()));
        ProductAdminPage productAdminPage = Application.get().loginAdmin()
                .validEnterAdminProfile(context, UserRepository.get().admin())
                .openProductAdminPage(context)
                .filterProductTableByTemplate(adminProductLists)
                .initCurrentDisplayedProductList();
        context.setAttribute(TestContextAttributes.PRODUCT_ADMIN_PAGE.toString(), productAdminPage);
        boolean isListsEqual = new ProductPageUtils()
                .filterProductListAndCompare(adminProductLists, productAdminPage.getProductShortListAllPages());
        Assert.assertTrue(isListsEqual, ErrorMessages.WRONG_FILTER_LIST.toString());
    }

    @AfterMethod
    public void setDefaultOptionsAndLogout(ITestContext context) {
        if ((String) context.getAttribute(TestContextAttributes.TOKEN.toString()) != null) {
            Application.get().logoutAdmin(context);
        }
    }
}
