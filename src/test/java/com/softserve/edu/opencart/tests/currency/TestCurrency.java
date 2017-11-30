package com.softserve.edu.opencart.tests.currency;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.categories.CurrencyRepository;
import com.softserve.edu.opencart.data.categories.IDetailCategory;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.pages.Application;

/**
 * @author Yurii Ivanytskyi
 */
public class TestCurrency {
	
//	private String PRICES_NOT_EQUALS = String.format("Prices not equals: actual = %s; expected = %s");
	private String PRICES_NOT_EQUALS = "Prices not equals:";

    @BeforeClass
    public void beforeClass() {
        Application.get(ApplicationSourceRepository.get().chromeServer7());
        // Application.get(ApplicationSourceRepository.get().firefoxServer7());
        Application.get().loadHomePage().chooseCurrencyByDetailCategory(CurrencyRepository.get().dollar());
    }

    @AfterClass
    public void afterClass() {
        Application.get().loadHomePage().chooseCurrencyByDetailCategory(CurrencyRepository.get().dollar());
        Application.remove();
    }

    @DataProvider
    public Object[][] currencyData() {
        return new Object[][] { 
        	{ CurrencyRepository.get().euro(), ProductRepository.get().iPhone() },
            { CurrencyRepository.get().dollar(), ProductRepository.get().iPhone() },
            { CurrencyRepository.get().poundSterling(), ProductRepository.get().iPhone() } };
    }

    @Test(dataProvider = "currencyData")
    public void checkChangeCurrency(IDetailCategory detailCurency, Product product) {
        double actualPrice = Application.get().loadHomePage().chooseCurrencyByDetailCategory(detailCurency)
                .getPriceAmountByProduct(product);
        double expectedPrice = product.getPrices().get(detailCurency.getOptionName());
        Assert.assertEquals(actualPrice, expectedPrice, 0.001, PRICES_NOT_EQUALS);
    }

}
