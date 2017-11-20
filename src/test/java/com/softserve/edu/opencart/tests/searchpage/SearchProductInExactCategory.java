package com.softserve.edu.opencart.tests.searchpage;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.products.ISearchProduct;
import com.softserve.edu.opencart.data.products.SearchProductRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.SuccessSearchPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchProductInExactCategory {

    @BeforeClass
    public void beforeClass() {
        Application.get(ApplicationSourceRepository.get().chromeServer7());
    }

    @AfterClass
    public void afterClass() {
        Application.remove();
    }

    @DataProvider
    public Object[][] productData() {

        return new Object[][]{
                {SearchProductRepository.get().searchMacBookAirInCategory()},
                {SearchProductRepository.get().searchNikonInCategory()},
                {SearchProductRepository.get().searchIMacInCategory()}
        };
    }

    @Test(dataProvider = "productData")
    public void checkSearchProductResult(ISearchProduct productToSearch){
         SuccessSearchPage searchProduct = Application.get().loadHomePage()
                .goFailureSearch().findProductInRightCategory(
                        productToSearch.getProductName(), productToSearch.getProductCategory());
        List<String> actualProduct = searchProduct.getProductComponentTexts();
        Assert.assertTrue(searchProduct.isFound(actualProduct, productToSearch.getProductName()), searchProduct.NO_MATCH);
    }
}