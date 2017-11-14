package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.tools.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductAdminPage extends AHeaderComponentAdmin {

    // Fields
    WebElement addProductBtn;
    WebElement copyProductBtn;
    WebElement deleteProductBtn;
    FilterSettings filterSettings;
    PaginationTable paginationTable;
    ProductListTable productListTable;

    public ProductAdminPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
        addProductBtn = webDriverManager.findElement(By.xpath("//a[child::i[@class='fa fa-plus']]"));
        copyProductBtn = webDriverManager.findElement(By.className("btn-default"));
        deleteProductBtn = webDriverManager.findElement(By.className("btn-danger"));

        filterSettings = new FilterSettings();
        paginationTable = new PaginationTable();
        productListTable = new ProductListTable();
    }

    // PageObject

    // get Data

    public WebElement getAddProductBtn() {
        return addProductBtn;
    }

    public WebElement getCopyProductBtn() {
        return copyProductBtn;
    }

    public WebElement getDeleteProductBtn() {
        return deleteProductBtn;
    }

    // get Functional

    //TODO PRODUCT Object return from filter


    // set Data

    public void clickAddProductBtn() {
        webDriverManager.clickElement(getAddProductBtn());
    }

    public void clickCopyProductBtn() {
        webDriverManager.clickElement(copyProductBtn);
    }

    public void clickDeleteProductBtn() {
        webDriverManager.clickElement(deleteProductBtn);
    }

    // set Functional

    //TODO set PRODUCT Object

    // Business Logic


    //-----------------------------------------------------------
    private class FilterSettings {

        // Fields
        private WebElement productNameField;
        private WebElement modelField;
        private WebElement priceField;
        private WebElement quantityField;
        private Select statusDropDown;
        private Select imageDropDown;
        private WebElement filterButton;

        public FilterSettings() {
            productNameField = webDriverManager.findElement(By.id("input-name"));
            modelField = webDriverManager.findElement(By.id("input-model"));
            priceField = webDriverManager.findElement(By.id("input-price"));
            quantityField = webDriverManager.findElement(By.id("input-nquantity"));
            statusDropDown = new Select(webDriverManager.findElement(By.id("input-status")));
            imageDropDown = new Select(webDriverManager.findElement(By.id("input-image")));
            filterButton = webDriverManager.findElement(By.id("button-filter"));
        }
        // PageObject
        // get Data

        public WebElement getProductNameField() {
            return productNameField;
        }

        public WebElement getModelField() {
            return modelField;
        }

        public WebElement getPriceField() {
            return priceField;
        }

        public WebElement getQuantityField() {
            return quantityField;
        }

        public Select getStatusDropDown() {
            return statusDropDown;
        }

        public Select getImageDropDown() {
            return imageDropDown;
        }

        public WebElement getFilterButton() {
            return filterButton;
        }

        // get Functional

        public String getStatusDropdownSelectedOptionText () {
            return getStatusDropDown().getAllSelectedOptions().get(0).getText();
        }

        public String getImageDropdownSelectedOptionText () {
            return getImageDropDown().getAllSelectedOptions().get(0).getText();
        }

        // set Data

        public void setProductNameField(String name) {
            webDriverManager.fillInputField(getProductNameField(), name);
        }

        public void settModelField(String model) {
            webDriverManager.fillInputField(getModelField(), model);
        }

        public void setPriceField(String price) {
            webDriverManager.fillInputField(getPriceField(), price);
        }

        public void setQuantityField(String quantity) {
            webDriverManager.fillInputField(getQuantityField(), quantity);
        }

        public void clickFilterButton() {
            webDriverManager.clickElement(getFilterButton());
        }

        // set Functional
        public void setStatusDropDownByStatusText(String value) {
            webDriverManager.selectByVisibleText(getStatusDropDown(), value);
        }

        public void setImageDropDownByImageText(String value) {
            webDriverManager.selectByVisibleText(getImageDropDown(), value);
        }
        // Business Logic
    }

    //------------------------------------------------------------

    private class PaginationTable {


        private final String FIRST_PAGE_SYMBOL = "|<";
        private final String PREVIOUS_PAGE_SYMBOL = "<";
        private final String NEXT_PAGE_SYMBOL = ">";
        private final String LAST_PAGE_SYMBOL = ">|";

        // Fields
        private WebElement paginationTable;
        private List<WebElement> paginationButtons;
        private WebElement currentPage;

        public PaginationTable() {
            paginationTable = webDriverManager.findElement(By.className("pagination"));
            paginationButtons = webDriverManager.findElementsInsideElement(paginationTable, By.cssSelector("li > a"));
            currentPage = webDriverManager.findElementInsideElement(paginationTable, By.cssSelector("li > span"));
        }

        // PageObject

        // get Data

        public List<WebElement> getPaginationButtons() {
            return paginationButtons;
        }

        public WebElement getCurrentPage() {
            return currentPage;
        }

        private WebElement getBtnBySymbol (String btnSymbol) {
            WebElement result = null;
            for (WebElement current: getPaginationButtons()) {
                if (current.getText().toLowerCase().equals(btnSymbol.toLowerCase())) {
                    result = current;
                    break;
                }
            }
            return result;
        }

        // get Functional

        public String getCurrentPageText () {
            return getCurrentPage().getText();
        }

        public WebElement getFirstPageBtn () {
            return getBtnBySymbol(FIRST_PAGE_SYMBOL);
        }
        public WebElement getPreviousPageBtn () {
            return getBtnBySymbol(PREVIOUS_PAGE_SYMBOL);
        }
        public WebElement getNextPageBtn () {
            return getBtnBySymbol(NEXT_PAGE_SYMBOL);
        }
        public WebElement getLastPageBtn () {
            return getBtnBySymbol(LAST_PAGE_SYMBOL);
        }
        public WebElement getPageByNumber (int pageNumber) {
            return getBtnBySymbol(String.valueOf(pageNumber));
        }

    }

    //------------------------------------------------------------
    private class ProductListTable {

        private static final String INACTIVE_TITLE_HEAD_SELECTOR_XPATH = "./td[not(./*)]";
        private static final String ACTIVE_TITLE_HEAD_SELECTOR_XPATH = "./td/a]";
        private static final String TITLE_CHECKBOX_SELECTOR_XPATH = "./td/input";

        private static final String PRODUCT_CHECKBOX_SELECTOR_XPATH = "./td/input";
        private static final String PRODUCT_IMAGE_SELECTOR_XPATH = "./td/img";
        private static final String PRODUCT_NAME_SELECTOR_XPATH = "./td[3]";
        private static final String PRODUCT_MODEL_SELECTOR_XPATH = "./td[4]";
        private static final String PRODUCT_PRICE_SELECTOR_XPATH = "./td[5]";
        private static final String PRODUCT_QUANTITY_SELECTOR_XPATH = "./td[6]";
        private static final String PRODUCT_STATUS_SELECTOR_XPATH = "./td[7]";
        private static final String PRODUCT_EDIT_BTN_SELECTOR_XPATH = "./td/a";

        private WebElement productListTableHeadRow;
        private List<WebElement> productRows;

        public ProductListTable() {
            productListTableHeadRow = webDriverManager.findElement(By.cssSelector(".table-bordered > thead > tr"));
            productRows = webDriverManager.findElements(By.cssSelector(".table-bordered > tbody > tr"));
        }

    }
}

