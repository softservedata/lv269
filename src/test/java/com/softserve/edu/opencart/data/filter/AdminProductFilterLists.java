package com.softserve.edu.opencart.data.filter;

import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminProductFilterLists implements IAdminProductFilterLists {

    //TODO make protection from wrong input
    private final String DELIMITER = ",";

    private ProductShort filterTemplate;
    private List<ProductShort> currentProductShortList;
    private Map<String, String> optionsReplaceValues;

    public AdminProductFilterLists() {
        filterTemplate = new ProductShort();
        optionsReplaceValues = new HashMap<>();
        currentProductShortList = new ArrayList<>();
    }

    public ProductShort getFilterTemplate() {
        return filterTemplate;
    }

    public List<ProductShort> getCurrentProductShortList() {
        return currentProductShortList;
    }

    public Map<String, String> getOptionsReplaceValues() {
        return optionsReplaceValues;
    }

    public AdminProductFilterLists setCurrentProductShortList(List<ProductShort> currentProductList) {
        this.currentProductShortList = currentProductList;
        return this;
    }

    public AdminProductFilterLists readCurrentProductShortList (String fileName) {
        for (String current : Application.get().fileManager().readFromFile(ApplicationSourceRepository.class
                .getResource("/" + fileName).getPath().substring(1))) {
            currentProductShortList.add(new ProductShort(current, DELIMITER));
        }
        return this;

        //        currentProductList = new ArrayList<>();
//        for (String current : Application.get().fileManager().readFromFile(ApplicationSourceRepository.class
//                .getResource(fileName).getPath().substring(1))) {
//            currentProductList.add(new ProductShort(current, PARAMETERS_DELIMITER));
//        }
//        return this;
    }

    public AdminProductFilterLists setFilterTemplateByString(String parametersString) {
        filterTemplate = new ProductShort(parametersString, DELIMITER);
        return this;
    }

    public AdminProductFilterLists setNameFilterTemplate (String name) {
        filterTemplate.setName(name);
        return this;
    }

    public AdminProductFilterLists setModelFilterTemplate (String model) {
        filterTemplate.setModel(model);
        return this;
    }

    public AdminProductFilterLists setPriceFilterTemplate (String price) {
        filterTemplate.setPrice(price);
        return this;
    }

    public AdminProductFilterLists setQuantityFilterTemplate (String quantity) {
        filterTemplate.setQuantity(quantity);
        return this;
    }

    public AdminProductFilterLists setImageFlagFilterTemplate (String imageFlagText) {
        filterTemplate.setImageFlag(imageFlagText);
        return this;
    }

    public AdminProductFilterLists setImageFlagFilterTemplate (boolean imageFlag) {
        filterTemplate.setImageFlag(imageFlag);
        return this;
    }

    public AdminProductFilterLists setStatusFlagFilterTemplate (String statusFlagText) {
        filterTemplate.setStatusFlag(statusFlagText);
        return this;
    }

    public AdminProductFilterLists setStatusFlagFilterTemplate (Boolean statusFlag) {
        filterTemplate.setStatusFlag(statusFlag);
        return this;
    }
}
