package com.softserve.edu.opencart.tests.searchpage;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.products.SearchProductRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.FailureSearchPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchProductByDescription {
    public final String NO_MATCH = "List of products not matches expected list.";
    public final String UNEXPECTED_ELEMENTS_FOUND = "Elements are not expected to be found.";

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
                {SearchProductRepository.get().searchByDescription().getProductName(),
                        SearchProductRepository.get().searchByDescription().getProducts()}
        };
    }

    @DataProvider
    public Object[][] descriptionText() {

        return new Object[][]{
                {SearchProductRepository.get().searchByDescription().getProductName()}
        };
    }

    @Test(dataProvider = "productData")
    public void checkSearchProductResult(String descriptionText, List<String> foundProducts) {
        List<String> actualProduct = Application.get().loadHomePage()
                .goFailureSearch().findProductByDescription(descriptionText)
                .getProductComponentTexts();
        Assert.assertEquals(actualProduct, foundProducts, NO_MATCH);
    }

    @Test(dataProvider = "descriptionText")
    public void checkSearchProductResultNegative(String descriptionText){
        FailureSearchPage searchProduct = Application.get().loadHomePage()
                .goFailureSearch().findNoElements(descriptionText);
        Assert.assertTrue(searchProduct.nothingFound(), UNEXPECTED_ELEMENTS_FOUND);
    }
}