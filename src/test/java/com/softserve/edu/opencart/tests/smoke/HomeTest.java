package com.softserve.edu.opencart.tests.smoke;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.categories.CurrencyRepository;
import com.softserve.edu.opencart.data.categories.DetailCategory;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.pages.Application;

public class HomeTest {

    @BeforeClass
    public void beforeClass() {
        Application.get(ApplicationSourceRepository.get().chromeServer7());
        //Application.get(ApplicationSourceRepository.get().firefoxServer7());
    }

    @AfterClass
    public void afterClass() {
        Application.remove();
    }
    
    @DataProvider//(parallel = true)
    public Object[][] productData() {
        // Read from ...
        return new Object[][] {
            { CurrencyRepository.get().euro(), ProductRepository.get().macBook() },
            { CurrencyRepository.get().dollar(), ProductRepository.get().macBook() },
            };
    }

    @Test(dataProvider = "productData")
    public void checkProduct(DetailCategory detailCurency, Product product) {

        double actualPrice = Application.get().loadHomePage()
                .chooseCurrencyByDetailCategory(detailCurency)
                .getPriceAmountByProduct(product);

        // TODO getPrices(detailCurency)
        double expectedPrice = product.getPrices().get(detailCurency.getOptionName());
        Assert.assertEquals(actualPrice, expectedPrice, 0.001);
    }
}