/*
    public void openByAddress() {
        webDriverManager.openAddress(
                Credentials.URL_SERVER.get()
                        + Credentials.URL_ADMIN_PAGE.get()
                        + Credentials.URL_PRODUCT_PG.get());
        loginLogoutAdmin.loginIfLogouted();
    }

    public void setFilterFields(ProductShort product) {
        webDriverManager.fillInputField(By.id(
                Selectors.ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID
                        .getElement()), product.getName());
        webDriverManager.fillInputField(By.id(
                Selectors.ADM_PRODUCT_PG_MODEL_FLD_ID
                        .getElement()), product.getModel());
        webDriverManager.fillInputField(By.id(
                Selectors.ADM_PRODUCT_PG_PRICE_FLD_ID
                        .getElement()), product.getPrice());
        webDriverManager.fillInputField(By.id(
                Selectors.ADM_PRODUCT_PG_QUANTITY_FLD_ID
                        .getElement()), product.getQuantity());
        webDriverManager.selectByVisibleText(By.id(
                Selectors.ADM_PRODUCT_PG_STATUS_DRPD_ID
                        .getElement()), product.getQuantity());
        webDriverManager.selectByVisibleText(By.id(
                Selectors.ADM_PRODUCT_PG_IMAGE_DRPD_ID
                        .getElement()), product.getQuantity());
    }

    public void cleanFilter() {
        webDriverManager.cleanField(By.id(
                Selectors.ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID
                        .getElement()));
        webDriverManager.cleanField(By.id(
                Selectors.ADM_PRODUCT_PG_MODEL_FLD_ID
                        .getElement()));
        webDriverManager.cleanField(By.id(
                Selectors.ADM_PRODUCT_PG_PRICE_FLD_ID
                        .getElement()));
        webDriverManager.cleanField(By.id(
                Selectors.ADM_PRODUCT_PG_QUANTITY_FLD_ID
                        .getElement()));
        webDriverManager.selectByVisibleText(By.id(
                Selectors.ADM_PRODUCT_PG_STATUS_DRPD_ID
                        .getElement()), Credentials
                .ADM_PRODUCT_PG_STATUS_SLCT_NONVALUE_TXT.get());
        webDriverManager.selectByVisibleText(By.id(
                Selectors.ADM_PRODUCT_PG_IMAGE_DRPD_ID
                        .getElement()), Credentials
                .ADM_PRODUCT_PG_IMG_SLCT_NONVALUE_TXT.get());
        webDriverManager.clickElement(By.id(
                Selectors.ADM_PRODUCT_PG_FILTER_BTN_ID.getElement()));
    }

    public List<WebElement> readTable() {
        return webDriverManager.findElementsInsideElement(
                webDriverManager.getElement(By.cssSelector(
                        Selectors.ADM_PRODUCT_PG_ITEM_TABLE_TBODY_CSS
                                .getElement())),
                By.tagName("tr"));
    }

    public boolean isOpened() {
        return webDriverManager.isElementPresent(By.id(
                Selectors.ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID
                        .getElement()));
    }

    public boolean isPaginationPresent() {
        return webDriverManager.isElementPresent(By.className(
                Selectors.ADM_PRODUCT_PG_PAGINATION_CLS
                        .getElement()));
    }

    public void paginationClickLastPgBtn() {
        webDriverManager.clickElement(By.cssSelector(Selectors
                .ADM_PRODUCT_PAGINATION_LAST_PG_BTN_CSS
                .getElement()));
    }

    public void paginationClickFrstPgBtn() {
        webDriverManager.clickElement(By.cssSelector(Selectors
                .ADM_PRODUCT_PAGINATION_FIRST_PG_BTN_CSS
                .getElement()));
    }


    public String getNumberOfLastPage() {
        return webDriverManager.getTextFromElement(By.cssSelector(
                Selectors.ADM_PRODUCT_PG_LAST_PG_CHOSEN_TXT_CSS
                        .getElement()));
    }

    public int getNumberOfPages() {
        String numberOfPages = "1";
        if (webDriverManager.getElements(By.className(Selectors
                .ADM_PRODUCT_PG_PAGINATION_CLS.getElement())).size() > 0) {
            paginationClickLastPgBtn();
            numberOfPages = getNumberOfLastPage();
            paginationClickFrstPgBtn();
        }
        return Integer.parseInt(numberOfPages);
    } */
