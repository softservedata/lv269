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

public class PartialSearch {

    public final String PRODUCT_IS_NOT_FOUND = "Product not found by %s query";
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
        List<String> productInputData = SearchProductRepository.get().samsungTablet().getProducts();
        Object [][] objArray = new Object[productInputData.size()][];

        for(int i=0; i < productInputData.size(); i++){
            objArray[i] = new Object[1];
            objArray[i][0] = productInputData.get(i);
        }
        return objArray;
    }

    @Test (dataProvider = "productData")
    public void checkSearchResponse(String inputData){
        String expectedProduct = SearchProductRepository.get().samsungTablet().getProductName();
        List<String> actualProduct = Application.get().loadHomePage()
                .successProductSearch(inputData).getProductComponentTexts();
        Assert.assertTrue(actualProduct.contains(expectedProduct), String.format(PRODUCT_IS_NOT_FOUND,
                inputData));
    }
}