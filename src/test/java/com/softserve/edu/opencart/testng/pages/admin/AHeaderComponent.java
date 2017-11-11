package com.softserve.edu.opencart.testng.pages.admin;

import com.softserve.edu.opencart.testng.WebDriverManager;
import com.softserve.edu.opencart.testng.pages.GeneralLocators;
import com.softserve.edu.opencart.testng.pages.user.MainPg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

abstract public class AHeaderComponent {
    private enum Selectors {
        SBAR_FOLD_ICON_CLS("fa-indent"),
        SBAR_BTN_ID("button-menu"),
        LOGO_CLS(".navbar-brand"),
        ACTIONS_LIST_BTN_CSS("a.dropdown-toggle:has(i.fa.fa-bell.fa-lg)"),
        TO_STORE_BTN_CSS("a.dropdown-toggle:has(i.fa.fa-home.fa-lg)"),
        HELP_BTN_CSS("a.dropdown-toggle:has(i.fa.fa-life-ring.fa-lg)"),
        LOGOUT_BTN_CSS("a:has(.fa.fa-sign-out.fa-lg)"),
        //SBAR_MENU_PANEL_ID("menu"),
        SBAR_CATALOG_BTN_CSS("#menu-catalog > a"),
        SBAR_UNFOLD_CATALOG_PRODUCT_BTN_CSS(
                "ul.collapse.in > li> a[href*='catalog/product']"),
        //        SBAR_FOLD_CATALOG_BTN_FOLD_ID("menu-catalog"),
        SBAR_FOLD_CATALOG_BTN_FOLD_CSS("a:has('.fa.fa-tags.fw')"),
        SBAR_FOLD_PRODUCT_BTN_XPTH("//a [contains(" +
                "@href, 'catalog/product')][ancestor::li[@id= 'menu-catalog']]"),
        SBAR_FOLD_PRODUCT_BTN_CSS("#menu-catalog > ul > li > a[href*='catalog/product']");

        private String element;

        Selectors(String choice) {
            element = choice;
        }

        public String get() {
            return element;
        }
    }

    protected WebDriverManager webDriverManager;
    //Fields
    private SBarAdmin sBarAdmin;
    private WebElement logo;
    private WebElement actionsListBtn;
    private WebElement toStoreBtn;
    private WebElement helpBtn;
    private WebElement logoutBtn;


    public AHeaderComponent(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        logo = webDriverManager.getElement(By.className(Selectors.LOGO_CLS
                .get()));
        actionsListBtn = webDriverManager.getElement(By.cssSelector(Selectors
                .ACTIONS_LIST_BTN_CSS.get()));
        toStoreBtn = webDriverManager.getElement(By.cssSelector(Selectors
                .TO_STORE_BTN_CSS.get()));
        helpBtn = webDriverManager.getElement(By.cssSelector(Selectors
                .HELP_BTN_CSS.get()));
        logoutBtn = webDriverManager.getElement(By.cssSelector(Selectors
                .LOGOUT_BTN_CSS.get()));
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getActionsListBtn() {
        return actionsListBtn;
    }

    public WebElement getToStoreBtn() {
        return toStoreBtn;
    }

    public WebElement getHelpBtn() {
        return helpBtn;
    }

    public WebElement getLogoutBtn() {
        return logoutBtn;
    }

    public SBarAdmin getSBar() {
        return sBarAdmin;
    }

    //Function

    public MainAdmPg mainAdmPg() {
        webDriverManager.clickElement(logo);
        return new MainAdmPg(webDriverManager);
    }

    public MainPg logoutFromAdm() {
        webDriverManager.clickElement(logoutBtn);
        return new MainPg(webDriverManager);
    }

    //InnerClasses
    protected class SBarAdmin {

        private List<WebElement> currentMenuListElements;

        public SBarAdmin() {
            currentMenuListElements = setListMenuElements(By.id(Selectors
                    .SBAR_MENU_PANEL_ID.get()));
        }

        private List<WebElement> setListMenuElements(
                By byCurentMenuElement) {
            return webDriverManager.findElementsInsideElement(byCurentMenuElement,
                    By.xpath(GeneralLocators.CHILDREN_LI_XPTH.toString()));
        }

        public boolean isFolded() {
            return (webDriverManager.getElements(By.className(Selectors
                    .SBAR_FOLD_ICON_CLS.get())).size() > 0);
        }

        public void switchSBarFoldUnfold() {
            webDriverManager.clickElement(By.id(Selectors.SBAR_BTN_ID.get()));
        }

        public ProductPg openProductPg() {
            webDriverManager.clickElement(By.cssSelector(Selectors
                    .SBAR_FOLD_CATALOG_BTN_FOLD_CSS.get()));
            webDriverManager.clickElement(By.xpath(Selectors
                    .SBAR_FOLD_PRODUCT_BTN_XPTH.get()));
            return new ProductPg(webDriverManager);
        }

        protected class AMenuButtonElement {
            //TO DO
        }
    }

}
