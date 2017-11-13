package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.RegexPatterns;
import com.softserve.edu.opencart.tools.NumberUtils;

public class ProductComponent {

    // Fields

    private WebElement productLayout;
    //
    private WebElement name;
    private WebElement price;
    private WebElement addToCart;
    private WebElement addToWish;

    public ProductComponent(WebElement productLayout) {
        this.productLayout = productLayout;
        //
        name = productLayout.findElement(By.cssSelector("h4 a"));
        price = productLayout.findElement(By.cssSelector(".price"));
        // TODO
        //addToCart = null; //productLayout.findElement(By.cssSelector("button:has(.fa.fa-shopping-cart)"));
        addToCart = productLayout.findElement(By.cssSelector("button[onclick*='cart.add']"));

        //addToWish = null; //productLayout.findElement(By.cssSelector("button:has(.fa.fa-heart)"));
        addToWish = productLayout.findElement(By.cssSelector("button[onclick*='wishlist.add']"));

    }

    // PageObject

    // get Data

    public WebElement getProductLayout() {
        return productLayout;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getAddToWish() {
        return addToWish;
    }

    // get Functional

    public String getNameText() {
        return getName().getText();
    }

    public String getPriceText() {
        return getPrice().getText();
    }

    public double getPriceAmount() {
        return NumberUtils.extractDouble(RegexPatterns.NUMBER_DOUBLE.toString(), getPriceText());
    }

    // set Data

    public void clickName() {
        getName().click();
    }

    public void clickAddToCart() {
        getAddToCart().click();
    }

    public void clickAddToWish() {
        getAddToWish().click();
    }

    // set Functional

    // Business Logic

}
