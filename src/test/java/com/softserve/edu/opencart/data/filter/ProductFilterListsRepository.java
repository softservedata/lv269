package com.softserve.edu.opencart.data.filter;

import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;

import java.util.ArrayList;
import java.util.List;

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

    public IProductFilterLists filterOnlyProductName() {
        return new ProductFilterLists()
                .readCurrentProductListFromFile("productlist.txt")
                .setFilterTemplate("iPod Classic,,,,,");

    }
}
