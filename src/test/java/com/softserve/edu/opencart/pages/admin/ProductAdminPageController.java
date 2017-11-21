package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.SearchManager;

import java.util.ArrayList;
import java.util.List;

public class ProductAdminPageController {

    private ProductAdminPage currentProductAdminPage;
    private List<ProductShort> productShortListAllPages;
    private int lastProductAdminPageAllPages;
    private SearchManager searchManager;

    public ProductAdminPageController(SearchManager searchManager, ProductAdminPage productAdminPage) {
        currentProductAdminPage = productAdminPage;
        this.searchManager = searchManager;
    }

    public ProductAdminPage getLastProductAdminPageNumberAllPages() {
        currentProductAdminPage = currentProductAdminPage.toLastProductAdminPageAllPages();
        lastProductAdminPageAllPages = currentProductAdminPage.getCurrentPageNumber();
        currentProductAdminPage = currentProductAdminPage.toFirstProductAdminPageAllPages();
        currentProductAdminPage.setLastProductAdminPageAllPagesNumber(lastProductAdminPageAllPages);
        return currentProductAdminPage;
    }

//    public ProductAdminPage getProductsShortListFromAllPages() {
//        productShortListAllPages = new ArrayList<>();
//        currentProductAdminPage = addProductShortListAndToNextPage();
//        do {
//            currentProductAdminPage = addProductShortListAndToNextPage();
//        } while (!currentProductAdminPage.isLastPageOpened());
//        currentProductAdminPage = currentProductAdminPage.toFirstProductAdminPageAllPages();
//        currentProductAdminPage.setProductShortListAllPages(productShortListAllPages);
//        return currentProductAdminPage;
//    }

//    private ProductAdminPage addProductShortListAndToNextPage() {
//        productShortListAllPages.addAll(currentProductAdminPage.getProductsShortListFromPage());
//        return currentProductAdminPage.toProductAdminPageByNumber(
//                currentProductAdminPage.getCurrentPageNumber() + 1);
//
//    }

//    public ProductAdminPage initLastProductAdminPageNumberAllPages() {
//        ProductAdminPage result = this;
//        if (isPaganationOnPage()) {
//            result = new ProductAdminPageController(searchManager, this)
//                    .getLastProductAdminPageNumberAllPages();
//        }
//        return result;
//    }
//
//    public ProductAdminPage initProductsShortListAllPages() {
//        ProductAdminPage result = this;
//        if (isPaganationOnPage()) {
//            result = new ProductAdminPageController(searchManager, this)
//                    .getProductsShortListFromAllPages();
//        }
//        return result;
//    }
}