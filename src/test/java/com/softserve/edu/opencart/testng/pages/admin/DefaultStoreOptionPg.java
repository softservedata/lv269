package com.softserve.edu.opencart.testng.pages.admin;


import org.openqa.selenium.By;
import com.softserve.edu.opencart.testng.WebDriverCreator;

public class DefaultStoreOptionPg extends AHeaderComponent {

    /**
     * Selectors for different elements
     * Shortens
     * PG - page, WDW-window, SBAR - sidebar, UBAR - upper bar
     * FLD - field, BTN - button, DRPD - dropdown, RBTN - radio button
     * CLK - click, PRS-press
     * LGN - login, LGOUT - logout,  PSWD - password, ATTR-attribute
     * ADM - admin, USR - user
     * ID - id, CLS - class, CSS - css, XPTH - xpath
     * Format of the constant
     * WHERE_[STATE OF PLACE]_WHAT_[STATE OF ELEMENT]_FINDBY
     * - format of convention
     */
    private enum Selectors {

        OPTION_BTN_CSS("a[href='#tab-option'"),
        DFLT_ITEMS_FLD_ID("input-admin-limit"),
        SAVE_BTN_ID("button-save");

        private String element;

        Selectors(String choice) {
            element = choice;
        }

        public String getElement() {
            return element;
        }
    }

    public DefaultStoreOptionPg(WebDriverCreator webDriverCreator) {
        super(webDriverCreator);
    }

    public void changeItemsPerPage(int numberOfItems) {
        new SettingPg(webDriverCreator).opengPageByAddress();
        new SettingPg(webDriverCreator).enterDefaultStore();
        openOptionTab();
        changeItemsOnPg(String.valueOf(numberOfItems));
        saveOption();
    }

    public void changeItemsOnPg(String numberOfItems) {
        webDriverCreator.fillInputField(By.id(Selectors.DFLT_ITEMS_FLD_ID
                .getElement()), numberOfItems);
    }

    private void openOptionTab() {
        webDriverCreator.clickElement(By.cssSelector(Selectors
                .OPTION_BTN_CSS.getElement()));
    }

    private void saveOption() {
        webDriverCreator.clickElement(By.id(Selectors.SAVE_BTN_ID
                .getElement()));
    }


}
