 package com.softserve.edu.opencart.tests.currency;

import com.softserve.edu.opencart.data.categories.CurrencyRepository;
import com.softserve.edu.opencart.data.categories.IDetailCategory;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tests.TestRunner;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.tests.TestContextAttributes.STARTED_CHECK_CHANGE_CURRENCY_BY_PRICE;
import static com.softserve.edu.opencart.tests.TestContextAttributes.PRICES_NOT_EQUALS;
import static com.softserve.edu.opencart.tests.TestContextAttributes.SYMBOLS_NOT_EQUALS;;

/**
 * @author Yurii Ivanytskyi
 */
public class TestCurrency extends TestRunner{

    @BeforeClass
    public void setCurrency () {
        Application.get().loadHomePage().chooseCurrencyByDetailCategory(CurrencyRepository.get().dollar());
    }

    @DataProvider
    public Object[][] currencyData() {
        return new Object[][] { 
        	{ CurrencyRepository.get().euro(), ProductRepository.get().iPhone() },
            { CurrencyRepository.get().dollar(), ProductRepository.get().iPhone() },
            { CurrencyRepository.get().poundSterling(), ProductRepository.get().iPhone() } };
    }

    @Test(dataProvider = "currencyData")
    public void checkChangeCurrencyByPrice(IDetailCategory detailCurency, Product product) {
    	logger.info(String.format(STARTED_CHECK_CHANGE_CURRENCY_BY_PRICE.toString(), detailCurency.getOptionName(), product.getName()));
        reporter.display(String.format(STARTED_CHECK_CHANGE_CURRENCY_BY_PRICE.toString(), detailCurency.getOptionName(), product.getName()));
        
        flexAssert.assertEquals(Application.get()
        		.loadHomePage().chooseCurrencyByDetailCategory(detailCurency)
                .getPriceAmountByProduct(product), 
                product.getPrices().get(detailCurency.getOptionName()).getValue(), PRICES_NOT_EQUALS.toString());
        
        flexAssert.assertEquals(Application.get()
        		.loadHomePage().chooseCurrencyByDetailCategory(detailCurency)
                .getPriceSymbolAsciiByProduct(product), 
                product.getPrices().get(detailCurency.getOptionName()).getSymbolAsciiCode(), SYMBOLS_NOT_EQUALS.toString());
        flexAssert.assertAll();
    }
}
