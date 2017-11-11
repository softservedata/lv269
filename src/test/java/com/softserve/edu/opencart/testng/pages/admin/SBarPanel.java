package com.softserve.edu.opencart.testng.pages.admin;

import com.softserve.edu.opencart.testng.WebDriverManager;
import com.softserve.edu.opencart.testng.pages.GeneralLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SBarPanel {


    private enum SBarLocators {

//        SBAR_MENU_PANEL_ID("menu"),
        SBAR_FIRST_OPTIONS_CSS("> li > a"),
//        SBAR_BTN_ID("button-menu"),
//        SBAR_FOLD_ICON_CLS("fa-indent");
        // TO DO Selector inside selector

//
//        ,
//        LOGO_CLS(".navbar-brand"),
//        ACTIONS_LIST_BTN_CSS("a.dropdown-toggle:has(i.fa.fa-bell.fa-lg)"),
//        TO_STORE_BTN_CSS("a.dropdown-toggle:has(i.fa.fa-home.fa-lg)"),
//        HELP_BTN_CSS("a.dropdown-toggle:has(i.fa.fa-life-ring.fa-lg)"),
//        LOGOUT_BTN_CSS("a:has(.fa.fa-sign-out.fa-lg)"),
//        //SBAR_MENU_PANEL_ID("menu"),
//        SBAR_CATALOG_BTN_CSS("#menu-catalog > a"),
//        SBAR_UNFOLD_CATALOG_PRODUCT_BTN_CSS(
//                "ul.collapse.in > li> a[href*='catalog/product']"),
//        //        SBAR_FOLD_CATALOG_BTN_FOLD_ID("menu-catalog"),
//        SBAR_FOLD_CATALOG_BTN_FOLD_CSS("a:has('.fa.fa-tags.fw')"),
//        SBAR_FOLD_PRODUCT_BTN_XPTH("//a [contains(" +
//                "@href, 'catalog/product')][ancestor::li[@id= 'menu-catalog']]"),
//        SBAR_FOLD_PRODUCT_BTN_CSS("#menu-catalog > ul > li > a[href*='catalog/product']");

        private String field;

        SBarLocators(String field) {
            this.field = field;
        }

        public String toString() {
            return field;
        }
    }


    private WebDriverManager webDriverManager;
    private List<WebElement> currentListOptions;
    private WebElement currentParentOption;
    private WebElement currentClickableElement;

    public SBarPanel(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        firstListOptions = webDriverManager.findElementsInsideElement(
                By.id(SBarLocators.SBAR_MENU_PANEL_ID.toString()),
                By.cssSelector(SBarLocators.SBAR_FIRST_OPTIONS_CSS
                        .toString()));
    }

    public String getListOptions() {

        //TO DO findelements inside Elements a > span
        return "";
    }


    private boolean isValueAmongOptionsByPartialName(
            String value, List<WebElement> options) {

        boolean flag = false;
        for (WebElement current : options) {
            if (webDriverManager.findElementInsideElement(current, By.tagName(
                    GeneralLocators.SPAN_TAG.toString())).getText().toLowerCase()
                    .contains(value)) {
                flag = true;
                currentClickableElement = current;
            }
        }
        return flag;
    }

    public boolean isFolded() {
        return (webDriverManager.getElements(By.className(SBarLocators
                .SBAR_FOLD_ICON_CLS.toString())).size() > 0);
    }

    public void switchSBarFoldUnfold() {
        webDriverManager.clickElement(By.id(SBarLocators.SBAR_BTN_ID
                .toString()));
    }

    public clickOptionByPartialName(String)

    //----------------------------------------------->>>
    private abstract class AOptionsList {

        final protected String SUB_OPTIONS_LIST_LOCATOR_CSS="ul";
        final protected String OPTION_BUTTON_LOCATOR_GENERAL_LIST_CSS="";

        protected List<WebElement> optionsList;
        protected WebElement parentElement;
        protected By subListLocator;
        protected By optionBtnLocator;
        protected By optionTextLocator;
        private WebElement currentClickableOptionNumber;

        public AOptionsList(WebElement parentElement) {
            this.parentElement = parentElement;
            optionsList = setOptionsList();
        }

        protected List<WebElement> setOptionsList() {
            return webDriverManager.findElementsInsideElement(parentElement,
                    subListLocator);
        }

        protected String getOptionText(WebElement webElement) {
            return webElement.findElement(optionTextLocator).getText();
        }

        public boolean isOptionExist(String value) {
            boolean flag = false;
            for (String current : listOptionsText) {
                if (current.toLowerCase().equals(value.toLowerCase())) {
                    flag = true;
                    cur
                }

            }

            return flag;
        }

        public WebElement getOptionByPartialName (String value) {
            WebElement result = null;
            for (WebElement current : optionsList) {
                if (getOptionText(current).toLowerCase().equals(value.toLowerCase())) {
                    result = current;
                    break;
                }
            }
            return result;
        }

        private WebElement getOptionBtnByOption (WebElement option) {
            return webDriverManager
        }

        public boolean isOptionHasSubOptionByPartialName (String value) {
            return (getOptionByPartialName(value)
                    .findElements(By.tagName(SUB_OPTIONS_LIST_LOCATOR_CSS)).size() > 0);
        }

        public void clickOptionByPartialName (String value) {
            webDriverManager.clickElement(getOptionByPartialName (value));
        }

    }

    private class MainOptionsList extends AOptionsList {

        final private String SUB_OPTIONS_MAIN_LIST_LOCATOR_CSS="il";
        final private String SUB_OPTIONS_GENERAL_LIST_LOCATOR_CSS="ul>li";


        public MainOptionsList(WebElement parentElement) {

            super(parentElement);

        }
    }
}
