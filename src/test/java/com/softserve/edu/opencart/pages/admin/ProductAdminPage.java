package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.pages.RegexPatterns;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;
import com.softserve.edu.opencart.tools.Operations;
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
        PAGINATION_LAST_BTN_ACTIVE_ON_PAGE_SELECTOR_CSS(".pagination > li:last-child > a"),
        PAGINATION_LAST_BTN_ON_PAGE_SELECTOR_CSS(".pagination > li:last-child"),

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
    private Integer itemsOnAllPagesExceptLast;
    private int pagesPaginationQuantity;


    public ProductAdminPage() {
        super();
        addProductBtn = search.xpath("//a[child::i[@class='fa fa-plus']]");
        copyProductBtn = search.className("btn-default");
        deleteProductBtn = search.className("btn-danger");

        filterSettings = new FilterSettings();
        productListTable = new ProductListTable();
        initPagination();
        initLastProductAdminPageAllPages();
        initProductShortListAllPages();
    }

    private void initPagination() {
        if (search.isVisibleCssSelector(PaginationData.PAGINATION_ACTIVE_BTNS_SELECTOR_CSS.toString())) {
            paginationActiveBtns = search.cssSelectors(PaginationData.PAGINATION_ACTIVE_BTNS_SELECTOR_CSS.toString());
            paginationCurrentPage = search.cssSelector(PaginationData.PAGINATION_CURRENT_PAGE_SELECTOR_CSS.toString());
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

    public WebElement getLastPaginationBtnActiveOnPage() {
        ErrorUtils.createElementIsNotDisplayedException((paginationCurrentPage == null),
                PaginationData.NO_PAGINATION_MESSAGE.toString());
        return search.cssSelector(PaginationData.PAGINATION_LAST_BTN_ACTIVE_ON_PAGE_SELECTOR_CSS.toString());
    }

    public WebElement getFirstPaginationBtnOnPage() {
        ErrorUtils.createElementIsNotDisplayedException((paginationCurrentPage == null),
                PaginationData.NO_PAGINATION_MESSAGE.toString());
        return search.cssSelector(PaginationData.PAGINATION_FIRST_BTN_ON_PAGE_SELECTOR_CSS.toString());
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

    private WebElement getLastPaginationBtnOnPage() {
        return search.cssSelector(PaginationData.PAGINATION_LAST_BTN_ON_PAGE_SELECTOR_CSS.toString());
    }

    public Integer getItemsOnAllPagesExceptLast() {
        return itemsOnAllPagesExceptLast;
    }

    public int getPagesPaginationQuantity() {
        return pagesPaginationQuantity;
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



    public String getLastPaginationBtnActiveOnPageText() {
        return getLastPaginationBtnActiveOnPage().getText();
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

    private String getLastPaginationBtnOnPageText() {
        return getLastPaginationBtnOnPage().getText();
    }

    public boolean isLastPageOpened() {
        String temp =  getLastPaginationBtnOnPageText();
        int temp2 = getCurrentPageNumber();

        return (getLastPaginationBtnOnPageText().matches(RegexPatterns.ALL_DIGITS.toString())
                && (Integer.parseUnsignedInt(getLastPaginationBtnOnPageText()) == getCurrentPageNumber()));
    }

    public List<ProductShort> getProductsShortListFromPage() {
        return getProductListTable().getProductsShortList();
    }


    public List<WebElement> getProductRowsFromTable() {
        return getProductListTable().getProductRows();
    }
    //TODO get from filter fields' text
    //TODO get and click for headers active element (sort by them desc, asc); get and click edit button by ProductShort
    //TODO get ProductShortList by Name, Model....


    // set data

    public void clickAddProductBtn() {
        Operations.clickElement(getAddProductBtn());
    }

    public void clickCopyProductBtn() {
        Operations.clickElement(copyProductBtn);
    }

    public void clickDeleteProductBtn() {
        Operations.clickElement(deleteProductBtn);
    }

    public void clickToFirstPagePaginationBtn() {
        Operations.clickElement(getToFirstPagePaginationBtnOnPage());
    }

    public void clickToPreviousPagePaginationBtn() {
        Operations.clickElement(getToPreviousPagePaginationBtn());
    }

    public void clickToNextPagePaginationBtn() {
        Operations.clickElement(getToNextPagePaginationBtn());
    }

    public void clickLastPaginationBtnActiveOnPage() {
        Operations.clickElement(getLastPaginationBtnActiveOnPage());
    }

    public void clickFirstPaginationBtnOnPage() {
        Operations.clickElement(getFirstPaginationBtnOnPage());
    }

    public void clickToLastPagePaginationBtn() {
        Operations.clickElement(getToFirstPagePaginationBtnOnPage());
    }

    public void clickPaginationBtnByName(String paginationBtnName) {
        Operations.clickElement(getPaginationBtnByName(paginationBtnName));
    }

    protected void setLastProductAdminPageAllPagesNumber(Integer lastProductAdminPageAllPagesNumber) {
        this.lastProductAdminPageAllPagesNumber = lastProductAdminPageAllPagesNumber;
    }

    protected void setProductShortListAllPages(List<ProductShort> productShortListAllPages) {
        this.productShortListAllPages = productShortListAllPages;
    }

    public void setItemsOnAllPagesExceptLast(Integer itemsOnAllPagesExceptLast) {
        this.itemsOnAllPagesExceptLast = itemsOnAllPagesExceptLast;
    }

    public void setPagesPaginationQuantity(int pagesPaginationQuantity) {
        this.pagesPaginationQuantity = pagesPaginationQuantity;
    }

    // set Functional

    // Business Logic

    public ProductAdminPage filterProductAdminPage(ProductShort product) {
        filterSettings.setFilterFields(product);
        filterSettings.clickFilterButton();
        return new ProductAdminPage();
    }

    public ProductAdminPage toLastProductAdminPageAllPages() {
        clickLastPaginationBtnActiveOnPage();
        return new ProductAdminPage();
    }

    public ProductAdminPage toFirstProductAdminPageAllPages() {
        clickFirstPaginationBtnOnPage();
        return new ProductAdminPage();
    }

    protected ProductAdminPage toProductAdminPageByNumber(int productAdminPageNumber) {
        clickPaginationBtnByName(String.valueOf(productAdminPageNumber));
        return new ProductAdminPage();
    }

    public ProductAdminPage toNextProductAdminPage() {
        clickToNextPagePaginationBtn();
        return new ProductAdminPage();
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
            productNameField = search.id("input-name");
            modelField = search.id("input-model");
            priceField = search.id("input-price");
            quantityField = search.id("input-quantity");
            statusDropDown = new Select(search.id("input-status"));
            imageDropDown = new Select(search.id("input-image"));
            filterButton = search.id("button-filter");
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
            Operations.fillInputField(getProductNameField(), name);
        }

        public void settModelField(String model) {
            Operations.fillInputField(getModelField(), model);
        }

        public void setPriceField(String price) {
            Operations.fillInputField(getPriceField(), price);
        }

        public void setQuantityField(String quantity) {
            Operations.fillInputField(getQuantityField(), quantity);
        }

        // set Functional
        public void setStatusDropDownByStatusText(String value) {
            Operations.selectByVisibleText(getStatusDropDown(), value);
        }

        public void setImageDropDownByImageText(String value) {
            Operations.selectByVisibleText(getImageDropDown(), value);
        }

        public void clickFilterButton() {
            Operations.clickElement(getFilterButton());
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
            allProductsMarkCheckbox = search.cssSelector("thead > tr > td > input");
            activeProductListHeaderTitles = search.cssSelectors("thead > tr > td > a");
            productRows = search.cssSelectors("tbody > tr");
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
                    .setStatusFlag(getStatusTextFromProductRow(productRow));
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
            return search.xpath(ProductTableData.PRODUCT_NAME_SELECTOR_XPATH.toString(), productRow);
        }

        public String getProductNameTextFromProductRow(WebElement productRow) {
            return getProductNameFromProductRow(productRow).getText();
        }

        public WebElement getModelFromProductRow(WebElement productRow) {
            return search.xpath(ProductTableData.PRODUCT_MODEL_SELECTOR_XPATH.toString(), productRow);
        }

        public String getModelTextFromProductRow(WebElement productRow) {
            return getModelFromProductRow(productRow).getText();
        }

        public WebElement getPriceFromProductRow(WebElement productRow) {
            return search.xpath(ProductTableData.PRICE_SELECTOR_XPATH.toString(), productRow);
        }

        public String getPriceTextFromProductRow(WebElement productRow) {
            return getPriceFromProductRow(productRow).getText().split("\n")[0];
        }

        //TODO make get price with discount if it will be necessary

        public WebElement getQuantityFromProductRow(WebElement productRow) {
            return search.xpath(ProductTableData.QUANTITY_SELECTOR_XPATH.toString(), productRow);
        }

        public String getQuantityTextFromProductRow(WebElement productRow) {
            return getQuantityFromProductRow(productRow).getText();
        }

        public WebElement getImageFromProductRow(WebElement productRow) {
            return search.xpath(ProductTableData.IMAGE_SELECTOR_XPATH.toString(), productRow);
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
            return search.xpath(ProductTableData.STATUS_SELECTOR_XPATH.toString(), productRow);
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
                Operations.clickElement(getProductNameHeaderBtn());
            }
        }

        public void setProductNameColumnAscendant() {
            if (getClassNameFromElement(getProductNameHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getProductNameHeaderBtn()).isEmpty()) {
                Operations.clickElement(getProductNameHeaderBtn());
            }
        }


        public void setModelColumnDescendant() {
            if (getClassNameFromElement(getModelHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getModelHeaderBtn()).isEmpty()) {
                Operations.clickElement(getModelHeaderBtn());
            }
        }

        public void setModelColumnAscendant() {
            if (getClassNameFromElement(getModelHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getModelHeaderBtn()).isEmpty()) {
                Operations.clickElement(getModelHeaderBtn());
            }
        }

        public void setPriceColumnDescendant() {
            if (getClassNameFromElement(getPriceHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getPriceHeaderBtn()).isEmpty()) {
                Operations.clickElement(getPriceHeaderBtn());
            }
        }

        public void setPriceColumnAscendant() {
            if (getClassNameFromElement(getPriceHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getPriceHeaderBtn()).isEmpty()) {
                Operations.clickElement(getPriceHeaderBtn());
            }
        }

        public void setQuantityColumnDescendant() {
            if (getClassNameFromElement(getQuantityHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getQuantityHeaderBtn()).isEmpty()) {
                Operations.clickElement(getQuantityHeaderBtn());
            }
        }

        public void setQuantityColumnAscendant() {
            if (getClassNameFromElement(getQuantityHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getQuantityHeaderBtn()).isEmpty()) {
                Operations.clickElement(getQuantityHeaderBtn());
            }
        }

        public void setStatusColumnDescendant() {
            if (getClassNameFromElement(getStatusHeaderBtn()).equalsIgnoreCase(ASC)
                    || getClassNameFromElement(getStatusHeaderBtn()).isEmpty()) {
                Operations.clickElement(getStatusHeaderBtn());
            }
        }

        public void setStatusColumnAscendant() {
            if (getClassNameFromElement(getStatusHeaderBtn()).equalsIgnoreCase(DESC)
                    || getClassNameFromElement(getStatusHeaderBtn()).isEmpty()) {
                Operations.clickElement(getStatusHeaderBtn());
            }
        }

        public void selectAllProductMarkCheckbox() {
            Operations.selectCheckBox(getAllProductsMarkCheckbox());
        }

        public void deselectAllProductMarkCheckbox() {
            Operations.deselectCheckBox(getAllProductsMarkCheckbox());
        }
    }

    //------------------------------------------------------------

    public ProductAdminPage initLastProductAdminPageNumberAllPages() {
        ProductAdminPage result = this;
        if (isPaganationOnPage()) {
            result = new ProductAdminPageController(this)
                    .getLastProductAdminPageNumberAllPagesAndItemsPerEveryPage();
        } else {
            setItemsOnAllPagesExceptLast(getProductRowsFromTable().size());
            setPagesPaginationQuantity(1);
        }
        return result;
    }


}


