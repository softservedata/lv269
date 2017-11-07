package com.softserve.edu.opencart.pages.user;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.NumberUtils;

public abstract class AHeaderComponent {

    public static final String ATTRIBUTE_VALUE = "value";
    //
    public static final String FIRST_ANCHOR_CSS = "a:first-child";
    //
    private final String REGEX_ALL_DIGITS = "\\d+";
    private final String REGEX_FIRST_DIGITS = "^\\d+";
    private final String REGEX_LAST_DOUBLE = "\\d+\\.\\d+$";

    // Fields

    protected WebDriver driver;
    //
    private WebElement currency;
    private WebElement myAccount;
    private WebElement wishList;
    private WebElement shoppingCart;
    private WebElement checkout;
    private WebElement logo;
    private WebElement searchProductField;
    private WebElement searchProductButton;
    private WebElement cart;
    private List<WebElement> menuTop;

    protected AHeaderComponent(WebDriver driver) {
        this.driver = driver;
        //
        currency = driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        myAccount = driver.findElement(By.cssSelector(".list-inline > li > a.dropdown-toggle"));
        wishList = driver.findElement(By.id("wishlist-total"));
        // shoppingCart=driver.findElement(By.partialLinkText("Shopping Cart"));
        shoppingCart = driver.findElement(By.cssSelector("a:has('.fa.fa-shopping-cart')"));
        // checkout=driver.findElement(By.partialLinkText("Checkout"));
        checkout = driver.findElement(By.cssSelector("a:has('.fa.fa-share')"));
        logo = driver.findElement(By.cssSelector("#logo > a"));
        searchProductField = driver.findElement(By.name("search"));
        searchProductButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-lg"));
        cart = driver.findElement(By.cssSelector("#cart > button"));
        menuTop = driver.findElements(By.cssSelector("ul.nav.navbar-nav > li"));
    }

    // PageObject

    // get Data

    public WebElement getCurrency() {
        return currency;
    }

    public WebElement getMyAccount() {
        return myAccount;
    }

    public WebElement getWishList() {
        return wishList;
    }

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public WebElement getCheckout() {
        return checkout;
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getSearchProductField() {
        return searchProductField;
    }

    public WebElement getSearchProductButton() {
        return searchProductButton;
    }

    public WebElement getCart() {
        return cart;
    }

    public WebElement getCartTotal() {
        return getCart().findElement(By.id("cart-total"));
    }

    public List<WebElement> getMenuTop() {
        return menuTop;
    }

    public WebElement getMenuTopByCategoryPartialName(String categoryName) {
        WebElement result = null;
        for (WebElement current : getMenuTop()) {
            if (current.findElement(By.cssSelector("a:first-child")).getText()
                    .toLowerCase().contains(categoryName.toLowerCase())) {
                result = current;
                break;
            }
        }
        return result;
    }

    // Functional

    public String getCurrencyText() {
        return getCurrency().getText().substring(0, 1);
    }

    public String getMyAccountText() {
        return getMyAccount().getText();
    }

    public String getWishListText() {
        return getWishList().getText();
    }

    public int getWishListNumber() {
        return NumberUtils.extractNumber("\\d+", getWishListText());
    }

    public String getShoppingCartText() {
        return getShoppingCart().getText();
    }

    public String getCheckoutText() {
        return getCheckout().getText();
    }

    public String getSearchProductFieldText() {
        return getSearchProductField().getAttribute("value");
    }

    public String getCartText() {
        return getCart().getText();
    }

    public String getCartTotalText() {
        return getCartTotal().getText();
    }

    public int getCartAmount() {
        return NumberUtils.extractNumber("^\\d+", getCartTotalText());
    }

    public int getCartSum() {
        return NumberUtils.extractNumber("\\d+\\.\\d+$", getCartTotalText());
    }

    public List<String> getMenuTopTexts() {
        List<String> result = new ArrayList<>();
        for (WebElement current : getMenuTop()) {
            result.add(current
                    .findElement(By.cssSelector("a:first-child")).getText());
        }
        return result;
    }

    // set Data

    // public void setLoginInput(String login) {
    // getLoginInput().sendKeys(login);
    // }
    //
    // public void clearLoginInput() {
    // getLoginInput().clear();
    // }
    //
    // public void clickLoginAccount() {
    // getLoginAccount().click();
    // }

    // Business Logic

    // public CommonPage successLogin(IUser user) {
    // setLoginData(user);
    // return new CommonPage();
    // }

}
