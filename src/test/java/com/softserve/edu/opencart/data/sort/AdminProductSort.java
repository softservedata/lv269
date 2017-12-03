package com.softserve.edu.opencart.data.sort;

import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdminProductSort implements IAdminProductSort {

    //TODO make protection from wrong input
    private final String DELIMITER = ",";

    private Map<String, String> optionsReplaceValues;
    private String columnName;
    private String sortOrder;
    private List<ProductShort> currentProductShortList;

    public AdminProductSort() {
        currentProductShortList = new ArrayList<>();
        optionsReplaceValues = new HashMap<>();

    }

    public String getColumnName() {
        return columnName;
    }

    public Map<String, String> getOptionsReplaceValues() {
        return optionsReplaceValues;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public List<ProductShort> getCurrentProductShortList() {
        return currentProductShortList;
    }

    public AdminProductSort setColumnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    public AdminProductSort setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public AdminProductSort readCurrentProductShortListFromFile(String fileName) {
        for (String current : Application.get().fileManager().readFromFile(ApplicationSourceRepository.class
                .getResource("/" + fileName).getPath().substring(1))) {
            currentProductShortList.add(new ProductShort(current, DELIMITER));
        }
        return this;
    }

    public void addOptionReplaceValue(String optionReplaceName, String optionReplaceValue) {
        optionsReplaceValues.put(optionReplaceName, optionReplaceValue);
    }
}
