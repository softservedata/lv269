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

public class SearchForExactProduct {

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
                {SearchProductRepository.get().mac()},
                {SearchProductRepository.get().macBook()},
                {SearchProductRepository.get().iPod()},
                {SearchProductRepository.get().palm()}
        };
    }

    @Test (dataProvider = "productData")
    public void checkSearchProductResult(ISearchProduct productToSearch) {
        SuccessSearchPage searchPage = Application.get().loadHomePage()
                .successProductSearch(productToSearch.getProductName());
        List<String> actualProduct = searchPage.getProductComponentTexts();
        Assert.assertEquals(actualProduct, productToSearch.getProducts(), searchPage.NO_MATCH);
    }

}
