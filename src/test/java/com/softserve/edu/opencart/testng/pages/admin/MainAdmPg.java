package com.softserve.edu.opencart.testng.pages.admin;

import com.softserve.edu.opencart.testng.WebDriverManager;
import com.softserve.edu.opencart.testng.pages.user.MainPg;
import org.openqa.selenium.By;
import com.softserve.edu.opencart.junit.Credentials;


public class MainAdmPg extends AHeaderComponent{

    public MainAdmPg(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

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


//    private WebDriverManager webDriverManager = super.webDriverManager;

    public void logout() {
        webDriverManager.clickElement(By.xpath(
                Selectors.LGOUT_BTN_XPATH.getElement()));
    }

    public boolean isOpened() {
        return webDriverManager.isElementDisplayed(By.xpath(
                Selectors.LGOUT_BTN_XPATH.getElement()));
    }

    public void openFromAdmPgs() {
        webDriverManager.clickElement(By.className(
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
        if (!webDriverManager.isElementPresent(By.className(
                Selectors.SBAR_UNFOLD_ICON_CLS
                        .getElement()))) {
            webDriverManager.clickElement(By.id(
                    Selectors.SBAR_MENU_BTN_ID.getElement()));
        }
        if (!webDriverManager.isElementPresent(By.cssSelector(
                Selectors.SBAR_UNFOLD_CATALOG_LI_OPEN_STATE_CSS
                        .getElement()))) {
            webDriverManager.clickElement(By.cssSelector(
                    Selectors.SBAR_UNFOLD_CATALOG_BTN_CSS
                            .getElement()));
        }
        webDriverManager.waitToBeDisplayed(By.cssSelector(
                Selectors.SBAR_UNFOLD_CATALOG_PRODUCT_BTN_CSS
                        .getElement()));
        webDriverManager.clickElement(By.cssSelector(
                Selectors.SBAR_UNFOLD_CATALOG_PRODUCT_BTN_CSS
                        .getElement()));
    }

    public void openProductPgFoldSbar() {
        if (!webDriverManager.isElementPresent(By.className(
                Selectors.SBAR_FOLD_ICON_CLS
                        .getElement()))) {
            webDriverManager.clickElement(By.id(
                    Selectors.SBAR_MENU_BTN_ID.getElement()));
        }
        webDriverManager.clickElement(By.cssSelector(
                Selectors.SBAR_FOLD_CATALOG_BTN_FOLD_CSS
                        .getElement()));
        webDriverManager.clickElement(By.xpath(
                Selectors.SBAR_PRODUCT_BTN_FOLD_XPTH
                        .getElement()));
    }

    public void openPgAddress() {
        webDriverManager.openAddress(Credentials.URL_SERVER.getChosenConstant()
                + Credentials.URL_ADMIN_PAGE.getChosenConstant());
        new MainPg(webDriverManager).loginIfOpened(Credentials.ENTER
                .getChosenConstant());
    }

//    public void openfoldSideBarMozilla() {
//        if (!webDriverManager.isElementPresent(By.className(
//                Selectors.SBAR_FOLD_ICON_CLS
//                        .toString()))) {
//            webDriverManager.clickElement(By.id(
//                    Selectors.SBAR_MENU_BTN_ID.toString()));
//        }
//        webDriverManager.clickElement(By.id(
//                Selectors.SBAR_FOLD_CATALOG_BTN_FOLD_ID
//                        .toString()));
////        webDriverManager.clickAndHoldElement(By.id(
////                Selectors.SBAR_FOLD_CATALOG_BTN_FOLD_ID
////                        .toString()));
//        webDriverManager.clickElement(By.id(
//                Selectors.SBAR_FOLD_CATALOG_BTN_FOLD_ID
//                        .toString()));
//        webDriverManager.waitToBeDisplayed(By.xpath(
//                Selectors.SBAR_PRODUCT_BTN_FOLD_XPTH
//                        .toString()));
//        webDriverManager.clickElement(By.xpath(
//                Selectors.SBAR_PRODUCT_BTN_FOLD_XPTH
//                        .toString()));
//    }
}
