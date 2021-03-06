package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.data.categories.DetailCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SubCategoryProductsPage extends AColumnLeftComponent {

    // Fields

    private List<WebElement> leftSubCategories;
    private List<ProductComponent> productComponents;

    //public SubCategoryProductsPage(WebDriver driver) {
    public SubCategoryProductsPage() {
        //super(driver);
        super();
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

    public SubCategoryProductsPage chooseCurrencyByDetailCategory(DetailCategory detailCategory) {
        clickCurrencyByPartialName(detailCategory.getOptionName());
        //return new SubCategoryProductsPage(driver);
        return new SubCategoryProductsPage();
    }

}
