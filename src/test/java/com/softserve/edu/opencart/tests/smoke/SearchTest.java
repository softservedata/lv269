package com.softserve.edu.opencart.tests.smoke;

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

public class SearchTest {

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
        return new Object[][] {
                {SearchProductRepository.get().macBook().getProductName()}
        };
    }

    @Test
    public void checkFailureSearchPage() {
        FailureSearchPage searchPage = Application.get().loadHomePage()
                .failureProductSearch("");
        Assert.assertTrue(searchPage.getNoElementsMeetingCriteriaText()
                .toLowerCase()
                .contains(searchPage.NO_PRODUCT));
    }

    @Test (dataProvider = "productData")
    public void checkSuccessSearchPage(String productName) {
        List<String> actualProduct = Application.get().loadHomePage()
                .successProductSearch(productName).getProductComponentTexts();
        Assert.assertTrue(!actualProduct.isEmpty());
    }
}