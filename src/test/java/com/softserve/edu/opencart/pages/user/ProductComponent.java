package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.RegexPatterns;
import com.softserve.edu.opencart.tools.NumberUtils;
import com.softserve.edu.opencart.tools.ReporterWrapper;
import com.softserve.edu.opencart.tools.search.ISearch;

public class ProductComponent {

    // Fields

    protected final Logger logger;
    protected final ReporterWrapper reporter;
    protected final ISearch search;
    private WebElement productLayout;
    //
    private WebElement name;
    private WebElement price;
    private WebElement addToCart;
    private WebElement addToWish;

    public ProductComponent(WebElement productLayout) {
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.reporter = Application.get().reporter();
        this.search = Application.get().search();
        this.productLayout = productLayout;
        //
        //name = productLayout.findElement(By.cssSelector("h4 a"));
        name = search.cssSelector("h4 a", productLayout);
        //price = productLayout.findElement(By.cssSelector(".price"));
        price = search.cssSelector(".price", productLayout);
        // TODO
        //addToCart = null; //productLayout.findElement(By.cssSelector("button:has(.fa.fa-shopping-cart)"));
        addToCart = search.cssSelector(".fa.fa-shopping-cart", productLayout);
        //addToWish = null; //productLayout.findElement(By.cssSelector("button:has(.fa.fa-heart)"));
        addToWish = search.cssSelector(".fa.fa-heart", productLayout);
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
