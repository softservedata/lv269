package com.softserve.edu.opencart.testng.pages.admin;

import com.softserve.edu.opencart.testng.pages.user.MainPg;
import org.openqa.selenium.By;
import com.softserve.edu.opencart.junit.Credentials;
import com.softserve.edu.opencart.testng.WebDriverCreator;


public class MainAdmPg {

    private enum Selectors {

        LGOUT_BTN_XPATH("//a[child::i[" +
                "@class='fa fa-sign-out fa-lg']]"), //TO DO delete
        HOME_BTN_CLS("navbar-brand"), //TO DO delete
        SBAR_MENU_BTN_ID("button-menu"), //TO DO delete
        SBAR_UNFOLD_ICON_CLS("fa-dedent"), //UNFOLD STATE TO DO
        SBAR_UNFOLD_CATALOG_LI_OPEN_STATE_CSS("#menu-catalog.active.open"),
        SBAR_UNFOLD_CATALOG_BTN_CSS("#menu-catalog a.parent"),
        SBAR_UNFOLD_CATALOG_PRODUCT_BTN_CSS(
                "ul.collapse.in > li> a[href*='catalog/product']"),
        SBAR_FOLD_ICON_CLS("fa-indent"), //FOLD STATE TO DO delete
        SBAR_FOLD_CATALOG_BTN_FOLD_ID("menu-catalog"),
        SBAR_FOLD_CATALOG_BTN_FOLD_CSS("#menu-catalog > a.parent"),
        SBAR_PRODUCT_BTN_FOLD_XPTH("//a [contains(" +
                "@href, 'catalog/product')][ancestor::li[@id= 'menu-catalog']]");

        private String element;

        Selectors(String choice) {
            element = choice;
        }

        public String getElement() {
            return element;
        }
    }


    private WebDriverCreator webDriverCreator;

    public MainAdmPg(WebDriverCreator webDriverCreator) {
        this.webDriverCreator = webDriverCreator;
    }

    public void logout() {
        webDriverCreator.clickElement(By.xpath(
                Selectors.LGOUT_BTN_XPATH.getElement()));
    }

    public boolean isOpened() {
        return webDriverCreator.isElementDisplayed(By.xpath(
                Selectors.LGOUT_BTN_XPATH.getElement()));
    }

    public void openFromAdmPgs() {
        webDriverCreator.clickElement(By.className(
                Selectors.HOME_BTN_CLS
                        .getElement()));
    }

    public void openProductPg(boolean withSbarFold) {
        if (withSbarFold) {
            openProductPgFoldSbar();
        } else {
            openProductPgUnfoldSbar();
        }
    }

    public void openProductPgUnfoldSbar() {
        if (!webDriverCreator.isElementPresent(By.className(
                Selectors.SBAR_UNFOLD_ICON_CLS
                        .getElement()))) {
            webDriverCreator.clickElement(By.id(
                    Selectors.SBAR_MENU_BTN_ID.getElement()));
        }
        if (!webDriverCreator.isElementPresent(By.cssSelector(
                Selectors.SBAR_UNFOLD_CATALOG_LI_OPEN_STATE_CSS
                        .getElement()))) {
            webDriverCreator.clickElement(By.cssSelector(
                    Selectors.SBAR_UNFOLD_CATALOG_BTN_CSS
                            .getElement()));
        }
        webDriverCreator.waitToBeDisplayed(By.cssSelector(
                Selectors.SBAR_UNFOLD_CATALOG_PRODUCT_BTN_CSS
                        .getElement()));
        webDriverCreator.clickElement(By.cssSelector(
                Selectors.SBAR_UNFOLD_CATALOG_PRODUCT_BTN_CSS
                        .getElement()));
    }

    public void openProductPgFoldSbar() {
        if (!webDriverCreator.isElementPresent(By.className(
                Selectors.SBAR_FOLD_ICON_CLS
                        .getElement()))) {
            webDriverCreator.clickElement(By.id(
                    Selectors.SBAR_MENU_BTN_ID.getElement()));
        }
        webDriverCreator.clickElement(By.cssSelector(
                Selectors.SBAR_FOLD_CATALOG_BTN_FOLD_CSS
                        .getElement()));
        webDriverCreator.clickElement(By.xpath(
                Selectors.SBAR_PRODUCT_BTN_FOLD_XPTH
                        .getElement()));
    }

    public void openPgAddress() {
        webDriverCreator.openAddress(Credentials.URL_SERVER.getChosenConstant()
                + Credentials.URL_ADMIN_PAGE.getChosenConstant());
        new MainPg(webDriverCreator).loginIfOpened(Credentials.ENTER
                .getChosenConstant());
    }

//    public void openfoldSideBarMozilla() {
//        if (!webDriverCreator.isElementPresent(By.className(
//                Selectors.SBAR_FOLD_ICON_CLS
//                        .getElement()))) {
//            webDriverCreator.clickElement(By.id(
//                    Selectors.SBAR_MENU_BTN_ID.getElement()));
//        }
//        webDriverCreator.clickElement(By.id(
//                Selectors.SBAR_FOLD_CATALOG_BTN_FOLD_ID
//                        .getElement()));
////        webDriverCreator.clickAndHoldElement(By.id(
////                Selectors.SBAR_FOLD_CATALOG_BTN_FOLD_ID
////                        .getElement()));
//        webDriverCreator.clickElement(By.id(
//                Selectors.SBAR_FOLD_CATALOG_BTN_FOLD_ID
//                        .getElement()));
//        webDriverCreator.waitToBeDisplayed(By.xpath(
//                Selectors.SBAR_PRODUCT_BTN_FOLD_XPTH
//                        .getElement()));
//        webDriverCreator.clickElement(By.xpath(
//                Selectors.SBAR_PRODUCT_BTN_FOLD_XPTH
//                        .getElement()));
//    }
}
