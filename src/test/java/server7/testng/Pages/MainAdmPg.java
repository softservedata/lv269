package server7.testng.Pages;

import org.openqa.selenium.By;
import server7.testng.ElementsSelectors;
import server7.testng.WebDriverCreator;


public class MainAdmPg {


    private WebDriverCreator webDriverCreator;

    public MainAdmPg(WebDriverCreator webDriverCreator) {
        this.webDriverCreator = webDriverCreator;
    }

    public void logout() {
        webDriverCreator.clickElement(By.xpath(
                ElementsSelectors.ADM_PROFILE_PG_LGOUT_BT_XPATH.getElement()));
    }

    public boolean isOpened() {
        return webDriverCreator.isElementDisplayed(By.xpath(
                ElementsSelectors.ADM_PROFILE_PG_LGOUT_BT_XPATH.getElement()));
    }

    public void openFromAdmPgs() {
        webDriverCreator.clickElement(By.className(
                ElementsSelectors.ADM_PROFILE_PG_HOME_BTN_CLS
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
                ElementsSelectors.ADM_PROFILE_PG_SBAR_UNFOLD_ICON_CLS
                        .getElement()))) {
            webDriverCreator.clickElement(By.id(
                    ElementsSelectors.ADM_SBAR_MENU_BTN_ID.getElement()));
        }
        if (!webDriverCreator.isElementPresent(By.cssSelector(
                ElementsSelectors.ADM_SBAR_UNFOLD_CATALOG_LI_OPEN_STATE_CSS
                        .getElement()))) {
            webDriverCreator.clickElement(By.cssSelector(
                    ElementsSelectors.ADM_SBAR_UNFOLD_CATALOG_BTN_CSS
                            .getElement()));
        }
        webDriverCreator.waitToBeDisplayed(By.cssSelector(
                ElementsSelectors.ADM_SBAR_UNFOLD_CATALOG_PRODUCT_BTN_CSS
                        .getElement()));
        webDriverCreator.clickElement(By.cssSelector(
                ElementsSelectors.ADM_SBAR_UNFOLD_CATALOG_PRODUCT_BTN_CSS
                        .getElement()));
    }

    public void openProductPgFoldSbar() {
        if (!webDriverCreator.isElementPresent(By.className(
                ElementsSelectors.ADM_PROFILE_PG_SBAR_FOLD_ICON_CLS
                        .getElement()))) {
            webDriverCreator.clickElement(By.id(
                    ElementsSelectors.ADM_SBAR_MENU_BTN_ID.getElement()));
        }
        webDriverCreator.clickElement(By.cssSelector(
                ElementsSelectors.ADM_SBAR_FOLD_CATALOG_BTN_FOLD_CSS
                        .getElement()));
        webDriverCreator.clickElement(By.xpath(
                ElementsSelectors.ADM_SBAR_PRODUCT_BTN_FOLD_XPTH
                        .getElement()));
    }

//    public void openfoldSideBarMozilla() {
//        if (!webDriverCreator.isElementPresent(By.className(
//                ElementsSelectors.ADM_PROFILE_PG_SBAR_FOLD_ICON_CLS
//                        .getElement()))) {
//            webDriverCreator.clickElement(By.id(
//                    ElementsSelectors.ADM_SBAR_MENU_BTN_ID.getElement()));
//        }
//        webDriverCreator.clickElement(By.id(
//                ElementsSelectors.ADM_SBAR_FOLD_CATALOG_BTN_FOLD_ID
//                        .getElement()));
////        webDriverCreator.clickAndHoldElement(By.id(
////                ElementsSelectors.ADM_SBAR_FOLD_CATALOG_BTN_FOLD_ID
////                        .getElement()));
//        webDriverCreator.clickElement(By.id(
//                ElementsSelectors.ADM_SBAR_FOLD_CATALOG_BTN_FOLD_ID
//                        .getElement()));
//        webDriverCreator.waitToBeDisplayed(By.xpath(
//                ElementsSelectors.ADM_SBAR_PRODUCT_BTN_FOLD_XPTH
//                        .getElement()));
//        webDriverCreator.clickElement(By.xpath(
//                ElementsSelectors.ADM_SBAR_PRODUCT_BTN_FOLD_XPTH
//                        .getElement()));
//    }
}
