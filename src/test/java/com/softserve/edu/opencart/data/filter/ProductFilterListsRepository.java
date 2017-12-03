package com.softserve.edu.opencart.data.filter;

public class ProductFilterListsRepository {


    //TODO change without fields, think not to read file multiple times


    private static volatile ProductFilterListsRepository instance = null;

    private ProductFilterListsRepository() {
    }

    public static ProductFilterListsRepository get() {
        if (instance == null) {
            synchronized (ProductFilterListsRepository.class) {
                if (instance == null) {
                    instance = new ProductFilterListsRepository();
                }
            }
        }
        return instance;
    }

    public IProductFilterLists filterOnlyExistedProductName() {
        return new ProductFilterLists()
                .readCurrentProductListFromFile("productlist.txt")
                .setNameFilterTemplate("iPod Classic");
    }

    public IProductFilterLists filterOnlyNoneExistedProductName() {
        return new ProductFilterLists()
                .readCurrentProductListFromFile("productlist.txt")
                .setNameFilterTemplate("Hiu-Hiu");
    }

    public IProductFilterLists filterOnlyProductNameMultipleResult() {
        return new ProductFilterLists()
                .readCurrentProductListFromFile("productlist.txt")
                .setNameFilterTemplate("iPod");
    }

    public IProductFilterLists filterOnlyProductNameFromModelText() {
        return new ProductFilterLists()
                .readCurrentProductListFromFile("productlist.txt")
                .setNameFilterTemplate("Product 15");
    }

    public IProductFilterLists filterOnlyExistedModel() {
        return new ProductFilterLists()
                .readCurrentProductListFromFile("productlist.txt")
                .setNameFilterTemplate("Product 15");
    }

    public IProductFilterLists filterOnlyNoneExistedModel() {
        return new ProductFilterLists()
                .readCurrentProductListFromFile("productlist.txt")
                .setNameFilterTemplate("Dummy card");
    }



}
