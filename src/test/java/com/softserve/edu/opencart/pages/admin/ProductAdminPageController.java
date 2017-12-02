package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.data.sort.IAdminProductSort;

import java.util.ArrayList;
import java.util.List;

public class ProductAdminPageController {

    private ProductAdminPage currentProductAdminPage;
    private List<ProductShort> productShortListAllPages;
    private int lastProductAdminPageAllPages;
    private List<Integer> itemsPerEveryPage;
    private Integer itemsOnAllPagesExceptLast;
    private int pagesPaginationQuantity;

    public ProductAdminPageController(ProductAdminPage productAdminPage) {
        currentProductAdminPage = productAdminPage;
        itemsPerEveryPage = new ArrayList<>();

    }

    public ProductAdminPage getLastProductAdminPageNumberAllPages() {
        currentProductAdminPage = currentProductAdminPage.toLastProductAdminPageAllPages();
        lastProductAdminPageAllPages = currentProductAdminPage.getCurrentPageNumber();
        currentProductAdminPage = currentProductAdminPage.toFirstProductAdminPageAllPages();
        currentProductAdminPage.setLastProductAdminPageAllPagesNumber(lastProductAdminPageAllPages);
        return currentProductAdminPage;
    }

    public ProductAdminPage getLastProductAdminPageNumberAllPagesAndItemsPerEveryPage() {
        itemsPerEveryPage.add(currentProductAdminPage.getProductRowsFromTable().size());
        while (!currentProductAdminPage.isLastPageOpened()) {
            currentProductAdminPage = currentProductAdminPage.toNextProductAdminPage();
            itemsPerEveryPage.add(currentProductAdminPage.getProductRowsFromTable().size());
        }
        currentProductAdminPage = currentProductAdminPage.toFirstProductAdminPageAllPages();
        itemsOnAllPagesExceptLast = itemsPerEveryPage.get(0);
        for (int i = 1; i < itemsPerEveryPage.size() - 1; i++) {
            if (itemsPerEveryPage.get(0) != itemsPerEveryPage.get(i)) {
                itemsOnAllPagesExceptLast = null;
                break;
            }
        }
        currentProductAdminPage.setItemsOnAllPagesExceptLast(itemsOnAllPagesExceptLast);
        currentProductAdminPage.setPagesPaginationQuantity(itemsPerEveryPage.size());
        return currentProductAdminPage;
    }


    public ProductAdminPage getProductsShortListFromAllPages() {
        productShortListAllPages = new ArrayList<>();
        productShortListAllPages.addAll(currentProductAdminPage.getProductsShortListFromPage());
        while (!currentProductAdminPage.isLastPageOpened()) {
            currentProductAdminPage = currentProductAdminPage.toNextProductAdminPage();
            productShortListAllPages.addAll(currentProductAdminPage.getProductsShortListFromPage());
        }
        currentProductAdminPage = currentProductAdminPage.toFirstProductAdminPageAllPages();
        currentProductAdminPage.setProductShortListAllPages(productShortListAllPages);
        return currentProductAdminPage;
    }

    public ProductAdminPage sortProductPageTable(IAdminProductSort adminProductSort) {
        ProductAdminPage nextProductadminPage = currentProductAdminPage.sortByColumnName(adminProductSort);
        while (currentProductAdminPage != nextProductadminPage) {
            currentProductAdminPage = nextProductadminPage;
            nextProductadminPage = currentProductAdminPage.sortByColumnName(adminProductSort);
        }
        return nextProductadminPage;
    }

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