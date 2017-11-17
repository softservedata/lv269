package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.constants.URLs;
import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.pages.RegexPatterns;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;
import com.softserve.edu.opencart.tools.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductAdminPage extends AHeaderComponentAdmin {

    private enum PaginationData {
        FIRST_PAGE_SYMBOL("|<"),
        PREVIOUS_PAGE_SYMBOL("<"),
        NEXT_PAGE_SYMBOL(">"),
        LAST_PAGE_SYMBOL(">|"),
        PAGINATION_ACTIVE_BTN_SELECTOR_CSS(".pagination > li >a"),
        PAGINATION_CURRENT_PAGE_SELECTOR_CSS(".pagination > li > span"),
        PAGINATION_LAST_BTN_SELECTOR_CSS(".pagination > li:last-child > span"),
        NO_PAGINATION_MESSAGE("On ProductAdminPage, there is no pagination "),
        NO_PAGINATION_BTN_MESSAGE("There is no the button with name = %s");
        private String field;

        PaginationData(String field) {
            this.field = field;
        }

        public String toString() {
            return field;
        }
    }

    private enum ProductTableData {
        PRODUCT_MARK_CHECKBOX_SELECTOR_XPATH("./td/input"),
        IMAGE_SELECTOR_XPATH("./td/img"),
        PRODUCT_NAME_SELECTOR_XPATH("./td[3]"),
        PRODUCT_MODEL_SELECTOR_XPATH("./td[4]"),
        PRICE_SELECTOR_XPATH("./td[5]"),
        QUANTITY_SELECTOR_XPATH("./td[6]"),
        STATUS_SELECTOR_XPATH("./td[7]"),
        PRODUCT_EDIT_BTN_SELECTOR_XPATH("./td/a");

        private String field;

        ProductTableData(String field) {
            this.field = field;
        }

        public String toString() {
            return field;
        }
    }

    // Fields
    private WebElement addProductBtn;
    private WebElement copyProductBtn;
    private WebElement deleteProductBtn;

    private List<WebElement> paginationActiveBtns;
    private WebElement paginationCurrentPage;
    private FilterSettings filterSettings;
    private ProductListTable productListTable;

    public ProductAdminPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
        addProductBtn = webDriverManager.findElement(By.xpath("//a[child::i[@class='fa fa-plus']]"));
        copyProductBtn = webDriverManager.findElement(By.className("btn-default"));
        deleteProductBtn = webDriverManager.findElement(By.className("btn-danger"));

        filterSettings = new FilterSettings();
        productListTable = new ProductListTable();
        initPagination();
    }

    private void initPagination() {
        if (webDriverManager.isElementVisible(By.cssSelector(PaginationData.PAGINATION_ACTIVE_BTN_SELECTOR_CSS
                .toString()))) {
            paginationActiveBtns = webDriverManager.findElements(
                    By.cssSelector(PaginationData.PAGINATION_ACTIVE_BTN_SELECTOR_CSS.toString()));
            paginationCurrentPage = webDriverManager.findElement(
                    By.cssSelector(PaginationData.PAGINATION_CURRENT_PAGE_SELECTOR_CSS.toString()));
        } else {
            paginationActiveBtns = null;
            paginationActiveBtns = null;
        }
    }

    // PageObject

    // get data

    public WebElement getAddProductBtn() {
        return addProductBtn;
    }

    public WebElement getCopyProductBtn() {
        return copyProductBtn;
    }

    public WebElement getDeleteProductBtn() {
        return deleteProductBtn;
    }

    public List<WebElement> getPaginationActiveBtns() {
        ErrorUtils.createElementIsNotDisplayedException((paginationCurrentPage == null),
                PaginationData.NO_PAGINATION_MESSAGE.toString());
        return paginationActiveBtns;
    }

    public WebElement getPaginationCurrentPage() {
        ErrorUtils.createElementIsNotDisplayedException((paginationCurrentPage == null),
                PaginationData.NO_PAGINATION_MESSAGE.toString());
        return paginationCurrentPage;
    }

    public WebElement getLastPaginationBtn() {
        ErrorUtils.createElementIsNotDisplayedException((paginationCurrentPage == null),
                PaginationData.NO_PAGINATION_MESSAGE.toString());
        return webDriverManager.findElement(By.cssSelector(PaginationData.PAGINATION_LAST_BTN_SELECTOR_CSS.toString()));
    }

    // get Functional

    public boolean isPaganationOnPage() {
        return (getPaginationCurrentPage() != null);
    }

    public int getCurrentPageNumber() {
        return Integer.parseUnsignedInt(getPaginationCurrentPage().getText());
    }

    public WebElement getPaginationBtnByName(String paginationBtnName) {
        WebElement result = null;
        for (WebElement current : getPaginationActiveBtns()) {
            if (current.getText().equals(paginationBtnName)) {
                result = current;
                break;
            }
        }
        ErrorUtils.createElementIsNotDisplayedException((result == null),
                String.format(PaginationData.NO_PAGINATION_BTN_MESSAGE.toString(), paginationBtnName));
        return result;
    }

    public String getLastPaginationBtnText() {
        return getLastPaginationBtn().getText();
    }

    public WebElement getFirstPagePaginationBtn() {
        return getPaginationBtnByName(PaginationData.FIRST_PAGE_SYMBOL.toString());
    }

    public WebElement getPreviousPagePaginationBtn() {
        return getPaginationBtnByName(PaginationData.PREVIOUS_PAGE_SYMBOL.toString());
    }

    public WebElement getNextPagePaginationBtn() {
        return getPaginationBtnByName(PaginationData.NEXT_PAGE_SYMBOL.toString());
    }

    public WebElement getLastPagePaginationBtn() {
        return getPaginationBtnByName(PaginationData.LAST_PAGE_SYMBOL.toString());
    }

    public boolean isLastPageOpened() {
        return (getLastPaginationBtnText().matches(RegexPatterns.ALL_DIGITS.toString())
                && (Integer.parseUnsignedInt(getLastPaginationBtnText()) == getCurrentPageNumber()));
    }

    //TODO PRODUCT Object return from filter
    //TODO PRODUCT Table Function


    // set data

    public void clickAddProductBtn() {
        webDriverManager.clickElement(getAddProductBtn());
    }

    public void clickCopyProductBtn() {
        webDriverManager.clickElement(copyProductBtn);
    }

    public void clickDeleteProductBtn() {
        webDriverManager.clickElement(deleteProductBtn);
    }

    public void clickFirstPagePaginationBtn() {
        webDriverManager.clickElement(getFirstPagePaginationBtn());
    }

    public void clickPreviousPagePaginationBtn() {
        webDriverManager.clickElement(getPreviousPagePaginationBtn());
    }

    public void clickNextPagePaginationBtn() {
        webDriverManager.clickElement(getNextPagePaginationBtn());
    }

    public void clickLastPagePaginationBtn() {
        webDriverManager.clickElement(getFirstPagePaginationBtn());
    }

    public void clickPaginationBtnByName(String paginationBtnName) {
        webDriverManager.clickElement(getPaginationBtnByName(paginationBtnName));
    }

    // set Functional

    //TODO set PRODUCT Object

    // Business Logic

    public ProductAdminPage filterProductAdminPage(ProductShort product) {
        filterSettings.setFilterFields(product);
        filterSettings.clickFilterButton();
        return new ProductAdminPage(webDriverManager);
    }

    public ProductAdminPage toLastPage() {
        //TODO Write Pagibnation Buttons methods
        return new ProductAdminPage(webDriverManager);
    }

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
            quantityField = webDriverManager.findElement(By.id("input-quantity"));
            statusDropDown = new Select(webDriverManager.findElement(By.id("input-status")));
            imageDropDown = new Select(webDriverManager.findElement(By.id("input-image")));
            filterButton = webDriverManager.findElement(By.id("button-filter"));
        }
        // PageObject
        // get data

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

        public String getStatusDropdownSelectedOptionText() {
            return getStatusDropDown().getAllSelectedOptions().get(0).getText();
        }

        public String getImageDropdownSelectedOptionText() {
            return getImageDropDown().getAllSelectedOptions().get(0).getText();
        }

        // set data

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

        // set Functional
        public void setStatusDropDownByStatusText(String value) {
            webDriverManager.selectByVisibleText(getStatusDropDown(), value);
        }

        public void setImageDropDownByImageText(String value) {
            webDriverManager.selectByVisibleText(getImageDropDown(), value);
        }

        public void clickFilterButton() {
            webDriverManager.clickElement(getFilterButton());
        }

        public void setFilterFields(ProductShort product) {
            setProductNameField(product.getName());
            settModelField(product.getModel());
            setPriceField(product.getPrice());
            setQuantityField(product.getQuantity());
            setImageDropDownByImageText(product.getImageText());
            setStatusDropDownByStatusText(product.getStatusText());
        }
        // Business Logic
    }

    //------------------------------------------------------------

    private class ProductListTable {

        private final String ASC = "asc";
        private final String DESC = "desc";
        private final String IMAGE_URL_IS_EMPTY = "The image's URL of the product %s is empty";


        private WebElement allProductsMarkCheckbox;
        private List<WebElement> activeProductListHeaderTitles;
        private List<WebElement> productRows;
        private List<ProductShort> productList;

        public ProductListTable() {
            allProductsMarkCheckbox = webDriverManager.findElement(By.cssSelector("thead > tr > td > input"));
            activeProductListHeaderTitles = webDriverManager.findElements(By.cssSelector("thead > tr > td > a"));
            productRows = webDriverManager.findElements(By.cssSelector("tbody > tr"));
        }

        //GetData

        public List<WebElement> getProductRows() {
            return productRows;
        }

        public WebElement getAllProductsMarkCheckbox() {
            return allProductsMarkCheckbox;
        }

        public List<WebElement> getActiveProductListHeaderTitles() {
            return activeProductListHeaderTitles;
        }

        //GetFunctional
        public WebElement getProductNameFromProductRow(WebElement productRow) {
            return webDriverManager.findElementInsideElement(productRow, By.xpath(
                    ProductTableData.PRODUCT_NAME_SELECTOR_XPATH.toString()));
        }

        public String getProductNameTextFromProductRow(WebElement productRow) {
            return getProductNameFromProductRow(productRow).getText();
        }

        public WebElement getModelFromProductRow(WebElement productRow) {
            return webDriverManager.findElementInsideElement(productRow, By.xpath(
                    ProductTableData.PRODUCT_MODEL_SELECTOR_XPATH.toString()));
        }

        public String getModelTextFromProductRow(WebElement productRow) {
            return getModelFromProductRow(productRow).getText();
        }

        public WebElement getPriceFromProductRow(WebElement productRow) {
            return webDriverManager.findElementInsideElement(productRow, By.xpath(
                    ProductTableData.PRICE_SELECTOR_XPATH.toString()));
        }

        public String getPriceTextFromProductRow(WebElement productRow) {
            return getPriceFromProductRow(productRow).getText();
        }

        public WebElement getQuantityFromProductRow(WebElement productRow) {
            return webDriverManager.findElementInsideElement(productRow, By.xpath(
                    ProductTableData.QUANTITY_SELECTOR_XPATH.toString()));
        }

        public String getQuantityTextFromProductRow(WebElement productRow) {
            return getQuantityFromProductRow(productRow).getText();
        }

        public WebElement getImageFromProductRow(WebElement productRow) {
            return webDriverManager.findElementInsideElement(productRow, By.xpath(
                    ProductTableData.IMAGE_SELECTOR_XPATH.toString()));
        }

        public String getImageUrlFromProductRow(WebElement productRow) {
            return getImageFromProductRow(productRow).getAttribute(TagAttribute.SRC.toString());
        }

        public String getImageFlagTextFromProductRow(WebElement productRow) {
            String imageUrl = getImageUrlFromProductRow(productRow);
            ErrorUtils.createInputDataIsEmptyException(imageUrl.isEmpty(),
                    String.format(IMAGE_URL_IS_EMPTY, getProductNameTextFromProductRow(productRow)));
            String result = TagAttribute.ENABLED.toString();
            if (imageUrl.equalsIgnoreCase(URLs.ADM_PRODUCT_PG_DEFAULT_SMALL_IMAGE_URL.toString())) {
                result = TagAttribute.DISABLED.toString();
            }
            return result;
        }

        public WebElement getStatusFromProductRow(WebElement productRow) {
            return webDriverManager.findElementInsideElement(productRow, By.xpath(
                    ProductTableData.STATUS_SELECTOR_XPATH.toString()));
        }

        public String getStatusTextFromProductRow(WebElement productRow) {
            return getStatusFromProductRow(productRow).getText();
        }

        //TODO FIND ROWS By Name, By Model, Create List of ProductShort, Action Button,

        private WebElement getHeaderBtnByName(String headerBtnName) {
            WebElement result = null;
            for (WebElement current : getActiveProductListHeaderTitles()) {
                if (current.getText().toLowerCase().equals(headerBtnName.toLowerCase())) {
                    result = current;
                    break;
                }
            }
            return result;
        }

        public WebElement getProductNameHeaderBtn() {
            return getHeaderBtnByName(TagAttribute.PRODUCT_NAME.toString());
        }

        public WebElement getModelHeaderBtn() {
            return getHeaderBtnByName(TagAttribute.MODEL.toString());
        }

        public WebElement getPriceHeaderBtn() {
            return getHeaderBtnByName(TagAttribute.PRICE.toString());
        }

        public WebElement getQuantityHeaderBtn() {
            return getHeaderBtnByName(TagAttribute.QUANTITY.toString());
        }

        public WebElement getStatusHeaderBtn() {
            return getHeaderBtnByName(TagAttribute.STATUS.toString());
        }

        private String getClassNameFromElement(WebElement element) {
            return element.getAttribute(TagAttribute.CLASS.toString());
        }


        //SetData
        public void setProductNameColumnDescendant() {
            if (getClassNameFromElement(getProductNameHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getProductNameHeaderBtn()).isEmpty()) {
                webDriverManager.clickElement(getProductNameHeaderBtn());
            }
        }

        public void setProductNameColumnAscendant() {
            if (getClassNameFromElement(getProductNameHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getProductNameHeaderBtn()).isEmpty()) {
                webDriverManager.clickElement(getProductNameHeaderBtn());
            }
        }


        public void setModelColumnDescendant() {
            if (getClassNameFromElement(getModelHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getModelHeaderBtn()).isEmpty()) {
                webDriverManager.clickElement(getModelHeaderBtn());
            }
        }

        public void setModelColumnAscendant() {
            if (getClassNameFromElement(getModelHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getModelHeaderBtn()).isEmpty()) {
                webDriverManager.clickElement(getModelHeaderBtn());
            }
        }

        public void setPriceColumnDescendant() {
            if (getClassNameFromElement(getPriceHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getPriceHeaderBtn()).isEmpty()) {
                webDriverManager.clickElement(getPriceHeaderBtn());
            }
        }

        public void setPriceColumnAscendant() {
            if (getClassNameFromElement(getPriceHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getPriceHeaderBtn()).isEmpty()) {
                webDriverManager.clickElement(getPriceHeaderBtn());
            }
        }

        public void setQuantityColumnDescendant() {
            if (getClassNameFromElement(getQuantityHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getQuantityHeaderBtn()).isEmpty()) {
                webDriverManager.clickElement(getQuantityHeaderBtn());
            }
        }

        public void setQuantityColumnAscendant() {
            if (getClassNameFromElement(getQuantityHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getQuantityHeaderBtn()).isEmpty()) {
                webDriverManager.clickElement(getQuantityHeaderBtn());
            }
        }

        public void setStatusColumnDescendant() {
            if (getClassNameFromElement(getStatusHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getStatusHeaderBtn()).isEmpty()) {
                webDriverManager.clickElement(getStatusHeaderBtn());
            }
        }

        public void setStatusColumnAscendant() {
            if (getClassNameFromElement(getStatusHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getStatusHeaderBtn()).isEmpty()) {
                webDriverManager.clickElement(getStatusHeaderBtn());
            }
        }

        public void selectAllProductMarkCheckbox() {
            webDriverManager.selectCheckBox(getAllProductsMarkCheckbox());
        }

        public void deselectAllProductMarkCheckbox() {
            webDriverManager.deselectCheckBox(getAllProductsMarkCheckbox());
        }

        public List<ProductShort> getProductsFromProductRowsByProductShort(ProductShort searchingProductShort) {
            List<ProductShort> result = new ArrayList<>();
            for (WebElement current : getProductRows()) {
                ProductShort currentProductShort = initProductShortFromProductRow(current);
                if (searchingProductShort.getProductMap().equals(currentProductShort.getProductMap())) {
                    result.add(currentProductShort);
                }
            }
            return result;
        }

        //SetFunctional

        public ProductShort initProductShortFromProductRow(WebElement productRow) {
            return new ProductShort().setName(getProductNameTextFromProductRow(productRow))
                    .setModel(getModelTextFromProductRow(productRow))
                    .setPrice(getPriceTextFromProductRow(productRow))
                    .setQuantity(getQuantityTextFromProductRow(productRow))
                    .setImageFlag(getImageFlagTextFromProductRow(productRow))
                    .setStatusText(getStatusTextFromProductRow(productRow));
        }

        public List<ProductShort> initProductsFromProductsTable() {
            productList = new ArrayList<>();
            for (WebElement current : getProductRows()) {
                productList.add(initProductShortFromProductRow(current));
            }
            return productList;
        }
    }
}
/*

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
