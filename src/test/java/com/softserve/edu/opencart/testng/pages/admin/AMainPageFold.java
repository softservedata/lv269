package com.softserve.edu.opencart.testng.pages.admin;

import com.softserve.edu.opencart.testng.WebDriverCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

abstract public class AMainPageFold {
    private enum Selectors {
        SBAR_BTN_ID("button-menu"),
        LOGO_CLS(".navbar-brand"),
        ACTIONS_LIST_BTN_CSS("a.dropdown-toggle:has(i.fa.fa-bell.fa-lg)"),
        TO_STORE_BTN_CSS("a.dropdown-toggle:has(i.fa.fa-home.fa-lg)"),
        HELP_BTN_CSS("a.dropdown-toggle:has(i.fa.fa-life-ring.fa-lg)"),
        LOGOUT_BTN_CSS("a:has(.fa.fa-sign-out.fa-lg)"),
        SBAR_FOLD_ICON_CLS("fa-indent");
        private String element;

        Selectors(String choice) {
            element = choice;
        }

        public String getElement() {
            return element;
        }
    }

    protected WebDriverCreator webDriverCreator;
    //Fields
    private WebElement sBarBtn;
    private WebElement logo;
    private WebElement actionsListBtn;
    private WebElement toStoreBtn;
    private WebElement helpBtn;
    private WebElement logoutBtn;


    public AMainPageFold(WebDriverCreator webDriverCreator) {
        this.webDriverCreator = webDriverCreator;
        sBarBtn = webDriverCreator.getElement(By.id(Selectors.SBAR_BTN_ID
                .getElement()));
        logo = webDriverCreator.getElement(By.className(Selectors.LOGO_CLS
                .getElement()));
        actionsListBtn = webDriverCreator.getElement(By.cssSelector(Selectors
                .ACTIONS_LIST_BTN_CSS.getElement()));
        toStoreBtn = webDriverCreator.getElement(By.cssSelector(Selectors
                .TO_STORE_BTN_CSS.getElement()));
        helpBtn = webDriverCreator.getElement(By.cssSelector(Selectors
                .HELP_BTN_CSS.getElement()));
        logoutBtn = webDriverCreator.getElement(By.cssSelector(Selectors
                .LOGOUT_BTN_CSS.getElement()));
    }

    public WebElement getsBarBtn() {
        return sBarBtn;
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

    public boolean isSBarFold () {
        return (webDriverCreator.getElements(By.className(
                Selectors.SBAR_FOLD_ICON_CLS.getElement())).size() > 0);
    }

    //Function

    public void switchSBarFoldUnfold () {
        webDriverCreator.clickElement(sBarBtn);
    }

    public void mainAdmPg () {
        webDriverCreator.clickElement(logo);
    }

    public void logoutFromAdm () {
        webDriverCreator.clickElement(logoutBtn);
    }
}
