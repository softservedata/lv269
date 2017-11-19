package com.softserve.edu.opencart.pages.user;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.GeneralLocators;
import com.softserve.edu.opencart.pages.RegexPatterns;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;
import com.softserve.edu.opencart.tools.NumberUtils;

abstract class AHeaderComponent {

    private class DropdownOptions {

        private List<WebElement> listOptions;

        public DropdownOptions(By searchLocator) {
            initListOptions(searchLocator);
        }

        public DropdownOptions(By searchLocator, By lastLocator) {
            initListOptions(searchLocator);
            listOptions.add(driver.findElement(lastLocator));
        }

        private void initListOptions(By searchLocator) {
            listOptions = driver.findElements(searchLocator);
            //listOptions = driver.findElements(By.cssSelector(".list-inline > li > a.dropdown-toggle + ul > li > a"));
            //listOptions = myAccount.findElements(By.cssSelector("+ ul > li > a"));
        }

        public List<WebElement> getListOptions() {
            return listOptions;
        }

        public WebElement getDropdownOptionByPartialName(String optionName) {
            WebElement result = null;
            for (WebElement current : getListOptions()) {
                if (current.getText().toLowerCase().contains(optionName.toLowerCase())) {
                    result = current;
                    break;
                }
            }
            return result;
        }

        public List<String> getListOptionByPartialNameTexts() {
            List<String> result = new ArrayList<>();
            for (WebElement current : getListOptions()) {
                result.add(current.getText());
            }
            return result;
        }

