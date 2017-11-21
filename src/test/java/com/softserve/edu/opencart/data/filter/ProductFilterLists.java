package com.softserve.edu.opencart.data.filter;

import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;
import java.util.ArrayList;
import java.util.List;

public class ProductFilterLists implements IProductFilterLists {

    //TODO make protection from wrong input
    private final String PARAMETERS_DELIMITER = ",";

    private ProductShort filterTemplate;

    private List<ProductShort> currentProductList;

    public ProductShort getFilterTemplate() {
        return filterTemplate;
    }

    public List<ProductShort> getCurrentProductList() {
        return currentProductList;
    }

    public ProductFilterLists setCurrentProductList(List<ProductShort> currentProductList) {
        this.currentProductList = currentProductList;
        return this;
    }

    public ProductFilterLists readCurrentProductListFromFile (String fileName) {
        currentProductList = new ArrayList<>();
        for (String current : Application.get().getFileManager().readFromFile(ApplicationSourceRepository.class
                .getResource(fileName).getPath().substring(1))) {
            currentProductList.add(new ProductShort(current, PARAMETERS_DELIMITER));
        }
        return this;
    }

    public ProductFilterLists setFilterTemplate(String parametersString) {
        filterTemplate = new ProductShort(parametersString, PARAMETERS_DELIMITER);
        return this;
    }
}
