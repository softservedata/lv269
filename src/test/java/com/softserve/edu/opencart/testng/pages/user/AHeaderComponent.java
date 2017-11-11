package com.softserve.edu.opencart.testng.pages.user;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.testng.constants.Credentials;
import com.softserve.edu.opencart.testng.pages.RegexPatterns;
import com.softserve.edu.opencart.testng.pages.GeneralLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.testng.tools.NumberUtils;

public abstract class AHeaderComponent {

    enum Selectors {
        CURRENCY_BTN_CSS(".btn.btn-link.dropdown-toggle"),
        MY_ACCOUNT_BTN_CSS(".list-inline > li > a.dropdown-toggle"),
        WISH_LIST_BTN_ID ("wishlist-total"),
        SHOPPING_CART_CSS("a:has('.fa.fa-shopping-cart')"),
        CHECKOUT_CSS("a:has('.fa.fa-share')"),
        LOGO_CSS("#logo > a"),
        SEARCH_PRODUCT_FLD_NAME("search"),
        SEARCH_PRODUCT_BTN_CSS(".btn.btn-default.btn-lg"),
        CART_CSS("#cart > button"),
        MENU_TOP("ul.nav.navbar-nav > li"),
        CART_TOTAL_ID("cart-total");

        private String chosen;

        Selectors(String choice) {
            chosen = choice;
        }

        public String get() {
            return chosen;
        }

    }

    public static final String ATTRIBUTE_VALUE = "value";
    //

    //


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
        currency = driver.findElement(By.cssSelector(Selectors
                .CURRENCY_BTN_CSS.get()));
        myAccount = driver.findElement(By.cssSelector(Selectors
                .MY_ACCOUNT_BTN_CSS.get()));
        wishList = driver.findElement(By.id(Selectors
                .WISH_LIST_BTN_ID.get()));
        // shoppingCart=driver.findElement(By.partialLinkText("Shopping Cart"));
        shoppingCart = driver.findElement(By.cssSelector(Selectors
                .SHOPPING_CART_CSS.get()));
        // checkout=driver.findElement(By.partialLinkText("Checkout"));
        checkout = driver.findElement(By.cssSelector(Selectors
                .CHECKOUT_CSS.get()));
        logo = driver.findElement(By.cssSelector(Selectors.LOGO_CSS.get()));
        searchProductField = driver.findElement(By.name(Selectors
                .SEARCH_PRODUCT_FLD_NAME.get()));
        searchProductButton = driver.findElement(By.cssSelector(Selectors
                .SEARCH_PRODUCT_BTN_CSS.get()));
        cart = driver.findElement(By.cssSelector(Selectors.CART_CSS.get()));
        menuTop = driver.findElements(By.cssSelector(Selectors.MENU_TOP.get()));
    }

    // PageObject

    // toString Data

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
        return getCart().findElement(By.id(Selectors.CART_TOTAL_ID.get()));
    }

    public List<WebElement> getMenuTop() {
        return menuTop;
    }

    public WebElement getMenuTopByCategoryPartialName(String categoryName) {
        WebElement result = null;
        for (WebElement current : getMenuTop()) {
            if (current.findElement(By.cssSelector(GeneralLocators
                    .FIRST_ANCHOR_CSS.toString())).getText()
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
        return NumberUtils.extractNumber(RegexPatterns.ALL_DIGITS.get(),
                getWishListText());
    }

    public String getShoppingCartText() {
        return getShoppingCart().getText();
    }

    public String getCheckoutText() {
        return getCheckout().getText();
    }

    public String getSearchProductFieldText() {
        return getSearchProductField().getAttribute(Credentials
                .ATTRIBUTE_VALUE.get());
    }

    public String getCartText() {
        return getCart().getText();
    }

    public String getCartTotalText() {
        return getCartTotal().getText();
    }

    public int getCartAmount() {
        return NumberUtils.extractNumber(RegexPatterns.FIRST_DIGITS.get(),
                getCartTotalText());
    }

    public int getCartSum() {
        return NumberUtils.extractNumber(RegexPatterns.LAST_DOUBLE.get(),
                getCartTotalText());
    }

    public List<String> getMenuTopTexts() {
        List<String> result = new ArrayList<>();
        for (WebElement current : getMenuTop()) {
            result.add(current
                    .findElement(By.cssSelector(Credentials.ATTRIBUTE_VALUE
                            .get())).getText());
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
