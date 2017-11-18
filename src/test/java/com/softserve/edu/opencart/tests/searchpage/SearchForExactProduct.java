package com.softserve.edu.opencart.tests.searchpage;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.products.SearchProductRepository;
import com.softserve.edu.opencart.pages.Application;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchForExactProduct {

    public final String NO_MATCH = "List of products not matches expected list.";
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
                {SearchProductRepository.get().mac().getProductName(),
                        SearchProductRepository.get().mac().getProducts()},
                {SearchProductRepository.get().macBook().getProductName(),
                        SearchProductRepository.get().macBook().getProducts()},
                {SearchProductRepository.get().iPod().getProductName(),
                        SearchProductRepository.get().iPod().getProducts()},
                {SearchProductRepository.get().palm().getProductName(),
                        SearchProductRepository.get().palm().getProducts()}
        };
    }

    @Test (dataProvider = "productData")
    public void checkSearchProductResult(String productName, List<String> foundProducts){
        List<String> actualProduct = Application.get().loadHomePage()
                .successProductSearch(productName).getProductComponentTexts();
        Assert.assertEquals(actualProduct, foundProducts, NO_MATCH);
    }

}
