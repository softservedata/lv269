package server7.junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPg {

    private WebDriverCreator webDriverCreator;
    private LoginLogoutAdmin loginLogoutAdmin;


    ProductPg(WebDriverCreator webDriverCreator) {
        this.webDriverCreator = webDriverCreator;
        loginLogoutAdmin = new LoginLogoutAdmin(webDriverCreator);
    }

    public void login_admin() {
        loginLogoutAdmin.setMainPage();
        loginLogoutAdmin.login(Credentials.ENTER.getChosenConstant());
    }

    public void openMainAdmPg() {
        webDriverCreator.clickElement(By.className(
                ElementsSelectors.ADM_PROFILE_PG_HOME_BTN_CLS
                        .getElement()));
    }

    public void openByAddress() {
        webDriverCreator.openAddress(
                Credentials.URL_SERVER.getChosenConstant()
                        + Credentials.URL_ADMIN_PAGE.getChosenConstant()
                        + Credentials.URL_PRODUCT_PG.getChosenConstant());
        loginLogoutAdmin.loginIfLogouted();
    }

    public void openUnfoldSideBar() {
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

    public void openfoldSideBarChrome() {
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

    public void openfoldSideBarMozilla() {
        if (!webDriverCreator.isElementPresent(By.className(
                ElementsSelectors.ADM_PROFILE_PG_SBAR_FOLD_ICON_CLS
                        .getElement()))) {
            webDriverCreator.clickElement(By.id(
                    ElementsSelectors.ADM_SBAR_MENU_BTN_ID.getElement()));
        }
        webDriverCreator.clickElement(By.id(
                ElementsSelectors.ADM_SBAR_FOLD_CATALOG_BTN_FOLD_ID
                        .getElement()));
//        webDriverCreator.clickAndHoldElement(By.id(
//                ElementsSelectors.ADM_SBAR_FOLD_CATALOG_BTN_FOLD_ID
//                        .getElement()));
        webDriverCreator.clickElement(By.id(
                ElementsSelectors.ADM_SBAR_FOLD_CATALOG_BTN_FOLD_ID
                        .getElement()));
        webDriverCreator.waitToBeDisplayed(By.xpath(
                ElementsSelectors.ADM_SBAR_PRODUCT_BTN_FOLD_XPTH
                        .getElement()));
        webDriverCreator.clickElement(By.xpath(
                ElementsSelectors.ADM_SBAR_PRODUCT_BTN_FOLD_XPTH
                        .getElement()));
    }

    public void setFilterFields(ProductShort product) {
        webDriverCreator.fillInputField(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID
                        .getElement()), product.getName());
        webDriverCreator.fillInputField(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_MODEL_FLD_ID
                        .getElement()), product.getModel());
        webDriverCreator.fillInputField(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_PRICE_FLD_ID
                        .getElement()), product.getPrice());
        webDriverCreator.fillInputField(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_QUANTITY_FLD_ID
                        .getElement()), product.getQuantity());
        webDriverCreator.selectByVisibleText(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_STATUS_DRPD_ID
                        .getElement()), product.getQuantity());
        webDriverCreator.selectByVisibleText(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_IMAGE_DRPD_ID
                        .getElement()), product.getQuantity());
    }

    public void cleanFilter() {
        webDriverCreator.cleanField(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID
                        .getElement()));
        webDriverCreator.cleanField(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_MODEL_FLD_ID
                        .getElement()));
        webDriverCreator.cleanField(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_PRICE_FLD_ID
                        .getElement()));
        webDriverCreator.cleanField(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_QUANTITY_FLD_ID
                        .getElement()));
        webDriverCreator.selectByVisibleText(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_STATUS_DRPD_ID
                        .getElement()), Credentials
                .ADM_PRODUCT_PG_STATUS_SLCT_NONVALUE_TXT.getChosenConstant());
        webDriverCreator.selectByVisibleText(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_IMAGE_DRPD_ID
                        .getElement()), Credentials
                .ADM_PRODUCT_PG_IMG_SLCT_NONVALUE_TXT.getChosenConstant());
        webDriverCreator.clickElement(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_FILTER_BTN_ID.getElement()));
    }

    public List<WebElement> readTable() {
        return webDriverCreator.findElementsInsideElement(
                webDriverCreator.getElement(By.cssSelector(
                        ElementsSelectors.ADM_PRODUCT_PG_ITEM_TABLE_TBODY_CSS
                                .getElement())),
                By.tagName("tr"));
    }

    public boolean isOpened() {
        return webDriverCreator.isElementPresent(By.id(
                ElementsSelectors.ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID
                        .getElement()));
    }

    public boolean isPaginationPresent() {
        return webDriverCreator.isElementPresent(By.className(
                ElementsSelectors.ADM_PRODUCT_PG_PAGINATION_CLS
                        .getElement()));
    }

    public void PaginationClickLastPgBtn() {
        webDriverCreator.clickElement(By.cssSelector(ElementsSelectors
                .ADM_PRODUCT_PAGINATION_LAST_PG_BTN_CSS
                .getElement()));
    }


    public String getNumberOfLastPage() {
        return webDriverCreator.getTextFromElement(By.cssSelector(
                ElementsSelectors.ADM_PRODUCT_PG_LAST_PG_CHOSEN_TXT_CSS
                        .getElement()));
    }

    public int getNumberOfPages() {
        String numberOfPages = "1";
        if (webDriverCreator.getElements(By.className(ElementsSelectors
                .ADM_PRODUCT_PG_PAGINATION_CLS.getElement())).size() > 0) {
            PaginationClickLastPgBtn();
            numberOfPages = getNumberOfLastPage();
        }
        return Integer.parseInt(numberOfPages);
    }
}
