package com.softserve.edu.opencart.data.pagination;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;

import java.util.HashMap;
import java.util.Map;


public class Pagination implements IPagination {

    //TODO make protection from wrong input

    private Map<String, String> optionsReplaceValues;
    private int itemsNumber;
    private int itemsPerPageNumber;

    public Pagination() {
        optionsReplaceValues = new HashMap<>();
    }

    public int getItemsNumber() {
        return itemsNumber;
    }

    public int getItemsPerPageNumber() {
        return itemsPerPageNumber;
    }

    public Map<String, String> getOptionsReplaceValues() {
        return optionsReplaceValues;
    }

    public Pagination readItemsNumberFromFile(String fileName) {
        itemsNumber = Application.get().fileManager().readFromFile(ApplicationSourceRepository.class
                .getResource("/" + fileName).getPath().substring(1)).size();
        return this;
    }

    public void setItemsPerPageNumber(int itemsPerPageNumber) {
        this.itemsPerPageNumber = itemsPerPageNumber;
    }

    public void addOptionReplaceValue(String optionReplaceName, String optionReplaceValue) {
        optionsReplaceValues.put(optionReplaceName, optionReplaceValue);
    }
}
