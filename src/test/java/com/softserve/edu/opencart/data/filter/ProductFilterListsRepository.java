package com.softserve.edu.opencart.data.filter;

import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;

import java.util.ArrayList;
import java.util.List;

public class ProductFilterListsRepository {

    private final String PARAMETERS_DELIMITER = ",";
    //TODO change without fields, think not to read file multiple times

    private List<ProductShort> currentProductList;

    private static volatile ProductFilterListsRepository instance = null;

    private ProductFilterListsRepository() {
        initCurrentProductsList();
    }

    private void initCurrentProductsList() {
        currentProductList = new ArrayList<>();
        for (String current : Application.get().getFileManager().readFromFile(ApplicationSourceRepository.class
                .getResource("productlist.txt").getPath().substring(1))) {
            currentProductList.add(new ProductShort(current, PARAMETERS_DELIMITER));
        }
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
                .setCurrentProductList(currentProductList)
                .setFilterTemplate("iPod Classic,product 20,100.0000,995,Enabled,null", PARAMETERS_DELIMITER);

    }
}
