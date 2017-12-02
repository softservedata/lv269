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

    public ProductFilterLists() {
        filterTemplate = new ProductShort();
    }

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
        for (String current : Application.get().fileManager().readFromFile(ApplicationSourceRepository.class
                .getResource(fileName).getPath().substring(1))) {
            currentProductList.add(new ProductShort(current, PARAMETERS_DELIMITER));
        }
        return this;
    }

    public ProductFilterLists setFilterTemplateByString(String parametersString) {
        filterTemplate = new ProductShort(parametersString, PARAMETERS_DELIMITER);
        return this;
    }

    public ProductFilterLists setNameFilterTemplate (String name) {
        filterTemplate.setName(name);
        return this;
    }

    public ProductFilterLists setModelFilterTemplate (String model) {
        filterTemplate.setModel(model);
        return this;
    }

    public ProductFilterLists setPriceFilterTemplate (String price) {
        filterTemplate.setPrice(price);
        return this;
    }

    public ProductFilterLists setQuantityFilterTemplate (String quantity) {
        filterTemplate.setQuantity(quantity);
        return this;
    }

    public ProductFilterLists setImageFlagFilterTemplate (String imageFlagText) {
        filterTemplate.setImageFlag(imageFlagText);
        return this;
    }

    public ProductFilterLists setImageFlagFilterTemplate (boolean imageFlag) {
        filterTemplate.setImageFlag(imageFlag);
        return this;
    }

    public ProductFilterLists setStatusFlagFilterTemplate (String statusFlagText) {
        filterTemplate.setStatusFlag(statusFlagText);
        return this;
    }

    public ProductFilterLists setStatusFlagFilterTemplate (Boolean statusFlag) {
        filterTemplate.setStatusFlag(statusFlag);
        return this;
    }
}
