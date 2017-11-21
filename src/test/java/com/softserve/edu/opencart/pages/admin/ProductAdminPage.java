package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.pages.RegexPatterns;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;
import com.softserve.edu.opencart.tools.SearchManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductAdminPage extends AHeaderComponentAdmin {

    private enum PaginationData {
        TO_FIRST_PAGE_SYMBOL("|<"),
        TO_PREVIOUS_PAGE_SYMBOL("<"),
        TO_NEXT_PAGE_SYMBOL(">"),
        TO_LAST_PAGE_SYMBOL(">|"),
        PAGINATION_ACTIVE_BTNS_SELECTOR_CSS(".pagination > li >a"),
        PAGINATION_CURRENT_PAGE_SELECTOR_CSS(".pagination > li > span"),
        PAGINATION_LAST_BTN_ON_PAGE_SELECTOR_CSS(".pagination > li:last-child > a"),
        PAGINATION_FIRST_BTN_ON_PAGE_SELECTOR_CSS(".pagination > li:first-child > a"),

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

    private final String INIT_BEFORE_PRODUCT_ADMIN_PAGE_MESSAGE = "Init before get - pagination is on the ProductAdminPage";

    // Fields
    private WebElement addProductBtn;
    private WebElement copyProductBtn;
    private WebElement deleteProductBtn;

    private List<WebElement> paginationActiveBtns;
    private WebElement paginationCurrentPage;
    private FilterSettings filterSettings;
    private ProductListTable productListTable;
    protected Integer lastProductAdminPageAllPagesNumber;
    protected List<ProductShort> productShortListAllPages;

    public ProductAdminPage(SearchManager searchManager) {
        super(searchManager);
        addProductBtn = searchManager.findElement(By.xpath("//a[child::i[@class='fa fa-plus']]"));
        copyProductBtn = searchManager.findElement(By.className("btn-default"));
        deleteProductBtn = searchManager.findElement(By.className("btn-danger"));

        filterSettings = new FilterSettings();
        productListTable = new ProductListTable();
        initPagination();
        initLastProductAdminPageAllPages();
        initProductShortListAllPages();
    }

    private void initPagination() {
        if (searchManager.isElementVisible(By.cssSelector(PaginationData.PAGINATION_ACTIVE_BTNS_SELECTOR_CSS
                .toString()))) {
            paginationActiveBtns = searchManager.findElements(
                    By.cssSelector(PaginationData.PAGINATION_ACTIVE_BTNS_SELECTOR_CSS.toString()));
            paginationCurrentPage = searchManager.findElement(
                    By.cssSelector(PaginationData.PAGINATION_CURRENT_PAGE_SELECTOR_CSS.toString()));
        } else {
            paginationActiveBtns = null;
            paginationActiveBtns = null;
        }
    }

    private void initProductShortListAllPages() {
        if (isPaganationOnPage()) {
            productShortListAllPages = null;
        } else {
            productShortListAllPages = new ArrayList<>();
        }
    }

    private void initLastProductAdminPageAllPages() {
        if (isPaganationOnPage()) {
            lastProductAdminPageAllPagesNumber = null;
        } else {
            lastProductAdminPageAllPagesNumber = 1;
        }
    }

    // PageObject

    // get data

    public ProductListTable getProductListTable() {
        return productListTable;
    }

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

    public WebElement getLastPaginationBtnOnPage() {
        ErrorUtils.createElementIsNotDisplayedException((paginationCurrentPage == null),
                PaginationData.NO_PAGINATION_MESSAGE.toString());
        return searchManager.findElement(By.cssSelector(PaginationData.PAGINATION_LAST_BTN_ON_PAGE_SELECTOR_CSS.toString()));
    }

    public WebElement getFirstPaginationBtnOnPage() {
        ErrorUtils.createElementIsNotDisplayedException((paginationCurrentPage == null),
                PaginationData.NO_PAGINATION_MESSAGE.toString());
        return searchManager.findElement(By.cssSelector(PaginationData.PAGINATION_FIRST_BTN_ON_PAGE_SELECTOR_CSS.toString()));
    }

    public Integer getLastProductAdminPageAllPagesNumber() {
        ErrorUtils.createInitPaginationBeforeGetException((lastProductAdminPageAllPagesNumber == null),
                INIT_BEFORE_PRODUCT_ADMIN_PAGE_MESSAGE);
        return lastProductAdminPageAllPagesNumber;
    }

    public List<ProductShort> getProductShortListAllPages() {
        ErrorUtils.createInitPaginationBeforeGetException((productShortListAllPages == null),
                INIT_BEFORE_PRODUCT_ADMIN_PAGE_MESSAGE);
        return productShortListAllPages;
    }

    // get Functional

    public boolean isPaganationOnPage() {
        return (paginationCurrentPage != null);
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

    public String getLastPaginationBtnOnPageText() {
        return getLastPaginationBtnOnPage().getText();
    }

    public WebElement getToFirstPagePaginationBtnOnPage() {
        return getPaginationBtnByName(PaginationData.TO_FIRST_PAGE_SYMBOL.toString());
    }

    public WebElement getToPreviousPagePaginationBtn() {
        return getPaginationBtnByName(PaginationData.TO_PREVIOUS_PAGE_SYMBOL.toString());
    }

    public WebElement getToNextPagePaginationBtn() {
        return getPaginationBtnByName(PaginationData.TO_NEXT_PAGE_SYMBOL.toString());
    }

    public WebElement getToLastPagePaginationBtn() {
        return getPaginationBtnByName(PaginationData.TO_LAST_PAGE_SYMBOL.toString());
    }

    public boolean isLastPageOpened() {
        return (getLastPaginationBtnOnPageText().matches(RegexPatterns.ALL_DIGITS.toString())
                && (Integer.parseUnsignedInt(getLastPaginationBtnOnPageText()) == getCurrentPageNumber()));
    }

    public List<ProductShort> getProductsShortListFromPage() {
        return getProductListTable().getProductsShortList();
    }

    //TODO get from filter fields' text
    //TODO get and click for headers active element (sort by them desc, asc); get and click edit button by ProductShort
    //TODO get ProductShortList by Name, Model....


    // set data

    public void clickAddProductBtn() {
        searchManager.clickElement(getAddProductBtn());
    }

    public void clickCopyProductBtn() {
        searchManager.clickElement(copyProductBtn);
    }

    public void clickDeleteProductBtn() {
        searchManager.clickElement(deleteProductBtn);
    }

    public void clickToFirstPagePaginationBtn() {
        searchManager.clickElement(getToFirstPagePaginationBtnOnPage());
    }

    public void clickToPreviousPagePaginationBtn() {
        searchManager.clickElement(getToPreviousPagePaginationBtn());
    }

    public void clickToNextPagePaginationBtn() {
        searchManager.clickElement(getToNextPagePaginationBtn());
    }

    public void clickLastPaginationBtnOnPage() {
        searchManager.clickElement(getLastPaginationBtnOnPage());
    }

    public void clickFirstPaginationBtnOnPage() {
        searchManager.clickElement(getFirstPaginationBtnOnPage());
    }

    public void clickToLastPagePaginationBtn() {
        searchManager.clickElement(getToFirstPagePaginationBtnOnPage());
    }

    public void clickPaginationBtnByName(String paginationBtnName) {
        searchManager.clickElement(getPaginationBtnByName(paginationBtnName));
    }

    protected void setLastProductAdminPageAllPagesNumber(Integer lastProductAdminPageAllPagesNumber) {
        this.lastProductAdminPageAllPagesNumber = lastProductAdminPageAllPagesNumber;
    }

    protected void setProductShortListAllPages(List<ProductShort> productShortListAllPages) {
        this.productShortListAllPages = productShortListAllPages;
    }

    // set Functional

    // Business Logic

    public ProductAdminPage filterProductAdminPage(ProductShort product) {
        filterSettings.setFilterFields(product);
        filterSettings.clickFilterButton();
        return new ProductAdminPage(searchManager);
    }

    public ProductAdminPage toLastProductAdminPageAllPages() {
        clickLastPaginationBtnOnPage();
        return new ProductAdminPage(searchManager);
    }

    public ProductAdminPage toFirstProductAdminPageAllPages() {
        clickFirstPaginationBtnOnPage();
        return new ProductAdminPage(searchManager);
    }

    protected ProductAdminPage toProductAdminPageByNumber(int productAdminPageNumber) {
        clickPaginationBtnByName(String.valueOf(productAdminPageNumber));
        return new ProductAdminPage(searchManager);
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
            productNameField = searchManager.findElement(By.id("input-name"));
            modelField = searchManager.findElement(By.id("input-model"));
            priceField = searchManager.findElement(By.id("input-price"));
            quantityField = searchManager.findElement(By.id("input-quantity"));
            statusDropDown = new Select(searchManager.findElement(By.id("input-status")));
            imageDropDown = new Select(searchManager.findElement(By.id("input-image")));
            filterButton = searchManager.findElement(By.id("button-filter"));
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
            searchManager.fillInputField(getProductNameField(), name);
        }

        public void settModelField(String model) {
            searchManager.fillInputField(getModelField(), model);
        }

        public void setPriceField(String price) {
            searchManager.fillInputField(getPriceField(), price);
        }

        public void setQuantityField(String quantity) {
            searchManager.fillInputField(getQuantityField(), quantity);
        }

        // set Functional
        public void setStatusDropDownByStatusText(String value) {
            searchManager.selectByVisibleText(getStatusDropDown(), value);
        }

        public void setImageDropDownByImageText(String value) {
            searchManager.selectByVisibleText(getImageDropDown(), value);
        }

        public void clickFilterButton() {
            searchManager.clickElement(getFilterButton());
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
        private final String ADM_PRODUCT_PG_DEFAULT_SMALL_IMAGE_URL = "http://server7.pp.ua/image/cache/no_image-40x40.png";
        private final String IMAGE_URL_IS_EMPTY = "The image's URL of the product %s is empty";


        private WebElement allProductsMarkCheckbox;
        private List<WebElement> activeProductListHeaderTitles;
        private List<WebElement> productRows;
        private List<ProductShort> productsShortList;

        public ProductListTable() {
            allProductsMarkCheckbox = searchManager.findElement(By.cssSelector("thead > tr > td > input"));
            activeProductListHeaderTitles = searchManager.findElements(By.cssSelector("thead > tr > td > a"));
            productRows = searchManager.findElements(By.cssSelector("tbody > tr"));
            initProductsFromProductsTable();
        }

        public List<ProductShort> initProductsFromProductsTable() {
            productsShortList = new ArrayList<>();
            for (WebElement current : getProductRows()) {
                productsShortList.add(initProductShortFromProductRow(current));
            }
            return productsShortList;
        }

        private ProductShort initProductShortFromProductRow(WebElement productRow) {
            return new ProductShort().setName(getProductNameTextFromProductRow(productRow))
                    .setModel(getModelTextFromProductRow(productRow))
                    .setPrice(getPriceTextFromProductRow(productRow))
                    .setQuantity(getQuantityTextFromProductRow(productRow))
                    .setImageFlag(getImageFlagTextFromProductRow(productRow))
                    .setStatusText(getStatusTextFromProductRow(productRow));
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

        public List<ProductShort> getProductsShortList() {
            return productsShortList;
        }

        //GetFunctional
        public WebElement getProductNameFromProductRow(WebElement productRow) {
            return searchManager.findElementInsideElement(productRow, By.xpath(
                    ProductTableData.PRODUCT_NAME_SELECTOR_XPATH.toString()));
        }

        public String getProductNameTextFromProductRow(WebElement productRow) {
            return getProductNameFromProductRow(productRow).getText();
        }

        public WebElement getModelFromProductRow(WebElement productRow) {
            return searchManager.findElementInsideElement(productRow, By.xpath(
                    ProductTableData.PRODUCT_MODEL_SELECTOR_XPATH.toString()));
        }

        public String getModelTextFromProductRow(WebElement productRow) {
            return getModelFromProductRow(productRow).getText();
        }

        public WebElement getPriceFromProductRow(WebElement productRow) {
            return searchManager.findElementInsideElement(productRow, By.xpath(
                    ProductTableData.PRICE_SELECTOR_XPATH.toString()));
        }

        public String getPriceTextFromProductRow(WebElement productRow) {
            return getPriceFromProductRow(productRow).getText().split("\n")[0];
        }

        //TODO make get price with discount if it will be necessary

        public WebElement getQuantityFromProductRow(WebElement productRow) {
            return searchManager.findElementInsideElement(productRow, By.xpath(
                    ProductTableData.QUANTITY_SELECTOR_XPATH.toString()));
        }

        public String getQuantityTextFromProductRow(WebElement productRow) {
            return getQuantityFromProductRow(productRow).getText();
        }

        public WebElement getImageFromProductRow(WebElement productRow) {
            return searchManager.findElementInsideElement(productRow, By.xpath(
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
            if (imageUrl.equalsIgnoreCase(ADM_PRODUCT_PG_DEFAULT_SMALL_IMAGE_URL)) {
                result = TagAttribute.DISABLED.toString();
            }
            return result;
        }

        public WebElement getStatusFromProductRow(WebElement productRow) {
            return searchManager.findElementInsideElement(productRow, By.xpath(
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
                searchManager.clickElement(getProductNameHeaderBtn());
            }
        }

        public void setProductNameColumnAscendant() {
            if (getClassNameFromElement(getProductNameHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getProductNameHeaderBtn()).isEmpty()) {
                searchManager.clickElement(getProductNameHeaderBtn());
            }
        }


        public void setModelColumnDescendant() {
            if (getClassNameFromElement(getModelHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getModelHeaderBtn()).isEmpty()) {
                searchManager.clickElement(getModelHeaderBtn());
            }
        }

        public void setModelColumnAscendant() {
            if (getClassNameFromElement(getModelHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getModelHeaderBtn()).isEmpty()) {
                searchManager.clickElement(getModelHeaderBtn());
            }
        }

        public void setPriceColumnDescendant() {
            if (getClassNameFromElement(getPriceHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getPriceHeaderBtn()).isEmpty()) {
                searchManager.clickElement(getPriceHeaderBtn());
            }
        }

        public void setPriceColumnAscendant() {
            if (getClassNameFromElement(getPriceHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getPriceHeaderBtn()).isEmpty()) {
                searchManager.clickElement(getPriceHeaderBtn());
            }
        }

        public void setQuantityColumnDescendant() {
            if (getClassNameFromElement(getQuantityHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getQuantityHeaderBtn()).isEmpty()) {
                searchManager.clickElement(getQuantityHeaderBtn());
            }
        }

        public void setQuantityColumnAscendant() {
            if (getClassNameFromElement(getQuantityHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getQuantityHeaderBtn()).isEmpty()) {
                searchManager.clickElement(getQuantityHeaderBtn());
            }
        }

        public void setStatusColumnDescendant() {
            if (getClassNameFromElement(getStatusHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getStatusHeaderBtn()).isEmpty()) {
                searchManager.clickElement(getStatusHeaderBtn());
            }
        }

        public void setStatusColumnAscendant() {
            if (getClassNameFromElement(getStatusHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getStatusHeaderBtn()).isEmpty()) {
                searchManager.clickElement(getStatusHeaderBtn());
            }
        }

        public void selectAllProductMarkCheckbox() {
            searchManager.selectCheckBox(getAllProductsMarkCheckbox());
        }

        public void deselectAllProductMarkCheckbox() {
            searchManager.deselectCheckBox(getAllProductsMarkCheckbox());
        }
    }

    //------------------------------------------------------------

    public ProductAdminPage initLastProductAdminPageNumberAllPages() {
        ProductAdminPage result = this;
        if (isPaganationOnPage()) {
            result = new ProductAdminPageController(searchManager, this)
                    .getLastProductAdminPageNumberAllPages();
        }
        return result;
    }

}


