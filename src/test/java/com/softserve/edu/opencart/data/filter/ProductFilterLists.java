package com.softserve.edu.opencart.data.filter;

import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.pages.Application;
import java.util.ArrayList;
import java.util.List;

public class ProductFilterLists implements IProductFilterLists {

    //TODO make protection from wrong input

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

    public ProductFilterLists setFilterTemplate(String parametersString, String delimiter) {
        filterTemplate = new ProductShort(parametersString, delimiter);
        return this;
    }
}
