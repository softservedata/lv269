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

public class SpecialSymbols {

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
                {"'"}, {"["}, {"!"}, {"$"}, {"%"}, {"^"}, {"&"}, {"+"},
                {"|"}, {"~"}, {"="}, {"`"}, {"/"}, {":"}, {";"},{"?"},
                {"SELECT * FROM PRODUCTS"}
        };
    }

    @Test(dataProvider = "productData")
    public void checkSearchProductResult(String specialSymbol){
        FailureSearchPage searchPage = Application.get().loadHomePage()
                .failureProductSearch(specialSymbol);
        Assert.assertTrue(searchPage.nothingFound(), searchPage.UNEXPECTED_ELEMENTS_FOUND);
    }

}
