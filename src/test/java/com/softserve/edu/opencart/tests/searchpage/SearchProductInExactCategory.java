package com.softserve.edu.opencart.tests.searchpage;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
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

    private final String NO_MATCH = "List of products not matches expected list.";

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
                {SearchProductRepository.get().searchMacBookAirInCategory().getProductName(),
                        SearchProductRepository.get().searchMacBookAirInCategory().getProductCategory()},
                {SearchProductRepository.get().searchNikonInCategory().getProductName(),
                        SearchProductRepository.get().searchNikonInCategory().getProductCategory()},
                {SearchProductRepository.get().searchIMacInCategory().getProductName(),
                        SearchProductRepository.get().searchIMacInCategory().getProductCategory()}
        };
    }

    @Test(dataProvider = "productData")
    public void checkSearchProductResult(String productName, String productCategory){
         SuccessSearchPage searchProduct = Application.get().loadHomePage()
                .goFailureSearch().findProductInRightCategory(productName, productCategory);
        List<String> actualProduct = searchProduct.getProductComponentTexts();
        Assert.assertTrue(searchProduct.isFound(actualProduct, productName), NO_MATCH);
    }
}