package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.data.pathnames.IPathnames;
import com.softserve.edu.opencart.data.pathnames.StoreSettingOptionSet;
import com.softserve.edu.opencart.tests.TestContextAttributes;
import com.softserve.edu.opencart.tools.ErrorUtils;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;

public class SettingPage extends AHeaderComponentAdmin {

    private enum StoresTabeSelectors {
        CHECKBOX_SELECTOR_CSS("td > input"),
        STORE_URL_SELECTOR_CSS("td:nth-child(3)"),
        STORE_NAME_SELECTOR_CSS("td:nth-child(2)"),
        STORE_ACTION_BTN_SELECTOR_CSS("td > a");

        private String field;

        StoresTabeSelectors(String field) {
            this.field = field;
        }

        public String toString() {
            return field;
        }
    }

    //TODO replace to enum
    private final String STORE_ROW_SELECTOR_CSS = ".table-bordered > tbody > tr";
    private final String NO_SUCH_STORE_MESSAGE = "Store with url %s is not exist";


    //Fiels
    private WebElement addStoreBtn;
    private WebElement deleteStoreBtn;
    private List<StoreTable> storesTable;
    private WebElement headerAllStoreSelectCheckbox;

    //TODO delete static
    private static List<StoreSettingOptionSet>  defaultOptionsValuesSet;
    private static int currentOption;


    public SettingPage() {
        super();
        addStoreBtn = search.xpath("//a[child::i[@class='fa fa-plus']]");
        deleteStoreBtn = search.tagName("button");
        headerAllStoreSelectCheckbox = search.cssSelector(".table-bordered > thead > tr > td > input");
        setStoreTablesList();

    }

    private void setStoreTablesList() {
        storesTable = new ArrayList<>();
        for (WebElement current : search.cssSelectors(STORE_ROW_SELECTOR_CSS)) {
            storesTable.add(new StoreTable(current));
        }
    }
    //Page Object
    //Get Data

    public WebElement getAddStoreBtn() {
        return addStoreBtn;
    }

    public WebElement getDeleteStoreBtn() {
        return deleteStoreBtn;
    }

    public WebElement getHeaderAllStoreSelectCheckbox() {
        return headerAllStoreSelectCheckbox;
    }

    //Get Functional

    public StoreTable getStoreRowByUrl(String url) {
        StoreTable result = null;
        for (StoreTable current : storesTable) {
            if (current.getStoreUrlText().toLowerCase().equals(url.toLowerCase())) {
                result = current;
                break;
            }
        }
        ErrorUtils.createElementIsNotDisplayedException((result == null), String.format(NO_SUCH_STORE_MESSAGE, url));
        return result;
    }

    //Set Data
    public void clickAddStoreBtn() {
        operations.clickElement(getAddStoreBtn());
    }

    public void clickDeleteStoreBtn() {
        operations.clickElement(getDeleteStoreBtn());
    }

    public void selectAllStoreCheckbox() {
        operations.selectCheckBox(getHeaderAllStoreSelectCheckbox());
    }

    public void deselectAllStoreCheckbox() {
        operations.deselectCheckBox(getHeaderAllStoreSelectCheckbox());
    }

    //SetFunctional

    public void clickStoreEditSettingBtnByUrl (String url) {
        getStoreRowByUrl(url).clickStoreEditSettingBtn();
    }

    public void selectStoreSelectCheckboxByUrl (String url) {
        getStoreRowByUrl(url).selectStoreCheckbox();
    }

    public void deselectStoreSelectCheckboxByUrl (String url) {
        getStoreRowByUrl(url).deselectStoreCheckbox();
    }


    // Business Logic
    public StoreSettingPage openStoreSettingsPageByStoreUrl(ITestContext context) {
        clickStoreEditSettingBtnByUrl(((IPathnames)context.getAttribute(TestContextAttributes.PATHNAMES.toString()))
                .getStoreUrl());
        return new StoreSettingPage();
    }

    //-----------------------------------------------------------------------------------------
    private class StoreTable {


        // Fields
        private WebElement storeSelectCheckbox;
        private WebElement storeName;
        private WebElement storeUrl;
        private WebElement storeEditSettingsBtn;


        public StoreTable(WebElement storeRow) {
            storeSelectCheckbox = search.cssSelector(StoresTabeSelectors.CHECKBOX_SELECTOR_CSS.toString(), storeRow);
            storeName = search.cssSelector(StoresTabeSelectors.STORE_NAME_SELECTOR_CSS.toString(), storeRow);
            storeUrl = search.cssSelector(StoresTabeSelectors.STORE_URL_SELECTOR_CSS.toString(), storeRow);
            storeEditSettingsBtn = search.cssSelector(StoresTabeSelectors.STORE_ACTION_BTN_SELECTOR_CSS.toString(), storeRow);
        }

        // PageObject

        // get Data

        public WebElement getStoreSelectCheckbox() {
            return storeSelectCheckbox;
        }

        public WebElement getStoreName() {
            return storeName;
        }

        public WebElement getStoreUrl() {
            return storeUrl;
        }

        public WebElement getStoreEditSettingsBtn() {
            return storeEditSettingsBtn;
        }

        // get Functional

        public boolean isStoreSelectCheckboxStatusSelected() {
            return operations.isCheckboxSelected(getStoreSelectCheckbox());
        }

        public String getStoreNameText() {
            return operations.getText(getStoreName());
        }

        public String getStoreUrlText() {
            return operations.getText(getStoreUrl());
        }

        //setData

        public void clickStoreEditSettingBtn () {
            operations.clickElement(getStoreEditSettingsBtn());
        }

        //setFunctional

        public void selectStoreCheckbox() {
            operations.selectCheckBox(getStoreSelectCheckbox());
        }

        public void deselectStoreCheckbox() {
            operations.selectCheckBox(getStoreSelectCheckbox());
        }

        // Business Logic

        public StoreSettingPage openStoreSettingPageByStoreUrl (IPathnames pathnames) {
            clickStoreEditSettingBtnByUrl(pathnames.getStoreUrl());
            return new StoreSettingPage();
        }
    }
}