        public void clickDropdownOptionByPartialName(String optionName) {
            getDropdownOptionByPartialName(optionName).click();
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private class DropdownCart {
        // TODO
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private enum AHeaderComponentLocators {
        CART_TOTAL_ID("cart-total"),
        MY_ACCOUNT_OPTIONS_CSS(".list-inline > li > a.dropdown-toggle + ul > li > a"),
        CURRENCY_OPTIONS_CSS(".btn.btn-link.dropdown-toggle + ul > li > button"),
        // Do not Work with CSS ver. 3.x
        //MENUTOP_OPTIONS_CSS ("li:has(a:contains('%s')) li > a"),
        MENUTOP_OPTIONS_XPATH("//li/a[contains(text(),'%s')]/..//li/a"),
        // Do not Work with CSS ver. 3.x
        //MENUTOP_LAST_OPTION_CSS ("li:has(a:contains('%s')) div > a");
        MENUTOP_LAST_OPTION_XPATH("//a[contains(text(),'Show All %s')]");
        //
        private String field;

        private AHeaderComponentLocators(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return field;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";
    private final String PRODUCT_NAME_NOT_FOUND_MESSAGE = "Product name %s not found in %s";

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
    //
    protected List<ProductComponent> productComponents;
    private DropdownOptions dropdownOptions;
    //private DropdownCart dropdownCart;

    protected AHeaderComponent(WebDriver driver) {
        this.driver = driver;
        //
        currency = driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        myAccount = driver.findElement(By.cssSelector(".list-inline > li > a.dropdown-toggle"));
        wishList = driver.findElement(By.id("wishlist-total"));
        // shoppingCart=driver.findElement(By.partialLinkText("Shopping Cart"));
        // Do not Work with CSS ver. 3.x
        //shoppingCart = null;//driver.findElement(By.cssSelector("a:has('.fa.fa-shopping-cart')"));
        shoppingCart = driver.findElement(By.cssSelector("a[title='Shopping Cart']"));
        // checkout=driver.findElement(By.partialLinkText("Checkout"));
        // Do not Work with CSS ver. 3.x
        //checkout = null; //driver.findElement(By.cssSelector("a:has('.fa.fa-share')"));
        checkout = driver.findElement(By.cssSelector("a[title='Checkout']"));
        logo = driver.findElement(By.cssSelector("#logo > a"));
        searchProductField = driver.findElement(By.name("search"));
        searchProductButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-lg"));
        cart = driver.findElement(By.cssSelector("#cart > button"));
        menuTop = driver.findElements(By.cssSelector("ul.nav.navbar-nav > li"));
    }

    protected void initProductComponents(By searchLocator) {
        productComponents = new ArrayList<>();
        List<WebElement> productWebElements = driver.findElements(searchLocator);
        for (WebElement current : productWebElements) {
            productComponents.add(new ProductComponent(current));
        }
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
        return getCart().findElement(By.id(AHeaderComponentLocators.CART_TOTAL_ID.toString()));
    }

    public List<WebElement> getMenuTop() {
        return menuTop;
    }

    public WebElement getMenuTopByCategoryPartialName(String categoryName) {
        WebElement result = null;
        for (WebElement current : getMenuTop()) {
            if (current.findElement(By.cssSelector(GeneralLocators.FIRST_ANCHOR_CSS.toString())).getText()
                    .toLowerCase().contains(categoryName.toLowerCase())) {
                result = current;
                break;
            }
        }
        return result;
    }

    protected List<ProductComponent> getProductComponent() {
        return productComponents;
    }

    private ProductComponent getProductComponentByProductName(String productName) {
        ProductComponent result = null;
        for (ProductComponent current : getProductComponent()) {
            if (current.getNameText().toLowerCase().contains(productName.toLowerCase())) {
                result = current;
                break;
            }
        }
        ErrorUtils.createCustomException((result == null),
                String.format(PRODUCT_NAME_NOT_FOUND_MESSAGE, productName, getProductComponentTexts().toString()));
        return result;
    }

    // get Functional

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
        return NumberUtils.extractNumber(RegexPatterns.ALL_DIGITS.toString(), getWishListText());
    }

    public String getShoppingCartText() {
        return getShoppingCart().getText();
    }

    public String getCheckoutText() {
        return getCheckout().getText();
    }

    public String getSearchProductFieldText() {
        return getSearchProductField().getAttribute(TagAttribute.VALUE.toString());
    }

    public String getCartText() {
        return getCart().getText();
    }

    public String getCartTotalText() {
        return getCartTotal().getText();
    }

    public int getCartAmount() {
        return NumberUtils.extractNumber(RegexPatterns.FIRST_DIGITS.toString(), getCartTotalText());
    }

    public double getCartSum() {
        return NumberUtils.extractDouble(RegexPatterns.LAST_DOUBLE.toString(), getCartTotalText());
    }

    public List<String> getMenuTopTexts() {
        List<String> result = new ArrayList<>();
        for (WebElement current : getMenuTop()) {
            result.add(current.findElement(By
                    .cssSelector(GeneralLocators.FIRST_ANCHOR_CSS.toString())).getText());
        }
        return result;
    }

    protected List<String> getProductComponentTexts() {
        List<String> result = new ArrayList<>();
        for (ProductComponent current : getProductComponent()) {
            result.add(current.getNameText());
        }
        return result;
    }

    protected String getPriceTextByProductName(String productName) {
        return getProductComponentByProductName(productName).getPriceText();
    }

    protected double getPriceAmountByProductName(String productName) {
        return getProductComponentByProductName(productName).getPriceAmount();
    }

    // set Data

    public void setSearchProductField(String text) {
        getSearchProductField().sendKeys(text);
    }

    public void clearSearchProductField() {
        getSearchProductField().clear();
    }

    public void clickCurrency() {
        getCurrency().click();
    }

    public void clickMyAccount() {
        getMyAccount().click();
    }

    public void clickWishList() {
        getWishList().click();
    }

    public void clickShoppingCart() {
        getShoppingCart().click();
    }

    public void clickCheckout() {
        getCheckout().click();
    }

    public void clickLogo() {
        getLogo().click();
    }

    public void clickSearchProductField() {
        getSearchProductField().click();
    }

    public void clickSearchProductButton() {
        getSearchProductButton().click();
    }

    public void clickCart() {
        getCart().click();
    }

    protected void clickAddToCartByProductName(String productName) {
        getProductComponentByProductName(productName).clickAddToCart();
    }

    protected void clickAddToWishByProductName(String productName) {
        getProductComponentByProductName(productName).clickAddToWish();
    }

    protected void clickNameByProductName(String productName) {
        getProductComponentByProductName(productName).clickName();
    }

    // set Functional

    private void createDropdownOptions(By searchLocator, By lastLocator) {
        if (lastLocator == null) {
            dropdownOptions = new DropdownOptions(searchLocator);
        } else {
            dropdownOptions = new DropdownOptions(searchLocator, lastLocator);
        }
    }

    private void clickDropdownOptionByPartialName(String optionName, By searchLocator, By lastLocator) {
        boolean isClickable = false;
        createDropdownOptions(searchLocator, lastLocator);
        for (String current : dropdownOptions.getListOptionByPartialNameTexts()) {
            if (current.toLowerCase().contains(optionName.toLowerCase())) {
                isClickable = true;
            }
        }
        ErrorUtils.createCustomException(!isClickable,
                String.format(OPTION_NOT_FOUND_MESSAGE,
                        optionName, dropdownOptions.getListOptionByPartialNameTexts().toString()));
        dropdownOptions.clickDropdownOptionByPartialName(optionName);
    }

    public void clickMenuTopByCategoryPartialName(String categoryName) {
        boolean isClickable = false;
        for (String current : getMenuTopTexts()) {
            if (current.toLowerCase().contains(categoryName.toLowerCase())) {
                isClickable = true;
            }
        }
        ErrorUtils.createCustomException(!isClickable,
                String.format(OPTION_NOT_FOUND_MESSAGE,
                        categoryName, getMenuTopTexts().toString()));
        getMenuTopByCategoryPartialName(categoryName).click();
    }

    public void clickCurrencyByPartialName(String optionName) {
        clickCurrency();
        clickDropdownOptionByPartialName(optionName,
                By.cssSelector(AHeaderComponentLocators.CURRENCY_OPTIONS_CSS.toString()), null);
    }

    public void clickMyAccountByPartialName(String optionName) {
        clickMyAccount();
        clickDropdownOptionByPartialName(optionName,
                By.cssSelector(AHeaderComponentLocators.MY_ACCOUNT_OPTIONS_CSS.toString()), null);
    }

    public void clickMenuTopByPartialName(String categoryName, String optionName) {
        clickMenuTopByCategoryPartialName(categoryName);
        clickDropdownOptionByPartialName(optionName,
                By.xpath(String.format(AHeaderComponentLocators.MENUTOP_OPTIONS_XPATH.toString(), categoryName)),
                By.xpath(String.format(AHeaderComponentLocators.MENUTOP_LAST_OPTION_XPATH.toString(), categoryName)));
    }

    public List<String> getCurrencyOptions() {
        clickCurrency();
        createDropdownOptions(By.cssSelector(AHeaderComponentLocators.CURRENCY_OPTIONS_CSS.toString()), null);

        return dropdownOptions.getListOptionByPartialNameTexts();
    }

    public List<String> getMyAccountOptions() {
        clickMyAccount();
        createDropdownOptions(By.cssSelector(AHeaderComponentLocators.MY_ACCOUNT_OPTIONS_CSS.toString()), null);
        return dropdownOptions.getListOptionByPartialNameTexts();
    }

    public List<String> getMenuTopOptionsByPartialNameTexts(String categoryName) {
        clickMenuTopByCategoryPartialName(categoryName);
        createDropdownOptions(
                By.xpath(String.format(AHeaderComponentLocators.MENUTOP_OPTIONS_XPATH.toString(), categoryName)),
                By.xpath(String.format(AHeaderComponentLocators.MENUTOP_LAST_OPTION_XPATH.toString(), categoryName)));
        return dropdownOptions.getListOptionByPartialNameTexts();
    }


    // Business Logic

    // public CommonPage successLogin(IUser user) {
    // setLoginData(user);
    // return new CommonPage();
    // }

    public SubCategoryProductsPage gotoMenuTopByPartialName(String categoryName, String optionName) {
        clickMenuTopByPartialName(categoryName, optionName);
        return new SubCategoryProductsPage(driver);
    }

    // Alert

    private WebElement alertSuccess;
    private WebElement alertDanger;
    private WebElement alertWarning;
    private final String ALERT_NOT_FOUND_MESSAGE = "Alert %s not found";

    private void createAlert(String alert/*, String method*/) {
        WebElement result = null;
        if (driver.findElements(By.className(alert)).size() > 0) {
            result = driver.findElement(By.className(alert));
        }
        ErrorUtils.createCustomException((result == null),
                String.format(ALERT_NOT_FOUND_MESSAGE, alert /*, method*/));
    }

    protected void createAlertSuccess(/*String method*/) {
        createAlert("alert-success"/*, method*/);
    }

    protected void createAlertDanger(/*String method*/) {
        createAlert("alert-danger"/*, method*/);
    }

    protected void createAlertWarning(/*String method*/) {
        createAlert("alert-warning"/*, method*/);
    }

    private WebElement getAlertSuccess() {
        return alertSuccess;
    }

    private WebElement getAlertDanger() {
        return alertDanger;
    }

    private WebElement getAlertWarning() {
        return alertWarning;
    }

    public String getAlertSuccessText() {
        return getAlertSuccess().getText();
    }

    public String getAlertDangerText() {
        return getAlertDanger().getText();
    }

    public String getAlertWarningText() {
        return getAlertWarning().getText();
    }

}
