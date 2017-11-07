package com.softserve.edu.opencart.testng.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.softserve.edu.opencart.testng.*;

import java.util.List;

public class ProductPg extends AHeaderComponent {


    public ProductPg(WebDriverCreator webDriverCreator) {
        super(webDriverCreator);
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

    private WebDriverCreator webDriverCreator;
    private LoginLogoutAdmin loginLogoutAdmin;


    public void login_admin() {
        loginLogoutAdmin.setMainPage();
        loginLogoutAdmin.login(Credentials.ENTER.getChosenConstant());
    }

    public void openByAddress() {
        webDriverCreator.openAddress(
                Credentials.URL_SERVER.getChosenConstant()
                        + Credentials.URL_ADMIN_PAGE.getChosenConstant()
                        + Credentials.URL_PRODUCT_PG.getChosenConstant());
        loginLogoutAdmin.loginIfLogouted();
    }

    public void setFilterFields(ProductShort product) {
        webDriverCreator.fillInputField(By.id(
                Selectors.ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID
                        .getElement()), product.getName());
        webDriverCreator.fillInputField(By.id(
                Selectors.ADM_PRODUCT_PG_MODEL_FLD_ID
                        .getElement()), product.getModel());
        webDriverCreator.fillInputField(By.id(
                Selectors.ADM_PRODUCT_PG_PRICE_FLD_ID
                        .getElement()), product.getPrice());
        webDriverCreator.fillInputField(By.id(
                Selectors.ADM_PRODUCT_PG_QUANTITY_FLD_ID
                        .getElement()), product.getQuantity());
        webDriverCreator.selectByVisibleText(By.id(
                Selectors.ADM_PRODUCT_PG_STATUS_DRPD_ID
                        .getElement()), product.getQuantity());
        webDriverCreator.selectByVisibleText(By.id(
                Selectors.ADM_PRODUCT_PG_IMAGE_DRPD_ID
                        .getElement()), product.getQuantity());
    }

    public void cleanFilter() {
        webDriverCreator.cleanField(By.id(
                Selectors.ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID
                        .getElement()));
        webDriverCreator.cleanField(By.id(
                Selectors.ADM_PRODUCT_PG_MODEL_FLD_ID
                        .getElement()));
        webDriverCreator.cleanField(By.id(
                Selectors.ADM_PRODUCT_PG_PRICE_FLD_ID
                        .getElement()));
        webDriverCreator.cleanField(By.id(
                Selectors.ADM_PRODUCT_PG_QUANTITY_FLD_ID
                        .getElement()));
        webDriverCreator.selectByVisibleText(By.id(
                Selectors.ADM_PRODUCT_PG_STATUS_DRPD_ID
                        .getElement()), Credentials
                .ADM_PRODUCT_PG_STATUS_SLCT_NONVALUE_TXT.getChosenConstant());
        webDriverCreator.selectByVisibleText(By.id(
                Selectors.ADM_PRODUCT_PG_IMAGE_DRPD_ID
                        .getElement()), Credentials
                .ADM_PRODUCT_PG_IMG_SLCT_NONVALUE_TXT.getChosenConstant());
        webDriverCreator.clickElement(By.id(
                Selectors.ADM_PRODUCT_PG_FILTER_BTN_ID.getElement()));
    }

    public List<WebElement> readTable() {
        return webDriverCreator.findElementsInsideElement(
                webDriverCreator.getElement(By.cssSelector(
                        Selectors.ADM_PRODUCT_PG_ITEM_TABLE_TBODY_CSS
                                .getElement())),
                By.tagName("tr"));
    }

    public boolean isOpened() {
        return webDriverCreator.isElementPresent(By.id(
                Selectors.ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID
                        .getElement()));
    }

    public boolean isPaginationPresent() {
        return webDriverCreator.isElementPresent(By.className(
                Selectors.ADM_PRODUCT_PG_PAGINATION_CLS
                        .getElement()));
    }

    public void paginationClickLastPgBtn() {
        webDriverCreator.clickElement(By.cssSelector(Selectors
                .ADM_PRODUCT_PAGINATION_LAST_PG_BTN_CSS
                .getElement()));
    }

    public void paginationClickFrstPgBtn() {
        webDriverCreator.clickElement(By.cssSelector(Selectors
                .ADM_PRODUCT_PAGINATION_FIRST_PG_BTN_CSS
                .getElement()));
    }


    public String getNumberOfLastPage() {
        return webDriverCreator.getTextFromElement(By.cssSelector(
                Selectors.ADM_PRODUCT_PG_LAST_PG_CHOSEN_TXT_CSS
                        .getElement()));
    }

    public int getNumberOfPages() {
        String numberOfPages = "1";
        if (webDriverCreator.getElements(By.className(Selectors
                .ADM_PRODUCT_PG_PAGINATION_CLS.getElement())).size() > 0) {
            paginationClickLastPgBtn();
            numberOfPages = getNumberOfLastPage();
            paginationClickFrstPgBtn();
        }
        return Integer.parseInt(numberOfPages);
    }


}
