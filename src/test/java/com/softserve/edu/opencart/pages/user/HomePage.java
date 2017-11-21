package com.softserve.edu.opencart.pages.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.data.categories.DetailCategory;
import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.pages.Application;

public class HomePage extends AHeaderComponent {

    // Fields

    public HomePage(WebDriver driver) {
        super(driver);
        initProductComponents(By.cssSelector(".product-layout"));
    }

    // PageObject

    // get Data

    // get Functional

    @Override
    public List<String> getProductComponentTexts() {
        return super.getProductComponentTexts();
    }

    @Override
    public String getPriceTextByProductName(String productName) {
        return super.getPriceTextByProductName(productName);
    }

    @Override
    public double getPriceAmountByProductName(String productName) {
        return super.getPriceAmountByProductName(productName);
    }

    // set Data

    @Override
    public void clickAddToCartByProductName(String productName) {
        super.clickAddToCartByProductName(productName);
    }

    @Override
    public void clickAddToWishByProductName(String productName) {
        super.clickAddToWishByProductName(productName);
    }

    // set Functional

    // Business Logic
    
    public HomePage chooseCurrencyByDetailCategory(DetailCategory detailCategory) {
        clickCurrencyByPartialName(detailCategory.getOptionName());
        return new HomePage(driver); 
    }

    public HomePage addProductToCart(Product product) {
    	clickAddToCartByProductName(product.getName());
    	// TODO ChromeDriver/Chrome java script execution BUG!!! 
    	Application.get().getBrowser().refreshPage();
    	return new HomePage(driver);
    }
    
    public double getPriceAmountByProduct(Product product) {
        return getPriceAmountByProductName(product.getName());
    }

    public SuccesSearchPage succesSearchProduct(String partialProductName) {
        clickSearchProductField();
        clearSearchProductField();
        setSearchProductField(partialProductName);
        clickSearchProductButton();
        return new SuccesSearchPage(driver); 
    }

}
