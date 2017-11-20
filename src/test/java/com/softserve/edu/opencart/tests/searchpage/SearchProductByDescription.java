package com.softserve.edu.opencart.tests.searchpage;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.products.ISearchProduct;
import com.softserve.edu.opencart.data.products.SearchProductRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.FailureSearchPage;
import com.softserve.edu.opencart.pages.user.SuccessSearchPage;
import com.sun.net.httpserver.Authenticator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchProductByDescription {

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
                {SearchProductRepository.get().searchByDescription()}
        };
    }

    @DataProvider
    public Object[][] descriptionText() {

        return new Object[][]{
                {SearchProductRepository.get().searchByDescription()}
        };
    }

    @Test(dataProvider = "productData")
    public void checkSearchProductResult(ISearchProduct productDescription) {
         SuccessSearchPage searchPage = Application.get().loadHomePage()
                .goFailureSearch().findProductByDescription(productDescription.getProductDescription());
        List<String> actualProduct = searchPage.getProductComponentTexts();
        Assert.assertEquals(actualProduct, productDescription.getProducts(), searchPage.NO_MATCH);
    }

    @Test(dataProvider = "descriptionText")
    public void checkSearchProductResultNegative(ISearchProduct productToSearch){
        FailureSearchPage searchProduct = Application.get().loadHomePage()
                .goFailureSearch().findNoElements(productToSearch.getProductName());
        Assert.assertTrue(searchProduct.nothingFound(), searchProduct.UNEXPECTED_ELEMENTS_FOUND);
    }
}