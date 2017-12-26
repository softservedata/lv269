package com.softserve.edu.opencart.data.filter;

public class AdminProductFilterListsRepository {


    //TODO change without fields, think not to read file multiple times
    private final String PRODUCT_LIST_FILE_NAME = "productlist.txt";

    private static volatile AdminProductFilterListsRepository instance = null;

    private AdminProductFilterListsRepository() {
    }

    public static AdminProductFilterListsRepository get() {
        if (instance == null) {
            synchronized (AdminProductFilterListsRepository.class) {
                if (instance == null) {
                    instance = new AdminProductFilterListsRepository();
                }
            }
        }
        return instance;
    }

    public IAdminProductFilterLists filterOnlyExistedProductName() {
        return new AdminProductFilterLists()
                .readCurrentProductShortList(PRODUCT_LIST_FILE_NAME)
                .setNameFilterTemplate("iPod Classic");
    }

    public IAdminProductFilterLists filterOnlyNoneExistedProductName() {
        return new AdminProductFilterLists()
                .readCurrentProductShortList(PRODUCT_LIST_FILE_NAME)
                .setNameFilterTemplate("Hiu-Hiu");
    }

    public IAdminProductFilterLists filterOnlyProductNameMultipleResult() {
        return new AdminProductFilterLists()
                .readCurrentProductShortList(PRODUCT_LIST_FILE_NAME)
                .setNameFilterTemplate("iPod");
    }

    public IAdminProductFilterLists filterOnlyProductNameFromModelText() {
        return new AdminProductFilterLists()
                .readCurrentProductShortList(PRODUCT_LIST_FILE_NAME)
                .setNameFilterTemplate("Product 15");
    }

    public IAdminProductFilterLists filterOnlyExistedModel() {
        return new AdminProductFilterLists()
                .readCurrentProductShortList(PRODUCT_LIST_FILE_NAME)
                .setModelFilterTemplate("Product 15");
    }

    public IAdminProductFilterLists filterOnlyNoneExistedModel() {
        return new AdminProductFilterLists()
                .readCurrentProductShortList(PRODUCT_LIST_FILE_NAME)
                .setModelFilterTemplate("Dummy card");
    }

    public IAdminProductFilterLists filterOnlyExistedPriceMultiResult() {
        return new AdminProductFilterLists()
                .readCurrentProductShortList(PRODUCT_LIST_FILE_NAME)
                .setPriceFilterTemplate("100");
    }

    public IAdminProductFilterLists filterOnlyLetterQuantity() {
        return new AdminProductFilterLists()
                .readCurrentProductShortList(PRODUCT_LIST_FILE_NAME)
                .setQuantityFilterTemplate("aaa");
    }
}
