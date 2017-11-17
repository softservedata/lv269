package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.tools.ErrorUtils;
import com.softserve.edu.opencart.tools.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    private final String STORE_ROW_SELECTOR_CSS = ".table-bordered > tbody > tr";
    private final String NO_SUCH_STORE_MESSAGE = "Store with url %s is not exist";


    //Fiels
    private WebElement addStoreBtn;
    private WebElement deleteStoreBtn;
    private List<StoreTable> storesTable;
    private WebElement headerAllStoreSelectCheckbox;


    public SettingPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
        addStoreBtn = webDriverManager.findElement(By.xpath("//a[child::i[@class='fa fa-plus']]"));
        deleteStoreBtn = webDriverManager.findElement(By.tagName("button"));
        headerAllStoreSelectCheckbox = webDriverManager.findElement(
                By.cssSelector(".table-bordered > thead > tr > td > input"));
        setStoreTablesList();

    }

    private void setStoreTablesList() {
        storesTable = new ArrayList<>();
        for (WebElement current : webDriverManager.findElements(By.cssSelector(STORE_ROW_SELECTOR_CSS))) {
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
        webDriverManager.clickElement(getAddStoreBtn());
    }

    public void clickDeleteStoreBtn() {
        webDriverManager.clickElement(getDeleteStoreBtn());
    }

    public void selectAllStoreCheckbox() {
        webDriverManager.selectCheckBox(getHeaderAllStoreSelectCheckbox());
    }

    public void deselectAllStoreCheckbox() {
        webDriverManager.deselectCheckBox(getHeaderAllStoreSelectCheckbox());
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
    public StoreSettingPage openStoreSettingsPageByUrl(String url) {
        clickStoreEditSettingBtnByUrl(url);
        return new StoreSettingPage(webDriverManager);
    }

    //-----------------------------------------------------------------------------------------
    private class StoreTable {


        // Fields
        private WebElement storeSelectCheckbox;
        private WebElement storeName;
        private WebElement storeUrl;
        private WebElement storeEditSettingsBtn;


        public StoreTable(WebElement storeRow) {
            storeSelectCheckbox = webDriverManager.findElementInsideElement(storeRow,
                    By.cssSelector(StoresTabeSelectors.CHECKBOX_SELECTOR_CSS.toString()));
            storeName = webDriverManager.findElementInsideElement(storeRow,
                    By.cssSelector(StoresTabeSelectors.STORE_NAME_SELECTOR_CSS.toString()));
            storeUrl = webDriverManager.findElementInsideElement(storeRow,
                    By.cssSelector(StoresTabeSelectors.STORE_URL_SELECTOR_CSS.toString()));
            storeEditSettingsBtn = webDriverManager.findElementInsideElement(storeRow,
                    By.cssSelector(StoresTabeSelectors.STORE_ACTION_BTN_SELECTOR_CSS.toString()));
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
            return webDriverManager.isCheckboxSelected(getStoreSelectCheckbox());
        }

        public String getStoreNameText() {
            return getStoreName().getText();
        }

        public String getStoreUrlText() {
            return getStoreUrl().getText();
        }

        //setData

        public void clickStoreEditSettingBtn () {
            webDriverManager.clickElement(getStoreEditSettingsBtn());
        }

        //setFunctional

        public void selectStoreCheckbox() {
            webDriverManager.selectCheckBox(getStoreSelectCheckbox());
        }

        public void deselectStoreCheckbox() {
            webDriverManager.selectCheckBox(getStoreSelectCheckbox());
        }

        // Business Logic

    }
}
