package com.softserve.edu.opencart.testng.pages.admin;

import com.softserve.edu.opencart.testng.constants.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.softserve.edu.opencart.testng.*;

import java.util.List;

public class ProductPg extends AHeaderComponent {


    public ProductPg(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    private enum Selectors {

        ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID("input-name"),
        ADM_PRODUCT_PG_PRICE_FLD_ID("input-price"),
        ADM_PRODUCT_PG_STATUS_DRPD_ID("input-status"),
        ADM_PRODUCT_PG_MODEL_FLD_ID("input-model"),
        ADM_PRODUCT_PG_QUANTITY_FLD_ID("input-quantity"),
        ADM_PRODUCT_PG_IMAGE_DRPD_ID("input-image"),
        ADM_PRODUCT_PG_FILTER_BTN_ID("button-filter"),
        ADM_PRODUCT_PG_PAGINATION_CLS ("pagination"),
        ADM_PRODUCT_PAGINATION_LAST_PG_BTN_CSS(".pagination li:last-child > a"),
        ADM_PRODUCT_PAGINATION_FIRST_PG_BTN_CSS(".pagination li:first-child > a"),
        ADM_PRODUCT_PG_LAST_PG_CHOSEN_TXT_CSS (".pagination li.active span"),
        ITEMS_TABLE_STATUS_TD_XPTH (".//td[4]"),
        ADM_PRODUCT_PG_ADD_NEW_BTN_XPTH("//a[@class = 'btn btn-primary']" +
                "[child::i[@class='fa fa-plus']]"),
        ADM_PRODUCT_PG_ITEM_TABLE_CLS (".table.table-bordered.table-hover"),
        ADM_PRODUCT_PG_ITEM_TABLE_THEAD_CSS (".table.table-bordered.table-hover > thead"),
        ADM_PRODUCT_PG_ITEM_TABLE_TBODY_CSS (".table.table-bordered.table-hover > tbody"),
        ADM_ITEMS_TABLE_IMG_XPTH(".//td[2]/img"),
        ITEMS_TABLE_NAME_TD_XPTH (".//td[3]"),
        ITEMS_TABLE_MODEL_TD_XPTH (".//td[4]"),
        ITEMS_TABLE_PRICE_SPAN_2PRICES_XPTH (".//td[5]/span"),
        ITEMS_TABLE_PRICE_TD_1PRICE_XPTH (".//td[5]"),
        ITEMS_TABLE_QUANTITY_SPAN_XPTH (".//td[6]/span");
        
        private String element;

        Selectors(String choice) {
            element = choice;
        }

        public String getElement() {
            return element;
        }
    }

    private WebDriverManager webDriverManager;
    private LoginLogoutAdmin loginLogoutAdmin;


    public void login_admin() {
        loginLogoutAdmin.setMainPage();
        loginLogoutAdmin.login(Credentials.ENTER.get());
    }

    public void openByAddress() {
        webDriverManager.openAddress(
                Credentials.URL_SERVER.get()
                        + Credentials.URL_ADMIN_PAGE.get()
                        + Credentials.URL_PRODUCT_PG.get());
        loginLogoutAdmin.loginIfLogouted();
    }

    public void setFilterFields(ProductShort product) {
        webDriverManager.fillInputField(By.id(
                Selectors.ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID
                        .getElement()), product.getName());
        webDriverManager.fillInputField(By.id(
                Selectors.ADM_PRODUCT_PG_MODEL_FLD_ID
                        .getElement()), product.getModel());
        webDriverManager.fillInputField(By.id(
                Selectors.ADM_PRODUCT_PG_PRICE_FLD_ID
                        .getElement()), product.getPrice());
        webDriverManager.fillInputField(By.id(
                Selectors.ADM_PRODUCT_PG_QUANTITY_FLD_ID
                        .getElement()), product.getQuantity());
        webDriverManager.selectByVisibleText(By.id(
                Selectors.ADM_PRODUCT_PG_STATUS_DRPD_ID
                        .getElement()), product.getQuantity());
        webDriverManager.selectByVisibleText(By.id(
                Selectors.ADM_PRODUCT_PG_IMAGE_DRPD_ID
                        .getElement()), product.getQuantity());
    }

    public void cleanFilter() {
        webDriverManager.cleanField(By.id(
                Selectors.ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID
                        .getElement()));
        webDriverManager.cleanField(By.id(
                Selectors.ADM_PRODUCT_PG_MODEL_FLD_ID
                        .getElement()));
        webDriverManager.cleanField(By.id(
                Selectors.ADM_PRODUCT_PG_PRICE_FLD_ID
                        .getElement()));
        webDriverManager.cleanField(By.id(
                Selectors.ADM_PRODUCT_PG_QUANTITY_FLD_ID
                        .getElement()));
        webDriverManager.selectByVisibleText(By.id(
                Selectors.ADM_PRODUCT_PG_STATUS_DRPD_ID
                        .getElement()), Credentials
                .ADM_PRODUCT_PG_STATUS_SLCT_NONVALUE_TXT.get());
        webDriverManager.selectByVisibleText(By.id(
                Selectors.ADM_PRODUCT_PG_IMAGE_DRPD_ID
                        .getElement()), Credentials
                .ADM_PRODUCT_PG_IMG_SLCT_NONVALUE_TXT.get());
        webDriverManager.clickElement(By.id(
                Selectors.ADM_PRODUCT_PG_FILTER_BTN_ID.getElement()));
    }

    public List<WebElement> readTable() {
        return webDriverManager.findElementsInsideElement(
                webDriverManager.getElement(By.cssSelector(
                        Selectors.ADM_PRODUCT_PG_ITEM_TABLE_TBODY_CSS
                                .getElement())),
                By.tagName("tr"));
    }

    public boolean isOpened() {
        return webDriverManager.isElementPresent(By.id(
                Selectors.ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID
                        .getElement()));
    }

    public boolean isPaginationPresent() {
        return webDriverManager.isElementPresent(By.className(
                Selectors.ADM_PRODUCT_PG_PAGINATION_CLS
                        .getElement()));
    }

    public void paginationClickLastPgBtn() {
        webDriverManager.clickElement(By.cssSelector(Selectors
                .ADM_PRODUCT_PAGINATION_LAST_PG_BTN_CSS
                .getElement()));
    }

    public void paginationClickFrstPgBtn() {
        webDriverManager.clickElement(By.cssSelector(Selectors
                .ADM_PRODUCT_PAGINATION_FIRST_PG_BTN_CSS
                .getElement()));
    }


    public String getNumberOfLastPage() {
        return webDriverManager.getTextFromElement(By.cssSelector(
                Selectors.ADM_PRODUCT_PG_LAST_PG_CHOSEN_TXT_CSS
                        .getElement()));
    }

    public int getNumberOfPages() {
        String numberOfPages = "1";
        if (webDriverManager.getElements(By.className(Selectors
                .ADM_PRODUCT_PG_PAGINATION_CLS.getElement())).size() > 0) {
            paginationClickLastPgBtn();
            numberOfPages = getNumberOfLastPage();
            paginationClickFrstPgBtn();
        }
        return Integer.parseInt(numberOfPages);
    }


}
